package com.example.zzmdemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.zzmdemo.common.IdGenerator;
import com.example.zzmdemo.common.SysTemConstant;
import com.example.zzmdemo.entity.SysOrg;
import com.example.zzmdemo.entity.response.FailedResponse;
import com.example.zzmdemo.entity.response.Response;
import com.example.zzmdemo.entity.response.SuccessResponse;
import com.example.zzmdemo.mapper.SysOrgMapper;
import com.example.zzmdemo.service.ISysOrgService;
import com.example.zzmdemo.vo.SysOrgVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 组织表 服务实现类
 * </p>
 *
 * @author zhangzhiming
 * @since 2020-04-13
 */
@Service
public class SysOrgServiceImpl extends ServiceImpl<SysOrgMapper, SysOrg> implements ISysOrgService {
    @Resource
    private SysOrgMapper sysOrgMapper;
    @Resource
    private IdGenerator idGenerator;

    @Override
    public List<SysOrgVo> qryChildByParentId(String parentId) {
        if (StringUtils.isEmpty(parentId)) {
            return sysOrgMapper.qryChildByParentId(null, null, null);
        }
        SysOrg sysOrg = sysOrgMapper.selectById(parentId);
        if (sysOrg == null) {
            return null;
        }
        return sysOrgMapper.qryChildByParentId(sysOrg.getLeftNode(), sysOrg.getRightNode(), sysOrg.getLevel());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Response add(SysOrgVo sysOrgVo) {
        if (sysOrgVo == null) {
            return new FailedResponse("处理失败");
        }
        SysOrg sysOrg;
        SysOrg addOrg = new SysOrg();
        //添加子级节点
        if (StringUtils.isNotEmpty(sysOrgVo.getParentId())) {
            sysOrg = sysOrgMapper.selectById(sysOrgVo.getParentId());
            if (sysOrg == null) {
                return new FailedResponse("找不到父级组织");
            }
            //右 大于等于当前右+2
            //左大于等于当前右+2
            sysOrgMapper.updateAllRight(sysOrg.getRightNode(), 2);
            sysOrgMapper.updateAllLeft(sysOrg.getRightNode(), 2);
            addOrg.setLeftNode(sysOrg.getRightNode());
            addOrg.setRightNode(sysOrg.getRightNode() + 1);
            addOrg.setLevel(sysOrg.getLevel() + 1);
        } else {
            //没有父节点就作为根节点，查询当前最右节点
            sysOrg = sysOrgMapper.qryMaxRight();
            if (sysOrg == null) {
                //没有其他，自己就是第一个节点
                addOrg.setLeftNode(1);
                addOrg.setRightNode(2);
                addOrg.setLevel(1);
            } else {
                addOrg.setLeftNode(sysOrg.getRightNode() + 1);
                addOrg.setRightNode(sysOrg.getRightNode() + 2);
                addOrg.setLevel(sysOrg.getLevel());
            }
        }
        addOrg.setId(idGenerator.nextId());
        addOrg.setOrgName(sysOrgVo.getOrgName());
        addOrg.setDeleteFlag(SysTemConstant.DELETE_FLAG_OK);
        addOrg.setCreateTime(new Date());
        this.save(addOrg);
        return new SuccessResponse();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Response deleteById(String id){
        if(StringUtils.isEmpty(id)){
            return new FailedResponse("参数异常");
        }
        SysOrg sysOrg = sysOrgMapper.selectById(id);
        if(sysOrg==null){
            return new FailedResponse("查不到该组织");
        }
        sysOrg.setDeleteFlag(SysTemConstant.DELETE_FLAG_DELETE);
        this.updateById(sysOrg);
        //根节点待处理
        if(sysOrg.getLeftNode()>1){
            //将所有大于此节点 左节点的-2
            sysOrgMapper.updateAllRight(sysOrg.getRightNode(), -2);
            sysOrgMapper.updateAllLeft(sysOrg.getRightNode(), -2);
        }
        return new SuccessResponse();
    }

}

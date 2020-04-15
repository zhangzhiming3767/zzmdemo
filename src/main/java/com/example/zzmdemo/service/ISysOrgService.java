package com.example.zzmdemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.zzmdemo.entity.SysOrg;
import com.example.zzmdemo.entity.response.Response;
import com.example.zzmdemo.vo.SysOrgVo;

import java.util.List;

/**
 * <p>
 * 组织表 服务类
 * </p>
 *
 * @author zhangzhiming
 * @since 2020-04-13
 */
public interface ISysOrgService extends IService<SysOrg> {

    List<SysOrgVo> qryChildByParentId(String parentId);

    Response add(SysOrgVo sysOrgVo);

    Response deleteById(String id);
}

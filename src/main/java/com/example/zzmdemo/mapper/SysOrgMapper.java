package com.example.zzmdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.zzmdemo.entity.SysOrg;
import com.example.zzmdemo.vo.SysOrgVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 组织表 Mapper 接口
 * </p>
 *
 * @author zhangzhiming
 * @since 2020-04-13
 */
public interface SysOrgMapper extends BaseMapper<SysOrg> {

    List<SysOrgVo> qryChildByParentId(@Param("left") Integer left, @Param("right") Integer right, @Param("level") Integer level);

    Integer updateAllLeft(@Param("leftNum") Integer leftNum, @Param("count") Integer count);

    Integer updateAllRight(@Param("rightNum") Integer rightNum, @Param("count") Integer count);

    SysOrg qryMaxRight();
}

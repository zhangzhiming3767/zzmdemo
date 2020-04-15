package com.example.zzmdemo.vo;

import com.example.zzmdemo.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 组织表
 * </p>
 *
 * @author zhangzhiming
 * @since 2020-04-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SysOrg对象", description="组织表")
public class SysOrgVo extends BaseEntity  implements Serializable{

    private static final long serialVersionUID = 1L;


    private String orgName;

    @ApiModelProperty(value = "左节点")
    private Integer left;

    @ApiModelProperty(value = "右节点")
    private Integer right;

    @ApiModelProperty(value = "层级")
    private Integer level;

    private String parentId;

}

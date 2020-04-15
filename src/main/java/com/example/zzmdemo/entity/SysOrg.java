package com.example.zzmdemo.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
public class SysOrg extends BaseEntity  implements Serializable{

    private static final long serialVersionUID = 1L;


    private String orgName;

    @ApiModelProperty(value = "左节点")
    private Integer leftNode;

    @ApiModelProperty(value = "右节点")
    private Integer rightNode;

    @ApiModelProperty(value = "层级")
    private Integer level;

}

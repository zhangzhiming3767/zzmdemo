package com.example.zzmdemo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
//@Table(name = "sys_menu")
@EqualsAndHashCode(callSuper = false)
public class SysMenu extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 8082354824176117891L;
    /**
     * 父id
     */
    private String parentId;
    /**
     * 访问路径
     */
    private String menuUrl;
    /**
     * 菜单名称
     */
    private String menuName;
    /**
     * 图标
     */
    private String icon;
    /**
     * 描述
     */
    private String description;
    /**
     * 排序
     */
    private Integer order;
    /**
     * 启用禁用状态 1启0禁
     */
    private String useState;

}

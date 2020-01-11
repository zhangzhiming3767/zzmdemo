package com.example.zzmdemo.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "sys_user")
@EqualsAndHashCode(callSuper = false)
public class SysUser extends BaseEntity {
    @Id
    private String id;
    @Excel(name = "登录名", width = 30)
    private String loginName;
    @Excel(name = "手机号码", width = 30)
    private String phone;
    @Excel(name = "密码", width = 30)
    private String password;
    private String userName;
    @Excel(name = "性别", width = 30)
    private Integer sex;
    @Excel(name = "身份证", width = 30)
    private String idCard;
    @Excel(name = "人员类别", width = 30)
    private Integer rylb;
    private String photo;
    private Integer userState;


}

package com.example.zzmdemo.core;

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
    private String loginName;
    private String phone;
    private String password;
    private String userName;
    private Integer sex;
    private String idCard;
    private Integer rylb;
    private String photo;
    private Integer userState;


}

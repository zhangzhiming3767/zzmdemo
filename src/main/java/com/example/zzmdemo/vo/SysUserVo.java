package com.example.zzmdemo.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.example.zzmdemo.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
//@Table(name = "sys_user")
@EqualsAndHashCode(callSuper = false)
public class SysUserVo extends BaseEntity {

    //    @Excel(name = "登录名", width = 30)
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
    private String token;


}

package com.example.zzmdemo.core;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "sys_user")
public class SysUser {
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    private Date modifiedTime;


}

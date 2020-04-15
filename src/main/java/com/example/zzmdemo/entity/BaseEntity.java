package com.example.zzmdemo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Id;

//import javax.persistence.Id;
import java.util.Date;

@Data
public class BaseEntity {
    @Id
    private String id;
    /**
     * 1有效 2删除
     */
    private Integer deleteFlag;
    private String createBy;
    private String updateBy;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
}

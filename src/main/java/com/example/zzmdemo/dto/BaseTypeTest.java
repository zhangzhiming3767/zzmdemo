package com.example.zzmdemo.dto;

import lombok.Data;

import java.util.List;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *
 * @author zhangzhiming
 * @since 2020/2/16 17:09
 */
@Data
public class BaseTypeTest {
    private byte a;
    private short b;
    private int c;
    private long d;
    private float e;
    private double f;
    private char g;
    private boolean h;
    private Byte a2;
    private Short b2;
    private Integer c2;
    private Long d2;
    private Float e2;
    private Double f2;
    private Character g2;
    private Boolean h2;
    private List<BaseTypeTest> baseTypeTestList;
}

package com.example.zzmdemo.entity.test;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2019 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *
 * @author zhangzhiming
 * @since 2019/12/10 10:53
 */
public class Student {

    private int stuNum;
    private String name;

    public Student(int stuNum, String name) {
        this.stuNum = stuNum;
        this.name = name;
    }

    public int getStuNum() {
        return stuNum;
    }

    public String getName() {
        return name;
    }

    /**
    * @author :zhangzhiming
    * description :这个方法是通过比较学校stuNum来判断对象是否相等的，学号一致，所以两人一致，所以需要用stuNum来生成hashcode
    * @date :Create in  2019/12/10 11:20
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Student) {
            if (this.getStuNum() == ((Student) obj).getStuNum()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return getStuNum();
    }
}

package com.example.zzmdemo.nothingtodowithproject.javaBaseTest;

import com.example.zzmdemo.entity.SysUser;
import com.example.zzmdemo.utils.DateUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *
 * @author zhangzhiming
 * @since 2020/5/26 14:44
 */
public class Test {

    public static void main(String[] args) throws IOException {
        SysUser [] user=new SysUser[5];
        List<? extends SysUser> flist = new ArrayList<SysUser>();


    }

    /**
     * 之前做的测试
     */
    private  void test(){
                String birthday = "320721199511142437".substring(6, 14);
        int age=DateUtil.getAgeByBirth(birthday);
        System.out.println(age);
        StringBuilder bornDate=new StringBuilder();
        bornDate.append(birthday.substring(0,4)).append("-").append(birthday.substring(4,6)).append("-").append(birthday.substring(6,8));
        System.out.println(bornDate.toString());
        List<String> accuContentList=new ArrayList<>();
        accuContentList.add("第一句话。");
        accuContentList.add("第二句话。");
        Integer modified=Integer.valueOf("2020-06-09 16:43:15".substring(5,7));
        System.out.println(String.join("",accuContentList));
        System.out.println(modified);
    }
}

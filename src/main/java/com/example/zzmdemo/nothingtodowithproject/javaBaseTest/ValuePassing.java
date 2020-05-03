package com.example.zzmdemo.nothingtodowithproject.javaBaseTest;

import com.example.zzmdemo.dto.HeroNode;
import com.example.zzmdemo.entity.SysUser;

import java.util.ArrayList;
import java.util.List;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *  值传递与引用传递的测试
 * @author zhangzhiming
 * @since 2020/5/3 15:11
 */
public class ValuePassing {

    public static void main(String[] args) {
        HeroNode temp = null;
        for (int i = 0; i < 3; i++) {
            HeroNode heroNode = new HeroNode();
            heroNode.setId(i + "");
            heroNode.setNo(i);
            heroNode.setNickName("第" + i + "个节点");
            //头插法
            temp = SingleLinkList.addNodeTail(temp, heroNode);
        }
        //这就是一个引用传递的例子，如果传递的是值，则可不能返返回这个结果
        temp = SingleLinkList.reverseV4(temp);
        changeNode(temp);
        System.out.println(temp.toString());
        String s="ab";
        changeString(s);
        System.out.println(s);
        System.out.println("s "+s.hashCode());
        Boolean booleanTest=false;
        changeBoolean(booleanTest);
        System.out.println(booleanTest);
        List<SysUser> sysUserList=new ArrayList<>();
        SysUser sysUser=new SysUser();
        sysUser.setLoginName("这是登录名");
        sysUserList.add(sysUser);
        changeList(sysUserList);
        System.out.println(sysUser.toString());
        changeListV2(sysUserList);
        System.out.println(sysUser.toString());
        System.out.println("sysUser "+sysUser.hashCode());
    }

    private static void changeString(String s){
       s="cd";
        System.out.println("changeString s "+s.hashCode());
    }
    private static void changeNode(HeroNode node){
        node.nickName="改个名字试试";
    }

    private static void changeBoolean(Boolean booleanTest){
        booleanTest=true;
    }
    private static List<SysUser> changeList(List<SysUser> sysUserList){
        sysUserList.get(0).setLoginName("更改后的登录名");
        return sysUserList;
    }
    private static void changeListV2(List<SysUser> sysUserList){
        sysUserList.get(0).setLoginName("再改回去");
        System.out.println("sysUser "+sysUserList.get(0).hashCode());
    }
}

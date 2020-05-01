package com.example.zzmdemo.nothingtodowithproject.javaBaseTest;

import com.example.zzmdemo.entity.SysOrg;

import java.io.*;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *  序列化与反序列化
 * @author zhangzhiming
 * @since 2020/5/1 15:13
 */
public class SerializableTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //序列化
        FileOutputStream fos = new FileOutputStream("object.out");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        SysOrg student1 = new SysOrg();
        student1.setOrgName("组织名称");
        student1.setLeftNode(2);
        student1.setRightNode(3);
        oos.writeObject(student1);
        oos.flush();
        oos.close();
        //反序列化
        FileInputStream fis = new FileInputStream("object.out");
        ObjectInputStream ois = new ObjectInputStream(fis);
        SysOrg student2 = (SysOrg) ois.readObject();
        System.out.println(student2.getOrgName()+ " " +
                student2.getLeftNode() + " " + student2.getRightNode());
    }
}

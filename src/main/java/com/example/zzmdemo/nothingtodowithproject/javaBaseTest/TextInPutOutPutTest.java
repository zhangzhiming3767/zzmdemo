package com.example.zzmdemo.nothingtodowithproject.javaBaseTest;

import java.io.*;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *
 * @author zhangzhiming
 * @since 2020/5/1 15:37
 */
public class TextInPutOutPutTest {
    public static void main(String[] args) throws IOException {
        String path = "E:\\1\\3工作\\测试\\test.txt";
        File file = new File(path);
        if(!file.exists()){
            file.getParentFile().mkdirs();
        }
        file.createNewFile();

        read(file);
    }

    private static void write(File file) throws IOException {
        FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("text内容读写测试");
        bw.flush();
        bw.close();
        fw.close();
    }
    private static void read(File file) throws IOException {
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        //每次会自动读取下一行
        String content;
        while ( (content=br.readLine())!=null){
            System.out.println(content);
        }
    }
}

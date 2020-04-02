package com.example.zzmdemo.common;




import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *
 * @author zhangzhiming
 * @since 2020/4/2 9:49
 */
public class CodeGenerator {
    public static void main(String[] args) throws Exception {
        // MBG执行过程中的警告信息
        List<String> warnings = new ArrayList<>();

        // 当生成的代码重复时，覆盖原代码
        boolean overwrite = true;

//        // 读取MBG配置文件
//        InputStream is = CodeGenerator.class.getResourceAsStream("/generator/generatorConfig.xml");
//        ConfigurationParser cp = new ConfigurationParser(warnings);
//        Configuration config = cp.parseConfiguration(is);
//        is.close();
//
//        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
//
//        // 创建MBG
//        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
//
//        // 执行生成代码
//        myBatisGenerator.generate(null);
//
//        // 输出警告信息
//        for (String warn : warnings) {
//            System.out.println(warn);
//        }
    }

}

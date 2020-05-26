package com.example.zzmdemo.nothingtodowithproject.javaBaseTest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    public static void main(String[] args)  {
        List<String> list=new ArrayList<>();
        list.add(null);
        list.add(null);
        System.out.println(CollectionUtils.isEmpty(list));

    }
}

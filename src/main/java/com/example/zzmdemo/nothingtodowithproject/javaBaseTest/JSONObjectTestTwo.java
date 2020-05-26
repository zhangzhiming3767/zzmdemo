package com.example.zzmdemo.nothingtodowithproject.javaBaseTest;



import com.example.zzmdemo.entity.SysUser;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *
 * @author zhangzhiming
 * @since 2020/5/24 9:44
 */
public class JSONObjectTestTwo {

    public static void main(String[] args) {
        Map<String, Object> reMap = new HashMap<>();
        reMap.put("aaa",null);
        reMap.put("bbb","有值");
        reMap.put("ccc",new SysUser());

    }
}

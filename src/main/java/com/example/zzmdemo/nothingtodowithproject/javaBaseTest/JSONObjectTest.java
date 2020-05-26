package com.example.zzmdemo.nothingtodowithproject.javaBaseTest;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.zzmdemo.entity.SysUser;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *
 * @author zhangzhiming
 * @since 2020/5/24 9:44
 */
public class JSONObjectTest {

    public static void main(String[] args) {
        Map<String, String> reMap = new HashMap<>();
        reMap.put("aaa",null);
        reMap.put("bbb","有值");
        String jsonZero = JSONObject.toJSONString(reMap);
        System.out.println(jsonZero);
        String json = JSONObject.toJSONString(reMap,SerializerFeature.WriteMapNullValue);
        String json1 = JSONObject.toJSONString(reMap,SerializerFeature.WRITE_MAP_NULL_FEATURES);
        System.out.println("json:"+json);
        System.out.println("json1:"+json1);

    }


}

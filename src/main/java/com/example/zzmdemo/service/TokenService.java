package com.example.zzmdemo.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *
 * @author zhangzhiming
 * @since 2020/5/14 17:21
 */
@Service
public class TokenService {

    public String getToken(String userId,String passWord) {
        return JWT.create().withAudience(userId)
                .sign(Algorithm.HMAC256(passWord));
    }
}

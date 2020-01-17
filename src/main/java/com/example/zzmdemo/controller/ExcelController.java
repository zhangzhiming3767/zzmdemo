package com.example.zzmdemo.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.example.zzmdemo.entity.SysUser;
import com.example.zzmdemo.mapper.JdbcTestMapper;
import com.example.zzmdemo.service.UserService;
import com.example.zzmdemo.utils.EasyPoiUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2019 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *
 * @author zhangzhiming
 * @since 2019/12/30 19:48
 */
@RestController
@RequestMapping("/export")
public class ExcelController {
    @Resource
    private JdbcTestMapper jdbcTestMapper;


    @RequestMapping("word")
    public void export(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> params = new HashMap<>();
        params.put("title111", "这是标题");
        params.put("name111", "李四");
//        params.put("test", null);
        //
        EasyPoiUtils.exportWord("word/aaa.docx", "E:/1/00Ztesoft/余杭", "aaa.docx", params, request, response);
    }
    @GetMapping("excel")
    public void excel(HttpServletRequest request, HttpServletResponse response) {
        List<SysUser> sysUserList=jdbcTestMapper.userTest();
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(null, null), SysUser.class, sysUserList);
        try {
            response.setCharacterEncoding("UTF-8");
            response.setHeader("content-Type", "application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("人员列表.xls", "UTF-8"));
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /**
    * @author :zhangzhiming
    * description :请求https路径报错说 证书问题的，设置为忽略
    * @date :Create in  2020/1/17 19:49
    */
    public void test() throws Exception {
        trustAllHttpsCertificates();
        HttpURLConnection connection = (HttpURLConnection) new URL("https://yhdjtest.oss-cn-hangzhou.aliyuncs.com/yhdjexample/20200102/c79b1e0b-eaab-458e-b618-fc1b69e282eb.png").openConnection();
        connection.setReadTimeout(5000);
        connection.setConnectTimeout(5000);
        connection.setDoInput(true);
        connection.setDoOutput(true);
        connection.setUseCaches(false);
        ((HttpsURLConnection) connection).setHostnameVerifier(new CustomizedHostnameVerifier());
        connection.setRequestMethod("GET");
        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            InputStream inputStream = connection.getInputStream();
        }
    }

    private static void trustAllHttpsCertificates() throws Exception {
        javax.net.ssl.TrustManager[] trustAllCerts = new javax.net.ssl.TrustManager[1];
        javax.net.ssl.TrustManager tm = new miTM();
        trustAllCerts[0] = tm;
        javax.net.ssl.SSLContext sc = javax.net.ssl.SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, null);
        javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
    }
    static class miTM implements javax.net.ssl.TrustManager, javax.net.ssl.X509TrustManager {
        @Override
        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public boolean isServerTrusted(java.security.cert.X509Certificate[] certs) {
            return true;
        }

        public boolean isClientTrusted(java.security.cert.X509Certificate[] certs) {
            return true;
        }
        @Override
        public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType)
                throws java.security.cert.CertificateException {
            return;
        }
        @Override
        public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType)
                throws java.security.cert.CertificateException {
            return;
        }
    }

    /**
     * 自定义验证类
     */
    public static class CustomizedHostnameVerifier implements HostnameVerifier {
        /**
         * 重写验证方法
         *
         * @param arg0
         * @param arg1
         * @return
         */
        @Override
        public boolean verify(String arg0, SSLSession arg1) {
            //所有都正确
            return true;
        }
    }


}

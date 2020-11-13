package com.example.zzmdemo.controller;

import cn.afterturn.easypoi.entity.ImageEntity;
import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.alibaba.fastjson.JSON;
import com.example.zzmdemo.dto.SysUserDto;
import com.example.zzmdemo.entity.SysUser;
import com.example.zzmdemo.entity.response.FailedResponse;
import com.example.zzmdemo.entity.response.ObjectResponse;
import com.example.zzmdemo.entity.response.Response;
import com.example.zzmdemo.entity.response.SuccessResponse;
import com.example.zzmdemo.mapper.JdbcTestMapper;
import com.example.zzmdemo.mapper.UserMapper;
import com.example.zzmdemo.utils.EasyPoiUtils;
import com.example.zzmdemo.utils.token.PassToken;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
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
    @Resource
    private UserMapper userMapper;

    @RequestMapping("word")
    public void export(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> params = new HashMap<>();
        params.put("title111", "这是标题");
        params.put("name111", "李四");
//        params.put("test", null);
        //
        EasyPoiUtils.exportWord("word/aaa.docx", "E:/1/00Ztesoft/余杭", "aaa.docx", params, request, response);
    }

    /**
    * @author :zhangzhiming
    * description :导出json
    * @date :Create in  2020/5/26 20:06
    */
    @PassToken
    @GetMapping(value={"/exportJson"})
    public void exportJson(HttpServletResponse response) throws IOException {
        String userPath = "temporary"+ File.separator+"user.json";
        SysUser sysUser = new SysUser();
        sysUser.setLoginName("登录名");
        sysUser.setId("这是id");
        List<SysUser> sysUserList=new ArrayList<>();
        sysUserList.add(sysUser);
        File aFile = new File(userPath);
        if (!aFile.exists() ) {
            File temporary = new File("temporary");
            if(!temporary.mkdirs() &&
                    !aFile.createNewFile()){
                throw new RuntimeException("文件夹生成失败");
            }
        }
        FileOutputStream fileOutputStream = new FileOutputStream(aFile);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(JSON.toJSONString(sysUserList));
        objectOutputStream.flush();
        objectOutputStream.close();
        //上传到服务器
        InputStream inputStream = new FileInputStream(userPath);
        // 设置强制下载不打开
        response.setContentType("application/force-download");
        // 设置文件名
        response.addHeader("Content-Disposition", "attachment;fileName=user.json");
        OutputStream out = response.getOutputStream();
        int temp = 0;
        while ((temp = inputStream.read()) != -1) {
            out.write(temp);
        }
        inputStream.close();
        out.close();
        EasyPoiUtils.delAllFile( new File(userPath));
    }

    @GetMapping("excel")
    public void excel(HttpServletRequest request, HttpServletResponse response,Integer count) {
//        List<SysUser> sysUserList = userMapper.userTest();
        List<SysUser> sysUserList=new ArrayList<>();
        for(int i=0;i<count;i++){
            SysUser sysUser=new SysUser();
            sysUser.setLoginName("人员名称"+i);
            sysUserList.add(sysUser);
        }
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

    @GetMapping("hutoolExcelExport")
    public void hutoolExcelExport(HttpServletRequest request, HttpServletResponse response,Integer count) {
        List<SysUser> sysUserList=new ArrayList<>();
        for(int i=0;i<count;i++){
            SysUser sysUser=new SysUser();
            sysUser.setLoginName("人员名称"+i);
            sysUserList.add(sysUser);
        }
        ExcelWriter excelWriter= ExcelUtil.getBigWriter(-1);
        //自定义标题别名
        excelWriter.addHeaderAlias("loginName", "登录名");
        excelWriter.write(sysUserList, true);
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + "tets" + ".xlsx");
        ServletOutputStream out = null;
        try {
            out = response.getOutputStream();
            excelWriter.flush(out, true);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            excelWriter.close();
        }
        IoUtil.close(out);

    }


    /**
    * @author :zhangzhiming
    * description :读取excel
    * @date :Create in  2020/4/3 10:36
    */
    @PostMapping("importExcel")
    public Response importExcel(HttpServletRequest request, MultipartFile file) throws IOException {
        Workbook workbook = new XSSFWorkbook(file.getInputStream());
        List<SysUserDto> list = new ArrayList<>();
        Sheet sheet = workbook.getSheetAt(0);
        int count = sheet.getLastRowNum();
        if(count<2){
            return new FailedResponse("");
        }
        for (int j = 0; j <= count; j++) {
            Row row = sheet.getRow(j);
            SysUserDto dto = new SysUserDto();
            dto.setId(String.valueOf(row.getCell(0).getNumericCellValue()));
            dto.setUserName(row.getCell(1).getStringCellValue());
            dto.setPhone(String.valueOf(row.getCell(2).getNumericCellValue()));
            list.add(dto);
        }
        return new ObjectResponse<>(list);
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
            byte[] data = readInputStream(inputStream);
            FileOutputStream outStream = new FileOutputStream("yhdj-cadre-admin/src/main/resources/export/temporary/test.png");
            //把文件数据写到输出流中
            outStream.write(data);
            outStream.close();
        }
        ImageEntity image = new ImageEntity();
        image.setHeight(250);
        image.setWidth(200);
        image.setUrl("yhdj-cadre-admin/src/main/resources/export/temporary/test.png");
        image.setType(ImageEntity.URL);
    }

    public static byte[] readInputStream(InputStream inStream) throws Exception {
        //构造一个ByteArrayOutputStream
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        //设置一个缓冲区
        byte[] buffer = new byte[1024];
        int len = 0;
        //判断输入流长度是否等于-1  ，即非空
        while ((len = inStream.read(buffer)) != -1) {
            //把缓冲区的内容写入到输出流中，从0开始读取，长度为len
            outStream.write(buffer, 0, len);
        }
        inStream.close();
        return outStream.toByteArray();
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

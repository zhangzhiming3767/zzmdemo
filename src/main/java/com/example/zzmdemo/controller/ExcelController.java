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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
        params.put("test", new Date());
        //
        EasyPoiUtils.exportWord("word/aa.docx", "E:/1/00Ztesoft/余杭", "aaa.docx", params, request, response);
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


}

package com.example.zzmdemo.controller.org;


import com.example.zzmdemo.entity.response.ObjectResponse;
import com.example.zzmdemo.entity.response.Response;
import com.example.zzmdemo.service.ISysOrgService;
import com.example.zzmdemo.vo.SysOrgVo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 组织表 前端控制器
 * </p>
 *
 * @author zhangzhiming
 * @since 2020-04-13
 */
@RestController
@RequestMapping("/sysOrg")
public class SysOrgController {
    @Resource
    private ISysOrgService sysOrgService;
    @RequestMapping("/qryChildByParentId")
    public Response qryChildByParentId(@RequestParam String parentId) {
        return new ObjectResponse<>(sysOrgService.qryChildByParentId(parentId));
    }

    @RequestMapping("/add")
    public Response add(@RequestBody SysOrgVo sysOrgVo) {
        return sysOrgService.add(sysOrgVo);
    }

    @RequestMapping("/deleteById")
    public Response deleteById(@RequestParam String id) {
        return sysOrgService.deleteById(id);
    }


    @RequestMapping("/qryById")
    public Response qryById(@RequestParam String id) {

        return null;
    }



    @RequestMapping("/updateById")
    public Response updateById(@RequestParam String id) {

        return null;
    }


}

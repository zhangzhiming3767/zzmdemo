package com.example.zzmdemo.service;

import com.example.zzmdemo.common.IdGenerator;
import com.example.zzmdemo.core.SysMenu;
import com.example.zzmdemo.mapper.MenuMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class MenuService {
    @Resource
    private MenuMapper menuMapper;
    @Resource
    private IdGenerator idGenerator;

    /**
     * @author zhangzhiming
     * description
     * @date 14:57 2019/11/5
     */
    public List<SysMenu> getMenuList() {
        return menuMapper.getMenuList();
    }


}

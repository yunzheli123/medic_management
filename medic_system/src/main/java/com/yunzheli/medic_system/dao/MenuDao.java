package com.yunzheli.medic_system.dao;

import com.yunzheli.medic_system.bean.MainMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuDao {
    public List<MainMenu> getMenus();
}

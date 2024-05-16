package main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import main.dao.ManagerDao;
import main.pojo.Manager;
import main.service.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService{
    @Autowired
    ManagerDao managerDao;
    @Override
    public List<Manager> selectAll() {
        return managerDao.selectAll();
    }
    
    @Override
    public Manager selectByAccount(String account) {
        QueryWrapper<Manager> qw = new QueryWrapper<>();
        qw.eq("account", account);
        return managerDao.selectOne(qw);
    }    
}

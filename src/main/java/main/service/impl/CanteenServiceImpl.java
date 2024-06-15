package main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import main.dao.CanteenDao;
import main.pojo.Canteen;

import main.service.CanteenService;

@Service
public class CanteenServiceImpl implements CanteenService{
    @Autowired
    private CanteenDao canteenDao;

    @Override
    public List<Canteen> selectAllCanteen() {
        return canteenDao.selectList(null);
    }
    
}

package main.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import main.pojo.Manager;

@Mapper
@Repository
public interface ManagerDao extends BaseMapper<Manager>{
        public List<Manager> selectAll();
}
package main.service;

import java.util.List;

import main.pojo.Manager;

public interface ManagerService {
    public List<Manager> selectAll();
    public Manager selectByAccount(String account);
    public Manager selectById(Integer id);
    public boolean update(Manager manager);
}

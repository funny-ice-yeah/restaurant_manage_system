package main.service;

import java.util.List;


import main.pojo.User;

public interface UserService {
    public List<User> selectAll();
    public User selectById(Integer id);
    public boolean insert(User user);
    public boolean update(User user);
    public boolean deleteById(Integer id);
}
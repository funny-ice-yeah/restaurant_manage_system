package main.service;

import java.util.List;


import main.pojo.User;

public interface UserService {
    public List<User> listUser();
    public User getUserById(Integer id);
    public boolean createUser(User user);
    public boolean updateUser(User user);
    public boolean deleteUserById(Integer id);
}
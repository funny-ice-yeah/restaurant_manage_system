package main.service;

import java.util.List;

import main.dto.UserDTO;
import main.pojo.User;

public interface UserService {
    public List<User> selectAll();
    public User selectById(Integer id);
    public User selectByRoleId(String id);
    public List<UserDTO> selectPage(Integer pageNum, Integer pageSize);
    public boolean insert(User user);
    public boolean update(User user);
    public boolean deleteById(Integer id);
    public UserDTO convert2Dto(User user);
    public User convert2Pojo(UserDTO userDTO);
}
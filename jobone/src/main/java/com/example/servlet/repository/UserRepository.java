package com.example.servlet.repository;


import com.example.servlet.entity.User;

public interface UserRepository {

    public int save(User user);
    public long update(User user);
    public Long findUser(String username, String password);
public Long  deleteuser(User user);
    public int savefor(User user2);

  public   Long findUserfor(String username, String password);

    public Long deleteusertttttuu(User user);
}

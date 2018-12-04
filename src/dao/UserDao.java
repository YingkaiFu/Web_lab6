package dao;

import vo.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface UserDao {
    boolean login(String username, String pwd);

    boolean logup(String username, String pwd, String phone, String tel, String email, String add);

    List<User> queryAll();
}

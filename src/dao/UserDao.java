package dao;

import java.util.ArrayList;
import java.util.Map;

public interface UserDao {
    boolean login(String username, String pwd);

    boolean logup(String username, String pwd, String phone, String tel, String email, String add);

    ArrayList<Map> queryAll();
}

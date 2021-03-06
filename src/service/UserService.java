package service;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import vo.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserService {
    private UserDao userdao =new UserDaoImpl();

    public boolean login(String id, String password) {
        return userdao.login(id, password);
    }

    public boolean logup(String id, String password, String phone, String tel, String email, String add) {
        return userdao.logup(id, password, phone, tel, email, add);
    }

    public List<User> quaryUsers(){
        return userdao.queryAll();
    }
    public int getIdByName(String name){
        return userdao.getIdByName(name);
    }
}

package service;

import dao.UserDao;
import dao.impl.UserDaoImpl;

public class UserService {
    private UserDao userdao =new UserDaoImpl();

    public boolean login(String id, String password) {
        return userdao.login(id, password);
    }

    public boolean logup(String id, String password, String phone, String tel, String email, String add) {
        return userdao.logup(id, password, phone, tel, email, add);
    }
}

package service;

import dao.UserDao;
import dao.impl.UserDaoImpl;

public class UserService {
    private UserDao userdao =new UserDaoImpl();

    public Boolean login(String id, String password) {
        return userdao.login(id, password);
    }

    public Boolean logup(String id, String password) {
        return userdao.logup(id, password);
    }
}

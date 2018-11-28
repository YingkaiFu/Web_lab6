package service;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import vo.User;

public class UserService {
    private UserDao userdao =new UserDaoImpl();
    public User login(User user){
        return userdao.lgoin(user);
    }
}

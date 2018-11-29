package dao;

public interface UserDao {
    public boolean login(String username, String pwd);

    public boolean logup(String username, String pwd, String phone, String tel, String email, String add);
}

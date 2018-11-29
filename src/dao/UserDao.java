package dao;

public interface UserDao {
    public Boolean login(String username, String pwd);

    public Boolean logup(String username, String pwd);
}

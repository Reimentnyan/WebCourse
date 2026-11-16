package vn.iotstar.webcourse.service;
import vn.iotstar.webcourse.model.User;

public interface UserService {
    User login(String username, String password);
    boolean register(String username, String password, String email, String fullname, String phone);
    boolean checkExistEmail(String email);
    boolean checkExistUsername(String username);
}
package vn.iotstar.webcourse.service.impl;


import vn.iotstar.webcourse.dao.UserDao;
import vn.iotstar.webcourse.dao.impl.UserDaoImpl;
import vn.iotstar.webcourse.model.User;
import vn.iotstar.webcourse.service.UserService;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    @Override
    public User login(String username, String password) {
        User user = userDao.get(username);
        if (user != null && password.equals(user.getPassWord())) {
            return user;
        }
        return null;
    }

    @Override
    public boolean register(String username, String password, String email, String fullname, String phone) {
        if (userDao.checkExistUsername(username)) {
            return false;
        }
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);

        User user = new User();
        user.setEmail(email);
        user.setUserName(username);
        user.setFullName(fullname);
        user.setPassWord(password);
        user.setRoleid(5);
        user.setPhone(phone);
        user.setCreatedDate(date);

        userDao.insert(user);
        return true;
    }

    @Override
    public boolean checkExistEmail(String email) {
        return userDao.checkExistEmail(email);
    }

    @Override
    public boolean checkExistUsername(String username) {
        return userDao.checkExistUsername(username);
    }
}
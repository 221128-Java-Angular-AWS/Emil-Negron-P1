package main.java.com.revature.service;

import main.java.com.revature.exceptions.IncorrectPasswordException;
import main.java.com.revature.exceptions.UserNotFoundException;
import main.java.com.revature.persistence.UserDao;
import main.java.com.revature.pojos.UserPojo;
public class UserService {
    private UserDao dao;

    public UserService(UserDao dao) {
        this.dao = dao;
    }

    public void registerNewUser(UserPojo user) {

        dao.createUser(user);
    }

    public void updateUser(UserPojo user) {
        dao.updateUser(user);
    }

    public void deleteUser(Integer userId) {
        dao.deleteUser(userId);
    }

    public void deleteUser(UserPojo user) {
        dao.deleteUser(user.getUserId());
    }

    public UserPojo authenticateUser(UserPojo user) throws UserNotFoundException, IncorrectPasswordException {
        return dao.UserAuthentication(user.getEmail(), user.getPassword());
    }

    public UserPojo authenticateUser(String email, String password) throws UserNotFoundException, IncorrectPasswordException {
        return dao.UserAuthentication(email, password);
    }

    public UserPojo getUserById(Integer userId) {
        return dao.getUserById(userId);
    }
}

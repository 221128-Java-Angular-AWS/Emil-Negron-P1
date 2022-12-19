package main.java.com.revature.persistence;

import main.java.com.revature.exceptions.UserNotFoundException;
import main.java.com.revature.pojos.UserPojo;
import main.java.com.revature.exceptions.IncorrectPasswordException;

import java.sql.*;

public class UserDao {
    private Connection connection;

    public UserDao() {
        this.connection = ConnectionManager.getConnection();
    }

    public void createUser(UserPojo user) {
        try {
            String sql = "INSERT INTO users (email, first_name, last_name, password, pos_role," +
                    "ticket_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getFirst_name());
            pstmt.setString(4, user.getLast_name());
            pstmt.setString(5, user.getPassword());
            pstmt.setString(6, user.getPos_role());
            pstmt.setInt(7,user.getTicketNum());

            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if(rs.next()) {
                user.setUserId(rs.getInt("user_id"));
                System.out.println("DEBUG - auto generated key: " + user.getUserId());
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public UserPojo UserAuthentication(String email, String password) throws UserNotFoundException,
            IncorrectPasswordException {
        try {
            String sql = "SELECT * FROM users WHERE username = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, email);

            ResultSet rs = pstmt.executeQuery();

            if(!rs.next()) {
                throw new UserNotFoundException("This username was not found or was entered incorrectly");
            }

            UserPojo user = new UserPojo(rs.getInt("user_id"), rs.getString("email"),
                    rs.getString("first_name"), rs.getString("last_name"),
                    rs.getString("password"), rs.getString("pos_role"),
                    rs.getInt("ticket_id"));

            if(user.getPassword().equals(password)) {
                return user;
            }

            throw new IncorrectPasswordException("Incorrect Password");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public UserPojo getUserById(Integer userId) {
        UserPojo user = new UserPojo();
        try {
            String sql = "SELECT * FROM users WHERE user_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();

            if(rs.next()) {
                user = new UserPojo(rs.getInt("user_id"), rs.getString("email"),
                        rs.getString("first_name"), rs.getString("last_name"),
                        rs.getString("password"), rs.getString("pos_role"),
                        rs.getInt("ticket_id"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void updateUser(UserPojo user) {
        try {
            String sql = "UPDATE users SET first_name = ?, last_name = ?, password = ? WHERE user_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, user.getFirst_name());
            pstmt.setString(2, user.getLast_name());
            pstmt.setString(4, user.getPassword());
            pstmt.setInt(5, user.getUserId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void deleteUser(Integer userId) {
        try {
            String sql = "DELETE FROM users WHERE user_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, userId);

            pstmt.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

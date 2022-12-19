package main.java.com.revature.pojos;

import java.util.Objects;

public class UserPojo {
    private Integer userId;
    private String email;
    private String first_name;
    private String last_name;
    private String password;
    private String pos_role;
    private Integer ticketNum;

    public UserPojo() {
    }

    public UserPojo(Integer userId, String email, String first_name, String last_name, String password, String pos_role,
                    Integer ticketNum) {
        this.userId = userId;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.password = password;
        this.pos_role = pos_role;
        this.ticketNum = ticketNum;
    }

    public UserPojo(String email, String first_name, String last_name, String password, String pos_role,
                    Integer ticketNum) {
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.password = password;
        this.pos_role = pos_role;
        this.ticketNum = ticketNum;
    }

    public UserPojo(String email, String first_name, String last_name, String password, String pos_role) {
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.password = password;
        this.pos_role = pos_role;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPos_role() {
        return pos_role;
    }

    public void setPos_role(String pos_role) {
        this.pos_role = pos_role;
    }

    public Integer getTicketNum() {
        return ticketNum;
    }

    public void setTicketNum(Integer ticketNum) {
        this.ticketNum = ticketNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPojo userPojo = (UserPojo) o;
        return Objects.equals(userId, userPojo.userId) && Objects.equals(email, userPojo.email) &&
                Objects.equals(first_name, userPojo.first_name) && Objects.equals(last_name, userPojo.last_name) &&
                Objects.equals(password, userPojo.password) && Objects.equals(pos_role, userPojo.pos_role) &&
                Objects.equals(ticketNum, userPojo.ticketNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, email, first_name, last_name, password, pos_role, ticketNum);
    }
}

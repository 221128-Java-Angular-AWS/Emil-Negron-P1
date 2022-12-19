package main.java.com.revature.persistence;

import main.java.com.revature.pojos.TicketPojo;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;

public class TicketDao {
    private Connection connection;

    public TicketDao() {
        this.connection = ConnectionManager.getConnection();
    }

    public void createTicket(TicketPojo ticket) {
        try {
            String sql = "INSERT INTO tickets (ticket_id, user_id, amount, description, date_sub, status, date_proc, " +
                    "approved) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, ticket.getTicketId());
            pstmt.setInt(2,ticket.getUserNum());
            pstmt.setDouble(3, ticket.getAmount());
            pstmt.setString(4, ticket.getDescription());
            pstmt.setTimestamp(5, ticket.getDateSubmitted());
            pstmt.setBoolean(6, ticket.getStatus());
            pstmt.setTimestamp(7, ticket.getDateProcessed());
            pstmt.setBoolean(8, ticket.getApproved());

            pstmt.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    public TicketPojo getTicketById(Integer id) {
        TicketPojo ticket = new TicketPojo();

        try {
            String sql = "SELECT * FROM tickets WHERE ticket_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1,id);
            ResultSet result = pstmt.executeQuery();

            while(result.next()) {
                ticket.setTicketId(result.getInt("ticket_id"));
                ticket.setUserNum(result.getInt("user_id"));
                ticket.setAmount(result.getDouble("amount"));
                ticket.setDescription(result.getString("description"));
                ticket.setDateSubmitted(result.getTimestamp("date_sub"));
                ticket.setStatus(result.getBoolean("status"));
                ticket.setDateProcessed(result.getTimestamp("date_proc"));
                ticket.setApproved(result.getBoolean("approved"));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return ticket;
    }

    public void updateTicket(TicketPojo ticket) {
        try{
            String sql = "UPDATE tickets SET amount = ?, description = ?, status = ?, date_proc = ?, approved = ? " +
                    "WHERE ticket_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setInt(1, ticket.getTicketId());
            pstmt.setInt(2, ticket.getUserNum());
            pstmt.setDouble(3, ticket.getAmount());
            pstmt.setString(4, ticket.getDescription());
            pstmt.setTimestamp(5, ticket.getDateSubmitted());
            pstmt.setBoolean(6, ticket.getStatus());
            pstmt.setTimestamp(7,ticket.getDateProcessed());
            pstmt.setBoolean(8, ticket.getApproved());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTicket(Integer id) {
        try {
            String sql = "DELETE FROM tickets WHERE ticket_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();


        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}

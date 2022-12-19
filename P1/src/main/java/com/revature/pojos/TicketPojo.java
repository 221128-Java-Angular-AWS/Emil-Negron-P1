package main.java.com.revature.pojos;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

public class TicketPojo {
    private Integer ticketId;
    private Integer userNum;
    private Double amount;
    private String description;
    private Timestamp dateSubmitted;
    private Boolean status;
    private Timestamp dateProcessed;
    private Boolean approved;

    public TicketPojo() {
    }

    public TicketPojo(Integer ticketId, Integer userNum, Double amount, String description, Timestamp dateSubmitted,
                      Boolean status, Timestamp dateProcessed, Boolean approved){
        this.ticketId = ticketId;
        this.userNum = userNum;
        this.amount = amount;
        this.description = description;
        this.dateSubmitted = dateSubmitted;
        this.status = status;
        this.dateProcessed = dateProcessed;
        this.approved = approved;
    }

    public TicketPojo(Integer userNum, Double amount, String description, Timestamp dateSubmitted, Boolean status,
                      Timestamp dateProcessed, Boolean approved) {
        this.userNum = userNum;
        this.amount = amount;
        this.description = description;
        this.dateSubmitted = dateSubmitted;
        this.status = status;
        this.dateProcessed = dateProcessed;
        this.approved = approved;
    }

    public TicketPojo(Double amount, String description, Timestamp dateSubmitted, Boolean status,
                      Timestamp dateProcessed, Boolean approved) {
        this.amount = amount;
        this.description = description;
        this.dateSubmitted = dateSubmitted;
        this.status = status;
        this.dateProcessed = dateProcessed;
        this.approved = approved;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public Integer getUserNum() {
        return userNum;
    }

    public void setUserNum(Integer userNum) {
        this.userNum = userNum;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getDateSubmitted() {
        return dateSubmitted;
    }

    public void setDateSubmitted(Timestamp dateSubmitted) {
        this.dateSubmitted = dateSubmitted;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Timestamp getDateProcessed() {
        return dateProcessed;
    }

    public void setDateProcessed(Timestamp dateProcessed) {
        this.dateProcessed = dateProcessed;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketPojo that = (TicketPojo) o;
        return Objects.equals(ticketId, that.ticketId) && Objects.equals(userNum, that.userNum) &&
                Objects.equals(amount, that.amount) && Objects.equals(description, that.description) &&
                Objects.equals(dateSubmitted, that.dateSubmitted) && Objects.equals(status, that.status) &&
                Objects.equals(dateProcessed, that.dateProcessed) && Objects.equals(approved, that.approved);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketId, userNum, amount, description, dateSubmitted, status, dateProcessed, approved);
    }
}
package main.java.com.revature.service;

import main.java.com.revature.persistence.TicketDao;
import main.java.com.revature.pojos.TicketPojo;

public class TicketService {
    TicketDao dao;

    public TicketService(TicketDao dao) {
        this.dao = dao;
    }

    public void createNewTicket(TicketPojo ticket) {
        dao.createTicket(ticket);
    }

    public TicketPojo getTicket(Integer TicketId) {
        return dao.getTicketById(TicketId);
    }

    public TicketPojo getTask(TicketPojo ticket) {
        return dao.getTicketById(ticket.getTicketId());
    }

    public void updateTicket(TicketPojo ticket) {
        dao.updateTicket(ticket);
    }

    public void deleteTicket(Integer TicketId) {
        dao.deleteTicket(TicketId);
    }

    public void deleteTicket(TicketPojo ticket) {
        dao.deleteTicket(ticket.getTicketId());
    }
}

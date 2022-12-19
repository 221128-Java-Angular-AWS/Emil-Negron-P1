package main.java.com.revature.Javalin;

import main.java.com.revature.exceptions.UserNotFoundException;
import main.java.com.revature.exceptions.IncorrectPasswordException;
import main.java.com.revature.pojos.UserPojo;
import main.java.com.revature.pojos.TicketPojo;
import main.java.com.revature.service.TicketService;
import main.java.com.revature.service.UserService;
import main.java.com.revature.persistence.UserDao;
import main.java.com.revature.persistence.TicketDao;

import io.javalin.Javalin;
import io.javalin.http.Context;
public class JavalinApp {
    private static Javalin app;
    private static UserService userService;
    private static TicketService ticketService;

    public JavalinApp() {
    }

    public static Javalin getApp(int port) {
        if(app == null) {
            userService = new UserService(new UserDao());
            ticketService = new TicketService(new TicketDao());
            init(port);
        }
        return app;
    }

    private static void init(int port) {
        app = Javalin.create()
                .start(port);

        app.get("/ping", JavalinApp::ping);
//        app.post("/user", JavalinApp::postNewUser);
        app.post("/user/auth", JavalinApp::UserAuthentication);

        //task resources
        app.get("/ticket", JavalinApp::getTicketById);
//        app.post("/ticket", JavalinApp::postNewTask);
        app.put("/ticket", JavalinApp::updateTicket);
        app.delete("/ticket", JavalinApp::deleteTicket);
    }

    public static void ping(Context ctx) {
        ctx.result("pong!");
        ctx.status(200);
    }

    public static void UserAuthentication(Context ctx) {
        UserPojo auth = ctx.bodyAsClass(UserPojo.class);
        try {
            userService.authenticateUser(auth.getEmail(), auth.getPassword());
        } catch(UserNotFoundException e) {
            ctx.status(401);
            ctx.result("User not found.");
        } catch(IncorrectPasswordException e) {
            ctx.status(401);
            ctx.result("Password incorrect.");
        }
    }

    public static void getTicketById(Context ctx) {
        int id = Integer.parseInt(ctx.queryParam("ticket_id"));
        TicketPojo ticket = ticketService.getTicket(id);

        ctx.json(ticket);
        ctx.status(200);
    }

    public static void updateTicket(Context ctx) {
        TicketPojo ticket = ctx.bodyAsClass(TicketPojo.class);
        ticketService.updateTask(ticket);

        ctx.status(201);
    }

    public static void deleteTicket(Context ctx) {
        int id = Integer.parseInt(ctx.queryParam("ticket_id"));
        ticketService.deleteTicket(id);

        ctx.status(200);
    }
}

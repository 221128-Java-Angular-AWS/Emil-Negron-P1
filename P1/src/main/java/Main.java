package main.java;

import main.java.com.revature.Javalin.JavalinApp;
import io.javalin.Javalin;

public class Main {
    public static void main(String[] args) {
        Javalin app = JavalinApp.getApp(8080);
    }
}
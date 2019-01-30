package com.hwj.banking.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController

public class CommonController {
    @GetMapping("/login")
    public void login(HttpServletResponse response){
        System.out.println("login page");
        try {
            response.sendRedirect("/login.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/login-error")
    public void login_error(HttpServletResponse response){
        System.out.println("login error to error ");
        try {
            response.sendRedirect("/login-error.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/welcome")
    public void welcome(HttpServletResponse response){
        System.out.println(" to welcome");
        try {
            response.sendRedirect("/welcome.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

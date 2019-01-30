package com.hwj.banking.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/main")
public class MainController {
    @GetMapping("/home")
    public void login(HttpServletResponse response){
        System.out.println("======================");
        try {
            response.sendRedirect("/home.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

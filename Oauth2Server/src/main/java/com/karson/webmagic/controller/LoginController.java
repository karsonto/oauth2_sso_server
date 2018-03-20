package com.karson.webmagic.controller;

 

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.karson.webmagic.utils.CookieUtils;
 

@Controller
public class LoginController {
	 
	private final String cookieName ="JSESSIONID";
   @RequestMapping("/login")
    public String toLoginView() {
        return "login/login";
    }
   @RequestMapping("/exit")
   public void exit(HttpServletRequest request, HttpServletResponse response) {
       new SecurityContextLogoutHandler().logout(request, null, null);
       
       try {
           response.sendRedirect(request.getHeader("referer"));
       } catch (IOException e) {
           e.printStackTrace();
       }
     
       
   }
}
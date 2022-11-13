/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import models.User;
import services.AccountService;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Hashem
 */
public class AdminFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        HttpServletRequest httprequest = (HttpServletRequest) request;
        HttpServletResponse httpresponse = (HttpServletResponse) response;
        HttpSession session = httprequest.getSession();
        
        AccountService as = new AccountService();
        User user = (User) session.getAttribute("user");
        
        
            if(user.getRole().getRoleId() == 1){
                chain.doFilter(request, response);
            } else {
                httpresponse.sendRedirect("/notes");
            }
        
           
        
    }


    public void destroy() {        
    }

 
    public void init(FilterConfig filterConfig) {        

    }
}

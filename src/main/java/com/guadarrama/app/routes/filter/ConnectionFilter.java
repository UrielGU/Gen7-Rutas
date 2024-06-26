package com.guadarrama.app.routes.filter;

import com.guadarrama.app.routes.utils.DBConnection;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;
import java.sql.Connection;

//esa interface no la creamos, es dee Jakarta
@WebFilter("/*")
public class ConnectionFilter implements Filter {
    private Connection getConnection(){
        return DBConnection.getInstance();
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Connection connection = this.getConnection();
        servletRequest.setAttribute("connection", connection);
        try {
            filterChain.doFilter(servletRequest, servletResponse);
        }catch (IOException e){
            throw new RuntimeException(e);
        }catch (ServletException ex){
            throw new RuntimeException(ex);
        }
    }
}

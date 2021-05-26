package com.xuan.controller;

import com.xuan.Dao.UserDao;
import com.xuan.util.JdbcUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("UserName");
        String passWord = request.getParameter("PassWord");
        UserDao dao = new UserDao();
        String rs = dao.login(userName,passWord);
        if ("管理员".equals(rs)){
            response.sendRedirect("/myWeb/index2.html");
        }else {
            response.sendRedirect("/myWeb/index.html");
        }
    }
}

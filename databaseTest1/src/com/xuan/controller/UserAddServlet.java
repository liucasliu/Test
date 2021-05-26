package com.xuan.controller;

import com.xuan.Dao.UserDao;
import com.xuan.text.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String UserName,PassWord,jurisdiction;
        response.setContentType("text/html;charset=utf-8");
        UserName = request .getParameter("UserName");
        PassWord = request.getParameter("PassWord");
        jurisdiction = request.getParameter("jurisdiction");
        User user = new User(UserName,PassWord,jurisdiction);
        PrintWriter out = response.getWriter();
        UserDao dao = new UserDao();
        int rs = dao.add(user);
        if(rs == 1){
            out.print("<font style='color:red;font-size:40'>用户信息注册成功</font>");
        }else {
            out.print("<font style='color:red;font-size:40'>用户信息注册失败</font>");
        }
    }

}

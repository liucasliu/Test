package com.xuan.controller;

import com.xuan.Dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserDeleteServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String UserName = request.getParameter("UserName");
        UserDao dao = new UserDao();
        int result = dao.delete(UserName);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out = response.getWriter();
        if(result == 1){
            out.print("<font style='color:red;font-size:40'>用户信息删除成功</font>");
        }else {
            out.print("<font style='color:red;font-size:40'>用户删除失败</font>");
        }
    }
}

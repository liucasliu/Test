package com.xuan.controller;

import com.xuan.Dao.GuideDao;
import com.xuan.Dao.UserDao;
import com.xuan.text.Guide;
import com.xuan.text.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class UserFindServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        UserDao dao = new UserDao();
        PrintWriter out = response.getWriter();
        List<User> usersList = dao.find();
        out.print("<table border='2' align='center'>");
        out.print("<tr>");
        out.print("<td>用户名</td>");
        out.print("<td>用户密码</td>");
        out.print("<td>权限</td>");
        out.print("<td>操作</td>");
        out.print("</tr>");
        for(User user:usersList){
            out.print("<tr>");
            out.print("<td>"+user.getUserName()+"</td>");
            out.print("<td>"+user.getPassWord()+"</td>");
            out.print("<td>"+user.getJurisdiction()+"</td>");
            out.print("<td><a href='/myWeb/user/delete?UserName="+user.getUserName()+"'>删除用户</a></td>");
            out.print("</tr>");
        }
        out.print("</table>");
    }
}

package com.xuan.controller;

import com.xuan.Dao.tjRouteDao;
import com.xuan.text.tjRoute;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class tjRouteAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String tjroute,data,money;
        response.setContentType("text/html;charset=utf-8");
        tjroute = request.getParameter("tjroute");
        data = request.getParameter("data");
        money = request.getParameter("money");
        tjRouteDao dao = new tjRouteDao();
        tjRoute tj = new tjRoute(null,tjroute,data,Integer.parseInt((money)));
        PrintWriter out = response.getWriter();
        int rs = dao.add(tj);
        if(rs == 1){
            out.print("<font style='color:red;font-size:40'>特价线路信息注册成功</font>");
        }else {
            out.print("<font style='color:red;font-size:40'>特价线路信息注册失败</font>");
        }
    }

}

package com.xuan.controller;

import com.xuan.Dao.RouteDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CanTuanServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String  tourist = request.getParameter("tourist");
        String  routeId =  request.getParameter("routeId");
        RouteDao dao = new RouteDao();
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        int rs =  dao.canTuan(tourist,routeId);
        if(rs == 1){
            out.print("<font style='color:red;font-size:40'>用户参团成功</font>");
        }else {
            out.print("<font style='color:red;font-size:40'>用户参团失败</font>");
        }
    }

}

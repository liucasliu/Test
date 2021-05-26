package com.xuan.controller;


import com.xuan.Dao.RouteDao;
import com.xuan.text.Guide;
import com.xuan.text.Route;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class RouteFindServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        RouteDao dao = new RouteDao();
        PrintWriter out = response.getWriter();
        List<Route> routeList = dao.findAll();
        out.print("<table border='2' align='center'>");
        out.print("<tr>");
        out.print("<td>线路编号</td>");
        out.print("<td>线路内容</td>");
        out.print("<td>出行日期</td>");
        out.print("<td>花费(元/人)</td>");
        out.print("<td>导游编号</td>");
        out.print("</tr>");
        for(Route route:routeList){
            out.print("<tr>");
            out.print("<td>"+route.getRouteId()+"</td>");
            out.print("<td>"+route.getRoute()+"</td>");
            out.print("<td>"+route.getData()+"</td>");
            out.print("<td>"+route.getMoney()+"</td>");
            out.print("<td>"+route.getGuideId()+"</td>");
            out.print("</tr>");
        }
        out.print("</table>");
    }
}

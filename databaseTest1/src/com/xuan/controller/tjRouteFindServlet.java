package com.xuan.controller;

import com.xuan.Dao.RouteDao;
import com.xuan.Dao.tjRouteDao;
import com.xuan.text.Route;
import com.xuan.text.tjRoute;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class tjRouteFindServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        tjRouteDao dao = new tjRouteDao();
        PrintWriter out = response.getWriter();
        List<tjRoute> tjrouteList = dao.findAll();
        out.print("<table border='2' align='center'>");
        out.print("<tr>");
        out.print("<td>特价路线编号</td>");
        out.print("<td>特价路线内容</td>");
        out.print("<td>花费(元/人)</td>");
        out.print("<td>优惠日期</td>");
        out.print("</tr>");
        for(tjRoute tjroute:tjrouteList){
            out.print("<tr>");
            out.print("<td>"+tjroute.getTjrouteId()+"</td>");
            out.print("<td>"+tjroute.getTjroute()+"</td>");
            out.print("<td>"+tjroute.getMoney()+"</td>");
            out.print("<td>"+tjroute.getData()+"</td>");
            out.print("</tr>");
        }
        out.print("</table>");
    }
}

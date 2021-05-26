package com.xuan.controller;

import com.xuan.Dao.TouristDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TouristCountServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String routeId = request.getParameter("routeId");
        TouristDao dao = new TouristDao();
        int rs = dao.count(routeId);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print("<table border='2' align='center'>");
        out.print("<tr>");
        out.print("<td>线路编号</td>");
        out.print("<td>游客数量</td>");
        out.print("</tr>");
        out.print("<tr>");
        out.print("<td>"+routeId+"</td>");
        out.print("<td>"+rs+"</td>");
        out.print("<tr>");
    }
}

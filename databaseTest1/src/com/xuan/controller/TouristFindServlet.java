package com.xuan.controller;

import com.xuan.Dao.TouristDao;
import com.xuan.text.Tourist;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class TouristFindServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        TouristDao dao = new TouristDao();
        PrintWriter out = response.getWriter();
        List<Tourist> tourList = dao.findAll();
        out.print("<table border='2' align='center'>");
        out.print("<tr>");
        out.print("<td>游客编号</td>");
        out.print("<td>游客姓名</td>");
        out.print("<td>游客性别</td>");
        out.print("<td>联系电话</td>");
        out.print("<td>线路编号</td>");
        out.print("</tr>");
        for(Tourist tour:tourList){
            out.print("<tr>");
            out.print("<td>"+tour.getTouristId()+"</td>");
            out.print("<td>"+tour.getTouristName()+"</td>");
            out.print("<td>"+tour.getSex()+"</td>");
            out.print("<td>"+tour.getPhoneNumber()+"</td>");
            out.print("<td>"+tour.getRouteId()+"</td>");
            out.print("</tr>");
        }
        out.print("</table>");
    }
}


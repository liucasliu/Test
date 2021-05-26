package com.xuan.controller;

import com.xuan.Dao.TouristDao;
import com.xuan.text.TouristInformation;
import com.xuan.text.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class FindTouristServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        TouristDao dao = new TouristDao();
        List<TouristInformation>  userList = dao.findTour();
        out.print("<table border='2' align='center'>");
        out.print("<tr>");
        out.print("<td>游客名</td>");
        out.print("<td>路线内容</td>");
        out.print("<td>导游名</td>");
        out.print("</tr>");
        for(TouristInformation touristInformation:userList){
            out.print("<tr>");
            out.print("<td>"+touristInformation.getTouristName()+"</td>");
            out.print("<td>"+touristInformation.getRoute()+"</td>");
            out.print("<td>"+touristInformation.getGuideName()+"</td>");
            out.print("</tr>");
        }
        out.print("</table>");
    }
}

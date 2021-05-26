package com.xuan.controller;

import com.xuan.Dao.GuideDao;
import com.xuan.Dao.TouristDao;
import com.xuan.text.Guide;
import com.xuan.text.Tourist;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class GuideFindServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        GuideDao dao = new GuideDao();
        PrintWriter out = response.getWriter();
        List<Guide> guideList = dao.findAll();
        out.print("<table border='2' align='center'>");
        out.print("<tr>");
        out.print("<td>导游编号</td>");
        out.print("<td>导游姓名</td>");
        out.print("<td>导游性别</td>");
        out.print("<td>语种</td>");
        out.print("<td>线路编号</td>");
        out.print("</tr>");
        for(Guide guide:guideList){
            out.print("<tr>");
            out.print("<td>"+guide.getGuideId()+"</td>");
            out.print("<td>"+guide.getGuideName()+"</td>");
            out.print("<td>"+guide.getSex()+"</td>");
            out.print("<td>"+guide.getLanguage()+"</td>");
            out.print("<td>"+guide.getRouteId()+"</td>");
            out.print("<tr>");
        }
        out.print("</table>");
    }
}


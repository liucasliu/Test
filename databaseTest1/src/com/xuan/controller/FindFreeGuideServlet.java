package com.xuan.controller;

import com.xuan.Dao.RouteDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class FindFreeGuideServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String data = request.getParameter("data");
            RouteDao dao = new RouteDao();
            List<String> guideNameList = dao.findFree(data);
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.print("<table border='2' align='center'>");
            out.print("<tr>");
            out.print("<td>发车时间</td>");
            out.print("<td>空闲导游</td>");
            out.print("</tr>");
            out.print("<tr>");
            out.print("<td>"+data+"</td>");
            for(String guideName:guideNameList){
                out.print("<td>"+guideName+"</td>");
            }
            out.print("<tr>");
    }
}

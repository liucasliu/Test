package com.xuan.controller;

import com.xuan.Dao.TouristDao;
import com.xuan.text.Tourist;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TouristAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String touristName,sex,phoneNumber;
        response.setContentType("text/html;charset=utf-8");
        Tourist tour = null;
        int rs = 0;
        PrintWriter out = null;
        TouristDao dao = new TouristDao();
        touristName = request.getParameter("touristName");
        sex = request.getParameter("sex");
        phoneNumber = request.getParameter("phoneNumber");
        tour = new Tourist(null,touristName,sex,phoneNumber,null);
        rs = dao.add(tour);
        out = response.getWriter();
        if(rs == 1){
            out.print("<font style='color:red;font-size:40'>用户信息注册成功</font>");
        }else {
            out.print("<font style='color:red;font-size:40'>用户信息注册失败</font>");
        }
    }
}

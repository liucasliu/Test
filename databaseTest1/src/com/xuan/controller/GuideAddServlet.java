package com.xuan.controller;

import com.xuan.Dao.GuideDao;
import com.xuan.text.Guide;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GuideAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String guideName,language,sex,routeId;
        response.setContentType("text/html;charset=utf-8");
        guideName = request.getParameter("guideName");
        language = request.getParameter("language");
        sex = request.getParameter("sex");
        routeId = request.getParameter("routeId");
        PrintWriter out = response.getWriter();
        Guide guide = new Guide(null,guideName,sex,language,Integer.parseInt((routeId)));
        GuideDao dao = new GuideDao();
        int rs = dao.add(guide);
        if(rs == 1){
            out.print("<font style='color:red;font-size:40'>导游信息注册成功</font>");
        }else {
            out.print("<font style='color:red;font-size:40'>导游信息注册失败</font>");
        }
    }
}

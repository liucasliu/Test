package com.xuan.controller;

import com.xuan.Dao.GuideDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GuideDeleteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String guideId = request.getParameter("guideId");
        GuideDao dao = new GuideDao();
        int result = dao.delete(guideId);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out = response.getWriter();
        if(result == 1){
            out.print("<font style='color:red;font-size:40'>导游信息删除成功</font>");
        }else {
            out.print("<font style='color:red;font-size:40'>导游信息删除失败</font>");
        }
    }
}

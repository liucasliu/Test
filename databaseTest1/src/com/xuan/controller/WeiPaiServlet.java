package com.xuan.controller;

import com.xuan.Dao.GuideDao;
import com.xuan.Dao.RouteDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class WeiPaiServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String guideId,routeId;
            guideId = request.getParameter("guideId");
            routeId = request.getParameter("routeId");
            GuideDao dao1 =  new GuideDao();
            int result1 = dao1.guideWeiPai(guideId,routeId);
            RouteDao dao2 = new RouteDao();
            int result2 = dao2.routeWeiPai(guideId,routeId);
            int result = result1 + result2;
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            if(result == 2){
                out.print("<font style='color:red;font-size:40'>委派成功</font>");
            }else {
                out.print("<font style='color:red;font-size:40'>委派失败</font>");
            }
    }
}

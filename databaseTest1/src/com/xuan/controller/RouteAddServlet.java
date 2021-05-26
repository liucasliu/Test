package com.xuan.controller;

import com.xuan.Dao.GuideDao;
import com.xuan.Dao.RouteDao;
import com.xuan.text.Route;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RouteAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String route,data,money,guideId;
        response.setContentType("text/html;charset=utf-8");
        route = request.getParameter("route");
        data = request.getParameter("data");
        money = request.getParameter("money");
        guideId = request.getParameter("guideId");
        Route route1 = new Route(null,route,data,Integer.parseInt((money)),Integer.parseInt((guideId)));
        RouteDao dao = new RouteDao();
        PrintWriter out = response.getWriter();
        int rs = dao.add(route1);
        if(rs == 1){
            out.print("<font style='color:red;font-size:40'>线路信息注册成功</font>");
        }else {
            out.print("<font style='color:red;font-size:40'>线路信息注册失败</font>");
        }
    }
}

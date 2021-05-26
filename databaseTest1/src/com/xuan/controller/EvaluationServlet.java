package com.xuan.controller;

import com.xuan.Dao.EvaluationDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class EvaluationServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String guideId = request.getParameter("guideId");
        String evaluation = request.getParameter("evaluation");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        EvaluationDao dao = new EvaluationDao();
        if (evaluation.equals("good")) {
            int rs = dao.good(guideId) + 1;
            int result = dao.goodAdd(guideId, rs);
            if (result == 1) {
                out.print("<font style='color:red;font-size:40'>评价成功</font>");
            } else {
                out.print("<font style='color:red;font-size:40'>评价失败</font>");
            }
        }else if(evaluation.equals("medium")){
            int rs = dao.medium(guideId) + 1;
            int result = dao.mediumAdd(guideId,rs);
            if (result == 1) {
                out.print("<font style='color:red;font-size:40'>评价成功</font>");
            } else {
                out.print("<font style='color:red;font-size:40'>评价失败</font>");
            }
        }else if(evaluation.equals("bad")){
            int rs = dao.bad(guideId) + 1;
            int result = dao.badAdd(guideId,rs);
            if (result == 1) {
                out.print("<font style='color:red;font-size:40'>评价成功</font>");
            } else {
                out.print("<font style='color:red;font-size:40'>评价失败</font>");
            }
        }
    }
}

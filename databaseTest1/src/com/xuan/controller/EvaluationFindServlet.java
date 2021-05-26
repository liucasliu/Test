package com.xuan.controller;

import com.xuan.Dao.EvaluationDao;
import com.xuan.Dao.GuideDao;
import com.xuan.text.Evaluation;
import com.xuan.text.Guide;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class EvaluationFindServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        EvaluationDao dao = new EvaluationDao();
        PrintWriter out = response.getWriter();
        List<Evaluation> evaluationsList = dao.findAll();
        out.print("<table border='2' align='center'>");
        out.print("<tr>");
        out.print("<td>导游姓名</td>");
        out.print("<td>导游编号</td>");
        out.print("<td>好评</td>");
        out.print("<td>中评</td>");
        out.print("<td>差评</td>");
        out.print("</tr>");
        for(Evaluation evaluation:evaluationsList){
            out.print("<tr>");
            out.print("<td>"+evaluation.getGuideName()+"</td>");
            out.print("<td>"+evaluation.getGuideId()+"</td>");
            out.print("<td>"+evaluation.getGood()+"</td>");
            out.print("<td>"+evaluation.getMedium()+"</td>");
            out.print("<td>"+evaluation.getBad()+"</td>");
            out.print("</tr>");
        }
        out.print("</table>");
    }
}

package com.xuan.Dao;

import com.xuan.text.Evaluation;
import com.xuan.util.JdbcUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EvaluationDao {
    private JdbcUtil util = new JdbcUtil();
    //查询好评具体评价数量
    public int good(String guideId) {
        String sql = "select good from d_evaluation where guideId=?";
        PreparedStatement ps =util.getPs(sql);
        ResultSet rs = null;
        int a =0;
        try {
            ps.setString(1,guideId);
            rs = ps.executeQuery();
            while (rs.next()){
                a = rs.getInt("good");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return a;
    }
    //添加评价
    public int goodAdd(String guideId,int rs) {
        String sql ="update d_evaluation set good=? where guideId=?";
        PreparedStatement ps = util.getPs(sql);
        int result = 0;
        try {
            ps.setInt(1,rs);
            ps.setString(2,guideId);
            result = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
    //查询中评具体评价
    public int medium(String guideId) {
        String sql = "select medium from d_evaluation where guideId=?";
        PreparedStatement ps =util.getPs(sql);
        ResultSet rs = null;
        int a =0;
        try {
            ps.setString(1,guideId);
            rs = ps.executeQuery();
            while (rs.next()){
                a = rs.getInt("medium");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return a;
    }
    //添加评价
    public int mediumAdd(String guideId,int rs) {
        String sql ="update d_evaluation set medium=? where guideId=?";
        PreparedStatement ps = util.getPs(sql);
        int result = 0;
        try {
            ps.setInt(1,rs);
            ps.setString(2,guideId);
            result = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
    //查看差评具体评价
    public int bad(String guideId) {
        String sql = "select bad from d_evaluation where guideId=?";
        PreparedStatement ps =util.getPs(sql);
        ResultSet rs = null;
        int a =0;
        try {
            ps.setString(1,guideId);
            rs = ps.executeQuery();
            while (rs.next()){
                a = rs.getInt("medium");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return a;
    }
    //添加评价
    public int badAdd(String guideId,int rs) {
        String sql ="update d_evaluation set bad=? where guideId=?";
        PreparedStatement ps = util.getPs(sql);
        int result = 0;
        try {
            ps.setInt(1,rs);
            ps.setString(2,guideId);
            result = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
    //查找
    public List findAll() {
        String sql = "select guideName,d_evaluation.guideId,good,`medium`,bad from d_evaluation ,d_guide where d_evaluation.guideId =d_guide.guideId ";
        PreparedStatement ps = util.getPs(sql);
        ResultSet rs = null;
        List evaluationsList = new ArrayList();
        try {
            rs = ps.executeQuery();
            while (rs.next()){
                String  guideName = rs.getString("guideName");
                Integer guideId = rs.getInt("guideId");
                Integer good = rs.getInt("good");
                Integer medium = rs.getInt("medium");
                Integer bad = rs.getInt("bad");
                Evaluation evaluation = new Evaluation(guideName,guideId,good,medium,bad);
                evaluationsList.add(evaluation);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close(rs);
        }
        return evaluationsList;
    }
}

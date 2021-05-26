package com.xuan.Dao;

import com.xuan.text.Guide;
import com.xuan.util.JdbcUtil;

import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GuideDao {
    private JdbcUtil util = new JdbcUtil();
    //查找导游
    public List findAll() {
        String sql = "select * from d_guide";
        PreparedStatement ps = util.getPs(sql);
        ResultSet rs = null;
        List guideList = new ArrayList();
        try {
             rs = ps.executeQuery();
             while (rs.next()){
                 Integer guideId = rs.getInt("guideId");
                 String  guideName = rs.getString("guideName");
                 String  sex  = rs.getString("sex");
                 String  language = rs.getString("language");
                 Integer  routeId = rs.getInt("routeId");
                 Guide guide = new Guide(guideId,guideName,sex,language,routeId);
                 guideList.add(guide);
             }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close(rs);
        }
        return guideList;
    }
    //添加
    public int add(Guide guide) {
        int rs = 0;
        String sql = "insert into d_guide(guideName,sex,language,routeId)" +"values(?,?,?,?)";
        PreparedStatement ps = util.getPs(sql);
        try {
            ps.setString(1,guide.getGuideName());
            ps.setString(2,guide.getSex());
            ps.setString(3,guide.getLanguage());
            ps.setInt(4,guide.getRouteId());
            rs = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close();
        }
        return rs;
    }
    //删除
    public int delete(String guideId) {
        String sql = "delete from d_guide where guideId = ?";
        int rs = 0;
        PreparedStatement ps = util.getPs(sql);
        try {
            ps.setInt(1, Integer.parseInt(guideId));
            rs= ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close();
        }
        return rs;
    }
    //委派
    public int guideWeiPai(String guideId, String routeId) {
        String sql = "update d_guide set routeId=? where guideId=?";
        PreparedStatement ps = util.getPs(sql);
        int rs = 0;
        try {
            ps.setInt(1,Integer.parseInt((routeId)));
            ps.setInt(2,Integer.parseInt((guideId)));
            rs = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close();
        }
        return rs;
    }
}

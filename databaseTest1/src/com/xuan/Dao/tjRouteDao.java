package com.xuan.Dao;

import com.xuan.text.tjRoute;
import com.xuan.util.JdbcUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class tjRouteDao {
    private JdbcUtil util = new JdbcUtil();

    public List findAll() {
        String sql = "select * from d_tjroute";
        ResultSet rs = null;
        PreparedStatement ps = util.getPs(sql);
        List tjrouteList = new ArrayList();
        try {
            rs = ps.executeQuery();
            while (rs.next()){
                Integer tjrouteId = rs.getInt("tjrouteId");
                String  tjroute = rs.getString("tjroute");
                String  data = rs.getString("data");
                Integer money = rs.getInt("money");
                tjRoute tjRoute1 = new tjRoute(tjrouteId,tjroute,data,money);
                tjrouteList.add(tjRoute1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close(rs);
        }
        return tjrouteList;
    }

    public int add(tjRoute tj) {
        String sql = "insert into d_tjroute(tjroute,data,money)" + "values(?,?,?)";
        PreparedStatement ps = util.getPs(sql);
        int rs = 0;
        try {
            ps.setString(1,tj.getTjroute());
            ps.setString(2,tj.getData());
            ps.setInt(3,tj.getMoney());
            rs = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close();
        }
        return rs;
    }

    public int delete(String tjrouteId) {
        String  sql = "delete from d_tjroute where tjrouteId = ?";
        int rs = 0;
        PreparedStatement ps = util.getPs(sql);
        try {
            ps.setInt(1, Integer.parseInt(tjrouteId));
            rs= ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close();
        }
        return rs;
    }
}

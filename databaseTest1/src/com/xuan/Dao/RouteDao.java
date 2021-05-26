package com.xuan.Dao;

import com.xuan.text.Guide;
import com.xuan.text.Route;
import com.xuan.util.JdbcUtil;

import javax.servlet.http.HttpServletRequest;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RouteDao {
    private JdbcUtil util = new JdbcUtil();
    //查找线路
    public List findAll() {
        String sql = "select * from d_route";
        PreparedStatement ps = util.getPs(sql);
        List routeList = new ArrayList();
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            while (rs.next()){
                Integer routeId = rs.getInt("routeId");
                String  route = rs.getString("route");
                String  data = rs.getString("data");
                Integer  money = rs.getInt("money");
                Integer guideId = rs.getInt("guideId");
                Route router = new Route(routeId,route,data,money,guideId);
                routeList.add(router);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close(rs);
        }
        return routeList;
    }
    //游客参团
    public int canTuan(String tourist, String routeId) {
        String sql = "update d_tourist set routeId=?  where touristId=? ";
        PreparedStatement ps =util.getPs(sql);
        int rs = 0;
        try {
            ps.setInt(1, Integer.parseInt((routeId)));
            ps.setInt(2, Integer.parseInt((tourist)));
            rs = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close();
        }
       return rs;
    }
    //添加线路
    public int add(Route route1) {
        String sql ="insert into d_route(route,data,money,guideId)" + "values(?,?,?,?)";
        PreparedStatement ps =util.getPs(sql);
        int rs = 0;
        try {
            ps.setString(1,route1.getRoute());
            ps.setString(2,route1.getData());
            ps.setInt(3,route1.getMoney());
            ps.setInt(4,route1.getGuideId());
            rs=ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close();
        }
        return rs;
    }
    //删除线路
    public int delete(String routeId) {
        String  sql = "delete from d_route where routeId = ?";
        int rs = 0;
        PreparedStatement ps = util.getPs(sql);
        try {
            ps.setInt(1, Integer.parseInt(routeId));
            rs= ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close();
        }
        return rs;
    }
    //委派
    public int routeWeiPai(String guideId, String routeId) {
        String sql = "update d_route set guideId=? where routeId=?";
        PreparedStatement ps = util.getPs(sql);
        int rs = 0;
        try {
            ps.setInt(1,Integer.parseInt((guideId)));
            ps.setInt(2,Integer.parseInt((routeId)));
            rs = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close();
        }
        return rs;
    }
    //根据时间查询空闲导游
    public List findFree(String data) {
        String sql = "select guideName from d_guide,d_route where d_guide.routeId = d_route.routeId and data!=?";
        PreparedStatement ps = util.getPs(sql);
        List guideNameList = new ArrayList();
        ResultSet resultSet = null;
        try {
            ps.setString(1,data);
            resultSet = ps.executeQuery();
            while (resultSet.next()){
                String guideName = resultSet.getString("guideName");
                guideNameList.add(guideName);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close(resultSet);
        }
            return guideNameList;
    }
}

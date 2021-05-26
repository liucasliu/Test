package com.xuan.Dao;

import com.xuan.text.Tourist;
import com.xuan.text.TouristInformation;
import com.xuan.util.JdbcUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//游客方法
public class TouristDao {
    private JdbcUtil util = new JdbcUtil();

    //游客注册
    public  int add(Tourist tour){
        String sql = "insert into d_tourist(touristName,sex,phoneNumber)" +
                "values(?,?,?)";
        PreparedStatement ps = util.getPs(sql);
        int rs = 0;
        try {
            ps.setString(1,tour.getTouristName());
            ps.setString(2,tour.getSex());
            ps.setString(3,tour.getPhoneNumber());
            rs = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close();
        }
        return rs;
    }
    //查询游客
    public List findAll() {
        String sql = "select * from d_tourist";
        PreparedStatement ps = util.getPs(sql);
        List tourList = new ArrayList();
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            while (rs.next()){
                Integer touristId = rs.getInt("touristId");
                String  touristName = rs.getString("touristName");
                String  sex = rs.getString("sex");
                String  phoneNumber = rs.getString("phoneNumber");
                Integer routeId = rs.getInt("routeId");
                Tourist tour  = new Tourist(touristId,touristName,sex,phoneNumber,routeId);
                tourList.add(tour);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close(rs);
        }
        return tourList;
    }
    //删除游客信息
    public int delete(String touristId) {
        String sql = "delete from d_tourist where touristId = ?";
        int rs = 0;
        PreparedStatement ps = util.getPs(sql);
        try {

            ps.setInt(1, Integer.parseInt(touristId));
            rs= ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close();
        }
        return rs;
    }
    //查询线路游客数量
    public int count(String routeId) {
        String sql = "select count(touristId) from d_tourist where routeId=?";
        PreparedStatement ps = util.getPs(sql);
        int rs = 0;
        ResultSet resultSet = null;
        try {
            ps.setInt(1,Integer.parseInt(routeId));
            resultSet = ps.executeQuery();
            while (resultSet.next()){
                rs = resultSet.getInt("count(touristId)");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rs;
    }

    public List findTour() {
        String sql = "select \n" +
                "  a.touristName,b.route,c.guideName\n" +
                "from\n" +
                "  d_tourist a, \n" +
                "\td_route b,\n" +
                "\td_guide c\n" +
                "where \n" +
                "a.routeId = b.routeId\n" +
                "and b.guideId = c.guideId;";
        PreparedStatement ps = util.getPs(sql);
        List userList = new ArrayList();
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            while(rs.next()){
                String touristName = rs.getString("touristName");
                String route = rs.getString("route");
                String guideName = rs.getString("guideName");
                TouristInformation touristInformation = new TouristInformation(touristName,guideName,route);
                userList.add(touristInformation);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close(rs);
        }
        return userList;
    }
}

package com.xuan.Dao;

import com.xuan.text.User;
import com.xuan.util.JdbcUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private JdbcUtil util = new JdbcUtil();

    public int add(User user) {
        String sql = "insert into d_user(UserName,PassWord,jurisdiction)"+"values(?,?,?)";
        PreparedStatement ps = util.getPs(sql);
        int rs = 0;
        try {
            ps.setString(1,user.getUserName());
            ps.setString(2,user.getPassWord());
            ps.setString(3,user.getJurisdiction());
            rs = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rs;
    }

    public List find() {
        String sql = "select * from d_user ";
        PreparedStatement ps =util.getPs(sql);
        ResultSet rs = null;
        List UsersList = new ArrayList();
        try {
            rs = ps.executeQuery();
            while (rs.next()){
                String UserName = rs.getString("UserName");
                String PassWord = rs.getString("PassWord");
                String jurisdiction = rs.getString("jurisdiction");
                User user = new User(UserName,PassWord,jurisdiction);
                UsersList.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close(rs);
        }
        return  UsersList;
    }

    public int delete(String UserName) {
        String sql = "delete from d_user where UserName = ?";
        PreparedStatement ps =util.getPs(sql);
        int rs = 0;
        try {
            ps.setString(1,UserName);
            rs = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close();
        }
        return rs;
    }

    public String login(String userName, String passWord) {
        String sql = "select jurisdiction from d_user where UserName=? and PassWord=?";
        PreparedStatement ps = util.getPs(sql);
        String rs = null;
        ResultSet resultSet = null;
        try {
            ps.setString(1,userName);
            ps.setString(2,passWord);
            resultSet = ps.executeQuery();
            while (resultSet.next()){
                rs = resultSet.getString("jurisdiction");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rs;
    }
}

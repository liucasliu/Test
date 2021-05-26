package com.xuan.util;

import java.sql.*;

public class JdbcUtil {
    String url    = "jdbc:mysql://localhost:3306/date" +
            "baseswork";
    String user   = "root";
    String password = "123456";
    static Connection conn = null;
    static PreparedStatement ps = null ;


    //获得数据库连接
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver" );
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //获得连接对象
    public Connection getConn(){
        try {
            conn = DriverManager.getConnection(url,user,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }
    //获得数据库操作对象
    public PreparedStatement getPs(String sql){
        try {
            ps = getConn().prepareStatement(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ps;
    }
    //关闭
    public void close(){
        if(ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
               conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void close(ResultSet rs){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

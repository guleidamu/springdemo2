package com.example.springdemo.businessSchool.config.jdbc;

import java.sql.*;

public class jdbcConnect {

    public static void getConnect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/book?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
        String user = "root";
        String password = "root";
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            String sql = "select * from user";
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int id;
        String  username, datapassword;

        System.out.println("id\t名称\t密码");

        try {
            while (rs.next()){
                id = rs.getInt("id");
                username = rs.getString("username");
                datapassword = rs.getString("password");
                System.out.println(id + "\t" + username + "\t" + datapassword);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]){
        getConnect();
    }
}

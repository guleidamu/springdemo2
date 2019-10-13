package com.businessOracle.businessOracle.util;

import com.businessOracle.businessOracle.data.entity.DcsManualTask;
import com.businessOracle.businessOracle.data.entity.Dept;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class jdbc {
    private static String driver = "oracle.jdbc.driver.OracleDriver";
    //jdbc:oracle:thin:@192.168.43.9:1521:ORCL
    private static String url = "jdbc:oracle:thin:@127.0.0.1:1521:ORCL";
    private static String user = "scott";
    private static String password = "tiger";
    static Connection conn = null;
    static Statement stmt = null;


    public static Statement getStatement(String sql) {

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            System.out.println(conn);
            stmt = conn.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stmt;
    }

    public static void closeCAndS() {
        {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public static int addDept(String sql){
        boolean b = false;
        int flag = 0;
        stmt = getStatement(sql);
        try {
            flag = stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeCAndS();
        if(flag>0)
            System.out.println("插入成功" + sql);
        return flag;
    }

    public static List<DcsManualTask> selectDept(String sql) {
        stmt = getStatement(sql);
        try {
            ResultSet rs = stmt.executeQuery(sql);
            //5.操作结果集
            List<Dept> list = new ArrayList<>();
            while (rs.next()){
                Dept dept = new Dept();
//                Integer id = rs.getInt("id");
                String dName = rs.getString("dname");
                String loc = rs.getString("loc");
                dept.setDName(dName);
                dept.setLoc(loc);
                list.add(dept);
            }
            for (Dept dept1 : list) {
                System.out.println(dept1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeCAndS();
        return null;
    }

    public static int deleteDept(String sql){
        boolean b = false;
        int flag = 0;
        stmt = getStatement(sql);
        try {
            b = stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeCAndS();
        if(flag>0)
            System.out.println("删除成功" + sql);
        return flag;
    }
    public static int updateDept(String sql){

        int flag = 0;
        stmt = getStatement(sql);
        try {
            flag = stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeCAndS();
        if(flag>0)
            System.out.println("更新成功" + sql);
        return flag;
    }

    public static void main(String args[]) {
//        String selectSql = "select * from dept";
//        selectDept(selectSql);
//        String insertSql = "insert into dept (deptNo,Dname,Loc) values('49' , 'damu','miaoqian')";
//        addDept(insertSql);
//        String deleteSql = "delete from dept where deptNo = '58'";
//        deleteDept(deleteSql);
        String updateSql = "update dept set Dname='pigu' where deptNo= 77";
        updateDept(updateSql);
    }
}

package com.cungudafa.spingmvc01.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
    public static String dbUrl="jdbc:mysql://localhost:3306/ssm_mysql?useSSL=false&serverTimezone=UTC";
    public static String dbUserName="root";
    public static String dbPassword="wy123456";
    public static String CLASSNAME="com.mysql.cj.jdbc.Driver";
	/**
	 * 静态加载驱动
	 */
	static{
		try {
			Class.forName(CLASSNAME);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 获取对数据库的连接
	 */
    public static Connection getConnection() throws SQLException {
    	Connection con=DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
        return con;
    }
    public static void closeConnection(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}

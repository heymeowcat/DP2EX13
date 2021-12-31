/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.*;

/**
 *
 * @author heymeowcat
 */
public class SQLiteJDBC {

    private static Connection conn;

    private static void setConnection() throws Exception {
        Class.forName("org.sqlite.JDBC");
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:test.db");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void iud(String sql) throws Exception {
        if (conn == null) {
            setConnection();
        }
        conn.createStatement().executeUpdate(sql);
    }

    public static ResultSet search(String sql) throws Exception {
        if (conn == null) {
            setConnection();
        }
        return conn.createStatement().executeQuery(sql);

    }

}

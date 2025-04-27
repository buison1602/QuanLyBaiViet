/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyBaiViet;

import java.sql.*;

public class DbQLBV {
    private String str = "jdbc:sqlserver://localhost:1433;databaseName=DBBV;encrypt=false";
    private Connection conn = null;

    public Connection getCon() {
        try {
            conn = DriverManager.getConnection(str, "sa", "Buicongson1622004@");
            System.out.println("Connect succses");
            return conn;
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return  null;
        }
    }
}

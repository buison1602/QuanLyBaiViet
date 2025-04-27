/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyBaiViet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryController {
//    private String str = "jdbc:sqlserver://localhost:1433;databaseName=DBBV;encrypt=false";
    private Connection conn = null;

//    public void getCon() {
//        try {
//            conn = DriverManager.getConnection(str, "sa", "Buicongson1622004@");
//            System.out.println("Connect succses");
//        } catch (SQLException e) {
//            System.out.println("Error: " + e.getMessage());
//        }
//    }

    public CategoryController(Connection conn) {
        this.conn = conn;
    }
    
    public List<Category> getAll() {
        List<Category> categorys = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tbCategory";
            PreparedStatement ps = conn.prepareStatement(sql);  // conn là Connection

            ResultSet rs = ps.executeQuery();
            // Duyệt qua ResultSet
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                // Tạo đối tượng Article và thêm vào danh sách
                Category category = new Category(id, title);
                categorys.add(category);
            }
            
            return categorys;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
}

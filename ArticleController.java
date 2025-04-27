/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyBaiViet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticleController {
    private Connection conn = null;

    public ArticleController(Connection conn) {
        this.conn = conn;
    }
    
    public List<Article> getAll() {
        List<Article> articles = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tbArticle";
            PreparedStatement ps = conn.prepareStatement(sql);  // conn là Connection

            ResultSet rs = ps.executeQuery();
            // Duyệt qua ResultSet
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String content = rs.getString("content");
                // Tạo đối tượng Article và thêm vào danh sách
                Article article = new Article(id, title, content);
                articles.add(article);
            }
            
            return articles;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
    
    public Article getById(int id) {
        Article article = null;
        try {
            String sql = "SELECT * FROM tbArticle WHERE Id LIKE ?";
            PreparedStatement ps = conn.prepareStatement(sql);  // conn là Connection
            ps.setInt(1, id); // hoặc set theo giá trị bạn cần

            ResultSet rs = ps.executeQuery();
            if(rs.next()) {   
                int articleId = rs.getInt("id");
                String title = rs.getString("title");
                String content = rs.getString("content");
                article = new Article(articleId, title, content);
            }
            
            return article;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public boolean updateArticle(Article article) {
        try {
            String sql = "UPDATE tbArticle SET title = ?, content = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            // Gán giá trị vào dấu ?
            ps.setString(1, article.getTitle());
            ps.setString(2, article.getContent());
            ps.setInt(3, article.getId()); // id bài viết cần update

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            System.out.println("Errot update: " + e.getMessage());
            return false;
        }
    }
    
    public boolean createArticle(Article article) {
        try {
            // Câu lệnh SQL INSERT
            String sql = "INSERT INTO tbArticle (title, content) VALUES (?, ?)";

            // Tạo PreparedStatement
            PreparedStatement ps = conn.prepareStatement(sql);

            // Gán giá trị vào dấu ?
            ps.setString(1, article.getTitle());
            ps.setString(2, article.getContent());

            // Thực thi câu lệnh INSERT
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            System.out.println("Errot insert: " + e.getMessage());
            return false;
        }
    }
    
    public boolean deleteArticle(int id) {
        try {
            // Câu lệnh SQL DELETE
            String sql = "DELETE FROM tbArticle WHERE id = ?";

            // Tạo PreparedStatement
            PreparedStatement ps = conn.prepareStatement(sql);

            // Gán giá trị vào dấu ?
            ps.setInt(1, id); // id của bài viết cần xóa

            // Thực thi câu lệnh DELETE
            int rowsAffected = ps.executeUpdate();
            
            return rowsAffected > 0;
        } catch (Exception e) {
            System.out.println("Errot delete: " + e.getMessage());
            return false;
        }
    }
    
    public List<Article> FilterByCategory(Category category) {
        List<Article> articles = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM tbArticle WHERE categoryId LIKE ?";
            PreparedStatement ps = conn.prepareStatement(sql);  // conn là Connection
            ps.setInt(1, category.getId()); // hoặc set theo giá trị bạn cần

            ResultSet rs = ps.executeQuery();
            
            // Duyệt qua ResultSet
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String content = rs.getString("content");
                // Tạo đối tượng Article và thêm vào danh sách
                Article article = new Article(id, title, content);
                articles.add(article);
            }
            
            return articles;
        } catch (Exception e) {
            return null;
        }
    }
}

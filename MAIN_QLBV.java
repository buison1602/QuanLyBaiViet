package QuanLyBaiViet;

import java.sql.*;
import java.util.List;

public class MAIN_QLBV {
    public static void main(String[] args) {
        DbQLBV dbQLBV = new DbQLBV();
        Connection conn = dbQLBV.getCon();
        
        ArticleController art = new ArticleController(conn);
        
        Category category = new Category(2, "HEHE");
        
        List<Article> articles = art.FilterByCategory(category);
        articles.stream().forEach(a -> {
        System.out.println("----------------------------");
            System.out.println("id = " + a.getId());
            System.out.println("title = " + a.getTitle());
            System.out.println("content = " + a.getContent()); 
        });
        
        CategoryController cate = new CategoryController(conn);
        
    }
}

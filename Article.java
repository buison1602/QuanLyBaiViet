/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyBaiViet;

/**
 *
 * @author buico
 */
public class Article {
    private int Id;
    private String title;
    private String Content;
    
    private int CategoryId; 

    public Article(int Id, String title, String Content) {
        this.Id = Id;
        this.title = title;
        this.Content = Content;
    }
    
    public int getId() {
        return Id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return Content;
    }
    
    
}

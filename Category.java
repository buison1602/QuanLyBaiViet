/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyBaiViet;

/**
 *
 * @author buico
 */
public class Category {
    private int Id;
    private String Title;

    public Category(int Id, String Title) {
        this.Id = Id;
        this.Title = Title;
    }

    public int getId() {
        return Id;
    }

    public String getTitle() {
        return Title;
    }
}

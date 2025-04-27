package QuanLyBaiViet;

import java.sql.*;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;


public class GUIBaiViet extends JFrame  {
    private ArticleController articleController = null;
    private CategoryController categoryController = null;
    private int currentRow = -1;

    public GUIBaiViet() {
        setSize(920, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        
    // CATEGORY
        JLabel lbmdd_CATE = new JLabel("Id: ");
        lbmdd_CATE.setBounds(10, 10, 100, 30);
        JTextField tfmdd_CATE = new JTextField();
        tfmdd_CATE.setBounds(120, 10, 100, 30);

        JLabel lbht_CATE = new JLabel("Title: ");
        lbht_CATE.setBounds(10, 50, 100, 30);
        JTextField tfht_CATE = new JTextField();
        tfht_CATE.setBounds(120, 50, 100, 30);
        
    // ARTICLE
        JLabel lbmdd = new JLabel("Id: ");
        lbmdd.setBounds(10, 10, 100, 30);
        JTextField tfmdd = new JTextField();
        tfmdd.setBounds(120, 10, 100, 30);

        JLabel lbht = new JLabel("Title: ");
        lbht.setBounds(10, 50, 100, 30);
        JTextField tfht = new JTextField();
        tfht.setBounds(120, 50, 100, 30);

        JLabel lbgt = new JLabel("Content: ");
        lbgt.setBounds(10, 90, 100, 30);
        JTextField tfgt = new JTextField();
        tfgt.setBounds(120, 90, 100, 30);
        
    // BUTTON
        JButton btThem = new JButton("Thêm");
        btThem.setBounds(10, 210, 90, 20);

        JButton btSua = new JButton("Sửa");
        btSua.setBounds(110, 210, 90, 20);

        JButton btXoa = new JButton("Xóa");
        btXoa.setBounds(210, 210, 90, 20);
    
    // TABLE 
        String columns[] = {"Id", "Title", "Id", "Title", "Content"};
        DefaultTableModel tabaModel = new DefaultTableModel();
        tabaModel.setColumnIdentifiers(columns);
        
        JTable tabel = new JTable(tabaModel);
        JScrollPane jsp = new JScrollPane(tabel);
        jsp.setBounds(410, 10, 490, 380);
        
    //ADD CONTROLS
        add(lbmdd_CATE);
        add(lbht_CATE);
        add(tfmdd_CATE);
        add(tfht_CATE);
        
        add(lbmdd);
        add(lbgt);
        add(lbht);
        
        add(tfgt);
        add(tfht);
        add(tfmdd);
        
        add(btSua);
        add(btThem);
        add(btXoa);
        add(jsp);
        //
        loadData(tabaModel);
    }
    
    private void loadData(DefaultTableModel tableModel) {
        DbQLBV dbQLBV = new DbQLBV();
        Connection conn = dbQLBV.getCon();
        
        try {
            tableModel.setRowCount(0);
            tableModel.fireTableDataChanged();

            ResultSet res = xldl.getAllData();
            List<Article> articles = articleController.getAll();
            List<Category> categorys = categoryController.getAll();

            if (res != null) {
                while (res.next()) {
                    tableModel.addRow(
                            new String[]{res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getInt(5) + ""});
                }
            }
            
//            articles.forEach(a -> );
            
        } catch (SQLException e) {
            System.out.println("Error load data: " + e.getMessage());
        }
    }
    
}

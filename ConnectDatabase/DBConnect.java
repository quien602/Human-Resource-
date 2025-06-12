/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConnectDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cslt
 */

public class DBConnect {

    public static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static String url = "jdbc:sqlserver://DESKTOP-FAMRMBO:1433;databaseName=QLNS_Vinamilk";
    public static String user = "sa";
    public static String pass = "123";
    //tạo biến lưu trữ kết nối
    public static Connection cnn;
    //Hàm để kết nối database, boolean trả về giá trị true, false
    public static boolean open() {
        try {
            if (cnn == null || cnn.isClosed()) {
                Class.forName(driver);//để tải driver JDBC cho SQL Server và sau đó sử dụng 
                cnn = DriverManager.getConnection(url, user, pass);//để kết nối đến cơ sở dữ liệu với thông tin đăng nhập và địa chỉ URL đã được khai báo.
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
    }
//Hàm đóng kết nối
    public static void close() {
        try {
            if (cnn != null) {
                cnn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
//Hàm đóng kết nối đối tượng truy vấn với database sql    
    public static void close(PreparedStatement ps){
        try {
            if (ps !=null) {
            ps.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
    }
//Hàm đóng kết nối đối tượng lưu kết quả truy vấn với database sql
    public static void close(PreparedStatement ps, ResultSet rs){
        try {
            if (rs !=null) {
            rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        close(ps);
    }
}


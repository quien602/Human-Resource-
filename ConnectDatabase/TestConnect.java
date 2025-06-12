/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConnectDatabase;

/**
 *
 * @author IBM ThinkPad
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestConnect {

    public static void main(String[] args) {
        if (DBConnect.open()) {
            Connection conn = DBConnect.cnn;
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                ps = conn.prepareStatement("SELECT * FROM Taikhoan");
                rs = ps.executeQuery();
                while (rs.next()) {
                    System.out.println(rs.getString("TenDangNhap"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(TestConnect.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
            }
        }
    }

}


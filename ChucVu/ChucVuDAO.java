/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ChucVu;

import ConnectDatabase.DBConnect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Anonymous
 */
public class ChucVuDAO implements IChucVuDAO {

    @Override
    public ArrayList<ChucVu> getAll() {
        ArrayList<ChucVu> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select *from ChucVu");
                rs = ps.executeQuery();
                list = new ArrayList<ChucVu>();
                while (rs.next()) {
                    ChucVu k = new ChucVu();
                    k.setMaCV(rs.getString(1));
                    k.setTenCV(rs.getString(2));
                    list.add(k);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ChucVuDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
            }

        }
        return list;
    }

    @Override
    public ChucVu addNew(ChucVu cv) {
        PreparedStatement ps = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("INSERT INTO ChucVu values (?,?)");
                ps.setString(1, cv.getMaCV());
                ps.setString(2, cv.getTenCV());
                int row = ps.executeUpdate();
                if (row < 1) {
                    cv = null;
                }
            } catch (SQLException ex) {
                Logger.getLogger(ChucVuDAO.class.getName()).log(Level.SEVERE, null, ex);
                cv = null;
            }finally{
                DBConnect.close(ps);
            }
        }
        return cv;
    }

    @Override
    public ChucVu updateByID(ChucVu cv) {
        PreparedStatement ps = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("update ChucVu set TenCV =? where MaCV = ?");
               
                ps.setString(1, cv.getTenCV());
                 ps.setString(2, cv.getMaCV());
                int row = ps.executeUpdate();
                if (row < 1) {
                    cv = null;
                }
            } catch (SQLException ex) {
                Logger.getLogger(ChucVuDAO.class.getName()).log(Level.SEVERE, null, ex);
                cv = null;
            }finally{
                DBConnect.close();
            }
        }
        return cv;
    }
    public void deleteChucVu(String CVID) throws SQLException, ClassNotFoundException{
        PreparedStatement ps = null;
        if (DBConnect.open()) {
            ps = DBConnect.cnn.prepareStatement("delete from ChucVu where MaCV = ?");
            ps.setString(1, CVID);
            ps.executeUpdate();
            DBConnect.close();
        }
    }

    @Override
    public ArrayList<ChucVu> checkID(String MaCV) {
        ArrayList<ChucVu> list = null;
        PreparedStatement psCheck = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                psCheck = DBConnect.cnn.prepareStatement("select *from ChucVu where MaCV = ?");
                psCheck.setString(1, MaCV);
                rs = psCheck.executeQuery();
                list = new ArrayList<ChucVu>();
                while (rs.next()) {
                    ChucVu k = new ChucVu();
                    k.setMaCV(rs.getString(1));
                    list.add(k);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ChucVuDAO.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                DBConnect.close(psCheck, rs);
            }
            
        }
        return list;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Phongban;

import ConnectDatabase.DBConnect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FPT
 */
public class PhongbanDAO implements IPhongbanDAO {

    @Override
    public ArrayList<Phongban> getAll() {
        ArrayList<Phongban> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select *from PhongBan");
                rs = ps.executeQuery();
                list = new ArrayList<Phongban>();
                while (rs.next()) {
                    Phongban pb = new Phongban();
                    pb.setMaPB(rs.getString(1));
                    pb.setTenPB(rs.getString(2));
                    pb.setDiaDiemPB(rs.getString(3));
                    pb.setSdtPB(rs.getString(4));
                    list.add(pb);
                }
            } catch (SQLException ex) {
                Logger.getLogger(PhongbanDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
            }
        }
        return list;
    }

   

    @Override
    public Phongban addNew(Phongban pb) {
        PreparedStatement ps = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("insert into PhongBan(MaPB,TenPB,DiaDiemPB,SdtPB) values(?,?,?,?)");
                ps.setString(1, pb.getMaPB());
                ps.setString(2, pb.getTenPB());
                ps.setString(3, pb.getDiaDiemPB());
                ps.setString(4, pb.getSdtPB());
                int row = ps.executeUpdate();
                if (row < 1) {
                    pb = null;
                }
            } catch (SQLException ex) {
                Logger.getLogger(PhongbanDAO.class.getName()).log(Level.SEVERE, null, ex);
                pb = null;
            } finally {
                DBConnect.close(ps);
            }
        }
        return pb;
    }

    @Override
    public Phongban updateByID(Phongban pb) {
        PreparedStatement ps = null;
        if (DBConnect.open()) {
            try {
               ps = DBConnect.cnn.prepareStatement("update PhongBan set TenPB = ?,DiaDiemPB=?, SdtPB = ? where MaPB= ?");
               
                ps.setString(1, pb.getTenPB());
                ps.setString(2, pb.getDiaDiemPB());
                ps.setString(3, pb.getSdtPB());
                ps.setString(4, pb.getMaPB());
                int row = ps.executeUpdate();
                if (row < 1) {
                    pb = null;
                }
            } catch (SQLException ex) {
                Logger.getLogger(PhongbanDAO.class.getName()).log(Level.SEVERE, null, ex);
                pb = null;
            } finally {
                DBConnect.close();
            }
        }
        return pb;
    }
    public void deletePhongban(String MaPB)throws SQLException, ClassNotFoundException{
    PreparedStatement ps = null;
        if (DBConnect.open()) {
            ps = DBConnect.cnn.prepareStatement("delete from PhongBan where MaPB= ?");
            ps.setString(1, MaPB);
            ps.executeUpdate();
            DBConnect.close();
        }
    }

    @Override
    public ArrayList<Phongban> checkID(String MaPB) {
      ArrayList<Phongban> list = null;
      PreparedStatement psCheck = null;
      ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                psCheck = DBConnect.cnn.prepareStatement("select *from PhongBan where MaPB = ? ");
                psCheck.setString(1, MaPB);
                rs = psCheck.executeQuery();
                list = new ArrayList<Phongban>();
                while (rs.next()) {
                    Phongban pb = new Phongban();
                    pb.setMaPB(rs.getString(1));
                    list.add(pb);
                }
            } catch (SQLException ex) {
                Logger.getLogger(PhongbanDAO.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
            DBConnect.close(psCheck, rs);
            }
            
        }
        return list;
    }
    
}

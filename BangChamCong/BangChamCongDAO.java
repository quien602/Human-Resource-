/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BangChamCong;

import ConnectDatabase.DBConnect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author IBM ThinkPad
 */
public class BangChamCongDAO implements IBangChamCongDAO{
     @Override
    public ArrayList<BangChamCong> getAll() {
        ArrayList<BangChamCong> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select *from BangChamCong");
                rs = ps.executeQuery();
                list = new ArrayList<>();
                while (rs.next()) {
                    BangChamCong k = new BangChamCong();
                    k.setMaChamCong(rs.getString(1));
                    k.setMaNV(rs.getString(2));
                    k.setThangCC(rs.getInt(3));
                    k.setNamCC(rs.getInt(4));
                    k.setSongaylam(rs.getInt(5));
                    k.setSongaynghi(rs.getInt(6));
                    k.setSogiotangca(rs.getInt(7));      
                    list.add(k);
                }
            } catch (SQLException ex) {
                Logger.getLogger(BangChamCongDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
            }

        }
        return list;
    }

    @Override
    public BangChamCong addNew(BangChamCong bcc) {
        PreparedStatement ps = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("INSERT INTO BangChamCong values (?,?,?,?,?,?,?)");
                ps.setString(1, bcc.getMaChamCong());
                ps.setString(2, bcc.getMaNV());
                 ps.setInt(3, bcc.getThangCC());
                 ps.setInt(4, bcc.getNamCC());
                 ps.setInt(5,bcc.getSongaylam());
                 ps.setInt(6,bcc.getSongaynghi());
                 ps.setInt(7,bcc.getSogiotangca());
                
                int row = ps.executeUpdate();
                if (row < 1) {
                    bcc = null;
                }
            } catch (SQLException ex) {
                Logger.getLogger(BangChamCongDAO.class.getName()).log(Level.SEVERE, null, ex);
                bcc = null;
            }finally{
                DBConnect.close(ps);
            }
        }
        return bcc;
    }

    @Override
    public BangChamCong updateByID(BangChamCong bcc) {
        PreparedStatement ps = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("update BangChamCong set MaNV =?,ThangCC=?,NamCC=?,Songaylam=?,Songaynghi=?,Sogiotangca=? where MaChamCong = ?");
               ps.setString(1, bcc.getMaChamCong());
                ps.setString(2, bcc.getMaNV());
                 ps.setInt(3, bcc.getThangCC());
                 ps.setInt(4, bcc.getNamCC());
                 ps.setInt(5,bcc.getSongaylam());
                 ps.setInt(6,bcc.getSongaynghi());
                 ps.setInt(7,bcc.getSogiotangca());
                int row = ps.executeUpdate();
                if (row < 1) {
                    bcc = null;
                }
            } catch (SQLException ex) {
                Logger.getLogger(BangChamCongDAO.class.getName()).log(Level.SEVERE, null, ex);
                bcc = null;
            }finally{
                DBConnect.close();
            }
        }
        return bcc;
    }
    public void deleteBangChamCong(String CCID) throws SQLException, ClassNotFoundException{
        PreparedStatement ps = null;
        if (DBConnect.open()) {
            ps = DBConnect.cnn.prepareStatement("delete from BangChamCong where MaChamCong = ?");
            ps.setString(1, CCID);
            ps.executeUpdate();
            DBConnect.close();
        }
    }

    @Override
    public ArrayList<BangChamCong> checkID(String MaChamCong) {
        ArrayList<BangChamCong> list = null;
        PreparedStatement psCheck = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                psCheck = DBConnect.cnn.prepareStatement("select *from BangChamCong where MaChamCong = ?");
                psCheck.setString(1, MaChamCong);
                rs = psCheck.executeQuery();
                list = new ArrayList<BangChamCong>();
                while (rs.next()) {
                    BangChamCong k = new BangChamCong();
                    k.setMaChamCong(rs.getString(1));
                    list.add(k);
                }
            } catch (SQLException ex) {
                Logger.getLogger(BangChamCongDAO.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                DBConnect.close(psCheck, rs);
            }
            
        }
        return list;
    }
    public void deleteIDCC(String MaCC)throws SQLException,ClassNotFoundException{
    PreparedStatement ps = null;
        if (DBConnect.open()) {
            ps = DBConnect.cnn.prepareStatement("delete from BangChamCong where MaChamCong= ?");
            ps.setString(1, MaCC);
            ps.executeUpdate();
            DBConnect.close();
        }
    }
    public ArrayList<BangChamCong> CheckID(String MaChamCong) {
       // throw new UnsupportedOperationException("Not supported yet.");
         ArrayList<BangChamCong> list = null;
        PreparedStatement psCheck = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                psCheck = DBConnect.cnn.prepareStatement("select *from BangChamCong where MaChamCong= ?");
               psCheck.setString(1, MaChamCong);
                rs = psCheck.executeQuery();
                    list = new ArrayList<BangChamCong>();
                    while (rs.next()) {
                        BangChamCong bangChamCong = new BangChamCong();
                        bangChamCong.setMaChamCong(rs.getString(1));
                        list.add(bangChamCong);
                    }
            } catch (SQLException ex) {
                Logger.getLogger(BangChamCongDAO.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
            DBConnect.close(psCheck, rs);
            }
        }
        return  list;
    }
    public ArrayList<BangChamCong> findByIDNhanVien(String MaNV) {
        ArrayList<BangChamCong> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select  * from Bangchamcong where MaNV = ?");
                ps.setString(1, MaNV);
                rs = ps.executeQuery();
                list = new ArrayList<BangChamCong>();
                while (rs.next()) {
                    BangChamCong bcc = new BangChamCong();
                    bcc.setMaChamCong(rs.getString(1));
                    bcc.setMaNV(rs.getString(2));
                    bcc.setThangCC(rs.getInt(3));
                    bcc.setNamCC(rs.getInt(4));
                    bcc.setSongaylam(rs.getInt(5));
                    bcc.setSongaynghi(rs.getInt(6));
                    bcc.setSogiotangca(rs.getInt(7));
                    list.add(bcc);
                }
            } catch (SQLException ex) {
                Logger.getLogger(BangChamCongDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
            }
        }
        return list;
    }
     public static void main(String[] args) {
        System.out.println(new BangChamCongDAO().findByIDNhanVien("NV001").get(0).getMaNV());

    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HopDong;
import ConnectDatabase.DBConnect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author IBM ThinkPad
 */
public class HopDongDAO implements IHopDongDAO{
   

   public ArrayList<HopDong> getAll() {
        ArrayList<HopDong> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select *from Hopdong");
                rs = ps.executeQuery();
                list = new ArrayList<HopDong>();
                while (rs.next()) {
                     HopDong hd = new HopDong();
                    hd.setMaHD(rs.getString(1));
                    hd.setLoaiHopDong(rs.getString(2));
                    hd.setNgayBD(new Date(rs.getDate(3).getTime()));
                    hd.setNgayKT(new Date(rs.getDate(4).getTime()));
                    hd.setMaNV(rs.getString(5));

                    list.add(hd);
                }
            } catch (SQLException ex) {
                Logger.getLogger(HopDongDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
            }

        }
        return list;
    }

    public HopDong addNew(HopDong hd) {
        PreparedStatement ps = null;
        if (DBConnect.open()) {
            try {
                  ps = DBConnect.cnn.prepareStatement("insert into Hopdong values(?,?,?,?,?)");
                ps.setString(1, hd.getMaHD());
                ps.setString(2, hd.getLoaiHopDong());
                ps.setDate(3, new java.sql.Date(hd.getNgayBD().getTime()));
                ps.setDate(4, new java.sql.Date(hd.getNgayKT().getTime()));
                ps.setString(5, hd.getMaNV());

                int row = ps.executeUpdate();
                if (row < 1) {
                    hd = null;
                }
            } catch (SQLException ex) {
                Logger.getLogger(HopDongDAO.class.getName()).log(Level.SEVERE, null, ex);
                hd = null;
            }finally{
                DBConnect.close(ps);
            }
        }
        return hd;
    }

    public HopDong updateByID(HopDong hd) {
        PreparedStatement ps = null;
        if (DBConnect.open()) {
            try {
                 ps = DBConnect.cnn.prepareStatement("update Hopdong set LoaiHopDong = ?,NgayBD=?, NgayKT = ?, MaNV = ?, where MaHD= ?");
               
                ps.setString(1, hd.getLoaiHopDong());
                ps.setDate(2, new java.sql.Date(hd.getNgayBD().getTime()));
                ps.setDate(3, new java.sql.Date(hd.getNgayKT().getTime()));
                 ps.setString(4, hd.getMaNV());
                ps.setString(5, hd.getMaHD());
                int row = ps.executeUpdate();
                if (row < 1) {
                    hd = null;

                }
            } catch (SQLException ex) {
                Logger.getLogger(HopDongDAO.class.getName()).log(Level.SEVERE, null, ex);
                hd = null;
            }finally{
                DBConnect.close();
            }
        }
        return hd;
    }
    public void deleteHopDong(String MaHD) throws SQLException, ClassNotFoundException{
        PreparedStatement ps = null;
        if (DBConnect.open()) {
            ps = DBConnect.cnn.prepareStatement("delete from Hopdong where MaHD = ?");
            ps.setString(1, MaHD);
            ps.executeUpdate();
            DBConnect.close();
        }
    }

    public ArrayList<HopDong> checkID(String MaHD) {
        ArrayList<HopDong> list = null;
        PreparedStatement psCheck = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                 psCheck = DBConnect.cnn.prepareStatement("select *from Hopdong where MaHD = ? ");
                psCheck.setString(1, MaHD);
                rs = psCheck.executeQuery();
                list = new ArrayList<HopDong>();
                while (rs.next()) {
                    HopDong hd = new HopDong();
                    hd.setMaHD(rs.getString(1));
                    list.add(hd);

                }
            } catch (SQLException ex) {
                Logger.getLogger(HopDongDAO.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                DBConnect.close(psCheck, rs);
            }
            
        }
        return list;
    }
    
    
}

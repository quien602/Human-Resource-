/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Luong;

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
public class LuongDAO implements ILuongDAO {
     @Override
    public ArrayList<Luong> getAll() {
        ArrayList<Luong> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select * from Luong");
                rs = ps.executeQuery();
                list = new ArrayList<>();
                while (rs.next()) {
                    Luong k = new Luong();
                   k.setMaLuong(rs.getString(1));
                   k.setThangLuong(rs.getInt(2));
                    k.setNamLuong(rs.getInt(3));
                   k.setMaNV(rs.getString(4));
                    k.setMaChamCong(rs.getString(5));
                    k.setLuongCoBan(rs.getFloat(6));
                    k.setPhuCap(rs.getFloat(7));      
                    k.setLuongTangCa(rs.getFloat(8));
                    k.setBHTN(rs.getFloat(9));      
                    k.setBHYT(rs.getFloat(10));
                    k.setBHXH(rs.getFloat(11));     
                    k.setSoNguoiPT(rs.getInt(12));
                    k.setThueTNCN(rs.getFloat(13));
                    k.setLuongThucLinh(rs.getFloat(14));  
                    list.add(k);
                }
            } catch (SQLException ex) {
                Logger.getLogger(LuongDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
            }

        }
        return list;
    }

    @Override
    public Luong addNew(Luong lu) {
        PreparedStatement ps = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("INSERT INTO Luong values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                ps.setString(1, lu.getMaLuong());
                
                 ps.setString(2, lu.getMaNV());
                ps.setString(3, lu.getMaChamCong());
                
                 ps.setInt(4, lu.getThangLuong());
                 ps.setInt(5, lu.getNamLuong());
                 ps.setFloat(6,lu.getLuongCoBan());
                 ps.setFloat(7,lu.getPhuCap());
                 ps.setFloat(8,lu.getLuongTangCa());
                 ps.setFloat(9,lu.getBHTN());
                 ps.setFloat(10,lu.getBHYT());
                 ps.setFloat(11,lu.getBHXH());
                 ps.setInt(12,lu.getSoNguoiPT());
                 ps.setFloat(13,lu.getThueTNCN());
                 ps.setFloat(14,lu.getLuongThucLinh());
                
                int row = ps.executeUpdate();
                if (row < 1) {
                    lu = null;
                }
            } catch (SQLException ex) {
                Logger.getLogger(LuongDAO.class.getName()).log(Level.SEVERE, null, ex);
                lu = null;
            }finally{
                DBConnect.close(ps);
            }
        }
        return lu;
    }

    @Override
    public Luong updateByID(Luong lu) {
        PreparedStatement ps = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("update Luong set MaNV =?,MaChamCong =?,ThangLuong=?,NamLuong=?,LuongCoBan=?,PhuCap=?,LuongTangCa=?,BHTN=?,BHYT=?,BHXH=?,SoNguoiPT=?,ThueTNCN=?,LuongThucLinh=? where MaLuong = ?");
                ps.setString(1, lu.getMaLuong());
                ps.setString(2, lu.getMaNV());
                ps.setString(3, lu.getMaChamCong());
                ps.setInt(4, lu.getThangLuong());
                ps.setInt(5, lu.getNamLuong());
                 ps.setFloat(6,lu.getLuongCoBan());
                 ps.setFloat(7,lu.getPhuCap());
                 ps.setFloat(8,lu.getLuongTangCa());
                 ps.setFloat(9,lu.getBHTN());
                 ps.setFloat(10,lu.getBHYT());
                 ps.setFloat(11,lu.getBHXH());
                 ps.setInt(12,lu.getSoNguoiPT());
                 ps.setFloat(13,lu.getThueTNCN());
                 ps.setFloat(14,lu.getLuongThucLinh());
                int row = ps.executeUpdate();
                if (row < 1) {
                    lu = null;
                }
            } catch (SQLException ex) {
                Logger.getLogger(LuongDAO.class.getName()).log(Level.SEVERE, null, ex);
                lu = null;
            }finally{
                DBConnect.close();
            }
        }
        return lu;
    }
    public void deleteLuong(String LuongID) throws SQLException, ClassNotFoundException{
        PreparedStatement ps = null;
        if (DBConnect.open()) {
            ps = DBConnect.cnn.prepareStatement("delete from Luong where MaLuong = ?");
            ps.setString(1, LuongID);
            ps.executeUpdate();
            DBConnect.close();
        }
    }

    @Override
    public ArrayList<Luong> checkID(String MaLuong) {
        ArrayList<Luong> list = null;
        PreparedStatement psCheck = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                psCheck = DBConnect.cnn.prepareStatement("select *from Luong where MaLuong = ?");
                psCheck.setString(1, MaLuong);
                rs = psCheck.executeQuery();
                list = new ArrayList<Luong>();
                while (rs.next()) {
                    Luong k = new Luong();
                    k.setMaLuong(rs.getString(1));
                    list.add(k);
                }
            } catch (SQLException ex) {
                Logger.getLogger(LuongDAO.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                DBConnect.close(psCheck, rs);
            }
            
        }
        return list;
    }
    public void deleteIDLuong(String MaLuong)throws SQLException,ClassNotFoundException{
    PreparedStatement ps = null;
        if (DBConnect.open()) {
            ps = DBConnect.cnn.prepareStatement("delete from Luong where MaLuong= ?");
            ps.setString(1, MaLuong);
            ps.executeUpdate();
            DBConnect.close();
        }
    }
    public ArrayList<Luong> CheckID(String MaLuong) {
       // throw new UnsupportedOperationException("Not supported yet.");
         ArrayList<Luong> list = null;
        PreparedStatement psCheck = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                psCheck = DBConnect.cnn.prepareStatement("select *from Luong where MaLuong= ?");
               psCheck.setString(1, MaLuong);
                rs = psCheck.executeQuery();
                    list = new ArrayList<Luong>();
                    while (rs.next()) {
                        Luong luong = new Luong();
                        luong.setMaLuong(rs.getString(1));
                        list.add(luong);
                    }
            } catch (SQLException ex) {
                Logger.getLogger(LuongDAO.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
            DBConnect.close(psCheck, rs);
            }
        }
        return  list;
    }
     
}

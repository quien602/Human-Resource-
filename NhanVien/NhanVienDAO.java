/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package NhanVien;

import ConnectDatabase.DBConnect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author FPT
 */
public class NhanVienDAO implements INhanVienDAO {

    @Override
    public ArrayList<NhanVien> getAll() {
        ArrayList<NhanVien> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select* from Nhanvien");
                rs = ps.executeQuery();

                list = new ArrayList<>();
                while (rs.next()) {
                    NhanVien nv = new NhanVien();
                    nv.setMaNV(rs.getString(1));
                    nv.setHoTen(rs.getString(2));
                    nv.setCCCD(rs.getString(3));
                    nv.setNgaySinh(new Date(rs.getDate(4).getTime()));
                    nv.setQueQuan(rs.getString(5));
                    nv.setGioitinh(rs.getBoolean(6));
                    nv.setSdtNV(rs.getString(7));
                    nv.setMaPB(rs.getString(8));
                    nv.setMaCV(rs.getString(9));
                    nv.setMaKT(rs.getString(10));
                    list.add(nv);
                }
            } catch (SQLException ex) {
                Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
            }

        }
        return list;
    }

    @Override
    public ArrayList<NhanVien> findByIDPhongban(String MaPB) {
        ArrayList<NhanVien> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select * from Nhanvien where MaPB = ?");
                ps.setString(1, MaPB);
                rs = ps.executeQuery();
                list = new ArrayList<>();
                while (rs.next()) {
                   NhanVien nv = new NhanVien();
                    nv.setMaNV(rs.getString(1));
                    nv.setHoTen(rs.getString(2));
                    nv.setCCCD(rs.getString(3));
                    nv.setNgaySinh(new Date(rs.getDate(4).getTime()));
                    nv.setQueQuan(rs.getString(5));
                    nv.setGioitinh(rs.getBoolean(6));
                    nv.setSdtNV(rs.getString(7));
                    nv.setMaPB(rs.getString(8));
                    nv.setMaCV(rs.getString(9));
                    nv.setMaKT(rs.getString(10));
                    list.add(nv);
                }

            } catch (SQLException ex) {
                Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
            }

        }

        return list;
    }
    
    @Override
    public ArrayList<NhanVien> findByIDChucVu(String MaCV) {
        ArrayList<NhanVien> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select * from Nhanvien where MaCV = ?");
                ps.setString(1, MaCV);
                rs = ps.executeQuery();
                list = new ArrayList<>();
                while (rs.next()) {
                   NhanVien nv = new NhanVien();
                    nv.setMaNV(rs.getString(1));
                    nv.setHoTen(rs.getString(2));
                    nv.setCCCD(rs.getString(3));
                    nv.setNgaySinh(new Date(rs.getDate(4).getTime()));
                    nv.setQueQuan(rs.getString(5));
                    nv.setGioitinh(rs.getBoolean(6));
                    nv.setSdtNV(rs.getString(7));
                    nv.setMaPB(rs.getString(8));
                    nv.setMaCV(rs.getString(9));
                    nv.setMaKT(rs.getString(10));
                    list.add(nv);
                }

            } catch (SQLException ex) {
                Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
            }

        }

        return list;
    }
    
    @Override
    public ArrayList<NhanVien> findByIDMucKhenThuong(String MaKT) {
        ArrayList<NhanVien> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select * from Nhanvien where MaKhenThuong = ?");
                ps.setString(1, MaKT);
                rs = ps.executeQuery();
                list = new ArrayList<>();
                while (rs.next()) {
                   NhanVien nv = new NhanVien();
                    nv.setMaNV(rs.getString(1));
                    nv.setHoTen(rs.getString(2));
                    nv.setCCCD(rs.getString(3));
                    nv.setNgaySinh(new Date(rs.getDate(4).getTime()));
                    nv.setQueQuan(rs.getString(5));
                    nv.setGioitinh(rs.getBoolean(6));
                    nv.setSdtNV(rs.getString(7));
                    nv.setMaPB(rs.getString(8));
                    nv.setMaCV(rs.getString(9));
                    nv.setMaKT(rs.getString(10));
                    list.add(nv);
                }

            } catch (SQLException ex) {
                Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
            }

        }

        return list;
    }

    @Override
    public NhanVien addNew(NhanVien nv) {
        PreparedStatement ps = null;

        if (DBConnect.open()) {
            try {

                ps = DBConnect.cnn.prepareStatement("insert into Nhanvien values (?,?,?,?,?,?,?,?,?,?)");
                ps.setNString(1, nv.getMaNV());
                ps.setNString(2, nv.getHoTen());
                ps.setNString(3, nv.getCCCD ());
                ps.setDate(4, new java.sql.Date(nv.getNgaySinh().getTime()));
                ps.setNString(5, nv.getQueQuan());
                ps.setBoolean(6, nv.isGioitinh());
                ps.setNString(7, nv.getSdtNV());
                ps.setNString(8, nv.getMaPB());
                ps.setNString(9, nv.getMaCV());
                ps.setNString(10, nv.getMaKT());
                int row = ps.executeUpdate();
                if (row < 1) {
                    nv = null;
                }

            } catch (SQLException ex) {
                Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
                nv = null;
            } finally {
                DBConnect.close(ps);
            }
        }
        return nv;

    }

    @Override
    public NhanVien updateByID(NhanVien nv) {
        PreparedStatement ps = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("update Nhanvien set HoTen = ?,"
                        + "CCCD = ?, NgaySinh = ?,"
                        +"QueQuan  = ?, GioiTinh = ?, SdtNV = ?,"
                        +"MaPB = ?,MaCV = ?,MaKhenThuong = ? where MaNV = ?");
                ps.setNString(1, nv.getHoTen());
                ps.setNString(2, nv.getCCCD ());
                ps.setDate(3, new java.sql.Date(nv.getNgaySinh().getTime()));
                ps.setNString(4, nv.getQueQuan());
                ps.setBoolean(5, nv.isGioitinh());
                ps.setNString(6, nv.getSdtNV());
                ps.setNString(7, nv.getMaPB());
                ps.setNString(8, nv.getMaCV());
                ps.setNString(9, nv.getMaKT());
                ps.setNString(10, nv.getMaNV());
                if (ps.executeUpdate() < 1) {
                    nv = null;
                }

            } catch (SQLException ex) {
                Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close();
            }
        }
        return nv;
    }

    public void deleteIDNhanVien(String MaNV) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = null;
        if (DBConnect.open()) {
            ps = DBConnect.cnn.prepareStatement("delete from Nhanvien where MaNV= ?");
            ps.setString(1, MaNV);
            ps.executeUpdate();
            DBConnect.close();
        }
    }

    public static void main(String[] args) {
        System.out.println(new NhanVienDAO().findByIDPhongban("PB001").get(0).getMaPB());

    }

    @Override
    public ArrayList<NhanVien> CheckID(String MaNV) {
        ArrayList<NhanVien> list = null;
        PreparedStatement psCheck = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                psCheck = DBConnect.cnn.prepareStatement("select *from Nhanvien where MaNV = ?");
                psCheck.setString(1, MaNV);
                rs = psCheck.executeQuery();
                list = new ArrayList<NhanVien>();
                while (rs.next()) {
                    NhanVien nhanVien = new NhanVien();
                    nhanVien.setMaNV(rs.getString(1));
                    list.add(nhanVien);
                }
            } catch (SQLException ex) {
                Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(psCheck, rs);
            }
        }
        return list;
    }
}

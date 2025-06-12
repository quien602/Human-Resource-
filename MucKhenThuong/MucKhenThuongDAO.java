/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MucKhenThuong;

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
public class MucKhenThuongDAO implements IMucKhenThuongDAO {

    @Override
    public ArrayList<MucKhenThuong> getAll() {
        ArrayList<MucKhenThuong> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select *from MucKhenthuong");
                rs = ps.executeQuery();
                list = new ArrayList<>();
                while (rs.next()) {
                    MucKhenThuong kt = new MucKhenThuong();
                    kt.setMaKT(rs.getString(1));
                    kt.setLyDo(rs.getString(2));
                    kt.setTienThuong(rs.getInt(3));

                    list.add(kt);
                }
            } catch (SQLException ex) {
                Logger.getLogger(MucKhenThuongDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
            }
        }
        return list;

    }

    @Override
    public ArrayList<MucKhenThuong> findIDMaKT(String MaKT) {
        ArrayList<MucKhenThuong> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select *from MucKhenthuong where MaKhenThuong =?");
                ps.setString(1, MaKT);
                rs = ps.executeQuery();
                list = new ArrayList<>();
                while (rs.next()) {
                    MucKhenThuong kt = new MucKhenThuong();
                    kt.setMaKT(rs.getString(1));
                    kt.setLyDo(rs.getString(2));
                    kt.setTienThuong(rs.getInt(3));
                    list.add(kt);
                }
            } catch (SQLException ex) {
                Logger.getLogger(MucKhenThuongDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
            }
        }
        return list;
    }

    @Override
    public MucKhenThuong addNew(MucKhenThuong kt) {
        PreparedStatement ps = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("insert into MucKhenthuong(MaKhenThuong,LyDo,TienThuong) values (?,?,?)");
                ps.setString(1, kt.getMaKT());
                ps.setString(2, kt.getLyDo());
                ps.setInt(3, kt.getTienThuong());

                int row = ps.executeUpdate();
                if (row < 1) {
                    kt = null;
                }
            } catch (SQLException ex) {
                Logger.getLogger(MucKhenThuongDAO.class.getName()).log(Level.SEVERE, null, ex);
                kt = null;
            } finally {
                DBConnect.close(ps);
            }
        }
        return kt;
    }

    @Override
    public MucKhenThuong updateByID(MucKhenThuong kt) {
        PreparedStatement ps = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("update MucKhenthuong set LyDo=?,TienThuong=? where MaKhenThuong=?");

                ps.setString(1, kt.getLyDo());
                ps.setInt(2, kt.getTienThuong());
                ps.setString(3, kt.getMaKT());
                int row = ps.executeUpdate();
                if (row < 1) {
                    kt = null;
                }
            } catch (SQLException ex) {
                Logger.getLogger(MucKhenThuongDAO.class.getName()).log(Level.SEVERE, null, ex);
                kt = null;
            } finally {
                DBConnect.close();
            }
        }
        return kt;
    }

    public void deleteMucKhenThuong(String KhenThuongID) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = null;
        if (DBConnect.open()) {
            ps = DBConnect.cnn.prepareStatement("delete from MucKhenthuong where MaKhenThuong= ?");
            ps.setString(1, KhenThuongID);
            ps.executeUpdate();
            DBConnect.close();
        }
    }

    @Override
    public ArrayList<MucKhenThuong> CheckID(String MaKT) {
       // throw new UnsupportedOperationException("Not supported yet.");
         ArrayList<MucKhenThuong> list = null;
        PreparedStatement psCheck = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                psCheck = DBConnect.cnn.prepareStatement("select *from MucKhenthuong where MaKhenThuong= ?");
               psCheck.setString(1, MaKT);
                rs = psCheck.executeQuery();
                    list = new ArrayList<MucKhenThuong>();
                    while (rs.next()) {
                        MucKhenThuong muckhenThuong = new MucKhenThuong();
                        muckhenThuong.setMaKT(rs.getString(1));
                        list.add(muckhenThuong);
                    }
            } catch (SQLException ex) {
                Logger.getLogger(MucKhenThuongDAO.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
            DBConnect.close(psCheck, rs);
            }
        }
        return  list;
    }
}

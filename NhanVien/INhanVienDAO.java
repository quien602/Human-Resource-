/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package NhanVien;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
public interface INhanVienDAO {
    public ArrayList<NhanVien> getAll();
    public ArrayList<NhanVien>findByIDPhongban(String MaPB);
    public ArrayList<NhanVien>findByIDChucVu(String MaCV);
    public ArrayList<NhanVien>findByIDMucKhenThuong(String MaKT);
    public NhanVien addNew(NhanVien nv);
    public NhanVien updateByID(NhanVien nv);
    public ArrayList<NhanVien> CheckID(String MaNV);
}

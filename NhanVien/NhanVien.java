/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package NhanVien;


import Phongban.Phongban;
import ChucVu.ChucVu;
import MucKhenThuong.MucKhenThuong;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author FPT
 */
public class NhanVien {
     private String MaNV;
    private String HoTen ;
    private String CCCD;
    private Date NgaySinh;
    private String QueQuan;
    private boolean GioiTinh;
    private String SdtNV;
    private String MaPB;
    private String MaCV;
    private String MaKT;
    private ArrayList<Phongban> listPB;
    private ArrayList<ChucVu> listCV;
    private ArrayList<MucKhenThuong> listKT;
    
    public ArrayList<Phongban> getListPB() {
        return listPB;
    }

    public void setListPB(ArrayList<Phongban> listPB) {
        this.listPB = listPB;
    }
    
    public ArrayList<ChucVu> getListCV() {
        return listCV;
    }

    public void setListCV(ArrayList<ChucVu> listCV) {
        this.listCV = listCV;
    }
    
    public ArrayList<MucKhenThuong> getListKT() {
        return listKT;
    }

    public void setListKT(ArrayList<MucKhenThuong> listKT) {
        this.listKT = listKT;
    }

    public  NhanVien() {
    }

    public NhanVien(String MaNV,String HoTen,String CCCD, Date NgaySinh,String QueQuan, boolean GioiTinh, String SdtNV, String MaPB,String MaCV,String MaKT) {
        this.MaNV = MaNV;
        this.HoTen = HoTen;
        this.CCCD = CCCD;
        this.NgaySinh = NgaySinh;
        this.QueQuan = QueQuan;
        this.GioiTinh = GioiTinh;
        this.SdtNV = SdtNV;
        this.MaPB =MaPB;
        this.MaCV =MaCV;
        this.MaKT =MaKT;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }    
    
    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }
    
    public String getQueQuan () {
        return QueQuan ;
    }

    public void setQueQuan (String QueQuan ) {
        this.QueQuan  = QueQuan ;
    }



    public boolean isGioitinh() {
        return GioiTinh;
    }

    public void setGioitinh(boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }


    public String getSdtNV() {
        return SdtNV;
    }

    public void setSdtNV(String SdtNV) {
        this.SdtNV = SdtNV;
    }
    
    public String getMaPB() {
        return MaPB;
    }

    public void setMaPB(String MaPB) {
        this.MaPB = MaPB;
    }
    
    public String getMaCV() {
        return MaCV;
    }

    public void setMaCV(String MaCV) {
        this.MaCV = MaCV;
    }
    
    public String getMaKT() {
        return MaKT;
    }

    public void setMaKT(String MaKT) {
        this.MaKT = MaKT;
    }
}
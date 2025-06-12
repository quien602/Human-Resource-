/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HopDong;
import java.util.ArrayList;
import java.util.Date;
import NhanVien.NhanVien;
/**
 *
 * @author IBM ThinkPad
 */
public class HopDong {
     private String MaHD;
    private String LoaiHopDong ;
    private Date NgayBD;
    private Date NgayKT;
    private String MaNV;
    private ArrayList<NhanVien> listNV;
    
    public ArrayList<NhanVien> getListNV() {
        return listNV;
    }

    public void setListNV(ArrayList<NhanVien> listNV) {
        this.listNV = listNV;
    }
    
    

    public  HopDong() {
    }

    public HopDong(String MaHD,String LoaiHopDong,Date NgayBD,Date NgayKT, String MaNV) 
    {
        this.MaHD = MaHD;
        this.LoaiHopDong = LoaiHopDong;
        this.NgayBD = NgayBD;
        this.NgayKT = NgayKT;
        this.MaNV =MaNV;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getLoaiHopDong() {
        return LoaiHopDong;
    }

    public void setLoaiHopDong(String LoaiHopDong) {
        this.LoaiHopDong = LoaiHopDong;
    }
    
    public Date getNgayBD() {
        return NgayBD;
    }

    public void setNgayBD(Date NgayBD) {
        this.NgayBD = NgayBD;
    }
    
     public Date getNgayKT() {
        return NgayKT;
    }

    public void setNgayKT(Date NgayKT) {
        this.NgayKT = NgayKT;
    }


    
    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }
}

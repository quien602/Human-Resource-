/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Luong;

import NhanVien.NhanVien;
import BangChamCong.BangChamCong;
import java.util.ArrayList;

/**
 *
 * @author IBM ThinkPad
 */
public class Luong {
    private String MaLuong;
    private int ThangLuong;
    private int NamLuong;
    private String MaNV;
    private ArrayList<NhanVien> listNV;
    private String MaChamCong;
    private ArrayList<BangChamCong> listCC;
    
    private float LuongCoBan;
    private float PhuCap;
    private float LuongTangCa;
    private float BHTN;
    private float BHYT;
    private float BHXH;
    private int SoNguoiPT;
    private float ThueTNCN;
    private float LuongThucLinh;
    
    
   
    
    public ArrayList<NhanVien> getListNV() {
        return listNV;
    }

    public void setListNV(ArrayList<NhanVien> listNV) {
        this.listNV = listNV;
    }
    
    public ArrayList<BangChamCong> getListCC() {
        return listCC;
    }

    public void setListCC(ArrayList<BangChamCong> listCC) {
        this.listCC = listCC;
    }

    public  Luong() {
    }

    public Luong(String MaLuong,String MaNV,String MaChamCong, int ThangLuong, int NamLuong,float LuongCoBan,float PhuCap, float LuongTangCa, float BHTN, float BHYT, float BHXH, int SoNguoiPT, float ThueTNCN, float LuongThucLinh) 
    {
        this.MaLuong=MaLuong;
        this.MaNV = MaNV;
        this.MaChamCong = MaChamCong;
        this.ThangLuong = ThangLuong;
        this.NamLuong = NamLuong;
        this.LuongCoBan =LuongCoBan;
        this.PhuCap =PhuCap;
        this.LuongTangCa =LuongTangCa;
        this. BHTN =  BHTN;
        this.BHYT = BHYT;
        this.BHXH = BHXH;
        this.SoNguoiPT =SoNguoiPT;
        this.ThueTNCN =ThueTNCN;
        this.LuongThucLinh =LuongThucLinh;
        
    }
    
 public String getMaLuong() {
        return MaLuong;
    }

    public void setMaLuong(String MaLuong) {
        this.MaLuong = MaLuong;
    }

    
     public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getMaChamCong() {
        return MaChamCong;
    }

    public void setMaChamCong(String MaChamCong) {
        this.MaChamCong = MaChamCong;
    }

    
    
   public int getThangLuong() {
        return ThangLuong;
    }
   
   public int getNamLuong() {
        return NamLuong;
    }
   
   public float getLuongCoBan() {
        return LuongCoBan;
    }
   
   public float getPhuCap() {
        return PhuCap;
    }
   public float getLuongTangCa() {
        return LuongTangCa;
    }
   
   public float getBHTN() {
        return BHTN;
    }
   public float getBHYT() {
        return BHYT;
    }
   
   public float getBHXH() {
        return BHXH;
    }
   public int getSoNguoiPT() {
        return SoNguoiPT;
    }
   public float getThueTNCN() {
        return ThueTNCN;
    }
   
   public float getLuongThucLinh() {
        return LuongThucLinh;
    }
   
  
   public void setThangLuong(int ThangLuong) {
        this.ThangLuong= ThangLuong;
    }
   public void setNamLuong(int NamLuong) {
        this.NamLuong= NamLuong;
    }
    public void setLuongCoBan(float LuongCoBan) {
        this.LuongCoBan= LuongCoBan;
    }
   public void setPhuCap(float PhuCap) {
        this.PhuCap= PhuCap;
    }
   public void setLuongTangCa(float LuongTangCa) {
        this.LuongTangCa= LuongTangCa;
    }
   public void setBHTN(float BHTN) {
        this.BHTN= BHTN;
    }
   public void setBHYT(float BHYT) {
        this.BHYT= BHYT;
    }
   public void setBHXH(float BHXH) {
        this.BHXH= BHXH;
    }
   public void setSoNguoiPT(int SoNguoiPT) {
        this.SoNguoiPT= SoNguoiPT;
    }
  public void setThueTNCN(float ThueTNCN) {
        this.ThueTNCN= ThueTNCN;
    }
   public void setLuongThucLinh(float LuongThucLinh) {
        this.LuongThucLinh= LuongThucLinh;
    }
  
   
}

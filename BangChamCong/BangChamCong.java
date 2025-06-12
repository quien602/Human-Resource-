/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BangChamCong;

import NhanVien.NhanVien;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author IBM ThinkPad
 */
public class BangChamCong {
      private String MaChamCong;
       private String MaNV;
    private ArrayList<NhanVien> listNV;
    private int ThangCC;
    private int NamCC;
    private int Songaylam;
    private int Songaynghi;
    private int Sogiotangca;
    
   
    
    public ArrayList<NhanVien> getListNV() {
        return listNV;
    }

    public void setListNV(ArrayList<NhanVien> listNV) {
        this.listNV = listNV;
    }
    
    

    public  BangChamCong() {
    }

    public BangChamCong(String MaChamCong,String MaNV, int ThangCC, int NamCC, int Songaylam, int Songaynghi, int Sogiotangca) 
    {
        this.MaChamCong = MaChamCong;
        this.MaNV = MaNV;
        this.ThangCC = ThangCC;
        this.NamCC = NamCC;
        this.Songaylam =Songaylam;
        this.Songaynghi =Songaynghi;
        this.Sogiotangca =Sogiotangca;
    }

    public String getMaChamCong() {
        return MaChamCong;
    }

    public void setMaChamCong(String MaChamCong) {
        this.MaChamCong = MaChamCong;
    }

     public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    
   public int getThangCC() {
        return ThangCC;
    }
   
   public int getNamCC() {
        return NamCC;
    }
   
   public int getSongaylam() {
        return Songaylam;
    }
   
   public int getSongaynghi() {
        return   Songaynghi;
    }
   
   public int getSogiotangca() {
        return   Sogiotangca;
    }
   public void setThangCC(int ThangCC) {
        this.ThangCC= ThangCC;
    }
   public void setNamCC(int NamCC) {
        this.NamCC= NamCC;
    }
   public void setSongaylam(int Songaylam) {
        this.Songaylam= Songaylam;
    }
   public void setSongaynghi(int Songaynghi) {
        this.Songaynghi= Songaynghi;
    }
   public void setSogiotangca(int Sogiotangca) {
        this.Sogiotangca= Sogiotangca;
    }
   
    
}

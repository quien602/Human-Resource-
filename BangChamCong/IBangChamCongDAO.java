/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package BangChamCong;

import BangChamCong.BangChamCong;

import java.util.ArrayList;

/**
 *
 * @author IBM ThinkPad
 */
public interface IBangChamCongDAO {
    public ArrayList<BangChamCong> getAll();
    public BangChamCong addNew(BangChamCong bcc);
    public BangChamCong updateByID(BangChamCong bcc);
    public ArrayList<BangChamCong> checkID(String MaChamCong);
    public ArrayList<BangChamCong> findByIDNhanVien(String manv);
}

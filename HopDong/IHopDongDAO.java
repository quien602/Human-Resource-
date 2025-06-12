/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package HopDong;

import java.util.ArrayList;

/**
 *
 * @author IBM ThinkPad
 */
public interface IHopDongDAO {
     public ArrayList<HopDong> getAll();
    
    public HopDong addNew(HopDong hd);
    public HopDong updateByID(HopDong hd);
    public ArrayList<HopDong> checkID(String MaHD);
}

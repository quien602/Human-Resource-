/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Luong;
import Luong.Luong;
import java.util.ArrayList;
/**
 *
 * @author IBM ThinkPad
 */
public interface ILuongDAO {
      public ArrayList<Luong> getAll();
    public Luong addNew(Luong lu);
    public Luong updateByID(Luong lu);
    public ArrayList<Luong> checkID(String MaLuong);
    
}

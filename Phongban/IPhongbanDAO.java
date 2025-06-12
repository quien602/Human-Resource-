/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Phongban;

import java.util.ArrayList;

/**
 *
 * @author FPT
 */
public interface IPhongbanDAO {
    public ArrayList<Phongban> getAll();
    public Phongban addNew(Phongban pb);
    public Phongban updateByID(Phongban pb);
    public ArrayList<Phongban> checkID(String MaPB);
   }

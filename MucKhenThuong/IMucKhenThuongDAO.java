/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MucKhenThuong;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
public interface IMucKhenThuongDAO {

    public ArrayList<MucKhenThuong> getAll();
    public ArrayList<MucKhenThuong> findIDMaKT(String MaKT);
    public MucKhenThuong addNew(MucKhenThuong kt);
    public MucKhenThuong updateByID(MucKhenThuong kt);
    public ArrayList<MucKhenThuong> CheckID(String MaKT);
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ChucVu;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */ 
public interface IChucVuDAO {
    public ArrayList<ChucVu> getAll();
    public ChucVu addNew(ChucVu cv);
    public ChucVu updateByID(ChucVu cv);
    public ArrayList<ChucVu> checkID(String MaCV);
}

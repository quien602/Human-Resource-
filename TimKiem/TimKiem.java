/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TimKiem;

/**
 *
 * @author FPT
 */
public class TimKiem {
    private String MaPB;
    private String MaNV;

    public TimKiem() {
    }

    public TimKiem(String MaPB, String MaNV) {
        this.MaPB = MaPB;
        this.MaNV = MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getMaNV() {
        return MaNV;
    }

    public TimKiem(String MaPB) {
        this.MaPB = MaPB;
    }

    public String getMaPB() {
        return MaPB;
    }

    public void setMaPB(String MaPB) {
        this.MaPB = MaPB;
    }
    
}

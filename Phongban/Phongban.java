/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Phongban;

/**
 *
 * @author FPT
 */
public class Phongban {
    private String MaPB;
    private String TenPB ;
    private String DiaDiemPB;
    private String SdtPB;

    public Phongban() {
    }

    public Phongban(String MaPB, String TenPB, String DiaDiemPB, String SdtPB) {
        this.MaPB = MaPB;
        this.TenPB = TenPB;
        this.DiaDiemPB = DiaDiemPB;
        this.SdtPB = SdtPB;
    }

   

    public String getMaPB() {
        return MaPB;
    }

    public void setMaPB(String MaPB) {
        this.MaPB = MaPB;
    }

    public String getTenPB() {
        return TenPB;
    }

    public void setTenPB(String TenPB) {
        this.TenPB = TenPB;
    }



    public String getDiaDiemPB () {
        return DiaDiemPB ;
    }

    public void setDiaDiemPB (String DiaDiemPB ) {
        this.DiaDiemPB  = DiaDiemPB ;
    }

    public String getSdtPB() {
        return SdtPB;
    }

    public void setSdtPB(String SdtPB) {
        this.SdtPB = SdtPB;
    }
    
}
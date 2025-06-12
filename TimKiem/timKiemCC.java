/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TimKiem;

/**
 *
 * @author IBM ThinkPad
 */
public class timKiemCC {
     private String MaNV;
    private String MaChamCong;

    public timKiemCC() {
    }

    public timKiemCC(String MaNV, String MaChamCong) {
        
        this.MaNV = MaNV;
        this.MaChamCong = MaChamCong;
    }
    public String getMaChamCong() {
        return MaChamCong;
    }

    public void setMaChamCong(String MaChamCong) {
        this.MaChamCong = MaChamCong;
    }
    

    public timKiemCC(String MaNV) {
        this.MaNV = MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getMaNV() {
        return MaNV;
    }
    
}

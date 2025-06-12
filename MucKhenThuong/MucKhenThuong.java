/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MucKhenThuong;

/**
 *
 * @author FPT
 */
public class MucKhenThuong {
    private String MaKT;
    private String LyDo;
    private int TienThuong;


    public MucKhenThuong() {
    }

    public MucKhenThuong(String MaKT, String LyDo, int TienThuong) {
        this.MaKT= MaKT;
        this.LyDo = LyDo;
        this.TienThuong = TienThuong;
    }

    public String getMaKT() {
        return MaKT;
    }


    public String getLyDo() {
        return LyDo;
    }



    public int getTienThuong() {
        return TienThuong;
    }



    public void setMaKT(String MaKT) {
        this.MaKT = MaKT;
    }


    public void setLyDo(String LyDo) {
        this.LyDo= LyDo;
    }


    public void setTienThuong(int TienThuong) {
        this.TienThuong= TienThuong;
    }


}
   

  
    
    
    
   

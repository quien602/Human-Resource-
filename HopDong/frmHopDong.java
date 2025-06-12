/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HopDong;

import KiemTra.Kiemtra;
import NhanVien.INhanVienDAO;
import NhanVien.NhanVien;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author FPT
 */
public class frmHopDong extends javax.swing.JPanel {

    private DefaultTableModel dtm;
    private DefaultComboBoxModel dcbm;
    ArrayList<NhanVien> listnv = null;
    ArrayList<HopDong> listhd = null;
    public static String regexDDMMYYYY = "^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$";

    public frmHopDong() {
        try {
            initComponents();
            dcbm = new DefaultComboBoxModel();
            dtm = new DefaultTableModel();
            INhanVienDAO nhanVienDAO = (INhanVienDAO) Class.forName("NhanVien.NhanVienDAO").newInstance();
            listnv = nhanVienDAO.getAll();
            for (NhanVien nv : listnv) {
                dcbm.addElement(nv.getMaNV());
            }
            jcbma.setModel(dcbm);

            dtm.addColumn("Mã Hợp Đồng");
            dtm.addColumn("Loại hợp đồng");
            dtm.addColumn("Ngày bắt đầu HD");
            dtm.addColumn("Ngày kết thúc HD");
            dtm.addColumn("Mã Nhân Viên");
            
            data();
            // loaddata();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmHopDong.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(frmHopDong.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(frmHopDong.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    private void data() {
        try {
            IHopDongDAO hopDongDAO = (IHopDongDAO) Class.forName("HopDong.HopDongDAO").newInstance();
            listhd = new HopDongDAO().getAll();
            for (HopDong hd : listhd) {
                dtm.addRow(toObjectData(hd));
            }
            jtbTTHD.setModel(dtm);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmHopDong.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(frmHopDong.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(frmHopDong.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static Object[] toObjectData(HopDong hd) 
{
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        
        String datebd = dateFormat.format(hd.getNgayBD());
        
        String datekt = dateFormat.format(hd.getNgayKT());

        Object[] objectData = {hd.getMaHD(), hd.getLoaiHopDong(),
                 datebd,datekt, hd.getMaNV ()};
        return objectData;
      
    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jtbTTHD = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfngaybd = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jtfLoaiHD = new javax.swing.JTextField();
        jtfMaHD = new javax.swing.JTextField();
        jtfngaykt = new javax.swing.JTextField();
        jcbma = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jbUpdate = new javax.swing.JButton();
        jbDelete = new javax.swing.JButton();
        jbAdd = new javax.swing.JButton();
        jbExit = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));

        jtbTTHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã Hợp Đồng", "Loại Hợp Đồng", "Ngày bắt đầu HĐ", "Ngày kết thúc HĐ", "Mã Nhân Viên"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbTTHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbTTHDMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtbTTHD);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 102));
        jLabel8.setText("Ngày bắt đầu");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setText("Ngày kết thúc");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("Mã Hợp Đồng");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Loại Hợp Đồng");

        jLabel9.setBackground(new java.awt.Color(51, 51, 255));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 102));
        jLabel9.setText("Mã Nhân Viên");

        jLabel3.setText("dd/MM/yyyy");

        jLabel10.setText("dd/MM/yyyy");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jcbma, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addComponent(jtfMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(jtfLoaiHD, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(39, 39, 39)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10)
                    .addComponent(jLabel3)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(jtfngaybd, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jtfngaykt)))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jtfMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jtfngaybd, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jtfLoaiHD, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jcbma, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jtfngaykt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addComponent(jLabel10)))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));

        jbUpdate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbUpdate.setForeground(new java.awt.Color(0, 102, 102));
        jbUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/45.png"))); // NOI18N
        jbUpdate.setText("Cập nhật");
        jbUpdate.setEnabled(false);
        jbUpdate.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbUpdateActionPerformed(evt);
            }
        });

        jbDelete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbDelete.setForeground(new java.awt.Color(255, 0, 0));
        jbDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Remove.png"))); // NOI18N
        jbDelete.setText("Xóa");
        jbDelete.setEnabled(false);
        jbDelete.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbDelete.setIconTextGap(2);
        jbDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDeleteActionPerformed(evt);
            }
        });

        jbAdd.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jbAdd.setForeground(new java.awt.Color(0, 102, 102));
        jbAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Add.png"))); // NOI18N
        jbAdd.setText("Thêm");
        jbAdd.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAddActionPerformed(evt);
            }
        });

        jbExit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbExit.setForeground(new java.awt.Color(0, 102, 102));
        jbExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/reload.png"))); // NOI18N
        jbExit.setText("Tải lại");
        jbExit.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbExit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jbAdd, jbDelete, jbExit, jbUpdate});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbExit)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 51, 51));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setForeground(new java.awt.Color(204, 204, 255));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("THÔNG TIN HỢP ĐỒNG");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(295, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(290, 290, 290))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );
    }// </editor-fold>//GEN-END:initComponents

    public boolean checkinfo() {
        Kiemtra c = new Kiemtra();
        if (!c.checkID(jtfMaHD.getText())) {
            JOptionPane.showMessageDialog(this, "Nhập mã sai", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            jtfMaHD.setText("");
            jtfMaHD.requestFocus();
            return false;
        } else if (!c.checkSpace(jtfLoaiHD.getText()) || !c.check(jtfLoaiHD.getText())) {
            JOptionPane.showMessageDialog(this, "Nhập tên sai", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            jtfLoaiHD.setText("");
            jtfLoaiHD.requestFocus();
            return false;

        } 
//        } else if (!c.checkSpace(jtfngaysinh.getText()) || !c.check(jtfngaysinh.getText()) || c.checkDate(jtfngaysinh.getText())) {
//            JOptionPane.showMessageDialog(this, "Nhập ngày sinh sai", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
//            jtfngaysinh.setText("");
//            jtfngaysinh.requestFocus();
//            return false;

        
        return true;
    }
    private void jbAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAddActionPerformed
        String mahd = jtfMaHD.getText();
        String loaihd = jtfLoaiHD.getText();
        String ngaybd = jtfngaybd.getText();
        String ngaykt = jtfngaykt.getText();
        String manv = listnv.get(jcbma.getSelectedIndex()).getMaNV();
        Kiemtra c = new Kiemtra();
        if (!checkinfo()) {
            return;
        }


        Date d1 = null;
        if (ngaybd == null || ngaybd.equals("") || !ngaybd.matches(regexDDMMYYYY)) {
            JOptionPane.showMessageDialog(this, "Nhập ngày bắt đầu sai", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            jtfngaybd.setText("");
            jtfngaybd.requestFocus();
            return;
        } else {
            try {
                d1 = new SimpleDateFormat("dd/MM/yyyy").parse(ngaybd);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(this, "Nhập ngày bắt đầu sai", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        
        Date d2 = null;
        if (ngaykt == null || ngaykt.equals("") || !ngaykt.matches(regexDDMMYYYY)) {
            JOptionPane.showMessageDialog(this, "Nhập ngày kết thúc sai", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            jtfngaybd.setText("");
            jtfngaybd.requestFocus();
            return;
        } else {
            try {
                d1 = new SimpleDateFormat("dd/MM/yyyy").parse(ngaybd);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(this, "Nhập ngày kết thúc sai", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        HopDong hopDong = new HopDong(mahd, loaihd, d1, d2, manv);
        ArrayList<HopDong> listCheck = new HopDongDAO().checkID(manv);
        if (listCheck.size() > 0) {
            JOptionPane.showMessageDialog(this, "Mã ID bị trùng", "vui lòng kiểm tra lại", JOptionPane.ERROR_MESSAGE);
            jtfMaHD.setText("");
            jtfMaHD.requestFocus();

        } else {
            HopDong insert = new HopDongDAO().addNew(hopDong);
            if (insert != null) {
                showAll();
            }
        }



    }//GEN-LAST:event_jbAddActionPerformed

    private void jbUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbUpdateActionPerformed
        String mahd = jtfMaHD.getText();
        String loaihd = jtfLoaiHD.getText();
        String ngaybd = jtfngaybd.getText();
        String ngaykt = jtfngaykt.getText();
        String manv = listnv.get(jcbma.getSelectedIndex()).getMaNV();
        Kiemtra c = new Kiemtra();
        if (!checkinfo()) {
            return;
        }


        Date d1 = null;
        if (ngaybd == null || ngaybd.equals("") || !ngaybd.matches(regexDDMMYYYY)) {
            JOptionPane.showMessageDialog(this, "Nhập ngày bắt đầu sai", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            jtfngaybd.setText("");
            jtfngaybd.requestFocus();
            return;
        } else {
            try {
                d1 = new SimpleDateFormat("dd/MM/yyyy").parse(ngaybd);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(this, "Nhập ngày bắt đầu sai", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        
        Date d2 = null;
        if (ngaykt == null || ngaykt.equals("") || !ngaykt.matches(regexDDMMYYYY)) {
            JOptionPane.showMessageDialog(this, "Nhập ngày kết thúc sai", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            jtfngaybd.setText("");
            jtfngaybd.requestFocus();
            return;
        } else {
            try {
                d1 = new SimpleDateFormat("dd/MM/yyyy").parse(ngaybd);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(this, "Nhập ngày kết thúc sai", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        HopDong hopDong = new HopDong(mahd, loaihd, d1, d2, manv);
        HopDong update = new HopDongDAO().updateByID(hopDong);
        if (update != null) {
            showAll();
        }
        jbAdd.setEnabled(true);
        jbUpdate.setEnabled(false);
        jbDelete.setEnabled(false);
        jtfMaHD.setEnabled(true);
    }//GEN-LAST:event_jbUpdateActionPerformed

    private void jtbTTHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbTTHDMouseClicked
        jtfMaHD.setText(jtbTTHD.getValueAt(jtbTTHD.getSelectedRow(), 0).toString());
        jtfLoaiHD.setText(jtbTTHD.getValueAt(jtbTTHD.getSelectedRow(), 1).toString());
        jtfngaybd.setText(jtbTTHD.getValueAt(jtbTTHD.getSelectedRow(), 2).toString());
       jtfngaykt.setText(jtbTTHD.getValueAt(jtbTTHD.getSelectedRow(), 3).toString());
        jcbma.setSelectedItem(jtbTTHD.getValueAt(jtbTTHD.getSelectedRow(), 4).toString());
       

        jbAdd.setEnabled(false);
        jbUpdate.setEnabled(true);
        jbDelete.setEnabled(true);
        jtfMaHD.setEnabled(false);
    }//GEN-LAST:event_jtbTTHDMouseClicked
    public void resetForm() {
        jtfMaHD.setText("");
        jtfLoaiHD.setText("");
        jtfngaybd.setText("");
        jtfngaykt.setText("");
        jtfMaHD.requestFocus();
    }
    private void jbDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDeleteActionPerformed
        int b = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa dữ liệu này?", "Thông Báo", JOptionPane.YES_NO_OPTION);
        if (b == JOptionPane.YES_OPTION) {

            String mahd = jtfMaHD.getText();
            try {
                new HopDongDAO().deleteHopDong(mahd);
            } catch (SQLException ex) {
                Logger.getLogger(frmHopDong.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(frmHopDong.class.getName()).log(Level.SEVERE, null, ex);
            }

            while (dtm.getRowCount() > 0) {
                dtm.removeRow(0);
            }
            resetForm();
            data();
            jbAdd.setEnabled(true);
            jbUpdate.setEnabled(false);
            jbDelete.setEnabled(false);
            jtfMaHD.setEnabled(true);
        }
    }//GEN-LAST:event_jbDeleteActionPerformed

    private void jbExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExitActionPerformed
        this.resetForm();
    }//GEN-LAST:event_jbExitActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbAdd;
    private javax.swing.JButton jbDelete;
    private javax.swing.JButton jbExit;
    private javax.swing.JButton jbUpdate;
    private javax.swing.JComboBox jcbma;
    private javax.swing.JTable jtbTTHD;
    private javax.swing.JTextField jtfLoaiHD;
    private javax.swing.JTextField jtfMaHD;
    private javax.swing.JTextField jtfngaybd;
    private javax.swing.JTextField jtfngaykt;
    // End of variables declaration//GEN-END:variables

    private void showAll() {
        while (dtm.getRowCount() > 0) {
            dtm.removeRow(0);

        }
        ArrayList<HopDong> hds = new HopDongDAO().getAll();
            for (HopDong hd : hds) {
                Vector vector = new Vector();
                vector.add(hd.getMaHD());
                vector.add(hd.getLoaiHopDong());
                SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
                vector.add(dateFormat1.format(hd.getNgayBD()));
                SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy");
                vector.add(dateFormat2.format(hd.getNgayKT()));
                vector.add(hd.getMaNV());
                dtm.addRow(vector);

            }
            resetForm();
    }
}

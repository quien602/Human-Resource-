/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BangChamCong;

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
public class frmBangChamCong extends javax.swing.JPanel {

    private DefaultTableModel dtm;
    private DefaultComboBoxModel dcbm;
    ArrayList<NhanVien> listnv = null;
    ArrayList<BangChamCong> listbcc = null;

    public frmBangChamCong() {
        try {
            initComponents();
            dcbm = new DefaultComboBoxModel();
            dtm = new DefaultTableModel();
            INhanVienDAO nhanVienDAO = (INhanVienDAO) Class.forName("NhanVien.NhanVienDAO").newInstance();
            listnv = nhanVienDAO.getAll();
            for (NhanVien nv : listnv) {
                dcbm.addElement(nv.getMaNV());
            }
            jcbMaNV.setModel(dcbm);

            dtm.addColumn("Mã Chấm công");
            dtm.addColumn("Mã Nhân Viên");
            dtm.addColumn("Tháng Chấm Công");
            dtm.addColumn("Năm Chấm Công");
            dtm.addColumn("Số ngày làm");
            dtm.addColumn("Số ngày nghỉ");
            dtm.addColumn("Số giờ tăng ca");
            data();
            // loaddata();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmBangChamCong.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(frmBangChamCong.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(frmBangChamCong.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void data() {
        try {
            IBangChamCongDAO bangChamCongDAO = (IBangChamCongDAO) Class.forName("BangChamCong.BangChamCongDAO").newInstance();
            listbcc = new BangChamCongDAO().getAll();
            for (BangChamCong bcc : listbcc) {
                dtm.addRow(toObjectsData(bcc));
            }
            jtbTTBCC.setModel(dtm);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmBangChamCong.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(frmBangChamCong.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(frmBangChamCong.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    

       public static Object[] toObjectsData(BangChamCong bcc) {
        Object[] objectsData = {bcc.getMaChamCong(), bcc.getMaNV(), bcc.getThangCC(),
            bcc.getNamCC(),bcc.getSongaylam(),bcc.getSongaynghi(),bcc.getSogiotangca()};
        return objectsData;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jtbTTBCC = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfSongaylam = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jtfNamCC = new javax.swing.JTextField();
        jtfThangCC = new javax.swing.JTextField();
        jtfMaChamCong = new javax.swing.JTextField();
        jtfSogiotangca = new javax.swing.JTextField();
        jtfSongaynghi = new javax.swing.JTextField();
        jcbMaNV = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jbUpdate = new javax.swing.JButton();
        jbDelete = new javax.swing.JButton();
        jbAdd = new javax.swing.JButton();
        jbExit = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();

        setForeground(new java.awt.Color(255, 204, 204));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));

        jtbTTBCC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Chấm Công", "Mã Nhân Viên", "Tháng Chấm Công", "Năm Chấm Công", "Số ngày làm", "Số ngày nghỉ", "Số giờ tăng ca"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbTTBCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbTTBCCMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtbTTBCC);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 102));
        jLabel8.setText("Số ngày làm");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 102));
        jLabel7.setText("Số giờ tăng ca");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("Năm Chấm Công");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setText("Số ngày nghỉ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("Mã Chấm công");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Tháng Chấm Công");

        jLabel9.setBackground(new java.awt.Color(51, 51, 255));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 102));
        jLabel9.setText("Mã Nhân Viên");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jtfSogiotangca, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jcbMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(333, 333, 333))))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jtfNamCC, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jtfThangCC, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jtfSongaynghi))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jtfMaChamCong, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(jtfSongaylam)))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(jtfMaChamCong, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(jtfSongaylam, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfThangCC, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(jtfSongaynghi, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jtfSogiotangca, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfNamCC, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jcbMaNV))
                .addContainerGap(12, Short.MAX_VALUE))
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
                .addComponent(jbAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbExit)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 51, 51));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setForeground(new java.awt.Color(204, 204, 255));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("THÔNG TIN BẢNG CHẤM CÔNG");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(186, 186, 186)
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public boolean checkinfo() {
        Kiemtra c = new Kiemtra();
        if (!c.checkID(jtfMaChamCong.getText())) {
            JOptionPane.showMessageDialog(this, "Nhập mã sai", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            jtfMaChamCong.setText("");
            jtfMaChamCong.requestFocus();
            return false;

        }  else if (!c.checkSpace(jtfThangCC.getText()) || !c.checkNumber(jtfThangCC.getText())) {
            JOptionPane.showMessageDialog(this, "Kiểm tra lại", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            jtfThangCC.setText("");
            jtfThangCC.requestFocus();
            return false;
        }else if (!c.checkSpace(jtfNamCC.getText()) || !c.checkNumber(jtfNamCC.getText())) {
            JOptionPane.showMessageDialog(this, "Kiểm tra lại", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            jtfNamCC.setText("");
            jtfNamCC.requestFocus();
            return false;
        }else if (!c.checkSpace(jtfSongaylam.getText()) || !c.checkNumber(jtfSongaylam.getText())) {
            JOptionPane.showMessageDialog(this, "Kiểm tra lại", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            jtfSongaylam.setText("");
            jtfSongaylam.requestFocus();
            return false;
        }else if (!c.checkSpace(jtfSongaynghi.getText()) || !c.checkNumber(jtfSongaynghi.getText())) {
            JOptionPane.showMessageDialog(this, "Kiểm tra lại", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            jtfSongaynghi.setText("");
            jtfSongaynghi.requestFocus();
            return false;
        }else if (!c.checkSpace(jtfSogiotangca.getText()) || !c.checkNumber(jtfSogiotangca.getText())) {
            JOptionPane.showMessageDialog(this, "Kiểm tra lại", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            jtfSogiotangca.setText("");
            jtfSogiotangca.requestFocus();
            return false;
        }

        return true;
    }
    private void jbAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAddActionPerformed
        String MaChamCong = jtfMaChamCong.getText();
        String MaNV = listnv.get(jcbMaNV.getSelectedIndex()).getMaNV();
        String ThangCC = jtfThangCC.getText();
        String NamCC = jtfNamCC.getText();
        String Songaylam = jtfSongaylam.getText();
        String Songaynghi = jtfSongaynghi.getText();
        String Sogiotangca = jtfSogiotangca.getText();
        
        Kiemtra c = new Kiemtra();
        if (!checkinfo()) {
            return;
        }

        int tcc,ncc,snl,snn,sgtc;
        tcc = Integer.parseInt(ThangCC);
        ncc= Integer.parseInt(NamCC);
        snl= Integer.parseInt(Songaylam);
        snn= Integer.parseInt(Songaynghi);
        sgtc= Integer.parseInt(Sogiotangca);

        BangChamCong bangChamCong = new BangChamCong(MaChamCong, MaNV, tcc, ncc, snl, snn, sgtc);
        ArrayList<BangChamCong> listCheck = new BangChamCongDAO().CheckID(MaChamCong);
        if (listCheck.size() > 0) {
            JOptionPane.showMessageDialog(this, "Mã ID bị trùng", "vui lòng kiểm tra lại", JOptionPane.ERROR_MESSAGE);
            jtfMaChamCong.setText("");
            jtfMaChamCong.requestFocus();

        } else {
            BangChamCong insert = new BangChamCongDAO().addNew(bangChamCong);
            if (insert != null) {
                showAll();
            }
        }


    }//GEN-LAST:event_jbAddActionPerformed

    private void jbUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbUpdateActionPerformed
        String MaChamCong = jtfMaChamCong.getText();
        String MaNV = listnv.get(jcbMaNV.getSelectedIndex()).getMaNV();
        String ThangCC = jtfThangCC.getText();
        String NamCC = jtfNamCC.getText();
        String Songaylam = jtfSongaylam.getText();
        String Songaynghi = jtfSongaynghi.getText();
        String Sogiotangca = jtfSogiotangca.getText();

        int tcc,ncc,snl,snn,sgtc;
        tcc = Integer.parseInt(ThangCC);
        ncc= Integer.parseInt(NamCC);
        snl= Integer.parseInt(Songaylam);
        snn= Integer.parseInt(Songaynghi);
        sgtc= Integer.parseInt(Sogiotangca);
        
        BangChamCong bangChamCong = new BangChamCong(MaChamCong, MaNV, tcc, ncc, snl, snn, sgtc);
        
        BangChamCong update = new BangChamCongDAO().updateByID(bangChamCong);
        if (update != null) {
            showAll();
        }
        jbAdd.setEnabled(true);
        jbUpdate.setEnabled(false);
        jbDelete.setEnabled(false);
        jtfMaChamCong.setEnabled(true);
    }//GEN-LAST:event_jbUpdateActionPerformed

    private void jtbTTBCCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbTTBCCMouseClicked
        jtfMaChamCong.setText(jtbTTBCC.getValueAt(jtbTTBCC.getSelectedRow(), 0).toString());
        jcbMaNV.setSelectedItem(jtbTTBCC.getValueAt(jtbTTBCC.getSelectedRow(), 1).toString());
        jtfThangCC.setText(jtbTTBCC.getValueAt(jtbTTBCC.getSelectedRow(), 2).toString());
        jtfNamCC.setText(jtbTTBCC.getValueAt(jtbTTBCC.getSelectedRow(), 3).toString());
        jtfSongaylam.setText(jtbTTBCC.getValueAt(jtbTTBCC.getSelectedRow(), 4).toString());
        jtfSongaynghi.setText(jtbTTBCC.getValueAt(jtbTTBCC.getSelectedRow(), 5).toString());
        jtfSogiotangca.setText(jtbTTBCC.getValueAt(jtbTTBCC.getSelectedRow(), 6).toString());


        jbAdd.setEnabled(false);
        jbUpdate.setEnabled(true);
        jbDelete.setEnabled(true);
        jtfMaChamCong.setEnabled(false);
    }//GEN-LAST:event_jtbTTBCCMouseClicked
    public void resetForm() {
        jtfMaChamCong.setText("");
        jtfThangCC.setText("");
        jtfNamCC.setText("");
        jtfSongaynghi.setText("");
        jtfSogiotangca.setText("");
        jtfSongaylam.setText("");
        jtfMaChamCong.requestFocus();
    }
    private void jbDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDeleteActionPerformed
        String Macc = jtfMaChamCong.getText();
        int b = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa dữ liệu này?", "Thông Báo", JOptionPane.YES_NO_OPTION);
        if (b == JOptionPane.YES_OPTION) {
            try {
                new BangChamCongDAO().deleteIDCC(Macc);
            } catch (SQLException ex)  {
                Logger.getLogger(frmBangChamCong.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(frmBangChamCong.class.getName()).log(Level.SEVERE, null, ex);
            }

            while (dtm.getRowCount() > 0) {
                dtm.removeRow(0);
            }
            resetForm();
            data();
            jbAdd.setEnabled(true);
            jbUpdate.setEnabled(false);
            jbDelete.setEnabled(false);
            jtfMaChamCong.setEnabled(true);
        }
        
    }//GEN-LAST:event_jbDeleteActionPerformed

    private void jbExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExitActionPerformed
        this.resetForm();
    }//GEN-LAST:event_jbExitActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
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
    private javax.swing.JComboBox jcbMaNV;
    private javax.swing.JTable jtbTTBCC;
    private javax.swing.JTextField jtfMaChamCong;
    private javax.swing.JTextField jtfNamCC;
    private javax.swing.JTextField jtfSogiotangca;
    private javax.swing.JTextField jtfSongaylam;
    private javax.swing.JTextField jtfSongaynghi;
    private javax.swing.JTextField jtfThangCC;
    // End of variables declaration//GEN-END:variables

     private void showAll() {
        while (dtm.getRowCount() > 0) {
            dtm.removeRow(0);
        }
       int selectedIndex = jcbMaNV.getSelectedIndex();
        NhanVien getNhanVien = listnv.get(selectedIndex);
        ArrayList<BangChamCong> list = new BangChamCongDAO().findByIDNhanVien(getNhanVien.getMaNV());
        for (BangChamCong kt : list) {
            Vector v = new Vector();
            v.add(kt.getMaChamCong());
            v.add(kt.getThangCC());
            v.add(kt.getNamCC());
            v.add(kt.getSongaylam());
            v.add(kt.getSongaynghi());
            v.add(kt.getSogiotangca());


            dtm.addRow(v);
        }
        resetForm();
        // jtfthi.setText("");
    }
}

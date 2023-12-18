/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package TUGASPRAKOOP9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fatur Riski
 */
public class GUIMUTASI extends javax.swing.JFrame {

    public Connection con;
    String kodeobat1, tanggalmutasi1, tipemutasi1, jumlahmutasi1;
    private String search;

    public void koneksi() {
        try {
            con = null;
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/oop_gudangobat?user=root&password=");
        } catch (ClassNotFoundException e) {
            Logger.getLogger(GUIMUTASI.class.getName()).log(Level.SEVERE, null, e);
        } catch (SQLException e) {
            Logger.getLogger(GUIMUTASI.class.getName()).log(Level.SEVERE, null, e);
        } catch (Exception es) {
            Logger.getLogger(GUIMUTASI.class.getName()).log(Level.SEVERE, null, es);
        }
    }

    public void tampil() {
        DefaultTableModel tabelhead = new DefaultTableModel();
        tabelhead.addColumn("Kode Obat");
        tabelhead.addColumn("Tanggal Mutasi");
        tabelhead.addColumn("Tipe Mutasi");
        tabelhead.addColumn("Jumlah Mutasi");
        try {
            
            koneksi();
            String sql = "SELECT * FROM mutasi";
            Statement stat = con.createStatement();
            ResultSet res = stat.executeQuery(sql);
            while (res.next()) {
                tabelhead.addRow(new Object[]{res.getString("KodeObat"), res.getString("TanggalMutasi"), res.getString("TipeMutasi"),res.getString("JumlahMutasi")});
            }
            tblmutasi.setModel(tabelhead);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void insert() {
        kodeobat1 = txtkodeobt.getText();
        tanggalmutasi1 = txttglmutasi.getText();
        jumlahmutasi1 = txtjmlmutasi.getText();
        tipemutasi1 = cmbtipemutasi.getItemAt(cmbtipemutasi.getSelectedIndex());
        System.out.println(tipemutasi1);
       
        try {
            koneksi();
            String sql = "insert into mutasi (KodeObat,TanggalMutasi,TipeMutasi,JumlahMutasi) values ('" + kodeobat1 + "','" + tanggalmutasi1 + "','" + tipemutasi1 + "','" + jumlahmutasi1 + "')";
            Statement stat = con.createStatement();
            stat.executeUpdate(sql);
            stat.close();
            tampil();
            JOptionPane.showMessageDialog(this, "Data Berhasil Ditambahkan");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void update() {
        String kodeobat = txtkodeobt.getText();
        String tanggalmutasi = txtjmlmutasi.getText();
        String jumlahmutasi = txtjmlmutasi.getText();
        String tipemutasi = (String) cmbtipemutasi.getSelectedItem();

        try {
            Statement statement = con.createStatement();
            statement.executeUpdate("UPDATE mutasi SET KodeObat='" + kodeobat + "'," + "tanggalmutasi='" + tanggalmutasi + ", jumlahmutasi='" + jumlahmutasi + ",'tipemutasi='" + tipemutasi);
            statement.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Update Data Mahasiswa Berhasil!");
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
        tampil();
    }

    public void delete() {
        int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin akan menghapus data ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
            try {
                String sql = "DELETE * FROM mutasi WHERE kodeobat='" + txtkodeobt.getText() + "'";
                java.sql.PreparedStatement stmt = con.prepareStatement(sql);
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil di hapus");
                clear();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data gagal di hapus");
            }
        }
        tampil();
    }

    public void cari() {
        try ( Statement statement = con.createStatement()) {
        String sql = "SELECT * FROM mutasi WHERE `nim`  LIKE '%" + txtsearch + "%'";
        ResultSet rs = statement.executeQuery(sql); //menampilkan data dari sql query
        if (rs.next()) // .next() = scanner method
        {
//            txtkodeobat.set(rs.getString(2));
            txtkodeobt.setText(rs.getString("KodeObat"));
            txtkodeobt.setText(rs.getString("TanggalMutasi"));
            txtkodeobt.setText(rs.getString("TipeMutasi"));
            txtkodeobt.setText(rs.getString("JumlahMutasi"));
        } else {
            JOptionPane.showMessageDialog(null, "Data yang Anda cari tidak ada");
        }
    } catch (Exception ex) {
        System.out.println("Error." + ex);
    }
    }

    public void clear() {
//        txt.setText("");
        txtkodeobt.setText("");
        txttglmutasi.setText("");
        txtjmlmutasi.setText("");
        cmbtipemutasi.setSelectedIndex(0);
    }

    /**
     * Creates new form GUIMUTASI
     */
    public GUIMUTASI() {
        initComponents();
        tampil();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Mutasi = new javax.swing.JLabel();
        kodeobat = new javax.swing.JLabel();
        tanggalmutasi = new javax.swing.JLabel();
        tipemutasi = new javax.swing.JLabel();
        jumlahmutasi = new javax.swing.JLabel();
        txtkodeobt = new javax.swing.JTextField();
        txttglmutasi = new javax.swing.JTextField();
        txtjmlmutasi = new javax.swing.JTextField();
        cmbtipemutasi = new javax.swing.JComboBox<>();
        btncetak = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblmutasi = new javax.swing.JTable();
        txtsearch = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Mutasi.setText("MUTASI");

        kodeobat.setText("Kode Obat :");

        tanggalmutasi.setText("Tanggal Mutasi :");

        tipemutasi.setText("Tipe Mutasi :");

        jumlahmutasi.setText("Jumlah Mutasi :");

        cmbtipemutasi.setEditable(true);
        cmbtipemutasi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Keluar", "Masuk" }));

        btncetak.setText("SIMPAN");
        btncetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncetakActionPerformed(evt);
            }
        });

        tblmutasi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Kode Obat", "Tanggal Mutasi", "Tipe Mutasi", "Jumlah Mutasi"
            }
        ));
        jScrollPane2.setViewportView(tblmutasi);

        txtsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addComponent(Mutasi)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kodeobat)
                    .addComponent(tanggalmutasi)
                    .addComponent(tipemutasi)
                    .addComponent(jumlahmutasi))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txttglmutasi, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtkodeobt, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtsearch, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtjmlmutasi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                            .addComponent(cmbtipemutasi, javax.swing.GroupLayout.Alignment.LEADING, 0, 149, Short.MAX_VALUE))
                        .addGap(32, 32, 32)
                        .addComponent(btncetak)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(Mutasi)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kodeobat)
                    .addComponent(txtkodeobt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tanggalmutasi)
                    .addComponent(txttglmutasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipemutasi)
                    .addComponent(cmbtipemutasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jumlahmutasi)
                    .addComponent(txtjmlmutasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncetak))
                .addGap(18, 18, 18)
                .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btncetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncetakActionPerformed
        // TODO add your handling code here:
        insert();
//        ClassMutasi objMutasi = new ClassMutasi();
//        objMutasi.setKodeobat(txtkodeobt.getText());
//        objMutasi.tglmutasi = txttglmutasi.getText();
//        objMutasi.jumlahmutasi = txtjmlmutasi.getText();
//        objMutasi.tipemutasi = cmbtipemutasi.getItemAt(cmbtipemutasi.getSelectedIndex());
//        memoMutasi.setText("Kode Obat          : " + objMutasi.getKodeobat());
//        memoMutasi.append("\nTanggal Mutasi  : " + objMutasi.tglmutasi);
//        memoMutasi.append("\nTipe Mutasi        : " + objMutasi.tipemutasi);
//        memoMutasi.append("\nJumlah Mutasi    : " + objMutasi.jumlahmutasi);
    }//GEN-LAST:event_btncetakActionPerformed

    private void txtsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsearchActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUIMUTASI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIMUTASI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIMUTASI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIMUTASI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIMUTASI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Mutasi;
    private javax.swing.JButton btncetak;
    private javax.swing.JComboBox<String> cmbtipemutasi;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jumlahmutasi;
    private javax.swing.JLabel kodeobat;
    private javax.swing.JLabel tanggalmutasi;
    private javax.swing.JTable tblmutasi;
    private javax.swing.JLabel tipemutasi;
    private javax.swing.JTextField txtjmlmutasi;
    private javax.swing.JTextField txtkodeobt;
    private javax.swing.JTextField txtsearch;
    private javax.swing.JTextField txttglmutasi;
    // End of variables declaration//GEN-END:variables
}

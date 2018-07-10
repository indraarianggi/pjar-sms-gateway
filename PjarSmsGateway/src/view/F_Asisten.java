/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import main.DatabaseConnection;
import main.SmsGateway;
import main.TableListener;

/**
 *
 * @author indraarianggi
 */
public class F_Asisten extends javax.swing.JFrame {
    
    private DatabaseConnection kon;
    private DefaultTableModel tabel;
    private String kueri;
    public static int modeformasisten;
    public static String n_id;

    /**
     * Creates new form F_Asisten
     */
    public F_Asisten() {
        initComponents();
        setResizable(false);
        kon = new DatabaseConnection();
        modeformasisten = 0;
        String n_id = "";
        
        try {
            getData();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(F_Asisten.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(F_Asisten.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(F_Asisten.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //digunakan untuk mengambil respon klik user di header table
        //JTableHeader header = tblAsisten.getTableHeader();
        //header.addMouseListener(new TableListener(tblAsisten));
        
        //digunakan untuk mengambil respon klik di baris
        tblAsisten.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt){
                int row = tblAsisten.rowAtPoint(evt.getPoint());
                int col = tblAsisten.columnAtPoint(evt.getPoint());
                //JOptionPane.showMessageDialog(null, "baris ke - "+row);
                if(col!=0){
                    Boolean check = Boolean.valueOf(tblAsisten.getValueAt(row, 0).toString());
                    if(check){
                        tblAsisten.setValueAt(false, row, 0);
                    }else{
                        tblAsisten.setValueAt(true, row, 0);
                    }
                }
            }
        });
        
        txtName.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                System.out.println(txtName.getText());
                try {
                    getData(txtName.getText());
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(F_Asisten.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(F_Asisten.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(F_Asisten.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            @Override
            public void removeUpdate(DocumentEvent e) {
                try {
                    getData(txtName.getText());
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(F_Asisten.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(F_Asisten.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(F_Asisten.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            @Override
            public void changedUpdate(DocumentEvent e) {
                System.out.println(txtName.getText());
            }
        });
    }
    
    private void getData() throws ClassNotFoundException, SQLException, IOException{
        String query = "SELECT * FROM asisten";
        Statement st = kon.Connect().createStatement();
        ResultSet sql = st.executeQuery(query);
        
        int baris=1;
        int i=0;
        
        customTableModel c_model = new customTableModel();
        
        while(sql.next()){
            baris++;
        }
        
        String isi[][] = new String[baris][5];
        sql.beforeFirst();
        
        while(sql.next()){
//            switch(sql.getInt("tipe")){
//                case 0:
//                    tipe= "Guru";
//                    break;
//                case 1  :
//                    tipe= "Siswa";
//                    break;
//                case 2:
//                    tipe= "Orang Tua Siswa";
//                    break;
//            }
            c_model.addRow(new Object[]{
                false,
                Integer.toString(i+1),
                sql.getString("id"),
                sql.getString("nama"),
                sql.getString("telepon")
            });
            /*
            isi[i][0]=Integer.toString(i+1);
            isi[i][1]=sql.getString("nama");
            isi[i][2]=sql.getString("hp");
            switch(sql.getInt("tipe")){
                case 0:
                    isi[i][3]= "Guru";
                    break;
                case 1  :
                    isi[i][3]= "Siswa";
                    break;
                case 2:
                    isi[i][3]= "Orang Tua Siswa";
                    break;
            }
            isi[i][4]="false";*/
            i++;
        }
        
        String namakolom[] = {"","No","ID","Nama","Telepon"};
        //DefaultTableModel model = new DefaultTableModel(isi,namakolom);
        
        tblAsisten.setModel(c_model);
    }
    
    private void getData(String name) throws ClassNotFoundException, SQLException, IOException{
        String query = "SELECT * FROM asisten WHERE nama like '%"+name+"%'";
        Statement st = kon.Connect().createStatement();
        ResultSet sql = st.executeQuery(query);
        int baris=1;
        int i=0;
        
        customTableModel c_model = new customTableModel();
        
        while(sql.next()){
            baris++;
        }
        String isi[][] = new String[baris][5];
        sql.beforeFirst();
        while(sql.next()){
//            switch(sql.getInt("tipe")){
//                case 0:
//                    tipe= "Guru";
//                    break;
//                case 1  :
//                    tipe= "Siswa";
//                    break;
//                case 2:
//                    tipe= "Orang Tua Siswa";
//                    break;
//            }
            c_model.addRow(new Object[]{
                false,
                Integer.toString(i+1),
                sql.getString("id"),
                sql.getString("nama"),
                sql.getString("telepon")
            });
            /*
            isi[i][0]=Integer.toString(i+1);
            isi[i][1]=sql.getString("nama");
            isi[i][2]=sql.getString("hp");
            switch(sql.getInt("tipe")){
                case 0:
                    isi[i][3]= "Guru";
                    break;
                case 1  :
                    isi[i][3]= "Siswa";
                    break;
                case 2:
                    isi[i][3]= "Orang Tua Siswa";
                    break;
            }
            isi[i][4]="false";*/
            i++;
        }
        String namakolom[] = {"","No","ID","Nama","Telepon"};
        //DefaultTableModel model = new DefaultTableModel(isi,namakolom);
        
        tblAsisten.setModel(c_model);
    }
    
    private class customTableModel extends DefaultTableModel{
        public customTableModel() {
            super(new String[]{"Ceklis","No","ID","Nama","Telepon"},0);
        }
        
        @Override
        public Class<?> getColumnClass(int columnIndex) {
            switch(columnIndex){
                case 0 :
                    return Boolean.class;
                case 1 :
                    return String.class;
                case 2 :
                    return String.class;
                case 3 :
                    return String.class;
                case 4 :
                    return String.class;
                default :
                    return String.class;
            }
        }
        
//        @Override
//        public boolean isCellEditable(int row, int column) {
//          return column == 0;
//        }
    }
    
//    public void muatTabel(){
//        try{
//            Statement stasql = (Statement)kon.Connect().createStatement();
//            ResultSet runkueri = stasql.executeQuery("select * from asisten;");
//            int i = 1;
////            String tipe = null;
//            while (runkueri.next()) {
//                tabel.addRow(new Object[]{
//                    i,
//                    runkueri.getString("id"),
//                    runkueri.getString("nama"),
//                    runkueri.getString("telepon")
//                });
//                i++;
//            }
//            stasql.close();
//        } catch(Exception t){
//            JOptionPane.showMessageDialog(null,"Terdapat Kesalahan");
//        }
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAsisten = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnMessage = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ASISTEN");

        btnClose.setBackground(new java.awt.Color(0, 153, 102));
        btnClose.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnClose.setForeground(new java.awt.Color(0, 153, 102));
        btnClose.setText("CLOSE");
        btnClose.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnClose.setContentAreaFilled(false);
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Name : ");

        txtName.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        tblAsisten.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblAsisten.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAsistenMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblAsisten);

        btnAdd.setBackground(new java.awt.Color(0, 153, 102));
        btnAdd.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(0, 153, 102));
        btnAdd.setText("ADD");
        btnAdd.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnAdd.setContentAreaFilled(false);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(0, 153, 102));
        btnEdit.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(0, 153, 102));
        btnEdit.setText("EDIT");
        btnEdit.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnEdit.setContentAreaFilled(false);
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(0, 153, 102));
        btnDelete.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(0, 153, 102));
        btnDelete.setText("DELETE");
        btnDelete.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnDelete.setContentAreaFilled(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnMessage.setBackground(new java.awt.Color(0, 153, 102));
        btnMessage.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnMessage.setForeground(new java.awt.Color(0, 153, 102));
        btnMessage.setText("MESSAGE");
        btnMessage.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnMessage.setContentAreaFilled(false);
        btnMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMessageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 18, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        modeformasisten = 0;
        this.setVisible(false);        
        F_FormAsisten form_asisten = new F_FormAsisten("Add Asisten");
        form_asisten.setVisible(true);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        if(modeformasisten == 1){
            int row = tblAsisten.getSelectedRow();
            n_id = (String) tblAsisten.getValueAt(row, 2);
            this.setVisible(false);
            new F_FormAsisten("Edit Data Asisten").setVisible(true);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void tblAsistenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAsistenMouseClicked
        // TODO add your handling code here:
        modeformasisten = 1;
    }//GEN-LAST:event_tblAsistenMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        if(modeformasisten == 1){
            int row = tblAsisten.getSelectedRow();
            n_id = (String) tblAsisten.getValueAt(row, 2);
            try {
                Statement stasql = (Statement)kon.Connect().createStatement(); 
                kueri=("delete from asisten where id = '"+n_id+"';");
                stasql.executeUpdate(kueri);
                stasql.close();
                JOptionPane.showMessageDialog(null,"Record Telah Dihapus");
                this.setVisible(false);
                new F_Asisten().setVisible(true);
            } catch(Exception t){
                JOptionPane.showMessageDialog(null,"Record Gagal Dihapus\nTerdapat Kesalahan Pada Program");
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMessageActionPerformed
        // TODO add your handling code here:
        if(modeformasisten == 1){
            int count_check = 0;
            ArrayList telepon = new ArrayList();
            for(int i = 0;i<tblAsisten.getRowCount();i++){
                Boolean check = Boolean.valueOf(tblAsisten.getValueAt(i,0).toString());
                String no_tlp = tblAsisten.getValueAt(i, 4).toString();
                if(check){
                    count_check +=1;
                    telepon.add(no_tlp);
                }
            }
            for(int i=0;i<telepon.size();i++){
                System.out.println(telepon.get(i).toString());
            }
            try {
                //pgBar.setVisible(true);
                // BUKA F_FormMessage !!!!
                F_FormMessage form_message = new F_FormMessage("Send Message To Assisten", telepon);
                form_message.setVisible(true);
                //pesan.sendMessage(hp, txt_pesan.getText());
                //pgBar.setVisible(false);
            } catch (Exception ex) {
                Logger.getLogger(F_Asisten.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
    }//GEN-LAST:event_btnMessageActionPerformed

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
            java.util.logging.Logger.getLogger(F_Asisten.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(F_Asisten.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(F_Asisten.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(F_Asisten.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new F_Asisten().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnMessage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblAsisten;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}

package Book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class addcategory extends javax.swing.JFrame {
    
    static String driverClassName= "oracle.jdbc.driver.OracleDriver";
    static String url = "jdbc:oracle:thin:@192.168.6.21:1521:dblabs";
    static Connection dbConn=null;        
    static String username= "it175127";
    static String passwd= "fabrikofriendosmates7";
    static PreparedStatement insert=null;
    static Statement st;
    static ResultSet rs;
    static int lastauthorid;
    
    public addcategory() {
        initComponents();
        myConnection();
    }
    
    public int getlastauthorid(){
        try {
            Class.forName (driverClassName);
        } catch (ClassNotFoundException ex) {
        }
        try {
            dbConn= DriverManager.getConnection(url, username, passwd);
            String sql="select max(category_id) from category";
            st = dbConn.createStatement();
            rs= st.executeQuery(sql);
            if(rs.next()){
                lastauthorid=rs.getInt(1);
                lastauthorid++;
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, ex);
            System.out.println("\n -- SQL Exception --- \n");
            while(ex !=null){
                System.out.println("Message: "+ ex.getMessage());
                ex=ex.getNextException();
            }
        }
    return lastauthorid;
    }
    
    void myConnection(){
        try {
            Class.forName (driverClassName);
        } catch (ClassNotFoundException ex) {
        }
        try {
            dbConn= DriverManager.getConnection(url, username, passwd);
            String insertString= "INSERT INTO category ( category_id, caname , description) VALUES (?, ?, ?)";
            insert = dbConn.prepareStatement(insertString);
        } catch (SQLException ex) {
            System.out.println("\n -- SQL Exception --- \n");
            while(ex !=null){
                System.out.println("Message: "+ ex.getMessage());
                ex=ex.getNextException();
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        namea = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptioon = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Category Name :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Description : ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 280, -1, -1));

        namea.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(namea, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 200, 383, 38));

        descriptioon.setColumns(20);
        descriptioon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        descriptioon.setRows(5);
        jScrollPane1.setViewportView(descriptioon);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 280, 383, 128));

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 440, 136, -1));

        jTabbedPane1.addTab("tab1", jPanel1);

        jPanel2.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 1350, 760));

        jButton2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButton2.setText("All Categories");
        jButton2.setPreferredSize(new java.awt.Dimension(140, 50));
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 150, -1));

        jButton3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButton3.setText("Add Category");
        jButton3.setPreferredSize(new java.awt.Dimension(140, 50));
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 150, -1));

        jButton4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButton4.setText("HOME");
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 30, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-5, 4, 1350, 830));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int vcode= getlastauthorid();
        String vname= namea.getText();
        String vdesc= descriptioon.getText();
        
        try {
            insert.setInt(1, vcode);
            insert.setString(2, vname);
            insert.setString(3, vdesc);
            insert.executeUpdate();
           
        } catch (SQLException ex) {
            System.out.println("\n -- SQL Exception --- \n");
            while(ex !=null){
                System.out.println("Message: "+ ex.getMessage());
                ex=ex.getNextException();
            }
        }
        
        this.setVisible(false);
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(addcategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addcategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addcategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addcategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addcategory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea descriptioon;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField namea;
    // End of variables declaration//GEN-END:variables
}

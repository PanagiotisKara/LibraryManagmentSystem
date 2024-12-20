package Author;

import java.sql.*;
import javax.swing.JOptionPane;
public class AuthorAdd extends javax.swing.JFrame {
    static String driverClassName= "oracle.jdbc.driver.OracleDriver";
    static String url = "jdbc:oracle:thin:@192.168.6.21:1521:dblabs";
    static Connection dbConn=null;        
    static String username= "it175127";
    static String passwd= "fabrikofriendosmates7";
    static PreparedStatement insert=null;
    static Statement st;
    static ResultSet rs;
    static int lastauthorid;
   
    
    
    public AuthorAdd() {
        initComponents();
        myConnection();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }
    
    
    public int getlastauthorid(){
        try {
            Class.forName (driverClassName);
        } catch (ClassNotFoundException ex) {
        }
        try {
            dbConn= DriverManager.getConnection(url, username, passwd);
            String sql="select max(author_id) from author";
            st = dbConn.createStatement();
            rs= st.executeQuery(sql);
            if(rs.next()){
                lastauthorid=rs.getInt(1);
                lastauthorid++;
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, ex);
        }
    return lastauthorid;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nameA = new javax.swing.JTextField();
        lastnameA = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        addauthorbtn = new javax.swing.JButton();
        allauthorsbtn = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Author Name :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Author Last Name :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 270, -1, -1));

        nameA.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nameA.setMaximumSize(new java.awt.Dimension(64, 31));
        nameA.setPreferredSize(new java.awt.Dimension(300, 31));
        nameA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameAActionPerformed(evt);
            }
        });
        jPanel1.add(nameA, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 190, -1, -1));

        lastnameA.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lastnameA.setMaximumSize(new java.awt.Dimension(64, 31));
        lastnameA.setPreferredSize(new java.awt.Dimension(300, 31));
        jPanel1.add(lastnameA, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 270, -1, -1));

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 370, 133, -1));

        jTabbedPane1.addTab("tab1", jPanel1);

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 1360, 580));

        jTextField1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jPanel3.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, 620, -1));

        jTabbedPane1.addTab("tab2", jPanel3);

        jPanel2.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 1360, 770));

        addauthorbtn.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        addauthorbtn.setText("Add Author");
        jPanel2.add(addauthorbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 140, 50));

        allauthorsbtn.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        allauthorsbtn.setText("All Authors");
        jPanel2.add(allauthorsbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 140, 50));

        jButton2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButton2.setText("HOME");
        jButton2.setPreferredSize(new java.awt.Dimension(86, 35));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 30, 90, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1360, 840));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int vcode= getlastauthorid();
        String vname= nameA.getText();
        String vlastname= lastnameA.getText();
        try {
            insert.setInt(1, vcode);
            insert.setString(2, vname);
            insert.setString(3, vlastname);
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

    private void nameAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameAActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed
    
    void myConnection(){
        try {
            Class.forName (driverClassName);
        } catch (ClassNotFoundException ex) {
        }
        try {
            dbConn= DriverManager.getConnection(url, username, passwd);
            String insertString= "INSERT INTO AUTHOR ( author_id, aname , alastname) VALUES (?, ?, ?)";
            insert = dbConn.prepareStatement(insertString);
        } catch (SQLException ex) {
            System.out.println("\n -- SQL Exception --- \n");
            while(ex !=null){
                System.out.println("Message: "+ ex.getMessage());
                ex=ex.getNextException();
            }
        }
    }
    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String args[]) throws Exception {
         
        
       
         
        
        
        
        
        
        
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
            java.util.logging.Logger.getLogger(AuthorAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AuthorAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AuthorAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AuthorAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AuthorAdd().setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addauthorbtn;
    private javax.swing.JButton allauthorsbtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField lastnameA;
    private javax.swing.JTextField nameA;
    // End of variables declaration//GEN-END:variables
}

package Employee;

import java.sql.*;
import javax.swing.JOptionPane;
public class EmployeeAdd extends javax.swing.JFrame {
    
    static String driverClassName= "oracle.jdbc.driver.OracleDriver";
    static String url = "jdbc:oracle:thin:@192.168.6.21:1521:dblabs";
    static Connection dbConn=null;        
    static String username= "it175127";
    static String passwd= "fabrikofriendosmates7";
    static PreparedStatement insert=null;
    static Statement st;
    static ResultSet rs;
    static int lastemployeeid;
    
   public EmployeeAdd() {
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
            String sql="select max(employee_id) from employee";
            st = dbConn.createStatement();
            rs= st.executeQuery(sql);
            if(rs.next()){
                lastemployeeid=rs.getInt(1);
                lastemployeeid++;
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, ex);
        }
    return lastemployeeid;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        lastname = new javax.swing.JTextField();
        phone = new javax.swing.JTextField();
        add = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        allemployeesbtn = new javax.swing.JButton();
        addemployeebtn = new javax.swing.JButton();
        homebtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 102));
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
        jLabel1.setText("Name of Employee :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Last Name of Employee :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 230, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Phone :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 290, -1, -1));

        name.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });
        jPanel1.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 170, 300, -1));

        lastname.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(lastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 230, 300, -1));

        phone.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 290, 300, -1));

        add.setBackground(new java.awt.Color(51, 51, 51));
        add.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        add.setForeground(new java.awt.Color(255, 255, 255));
        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel1.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 420, 119, -1));

        jTabbedPane1.addTab("tab1", jPanel1);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

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

        jTextField1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(333, 333, 333)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(321, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("tab2", jPanel3);

        jPanel2.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, -1, 770));

        allemployeesbtn.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        allemployeesbtn.setText("All Employees");
        allemployeesbtn.setPreferredSize(new java.awt.Dimension(140, 50));
        jPanel2.add(allemployeesbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 148, -1));

        addemployeebtn.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        addemployeebtn.setText("Add Emplyee");
        addemployeebtn.setPreferredSize(new java.awt.Dimension(140, 50));
        jPanel2.add(addemployeebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, -1, -1));

        homebtn.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        homebtn.setText("HOME");
        jPanel2.add(homebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 30, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, 0, 1310, 830));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        int vcode= getlastauthorid();
        String vname= name.getText();
        String vlastname= lastname.getText();
        int vphone= Integer.parseInt(phone.getText());
        try {
            insert.setInt(1, vcode);
            insert.setString(2, vname);
            insert.setString(3, vlastname);
            insert.setInt(4, vphone);
            insert.executeUpdate();
           
        } catch (SQLException ex) {
            System.out.println("\n -- SQL Exception --- \n");
            while(ex !=null){
                System.out.println("Message: "+ ex.getMessage());
                ex=ex.getNextException();
            }
        }
    }//GEN-LAST:event_addActionPerformed

    void myConnection(){
        try {
            Class.forName (driverClassName);
        } catch (ClassNotFoundException ex) {
        }
        try {
            dbConn= DriverManager.getConnection(url, username, passwd);
            String insertString= "INSERT INTO employee ( employee_id, ename , elastname, ephone) VALUES (?, ?, ? , ?)";
            insert = dbConn.prepareStatement(insertString);
        } catch (SQLException ex) {
            System.out.println("\n -- SQL Exception --- \n");
            while(ex !=null){
                System.out.println("Message: "+ ex.getMessage());
                ex=ex.getNextException();
            }
        }
    }
    
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
            java.util.logging.Logger.getLogger(EmployeeAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeAdd().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton addemployeebtn;
    private javax.swing.JButton allemployeesbtn;
    private javax.swing.JButton homebtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField lastname;
    private javax.swing.JTextField name;
    private javax.swing.JTextField phone;
    // End of variables declaration//GEN-END:variables
}

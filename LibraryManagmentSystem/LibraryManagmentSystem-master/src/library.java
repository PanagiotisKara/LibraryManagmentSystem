import Author.AuthorAdd;
import Book.BookAdd;
import Employee.EmployeeAdd;
import Member.MemberAdd;
import Rent.RentAdd;
import java.sql.*;

public class library extends javax.swing.JFrame {

    public library() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        TotalPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TotalRents = new javax.swing.JTextField();
        TotalOpenRents = new javax.swing.JTextField();
        TotalBooks = new javax.swing.JTextField();
        TotalMembers = new javax.swing.JTextField();
        Refresh = new javax.swing.JButton();
        AddBook = new javax.swing.JButton();
        AddAuthor = new javax.swing.JButton();
        AddMember = new javax.swing.JButton();
        AddEmployee = new javax.swing.JButton();
        AddRent = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        TitlePanel = new javax.swing.JPanel();
        Title = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setMaximumSize(new java.awt.Dimension(1366, 780));
        setMinimumSize(new java.awt.Dimension(1366, 780));
        setPreferredSize(new java.awt.Dimension(1366, 780));
        setResizable(false);
        setSize(new java.awt.Dimension(1300, 780));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(1366, 650));
        jPanel1.setMinimumSize(new java.awt.Dimension(1366, 650));
        jPanel1.setPreferredSize(new java.awt.Dimension(1366, 650));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TotalPanel.setBackground(new java.awt.Color(0, 102, 102));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Total Rents :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Total Open Rents :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Total Books :");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Total Members :");

        TotalRents.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TotalRents.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TotalRents.setEnabled(false);

        TotalOpenRents.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TotalOpenRents.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TotalOpenRents.setEnabled(false);

        TotalBooks.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TotalBooks.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TotalBooks.setEnabled(false);

        TotalMembers.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TotalMembers.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TotalMembers.setEnabled(false);

        Refresh.setBackground(new java.awt.Color(51, 51, 51));
        Refresh.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Refresh.setForeground(new java.awt.Color(255, 255, 255));
        Refresh.setText("Refresh");

        javax.swing.GroupLayout TotalPanelLayout = new javax.swing.GroupLayout(TotalPanel);
        TotalPanel.setLayout(TotalPanelLayout);
        TotalPanelLayout.setHorizontalGroup(
            TotalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TotalPanelLayout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(TotalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TotalPanelLayout.createSequentialGroup()
                        .addGroup(TotalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(TotalPanelLayout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(34, 34, 34))
                            .addGroup(TotalPanelLayout.createSequentialGroup()
                                .addGroup(TotalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(49, 49, 49)))
                        .addGroup(TotalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TotalRents)
                            .addComponent(TotalOpenRents)
                            .addComponent(TotalBooks)
                            .addComponent(TotalMembers, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TotalPanelLayout.createSequentialGroup()
                        .addComponent(Refresh)
                        .addGap(150, 150, 150))))
        );
        TotalPanelLayout.setVerticalGroup(
            TotalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TotalPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TotalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TotalRents, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(TotalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TotalOpenRents, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(TotalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TotalBooks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(TotalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TotalMembers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(Refresh)
                .addGap(19, 19, 19))
        );

        jPanel1.add(TotalPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 280, 410, 280));

        AddBook.setBackground(new java.awt.Color(51, 51, 51));
        AddBook.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        AddBook.setForeground(new java.awt.Color(255, 255, 255));
        AddBook.setText("Books");
        AddBook.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        AddBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBookActionPerformed(evt);
            }
        });
        jPanel1.add(AddBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 40, 231, 70));

        AddAuthor.setBackground(new java.awt.Color(51, 51, 51));
        AddAuthor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        AddAuthor.setForeground(new java.awt.Color(255, 255, 255));
        AddAuthor.setText("Authors");
        AddAuthor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        AddAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddAuthorActionPerformed(evt);
            }
        });
        jPanel1.add(AddAuthor, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 130, 231, 40));

        AddMember.setBackground(new java.awt.Color(51, 51, 51));
        AddMember.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        AddMember.setForeground(new java.awt.Color(255, 255, 255));
        AddMember.setText("Add Member");
        AddMember.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        AddMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddMemberActionPerformed(evt);
            }
        });
        jPanel1.add(AddMember, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 40, 160, 90));

        AddEmployee.setBackground(new java.awt.Color(51, 51, 51));
        AddEmployee.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        AddEmployee.setForeground(new java.awt.Color(255, 255, 255));
        AddEmployee.setText("Add Employee");
        AddEmployee.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        AddEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddEmployeeActionPerformed(evt);
            }
        });
        jPanel1.add(AddEmployee, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 150, 160, 80));

        AddRent.setBackground(new java.awt.Color(51, 51, 51));
        AddRent.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        AddRent.setForeground(new java.awt.Color(255, 255, 255));
        AddRent.setText("Rents");
        AddRent.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        AddRent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddRentActionPerformed(evt);
            }
        });
        jPanel1.add(AddRent, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 296, 190));

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Categories");
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 190, 231, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 100, 1370, -1));

        TitlePanel.setBackground(new java.awt.Color(51, 51, 51));
        TitlePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        Title.setFont(new java.awt.Font("Berlin Sans FB", 0, 48)); // NOI18N
        Title.setForeground(new java.awt.Color(255, 255, 255));
        Title.setText("Library Managment System");

        javax.swing.GroupLayout TitlePanelLayout = new javax.swing.GroupLayout(TitlePanel);
        TitlePanel.setLayout(TitlePanelLayout);
        TitlePanelLayout.setHorizontalGroup(
            TitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TitlePanelLayout.createSequentialGroup()
                .addGap(381, 381, 381)
                .addComponent(Title)
                .addContainerGap(431, Short.MAX_VALUE))
        );
        TitlePanelLayout.setVerticalGroup(
            TitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TitlePanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(Title)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        getContentPane().add(TitlePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 100));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBookActionPerformed
        BookAdd ba=new BookAdd();
        ba.setVisible(true);
    }//GEN-LAST:event_AddBookActionPerformed

    private void AddAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddAuthorActionPerformed
       AuthorAdd au = new AuthorAdd();
       au.setVisible(true);
    }//GEN-LAST:event_AddAuthorActionPerformed

    private void AddRentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddRentActionPerformed
        RentAdd ra=new RentAdd();
        ra.setVisible(true);
    }//GEN-LAST:event_AddRentActionPerformed

    private void AddMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddMemberActionPerformed
        MemberAdd ma=new MemberAdd();
        ma.setVisible(true);
    }//GEN-LAST:event_AddMemberActionPerformed

    private void AddEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddEmployeeActionPerformed
        EmployeeAdd ea =new EmployeeAdd();
        ea.setVisible(true);
    }//GEN-LAST:event_AddEmployeeActionPerformed

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
            java.util.logging.Logger.getLogger(library.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(library.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(library.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(library.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new library().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddAuthor;
    private javax.swing.JButton AddBook;
    private javax.swing.JButton AddEmployee;
    private javax.swing.JButton AddMember;
    private javax.swing.JButton AddRent;
    private javax.swing.JButton Refresh;
    private javax.swing.JLabel Title;
    private javax.swing.JPanel TitlePanel;
    private javax.swing.JTextField TotalBooks;
    private javax.swing.JTextField TotalMembers;
    private javax.swing.JTextField TotalOpenRents;
    private javax.swing.JPanel TotalPanel;
    private javax.swing.JTextField TotalRents;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

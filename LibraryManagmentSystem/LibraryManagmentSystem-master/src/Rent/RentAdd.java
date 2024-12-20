/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Rent;

import java.awt.Color;
import static java.awt.Color.MAGENTA;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author hliga
 */
public class RentAdd extends javax.swing.JFrame {
    
    
    static String driverClassName= "oracle.jdbc.driver.OracleDriver";
    static String url = "jdbc:oracle:thin:@192.168.6.21:1521:dblabs";
    static Connection dbConn=null;        
    static String username= "it175127";
    static String passwd= "fabrikofriendosmates7";
    static PreparedStatement insert=null;
    static PreparedStatement instert1=null;
    static PreparedStatement SelectAuthor=null;
    static PreparedStatement SelectCategory=null;
    static Statement st;
    static ResultSet rs;
    static int lastrentid;
    static Statement stat;
    static Statement stct;
    DefaultTableModel tblModel;
    DefaultTableModel tblModel1;
    DefaultTableModel tblModel2;
    int bookidtemp=-1;
    int memberidtemp=-1;

    public RentAdd() {
        initComponents();
        myConnection();
        booksearch();
        membersearch();
        booksearch1();
        booksearch2();
        
        
        booktbl.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
        booktbl.getTableHeader().setOpaque(false);
        booktbl.getTableHeader().setForeground(new Color(255,102,102));
        booktbl.setRowHeight(30);
        
        membertbl.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
        membertbl.getTableHeader().setOpaque(false);
        membertbl.getTableHeader().setForeground(new Color(255,102,102));
        membertbl.setRowHeight(30);
        
        closerenttbl.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
        closerenttbl.getTableHeader().setOpaque(false);
        closerenttbl.getTableHeader().setForeground(new Color(255,102,102));
        closerenttbl.setRowHeight(30);
        
        allrentstbl.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
        allrentstbl.getTableHeader().setOpaque(false);
        allrentstbl.getTableHeader().setForeground(new Color(255,102,102));
        allrentstbl.setRowHeight(30);
    }
    
    void myConnection(){
        try {
            Class.forName (driverClassName);
        } catch (ClassNotFoundException ex) {
        }
        try {
            dbConn= DriverManager.getConnection(url, username, passwd);
            String insertString= "INSERT INTO rent ( rent_id, book_id , customer_id, date_rent, employee_id_give) VALUES (?, ?, ?, ?, ?)";
            String insertString1 = "UPDATE book set availablecopies=? where book_id=?";
            instert1=dbConn.prepareStatement(insertString1);
            insert = dbConn.prepareStatement(insertString);
        } catch (SQLException ex) {
            System.out.println("\n -- SQL Exception --- \n");
            while(ex !=null){
                System.out.println("Message: "+ ex.getMessage());
                ex=ex.getNextException();
            }
        }
    }
    
    
       
    
    
    public int getlastrentkid(){
        try {
            Class.forName (driverClassName);
        } catch (ClassNotFoundException ex) {
        }
        try {
            dbConn= DriverManager.getConnection(url, username, passwd);
            String sql="select max(rent_id) from rent";
            st = dbConn.createStatement();
            rs= st.executeQuery(sql);
            if(rs.next()){
                lastrentid=rs.getInt(1);
                lastrentid++;
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, ex);
        }
    return lastrentid;
    }
    
    public int getlastavlailable(int book){
        try {
            Class.forName (driverClassName);
        } catch (ClassNotFoundException ex) {
        }
        try {
            dbConn= DriverManager.getConnection(url, username, passwd);
            String sql="select availablecopies from book where book_id= " + book;
            st = dbConn.createStatement();
            rs= st.executeQuery(sql);
            if(rs.next()){
                lastrentid=rs.getInt(1);
                lastrentid--;
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, ex);
        }
        return lastrentid;
    
    }
    
    private void filter1 (String query){
        TableRowSorter<DefaultTableModel> tr= new TableRowSorter<DefaultTableModel>(tblModel1);
        booktbl.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
    }
    
    private void filter2 (String query){
        TableRowSorter<DefaultTableModel> tr= new TableRowSorter<DefaultTableModel>(tblModel2);
        membertbl.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
    }
    
    private void filter3 (String query){
        TableRowSorter<DefaultTableModel> tr= new TableRowSorter<DefaultTableModel>(tblModel1);
        closerenttbl.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
    }
    private void filter4 (String query){
        TableRowSorter<DefaultTableModel> tr= new TableRowSorter<DefaultTableModel>(tblModel1);
        allrentstbl.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
    }
    
    public void booksearch(){
        tblModel1= (DefaultTableModel)booktbl.getModel();
        tblModel1.setRowCount(0);
        try {
            Class.forName (driverClassName);
        } catch (ClassNotFoundException ex) {
        }
        try{
            dbConn = DriverManager.getConnection (url, username, passwd);
            stat= dbConn.createStatement();
            String selectString = "select book_id , bname, (a.alastname || ' ' || a.aname) AS  aid,c.caname as cname, publishinghouse, serialnum, availablecopies From book join author a on (book.author_id = a.author_id) join category c on (book.category_id=c.category_id) ORDER BY bname asc";
            rs = stat.executeQuery(selectString);

            while(rs.next()) {
                    String id = String.valueOf(rs.getInt("book_id"));
                    String title = rs.getString("bname");
                    String author = rs.getString("aid");
                    String category = rs.getString("cname");
                    String publisher = rs.getString("publishinghouse");
                    String serialnum= String.valueOf(rs.getInt("serialnum"));
                    String copies= String.valueOf(rs.getInt("Availablecopies"));
                    String tbData[] = {id,title,author,category,publisher,serialnum,copies};
                    
                    tblModel1.addRow(tbData);
            }
            stat.close();
            dbConn.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, ex);
        }
    }
    
    public void booksearch1(){
        tblModel1= (DefaultTableModel)allrentstbl.getModel();
        tblModel1.setRowCount(0);
        try {
            Class.forName (driverClassName);
        } catch (ClassNotFoundException ex) {
        }
        try{
            dbConn = DriverManager.getConnection (url, username, passwd);
            stat= dbConn.createStatement();
            String selectString = "select r.rent_id , b.bname, (c.culastname || ' ' || c.cuname) AS  aid,r.date_rent,r.due_date,r.employee_id_give,r.employee_id_took From rent r  join book b on (b.book_id = r.book_id) join customer c on (r.customer_id=c.customer_id) ORDER BY date_rent asc";
            rs = stat.executeQuery(selectString);

            while(rs.next()) {
                    String id = String.valueOf(rs.getInt("rent_id"));
                    String title = rs.getString("bname");
                    String name = rs.getString("aid");
                    String gave = rs.getString("date_rent");
                    String took = rs.getString("due_date");
                    String employeegave= String.valueOf(rs.getInt("employee_id_give"));
                    String employeetook= String.valueOf(rs.getInt("employee_id_took"));
                    String tbData[] = {id,title,name,gave,took,employeegave,employeetook};
                    
                    tblModel1.addRow(tbData);
            }
            stat.close();
            dbConn.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, ex);
        }
    }
    
    public void booksearch2(){
        tblModel1= (DefaultTableModel)closerenttbl.getModel();
        tblModel1.setRowCount(0);
        try {
            Class.forName (driverClassName);
        } catch (ClassNotFoundException ex) {
        }
        try{
            dbConn = DriverManager.getConnection (url, username, passwd);
            stat= dbConn.createStatement();
            String selectString = "select r.rent_id , b.bname, (c.culastname || ' ' || c.cuname) AS  aid,r.date_rent,r.employee_id_give From rent r  join book b on (b.book_id = r.book_id) join customer c on (r.customer_id=c.customer_id) where r.due_date IS NULL ORDER BY date_rent asc";
            rs = stat.executeQuery(selectString);

            while(rs.next()) {
                    String id = String.valueOf(rs.getInt("rent_id"));
                    String title = rs.getString("bname");
                    String name = rs.getString("aid");
                    String gave = rs.getString("date_rent");
                    String employeegave= String.valueOf(rs.getInt("employee_id_give"));
                    String tbData[] = {id,title,name,gave,employeegave,};
                    
                    tblModel1.addRow(tbData);
            }
            stat.close();
            dbConn.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, ex);
        }
    }
        
    public void membersearch(){
        tblModel2= (DefaultTableModel)membertbl.getModel();
        tblModel2.setRowCount(0);
        try {
            Class.forName (driverClassName);
        } catch (ClassNotFoundException ex) {
        }
        try{
            dbConn = DriverManager.getConnection (url, username, passwd);
            stct= dbConn.createStatement();
            String selectString = "select customer_id,culastname, cuname,address, phone, birthdate  From customer ORDER BY culastname asc";
            rs = stct.executeQuery(selectString);

            while(rs.next()) {
                    String id = String.valueOf(rs.getInt("customer_id"));
                    String clastname = rs.getString("culastname");
                    String cname = rs.getString("cuname");
                    String addre = rs.getString("address");
                    String phone = rs.getString("phone");
                    String birth = rs.getString("birthdate");
                    String tbData[] = {id,clastname,cname,addre,phone,birth};
                    
                    tblModel2.addRow(tbData);
            }
            stct.close();
            dbConn.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, ex);
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        memberlastnametxt = new javax.swing.JTextField();
        memberfirstnametxt = new javax.swing.JTextField();
        meberbirthtxt = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        booktitletxt = new javax.swing.JTextField();
        bookserialtxt = new javax.swing.JTextField();
        bookauthortxt = new javax.swing.JTextField();
        bookcategtxt = new javax.swing.JTextField();
        bookavailcoptxt = new javax.swing.JTextField();
        submit = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        booktxt = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        booktbl = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        membertbl = new javax.swing.JTable();
        membertxt = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        closerenttbl = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        allrentstbl = new javax.swing.JTable();
        jTextField3 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jTabbedPane2.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setText("Search Member");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 160, -1));

        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton4.setText("Search Book");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 160, -1));

        jTabbedPane1.setBackground(new java.awt.Color(0, 102, 102));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));

        jPanel5.setBackground(new java.awt.Color(0, 102, 102));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Member", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Last Name :");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("First Nam : ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Date of Birth :");

        memberlastnametxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        memberlastnametxt.setEnabled(false);

        memberfirstnametxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        memberfirstnametxt.setEnabled(false);

        meberbirthtxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        meberbirthtxt.setEnabled(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(49, 49, 49)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(memberlastnametxt)
                    .addComponent(memberfirstnametxt)
                    .addComponent(meberbirthtxt, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE))
                .addGap(0, 29, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(memberlastnametxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(memberfirstnametxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(meberbirthtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(0, 102, 102));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Book", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Title :");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Serial Number :");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Author :");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Category :");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Available Copies :");

        booktitletxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        booktitletxt.setEnabled(false);

        bookserialtxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bookserialtxt.setEnabled(false);

        bookauthortxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bookauthortxt.setEnabled(false);

        bookcategtxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bookcategtxt.setEnabled(false);

        bookavailcoptxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bookavailcoptxt.setEnabled(false);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(76, 76, 76)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(booktitletxt, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                    .addComponent(bookserialtxt)
                    .addComponent(bookauthortxt)
                    .addComponent(bookcategtxt)
                    .addComponent(bookavailcoptxt, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(booktitletxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(bookserialtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(bookauthortxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(bookcategtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(bookavailcoptxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        submit.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        submit.setText("Submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(245, 245, 245)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(248, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(353, 353, 353))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(submit)
                .addGap(519, 519, 519))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(submit)
                .addContainerGap(192, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab3", jPanel4);

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        booktxt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        booktxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                booktxtKeyReleased(evt);
            }
        });
        jPanel3.add(booktxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 720, 40));

        booktbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Title", "Author", "Category", "Publisher", "Serial Num", "Copies"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        booktbl.setFocusable(false);
        booktbl.setOpaque(false);
        booktbl.setRowHeight(30);
        booktbl.setSelectionBackground(new java.awt.Color(255, 102, 102));
        booktbl.setSelectionForeground(new java.awt.Color(255, 255, 255));
        booktbl.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        booktbl.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(booktbl);
        if (booktbl.getColumnModel().getColumnCount() > 0) {
            booktbl.getColumnModel().getColumn(0).setMaxWidth(1000);
            booktbl.getColumnModel().getColumn(1).setMaxWidth(6000);
            booktbl.getColumnModel().getColumn(2).setMaxWidth(7000);
            booktbl.getColumnModel().getColumn(3).setMaxWidth(5000);
            booktbl.getColumnModel().getColumn(4).setMaxWidth(6000);
            booktbl.getColumnModel().getColumn(5).setMaxWidth(1000);
            booktbl.getColumnModel().getColumn(6).setMaxWidth(1000);
        }

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 1130, 660));

        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton3.setText("OK");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 60, -1, 40));

        jTabbedPane1.addTab("tab1", jPanel3);

        jPanel9.setBackground(new java.awt.Color(0, 102, 102));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        membertbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Last Name", "First Name", "Address", "Phone", "Date of Birth"
            }
        ));
        membertbl.setOpaque(false);
        membertbl.setRowHeight(30);
        membertbl.setSelectionBackground(new java.awt.Color(255, 102, 102));
        membertbl.setSelectionForeground(new java.awt.Color(255, 255, 255));
        membertbl.getTableHeader().setReorderingAllowed(false);
        membertbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                membertblMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(membertbl);
        if (membertbl.getColumnModel().getColumnCount() > 0) {
            membertbl.getColumnModel().getColumn(0).setMaxWidth(1000);
        }

        jPanel9.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 181, 1130, 660));

        membertxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                membertxtKeyReleased(evt);
            }
        });
        jPanel9.add(membertxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 720, 40));

        jButton7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton7.setText("OK");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel9.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 60, -1, 40));

        jTabbedPane1.addTab("tab3", jPanel9);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 1130, 880));

        jTabbedPane2.addTab("tab3", jPanel1);

        jPanel7.setBackground(new java.awt.Color(0, 102, 102));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        closerenttbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Title", "Member", "Date Rent", "Employee Gave"
            }
        ));
        closerenttbl.setRowHeight(30);
        closerenttbl.setSelectionBackground(new java.awt.Color(255, 102, 102));
        closerenttbl.setSelectionForeground(new java.awt.Color(255, 255, 255));
        closerenttbl.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(closerenttbl);
        if (closerenttbl.getColumnModel().getColumnCount() > 0) {
            closerenttbl.getColumnModel().getColumn(0).setMaxWidth(1000);
        }

        jPanel7.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 117, 1310, 610));

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });
        jPanel7.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 540, -1));

        jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });
        jPanel7.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 50, 540, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Book Search");
        jPanel7.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Member Search");
        jPanel7.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 20, -1, -1));

        jTabbedPane2.addTab("tab2", jPanel7);

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        allrentstbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Book Title", "Member Name", "Date Of Rent", "Due Date", "Em. Name Gave", "Em. Name Resived"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        allrentstbl.setSelectionBackground(new java.awt.Color(255, 102, 102));
        allrentstbl.setSelectionForeground(new java.awt.Color(255, 255, 255));
        allrentstbl.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(allrentstbl);
        if (allrentstbl.getColumnModel().getColumnCount() > 0) {
            allrentstbl.getColumnModel().getColumn(0).setMaxWidth(1000);
        }

        jTextField3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField3KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(363, 363, 363)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(369, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("tab3", jPanel2);

        jPanel6.add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 1310, 790));

        jButton5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton5.setText("Start Rent");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 130, 50));

        jButton6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton6.setText("Close Rent");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 130, 50));

        jButton8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton8.setText("HOME");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 30, -1, -1));

        jButton9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton9.setText("All Rents");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 140, 50));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 840));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jTabbedPane1.setSelectedIndex(2);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jTabbedPane1.setSelectedIndex(1);
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       jTabbedPane2.setSelectedIndex(0);
       
       bookauthortxt.setText("");
       bookavailcoptxt.setText("");
       bookcategtxt.setText("");
       booktitletxt.setText("");
       bookserialtxt.setText("");
       memberfirstnametxt.setText("");
       memberlastnametxt.setText("");
       meberbirthtxt.setText("");
       
       bookidtemp=-1;
       memberidtemp=-1;
    }//GEN-LAST:event_jButton5ActionPerformed

    private void membertxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_membertxtKeyReleased
        String query = membertxt.getText().toLowerCase();
        filter2(query);
    }//GEN-LAST:event_membertxtKeyReleased

    private void booktxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_booktxtKeyReleased
        String query = booktxt.getText().toLowerCase();
        filter1(query);
    }//GEN-LAST:event_booktxtKeyReleased

    private void membertblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_membertblMouseClicked
       
        
        
    }//GEN-LAST:event_membertblMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int row= booktbl.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel)booktbl.getModel();
        bookidtemp=Integer.parseInt(model.getValueAt(row, 0).toString());
        booktitletxt.setText(model.getValueAt(row, 1).toString());
        bookserialtxt.setText(model.getValueAt(row, 2).toString());
        bookauthortxt.setText(model.getValueAt(row, 3).toString());
        bookcategtxt.setText(model.getValueAt(row, 4).toString());
        bookavailcoptxt.setText(model.getValueAt(row, 5).toString());
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        int row= membertbl.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel)membertbl.getModel();
        memberidtemp=Integer.parseInt(model.getValueAt(row, 0).toString());
        memberlastnametxt.setText(model.getValueAt(row, 1).toString());
        memberfirstnametxt.setText(model.getValueAt(row, 2).toString());
        meberbirthtxt.setText(model.getValueAt(row, 5).toString());
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy HH:mm:ss ");
        int vcode= getlastrentkid();
         
        Timestamp timestamp= new Timestamp(System.currentTimeMillis());
        String dateee=sdf.format(timestamp);
        
        if(bookidtemp!=-1 && memberidtemp!= -1){
            int aval=getlastavlailable(bookidtemp);
            try {
                instert1.setInt(1, aval);
                instert1.setInt(2, bookidtemp);
                insert.setInt(1, vcode);
                insert.setInt(2, bookidtemp);
                insert.setInt(3, memberidtemp);
                insert.setString(4, dateee);
                insert.setInt(5, 1);
                instert1.executeUpdate();
                insert.executeUpdate();
           } catch (SQLException ex) {
                System.out.println("\n -- SQL Exception --- \n");
                while(ex !=null){
                    System.out.println("Message: "+ ex.getMessage());
                    ex=ex.getNextException();
                }
            }
            tblModel1= (DefaultTableModel)booktbl.getModel();
        tblModel1.setRowCount(0);
        try {
            Class.forName (driverClassName);
        } catch (ClassNotFoundException ex) {
        }
        try{
            dbConn = DriverManager.getConnection (url, username, passwd);
            stat= dbConn.createStatement();
            String selectString = "select book_id , bname, (a.alastname || ' ' || a.aname) AS  aid,c.caname as cname, publishinghouse, serialnum, availablecopies From book join author a on (book.author_id = a.author_id) join category c on (book.category_id=c.category_id) ORDER BY bname asc";
            rs = stat.executeQuery(selectString);

            while(rs.next()) {
                    String id = String.valueOf(rs.getInt("book_id"));
                    String title = rs.getString("bname");
                    String author = rs.getString("aid");
                    String category = rs.getString("cname");
                    String publisher = rs.getString("publishinghouse");
                    String serialnum= String.valueOf(rs.getInt("serialnum"));
                    String copies= String.valueOf(rs.getInt("Availablecopies"));
                    String tbData[] = {id,title,author,category,publisher,serialnum,copies};
                    
                    tblModel1.addRow(tbData);
            }
            stat.close();
            dbConn.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, ex);
        }
        }
    }//GEN-LAST:event_submitActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        jTabbedPane2.setSelectedIndex(1);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        jTabbedPane2.setSelectedIndex(2);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
       String query = jTextField1.getText().toLowerCase();
            filter3(query);
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        String query = jTextField2.getText().toLowerCase();
            filter3(query);
    }//GEN-LAST:event_jTextField2KeyReleased

    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased
        String query = jTextField3.getText().toLowerCase();
            filter4(query);
    }//GEN-LAST:event_jTextField3KeyReleased

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
            java.util.logging.Logger.getLogger(RentAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RentAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RentAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RentAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RentAdd().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable allrentstbl;
    private javax.swing.JTextField bookauthortxt;
    private javax.swing.JTextField bookavailcoptxt;
    private javax.swing.JTextField bookcategtxt;
    private javax.swing.JTextField bookserialtxt;
    private javax.swing.JTable booktbl;
    private javax.swing.JTextField booktitletxt;
    private javax.swing.JTextField booktxt;
    private javax.swing.JTable closerenttbl;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField meberbirthtxt;
    private javax.swing.JTextField memberfirstnametxt;
    private javax.swing.JTextField memberlastnametxt;
    private javax.swing.JTable membertbl;
    private javax.swing.JTextField membertxt;
    private javax.swing.JButton submit;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AntiPatterns;

import database.SQLiteJDBC;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author heymeowcat
 */
public class Main extends javax.swing.JFrame {

    LocalDate today = LocalDate.now();

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        SetIcon();
        try {
//            SQLiteJDBC.iud("DROP TABLE Reservations");
            SQLiteJDBC.iud("CREATE TABLE  `Reservations` (\n"
                    + "  `bookingid` int(11) NOT NULL,\n"
                    + "  `date` date NOT NULL,\n"
                    + "  `session` text NOT NULL,\n"
                    + "  `package` text NOT NULL,\n"
                    + "  `teammembers` int(11) NOT NULL,\n"
                    + "  `total` double NOT NULL,\n"
                    + "  `pname` text NOT NULL,\n"
                    + "  `pmobile` int(11) NOT NULL,\n"
                    + "  `pemail` text NOT NULL,\n"
                    + "  `cname` text NOT NULL,\n"
                    + "  `cmobile` int(11) NOT NULL,\n"
                    + "  `cemail` text NOT NULL,\n"
                    + "  `state` int(11) NOT NULL\n"
                    + ");");
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        refreshtable(1);
        jRadioButton1.setSelected(true);
        jPanel3.setVisible(false);
        refreshtoday();

    }

    private void SetIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/booking.png")));
    }

    public void refreshtoday() {
        j1.setIndeterminate(true);

        new Thread() {
            @Override
            public void run() {
                try {
                    ResultSet rs = SQLiteJDBC.search("SELECT package,teammembers,total,pname,pmobile,pemail,cname,cmobile,cemail FROM `Reservations` WHERE date ='" + today + "' AND session ='Morning Session' AND state ='1'  ");
                    ResultSet rs2 = SQLiteJDBC.search("SELECT package,teammembers,total,pname,pmobile,pemail,cname,cmobile,cemail FROM `Reservations` WHERE date ='" + today + "' AND session ='Noon Session' AND state ='1' ");
                    ResultSet rs3 = SQLiteJDBC.search("SELECT package,teammembers,total,pname,pmobile,pemail,cname,cmobile,cemail FROM `Reservations` WHERE date ='" + today + "' AND session ='Evening Session' AND state ='1' ");
                    DefaultTableModel dtm = (DefaultTableModel) t1.getModel();
                    DefaultTableModel dtm2 = (DefaultTableModel) t2.getModel();
                    DefaultTableModel dtm3 = (DefaultTableModel) t3.getModel();
                    dtm.setRowCount(0);
                    dtm2.setRowCount(0);
                    dtm3.setRowCount(0);
                    if (rs.next()) {
                        Vector v1 = new Vector();
                        Vector v2 = new Vector();
                        Vector v3 = new Vector();
                        Vector v4 = new Vector();
                        Vector v5 = new Vector();
                        Vector v6 = new Vector();
                        Vector v7 = new Vector();
                        Vector v8 = new Vector();
                        Vector v9 = new Vector();
                        v1.add("Package");
                        v1.add(rs.getString(1));
                        v2.add("Team Members");
                        v2.add(rs.getString(2));
                        v3.add("Total");
                        v3.add(rs.getString(3));
                        v4.add("Personal Contact Name");
                        v4.add(rs.getString(4));
                        v5.add("Personal Mobile");
                        v5.add(rs.getString(5));
                        v6.add("Personal Email");
                        v6.add(rs.getString(6));
                        v7.add("Company Name");
                        v7.add(rs.getString(7));
                        v8.add("Company Mobile");
                        v8.add(rs.getString(8));
                        v9.add("Company Email");
                        v9.add(rs.getString(9));
                        dtm.addRow(v1);
                        dtm.addRow(v2);
                        dtm.addRow(v3);
                        dtm.addRow(v4);
                        dtm.addRow(v5);
                        dtm.addRow(v6);
                        dtm.addRow(v7);
                        dtm.addRow(v8);
                        dtm.addRow(v9);
                    }
                    if (rs2.next()) {
                        Vector v1 = new Vector();
                        Vector v2 = new Vector();
                        Vector v3 = new Vector();
                        Vector v4 = new Vector();
                        Vector v5 = new Vector();
                        Vector v6 = new Vector();
                        Vector v7 = new Vector();
                        Vector v8 = new Vector();
                        Vector v9 = new Vector();
                        v1.add("Package");
                        v1.add(rs2.getString(1));
                        v2.add("Team Members");
                        v2.add(rs2.getString(2));
                        v3.add("Total");
                        v3.add(rs2.getString(3));
                        v4.add("Personal Contact Name");
                        v4.add(rs2.getString(4));
                        v5.add("Personal Mobile");
                        v5.add(rs2.getString(5));
                        v6.add("Personal Email");
                        v6.add(rs2.getString(6));
                        v7.add("Company Name");
                        v7.add(rs2.getString(7));
                        v8.add("Company Mobile");
                        v8.add(rs2.getString(8));
                        v9.add("Company Email");
                        v9.add(rs2.getString(9));
                        dtm2.addRow(v1);
                        dtm2.addRow(v2);
                        dtm2.addRow(v3);
                        dtm2.addRow(v4);
                        dtm2.addRow(v5);
                        dtm2.addRow(v6);
                        dtm2.addRow(v7);
                        dtm2.addRow(v8);
                        dtm2.addRow(v9);
                    }
                    if (rs3.next()) {
                        Vector v1 = new Vector();
                        Vector v2 = new Vector();
                        Vector v3 = new Vector();
                        Vector v4 = new Vector();
                        Vector v5 = new Vector();
                        Vector v6 = new Vector();
                        Vector v7 = new Vector();
                        Vector v8 = new Vector();
                        Vector v9 = new Vector();
                        v1.add("Package");
                        v1.add(rs3.getString(1));
                        v2.add("Team Members");
                        v2.add(rs3.getString(2));
                        v3.add("Total");
                        v3.add(rs3.getString(3));
                        v4.add("Personal Contact Name");
                        v4.add(rs3.getString(4));
                        v5.add("Personal Mobile");
                        v5.add(rs3.getString(5));
                        v6.add("Personal Email");
                        v6.add(rs3.getString(6));
                        v7.add("Company Name");
                        v7.add(rs3.getString(7));
                        v8.add("Company Mobile");
                        v8.add(rs3.getString(8));
                        v9.add("Company Email");
                        v9.add(rs3.getString(9));
                        dtm3.addRow(v1);
                        dtm3.addRow(v2);
                        dtm3.addRow(v3);
                        dtm3.addRow(v4);
                        dtm3.addRow(v5);
                        dtm3.addRow(v6);
                        dtm3.addRow(v7);
                        dtm3.addRow(v8);
                        dtm3.addRow(v9);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                j1.setIndeterminate(false);
            }
        }.start();
    }

    private void refreshtableold() {
        j2.setIndeterminate(true);
        new Thread() {
            public void run() {
                try {
                    ResultSet rs = SQLiteJDBC.search("SELECT * FROM `Reservations` WHERE  DATE(date) < '" + today + "'  ORDER BY `date` DESC");
                    DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
                    dtm.setRowCount(0);
                    while (rs.next()) {
                        Vector v = new Vector();
                        v.add(rs.getString(1));
                        v.add(rs.getString(2));
                        v.add(rs.getString(3));
                        v.add(rs.getString(4));
                        v.add(rs.getString(5));
                        v.add(rs.getString(6));
                        v.add(rs.getString(7));
                        v.add(rs.getString(8));
                        v.add(rs.getString(9));
                        v.add(rs.getString(10));
                        v.add(rs.getString(11));
                        v.add(rs.getString(12));
                        dtm.addRow(v);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                j2.setIndeterminate(false);
            }
        }.start();
    }

    private void refreshtable(int i) {
        j2.setIndeterminate(true);
        new Thread() {
            public void run() {
                try {
                    ResultSet rs = SQLiteJDBC.search("SELECT * FROM `Reservations` where state ='" + i + "' and DATE(date) >= '" + today + "'   ORDER BY `Reservations`.`date` ASC");
                    DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
                    dtm.setRowCount(0);
                    while (rs.next()) {
                        Vector v = new Vector();
                        v.add(rs.getString(1));
                        v.add(rs.getString(2));
                        v.add(rs.getString(3));
                        v.add(rs.getString(4));
                        v.add(rs.getString(5));
                        v.add(rs.getString(6));
                        v.add(rs.getString(7));
                        v.add(rs.getString(8));
                        v.add(rs.getString(9));
                        v.add(rs.getString(10));
                        v.add(rs.getString(11));
                        v.add(rs.getString(12));
                        dtm.addRow(v);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                j2.setIndeterminate(false);
            }
        }.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        j1 = new javax.swing.JProgressBar();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        t1 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        t2 = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        t3 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        j3 = new javax.swing.JProgressBar();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        j2 = new javax.swing.JProgressBar();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jPanel8 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Reservations");

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sync.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Morning Session"));

        t1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Attributes", "Values"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(t1);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 883, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Noon Session"));

        t2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Attributes", "Values"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(t2);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Evening Session"));

        t3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Attributes", "Values"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(t3);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(j1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(j1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );

        jTabbedPane1.addTab("Today Bookings", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sync.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Manage Booking"));

        jButton3.setText("Verify Payment"); // NOI18N
        jButton3.setEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(j3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(j3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(0, 2, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Bookings"));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Booking Id", "Date", "Session", "Package", "Team members", "Total", "Personal name", "Personal mobile", "Personal email", "Company name", "Company mobile", "Company email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 883, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                .addContainerGap())
        );

        jRadioButton1.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Verified");
        jRadioButton1.setFocusPainted(false);
        jRadioButton1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jRadioButton1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Non-Verified");
        jRadioButton2.setFocusPainted(false);
        jRadioButton2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jRadioButton2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jRadioButton3.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("Old ");
        jRadioButton3.setFocusPainted(false);
        jRadioButton3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jRadioButton3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(j2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(j2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Manage Bookings", jPanel2);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 943, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 595, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Register Bookings", jPanel8);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        refreshtable(1);
        jRadioButton1.setSelected(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        refreshtoday();
        jPanel3.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        refreshtable(1);
        jPanel3.setVisible(false);

    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        refreshtable(0);
        jPanel3.setVisible(true);
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        refreshtableold();
        jPanel3.setVisible(false);

    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        String pendingbookingid = dtm.getValueAt(jTable1.getSelectedRow(), 0).toString();
        try {
            ResultSet rs = SQLiteJDBC.search("SELECT apid FROM `Reservations` where apid ='" + pendingbookingid + "' and DATE(date) >= '" + today + "'  and state=0  ");
            if (rs.next()) {
                jButton3.setEnabled(true);
            } else {
                jButton3.setEnabled(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jTable1MouseClicked

    public void verify(String id) {
        new Thread() {
            public void run() {
                try {
                    j3.setIndeterminate(true);
                    jButton3.setEnabled(false);
                    ResultSet rs = SQLiteJDBC.search("SELECT * FROM `Reservations` where apid ='" + id + "' ");
                    if (rs.next()) {
                        String host = "smtp.gmail.com";
                        String port = "587";
                        String mailFrom = "tailz.network@gmail.com";
                        String password = "vidura2531";
                        String mailTo = rs.getString(9);
                        String subject = "Booking Confired ";
                        String pkgselected = "";
                        if (rs.getString(4).equals("Basic")) {
                            pkgselected = "<div id='1pkg' class=''>\n"
                                    + "                                <h2>1.BASIC</h2>\n"
                                    + "                                <ul class='collection'>\n"
                                    + "                                    <li class='transparent collection-item'>\n"
                                    + "                                        PAINTBALL GUN - TIPPMAN 98 CUSTOM\n"
                                    + "                                    </li>\n"
                                    + "                                    <li class='transparent collection-item'>\n"
                                    + "                                        100 PAINTBALLS\n"
                                    + "                                    </li>\n"
                                    + "                                    <li class='transparent collection-item'>\n"
                                    + "                                        PAINTBALL MASK\n"
                                    + "                                    </li>\n"
                                    + "                                    <li class='transparent collection-item'>\n"
                                    + "                                        JACKET CAMO/DESSET\n"
                                    + "                                    </li>\n"
                                    + "                                    <li class='transparent collection-item'>\n"
                                    + "                                        EXTA PAINTBALLS - 600LKR(100 BALLS)\n"
                                    + "                                    </li>\n"
                                    + "                                    <li class='transparent collection-item'>\n"
                                    + "                                        WELCOME DRINK (FRESH ORANGE JUICE)\n"
                                    + "                                    </li>\n"
                                    + "                                </ul>\n"
                                    + "                            </div>\n";
                        } else if (rs.getString(4).equals("Extra")) {
                            pkgselected = "                            <div id='2pkg' class=''>\n"
                                    + "                                <h2>2.EXTRA</h2>\n"
                                    + "                                <ul class='collection'>\n"
                                    + "                                    <li class='transparent collection-item'>\n"
                                    + "                                        PAINTBALL GUN - TIPPMAN 98 CUSTOM\n"
                                    + "                                    </li>\n"
                                    + "                                    <li class='transparent collection-item'>\n"
                                    + "                                        200 PAINTBALLS\n"
                                    + "                                    </li>\n"
                                    + "                                    <li class='transparent collection-item'>\n"
                                    + "                                        PAINTBALL MASK\n"
                                    + "                                    </li>\n"
                                    + "                                    <li class='transparent collection-item'>\n"
                                    + "                                        JACKET CAMO/DESSET\n"
                                    + "                                    </li>\n"
                                    + "                                    <li class='transparent collection-item'>\n"
                                    + "                                        EXTA PAINTBALLS - 600LKR(100 BALLS)\n"
                                    + "                                    </li>\n"
                                    + "                                    <li class='transparent collection-item'>\n"
                                    + "                                        WELCOME DRINK (FRESH ORANGE JUICE)\n"
                                    + "                                    </li>\n"
                                    + "                                </ul>\n"
                                    + "                            </div>\n";
                        } else if (rs.getString(4).equals("Energy")) {
                            pkgselected = "                            <div id='3pkg' class=''>\n"
                                    + "                                <h2>3.ENERGY</h2>\n"
                                    + "                                <ul class='collection'>\n"
                                    + "                                    <li class='transparent collection-item'>\n"
                                    + "                                        PAINTBALL GUN - TIPPMAN 98 CUSTOM\n"
                                    + "                                    </li>\n"
                                    + "                                    <li class='transparent collection-item'>\n"
                                    + "                                        100 PAINTBALLS\n"
                                    + "                                    </li>\n"
                                    + "                                    <li class='transparent collection-item'>\n"
                                    + "                                        MEAL PLAN - LUNCH\n"
                                    + "                                    </li>\n"
                                    + "                                    <li class='transparent collection-item'>\n"
                                    + "                                        PAINTBALL MASK, JACKET CAMO/DESSET\n"
                                    + "                                    </li>\n"
                                    + "                                    <li class='transparent collection-item'>\n"
                                    + "                                        EXTA PAINTBALLS - 600LKR(100 BALLS)\n"
                                    + "                                    </li>\n"
                                    + "                                    <li class='transparent collection-item'>\n"
                                    + "                                        WELCOME DRINK (FRESH ORANGE JUICE)\n"
                                    + "                                    </li>\n"
                                    + "                                </ul>\n"
                                    + "                            </div>\n";
                        } else if (rs.getString(4).equals("Fresh")) {
                            pkgselected = "                            <div id='4pkg' class=''>\n"
                                    + "                                <h2>4.FRESH</h2>\n"
                                    + "                                <ul class='collection'>\n"
                                    + "                                    <li class='transparent collection-item'>\n"
                                    + "                                        PAINTBALL GUN - TIPPMAN 98 CUSTOM, 100 PAINTBALLS\n"
                                    + "                                    </li>\n"
                                    + "                                    <li class='transparent collection-item'>\n"
                                    + "                                        FACILITIES - SWIMMING POOL\n"
                                    + "                                    </li>\n"
                                    + "                                    <li class='transparent collection-item'>\n"
                                    + "                                        MEAL PLAN - LUNCH (RICE &amp; CURRY BUFFET)\n"
                                    + "                                    </li>\n"
                                    + "                                    <li class='transparent collection-item'>\n"
                                    + "                                        PAINTBALL MASK,JACKET CAMO/DESSET\n"
                                    + "                                    </li>\n"
                                    + "                                    <li class='transparent collection-item'>\n"
                                    + "                                        EXTA PAINTBALLS - 600LKR(100 BALLS)\n"
                                    + "                                    </li>\n"
                                    + "                                    <li class='transparent collection-item'>\n"
                                    + "                                        WELCOME DRINK (FRESH ORANGE JUICE)\n"
                                    + "                                    </li>\n"
                                    + "                                </ul>\n"
                                    + "                            </div>\n";
                        } else if (rs.getString(4).equals("High Fresh")) {
                            pkgselected = "                            <div id='5pkg' class=''>\n"
                                    + "                                <h2>5.HIGH FRESH</h2>\n"
                                    + "                                <ul class='collection'>\n"
                                    + "                                    <li class='transparent collection-item'>\n"
                                    + "                                        PAINTBALL GUN - TIPPMAN 98 CUSTOM, 100 PAINTBALLS\n"
                                    + "                                    </li>\n"
                                    + "                                    <li class='transparent collection-item'>\n"
                                    + "                                        FACILITIES - SWIMMING POOL\n"
                                    + "                                    </li>\n"
                                    + "                                    <li class='transparent collection-item'>\n"
                                    + "                                        MEAL PLAN - LUNCH (RICE &amp; CURRY BUFFET)\n"
                                    + "                                    </li>\n"
                                    + "                                    <li class='transparent collection-item'>\n"
                                    + "                                        PAINTBALL MASK,JACKET CAMO/DESSET\n"
                                    + "                                    </li>\n"
                                    + "                                    <li class='transparent collection-item'>\n"
                                    + "                                        EXTA PAINTBALLS - 600LKR(100 BALLS)\n"
                                    + "                                    </li>\n"
                                    + "                                    <li class='transparent collection-item'>\n"
                                    + "                                        WELCOME DRINK (FRESH ORANGE JUICE)\n"
                                    + "                                    </li>\n"
                                    + "                                </ul>\n"
                                    + "                            </div>\n";
                        } else if (rs.getString(4).equals("Pro")) {
                            pkgselected = "                            <div id='6pkg' class=''>\n"
                                    + "                                <h2>6.PRO</h2>\n"
                                    + "                                <ul class='collection'>\n"
                                    + "                                    <li class='transparent collection-item'>\n"
                                    + "                                        PAINTBALL GUN - TIPPMAN 98 CUSTOM, 100 PAINTBALLS\n"
                                    + "                                    </li>\n"
                                    + "                                    <li class='transparent collection-item'>\n"
                                    + "                                        NIGHT CAMPING/ CAMP FIRE\n"
                                    + "                                    </li>\n"
                                    + "                                    <li class='transparent collection-item'>\n"
                                    + "                                        WELCOME DRINK/ LUNCH (RICE &amp; CURRY BUFFET) / NIGHT BBQ / BREAKFAST\n"
                                    + "                                    </li>\n"
                                    + "                                    <li class='transparent collection-item'>\n"
                                    + "                                        PAINTBALL MASK,JACKET CAMO/DESSET\n"
                                    + "                                    </li>\n"
                                    + "                                    <li class='transparent collection-item'>\n"
                                    + "                                        EXTA PAINTBALLS - 600LKR(100 BALLS)\n"
                                    + "                                    </li>\n"
                                    + "                                    <li class='transparent collection-item'>\n"
                                    + "                                        WELCOME DRINK (FRESH ORANGE JUICE)\n"
                                    + "                                    </li>\n"
                                    + "                                </ul>\n"
                                    + "                            </div>\n";
                        }
                        String message = ""
                                + "<!DOCTYPE html>\n"
                                + "<html lang=\"en\">"
                                + "<body>"
                                + "<h1 style='color:green; background-color:#f5fff9'>Your Booking Confirmed | Paintball.lk</h1>"
                                + "<div class='row'>\n"
                                + "                    <div class='col s12'>\n"
                                + "                        <div class='resume-wrap ftco-animate fadeInUp ftco-animated'>\n"
                                + "                            <h1 style='background-color:#f5fff9'><u>Date &amp; Session</u></h1>\n"
                                + "                            <h2 id='datedisplay'>" + rs.getString(2) + "</h2>\n"
                                + "                            <h2 id='sessionselected'>" + rs.getString(3) + "</h2>\n"
                                + "                            <h2 id='memcount'>" + rs.getString(5) + " Team Members</h2>\n"
                                + "                        </div>\n"
                                + "                    </div>\n"
                                + "                    <div class='col s12'>\n"
                                + "                        <div class='resume-wrap ftco-animate fadeInUp ftco-animated'>\n"
                                + "                            <h1 style='background-color:#f5fff9'><u>Your Package</u></h1><br>\n"
                                + pkgselected
                                + "                        </div>\n"
                                + "                    </div>\n"
                                + "                    <div class='col s12'>\n"
                                + "                        <div class='resume-wrap ftco-animate fadeInUp ftco-animated'>\n"
                                + "                            <h1 style='background-color:#f5fff9'><u>Total Price</u></h1><br>\n"
                                + "                            <h2 id='pricegoeshere'>" + rs.getString(6) + " LKR</h2>\n"
                                + "\n"
                                + "                        </div>\n"
                                + "                    </div>\n"
                                + "                </div>"
                                + "</body>"
                                + "</html>";
                        SQLiteJDBC.iud("UPDATE `Reservations` SET `state` = '1' WHERE `Reservations`.`apid` = '" + id + "';");
                    }
                    j3.setIndeterminate(false);
                    refreshtable(1);
                    jRadioButton1.setSelected(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }


    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int response = JOptionPane.showConfirmDialog(null, "Do you want to Verify Payment and Confirm Booking?", "Confirm",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.NO_OPTION) {
        } else if (response == JOptionPane.YES_OPTION) {
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            String pendingbookingid = dtm.getValueAt(jTable1.getSelectedRow(), 0).toString();
            verify(pendingbookingid);
        } else if (response == JOptionPane.CLOSED_OPTION) {
        }
    }//GEN-LAST:event_jButton3ActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JProgressBar j1;
    private javax.swing.JProgressBar j2;
    private javax.swing.JProgressBar j3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable t1;
    private javax.swing.JTable t2;
    private javax.swing.JTable t3;
    // End of variables declaration//GEN-END:variables
}

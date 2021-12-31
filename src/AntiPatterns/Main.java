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
        System.out.println(today);
        try {
//            SQLiteJDBC.iud("DROP TABLE Reservations");
            SQLiteJDBC.iud("CREATE TABLE  IF NOT EXISTS `Reservations` (\n"
                    + "  `bookingid` INTEGER PRIMARY KEY AUTOINCREMENT,\n"
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
        verifiedRadio.setSelected(true);
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
                    DefaultTableModel dtm = (DefaultTableModel) MorningSessionTable.getModel();
                    DefaultTableModel dtm2 = (DefaultTableModel) NoonSessionTable.getModel();
                    DefaultTableModel dtm3 = (DefaultTableModel) EveningSessionTable.getModel();
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
                    DefaultTableModel dtm = (DefaultTableModel) ManageBookingsTable.getModel();
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
                    DefaultTableModel dtm = (DefaultTableModel) ManageBookingsTable.getModel();
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
        refreshTodaysBookingsBtn = new javax.swing.JButton();
        j1 = new javax.swing.JProgressBar();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        MorningSessionTable = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        NoonSessionTable = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        EveningSessionTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        refreshManageBookingsBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        verifyPaymentBtn = new javax.swing.JButton();
        verifyProgress = new javax.swing.JProgressBar();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ManageBookingsTable = new javax.swing.JTable();
        j2 = new javax.swing.JProgressBar();
        verifiedRadio = new javax.swing.JRadioButton();
        nonVerifiedRadio = new javax.swing.JRadioButton();
        oldBookingsRadio = new javax.swing.JRadioButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        createReservationsBtn = new javax.swing.JButton();
        cEmailTxt = new javax.swing.JTextField();
        cMobileTxt = new javax.swing.JTextField();
        cNameTxt = new javax.swing.JTextField();
        pEmailTxt = new javax.swing.JTextField();
        pMobileTxt = new javax.swing.JTextField();
        pNameTxt = new javax.swing.JTextField();
        teamMembersTxt = new javax.swing.JTextField();
        packageTxt = new javax.swing.JTextField();
        dateTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        sessionCombo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Reservations");

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        refreshTodaysBookingsBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sync.png"))); // NOI18N
        refreshTodaysBookingsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshTodaysBookingsBtnActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Morning Session"));

        MorningSessionTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(MorningSessionTable);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 994, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Noon Session"));

        NoonSessionTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(NoonSessionTable);

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
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Evening Session"));

        EveningSessionTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(EveningSessionTable);

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
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
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
                        .addComponent(refreshTodaysBookingsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(refreshTodaysBookingsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        refreshManageBookingsBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sync.png"))); // NOI18N
        refreshManageBookingsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshManageBookingsBtnActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Manage Booking"));

        verifyPaymentBtn.setText("Verify Payment"); // NOI18N
        verifyPaymentBtn.setEnabled(false);
        verifyPaymentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verifyPaymentBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(verifyPaymentBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(verifyProgress, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(verifyProgress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(verifyPaymentBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Bookings"));

        ManageBookingsTable.setModel(new javax.swing.table.DefaultTableModel(
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
        ManageBookingsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ManageBookingsTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ManageBookingsTable);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 994, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
                .addContainerGap())
        );

        verifiedRadio.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(verifiedRadio);
        verifiedRadio.setText("Verified");
        verifiedRadio.setFocusPainted(false);
        verifiedRadio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        verifiedRadio.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        verifiedRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verifiedRadioActionPerformed(evt);
            }
        });

        nonVerifiedRadio.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(nonVerifiedRadio);
        nonVerifiedRadio.setText("Non-Verified");
        nonVerifiedRadio.setFocusPainted(false);
        nonVerifiedRadio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nonVerifiedRadio.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        nonVerifiedRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nonVerifiedRadioActionPerformed(evt);
            }
        });

        oldBookingsRadio.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(oldBookingsRadio);
        oldBookingsRadio.setText("Old ");
        oldBookingsRadio.setFocusPainted(false);
        oldBookingsRadio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        oldBookingsRadio.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        oldBookingsRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oldBookingsRadioActionPerformed(evt);
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
                        .addComponent(refreshManageBookingsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(j2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(verifiedRadio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nonVerifiedRadio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(oldBookingsRadio)
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
                    .addComponent(refreshManageBookingsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(verifiedRadio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nonVerifiedRadio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(oldBookingsRadio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Manage Bookings", jPanel2);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Create New Reservation"));

        createReservationsBtn.setText("Create Reservation");
        createReservationsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createReservationsBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Date");

        jLabel2.setText("Session");

        jLabel3.setText("Package");

        jLabel4.setText("Team Members");

        jLabel5.setText("Personal Name");

        jLabel6.setText("Personal Mobile");

        jLabel7.setText("Personal Email");

        jLabel8.setText("Company Name");

        jLabel9.setText("Company Mobile");

        jLabel10.setText("Company Email");

        sessionCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Morning Session", "Noon Session", "Evening Session" }));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cEmailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                            .addComponent(cMobileTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5))
                            .addGap(68, 68, 68)
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(teamMembersTxt)
                                .addComponent(packageTxt)
                                .addComponent(dateTxt)
                                .addComponent(pNameTxt)
                                .addComponent(sessionCombo, 0, 211, Short.MAX_VALUE)))
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pMobileTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pEmailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(createReservationsBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dateTxt)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sessionCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(packageTxt)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(teamMembersTxt)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pNameTxt)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pMobileTxt)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pEmailTxt)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cNameTxt)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cMobileTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cEmailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(createReservationsBtn)
                .addContainerGap(284, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(637, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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

    private void refreshManageBookingsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshManageBookingsBtnActionPerformed
        refreshtable(1);
        verifiedRadio.setSelected(true);
    }//GEN-LAST:event_refreshManageBookingsBtnActionPerformed

    private void refreshTodaysBookingsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshTodaysBookingsBtnActionPerformed
        refreshtoday();
        jPanel3.setVisible(false);
    }//GEN-LAST:event_refreshTodaysBookingsBtnActionPerformed

    private void verifiedRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verifiedRadioActionPerformed
        refreshtable(1);
        jPanel3.setVisible(false);

    }//GEN-LAST:event_verifiedRadioActionPerformed

    private void nonVerifiedRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nonVerifiedRadioActionPerformed
        refreshtable(0);
        jPanel3.setVisible(true);
    }//GEN-LAST:event_nonVerifiedRadioActionPerformed

    private void oldBookingsRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oldBookingsRadioActionPerformed
        refreshtableold();
        jPanel3.setVisible(false);

    }//GEN-LAST:event_oldBookingsRadioActionPerformed

    private void ManageBookingsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ManageBookingsTableMouseClicked
        DefaultTableModel dtm = (DefaultTableModel) ManageBookingsTable.getModel();
        String pendingbookingid = dtm.getValueAt(ManageBookingsTable.getSelectedRow(), 0).toString();
        try {
            ResultSet rs = SQLiteJDBC.search("SELECT bookingid FROM `Reservations` where bookingid ='" + pendingbookingid + "' and DATE(date) >= '" + today + "'  and state=0  ");
            if (rs.next()) {
                verifyPaymentBtn.setEnabled(true);
            } else {
                verifyPaymentBtn.setEnabled(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_ManageBookingsTableMouseClicked

    private void verifyPaymentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verifyPaymentBtnActionPerformed
        int response = JOptionPane.showConfirmDialog(null, "Do you want to Verify Payment and Confirm Booking?", "Confirm",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.NO_OPTION) {
        } else if (response == JOptionPane.YES_OPTION) {
            DefaultTableModel dtm = (DefaultTableModel) ManageBookingsTable.getModel();
            String pendingbookingid = dtm.getValueAt(ManageBookingsTable.getSelectedRow(), 0).toString();
            verify(pendingbookingid);
        } else if (response == JOptionPane.CLOSED_OPTION) {
        }
    }//GEN-LAST:event_verifyPaymentBtnActionPerformed

    private void createReservationsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createReservationsBtnActionPerformed
        try {
            SQLiteJDBC.iud("INSERT INTO `Reservations` (`date`, `session`, `package`, `teammembers`, `total`, `pname`, `pmobile`, `pemail`, `cname`, `cmobile`, `cemail`, `state`) VALUES ('" + dateTxt.getText() + "', '" + sessionCombo.getSelectedItem().toString() + "', '" + packageTxt.getText() + "', '" + teamMembersTxt.getText() + "', '0.0', '" + pNameTxt.getText() + "','" + pMobileTxt.getText() + "', '" + pEmailTxt.getText() + "', '" + cNameTxt.getText() + "', '" + cMobileTxt.getText() + "', '" + cEmailTxt.getText() + "', '0')");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_createReservationsBtnActionPerformed

    public void verify(String id) {
        new Thread() {
            public void run() {
                try {
                    verifyProgress.setIndeterminate(true);
                    verifyPaymentBtn.setEnabled(false);
                    ResultSet rs = SQLiteJDBC.search("SELECT * FROM `Reservations` where bookingid ='" + id + "' ");
                    if (rs.next()) {
                        SQLiteJDBC.iud("UPDATE `Reservations` SET `state` = '1' WHERE `Reservations`.`bookingid` = '" + id + "';");
                    }
                    verifyProgress.setIndeterminate(false);
                    refreshtable(1);
                    verifiedRadio.setSelected(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }

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
    private javax.swing.JTable EveningSessionTable;
    private javax.swing.JTable ManageBookingsTable;
    private javax.swing.JTable MorningSessionTable;
    private javax.swing.JTable NoonSessionTable;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField cEmailTxt;
    private javax.swing.JTextField cMobileTxt;
    private javax.swing.JTextField cNameTxt;
    private javax.swing.JButton createReservationsBtn;
    private javax.swing.JTextField dateTxt;
    private javax.swing.JProgressBar j1;
    private javax.swing.JProgressBar j2;
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
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton nonVerifiedRadio;
    private javax.swing.JRadioButton oldBookingsRadio;
    private javax.swing.JTextField pEmailTxt;
    private javax.swing.JTextField pMobileTxt;
    private javax.swing.JTextField pNameTxt;
    private javax.swing.JTextField packageTxt;
    private javax.swing.JButton refreshManageBookingsBtn;
    private javax.swing.JButton refreshTodaysBookingsBtn;
    private javax.swing.JComboBox<String> sessionCombo;
    private javax.swing.JTextField teamMembersTxt;
    private javax.swing.JRadioButton verifiedRadio;
    private javax.swing.JButton verifyPaymentBtn;
    private javax.swing.JProgressBar verifyProgress;
    // End of variables declaration//GEN-END:variables
}

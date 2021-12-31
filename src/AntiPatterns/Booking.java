/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AntiPatterns;

import database.SQLiteJDBC;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.RadioButton;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author heymeowcat
 */
public class Booking {

    private int bookingid;
    private String date;
    private String session;
    private String pack;
    private int teammembers;
    private double total;
    private String pname;
    private int pmobile;
    private String pemail;
    private String cname;
    private String cmobile;
    private String cemail;
    private String state;

    private JTable ManageBookingsTable;
    private JTable MorningSessionTable;
    private JTable NoonSessionTable;
    private JTable EveningSessionTable;
    private JProgressBar j1;
    private JProgressBar j2;
    private JProgressBar verifyProgress;
    private JButton verifyPaymentBtn;
    private JRadioButton verifiedRadio;

    LocalDate today;

    public Booking(JTable ManageBookingsTable, JTable MorningSessionTable, JTable NoonSessionTable, JTable EveningSessionTable, JProgressBar j1, JProgressBar j2, JProgressBar verifyProgress, JButton verifyPaymentBtn, JRadioButton verifiedRadio) {
        this.ManageBookingsTable = ManageBookingsTable;
        this.MorningSessionTable = MorningSessionTable;
        this.NoonSessionTable = NoonSessionTable;
        this.EveningSessionTable = EveningSessionTable;
        this.j1 = j1;
        this.j2 = j2;
        this.verifyProgress = verifyProgress;
        this.verifyPaymentBtn = verifyPaymentBtn;
        this.verifiedRadio = verifiedRadio;
        this.today = LocalDate.now();
    }

    public int getBookingid() {
        return bookingid;
    }

    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getPack() {
        return pack;
    }

    public void setPack(String pack) {
        this.pack = pack;
    }

    public int getTeammembers() {
        return teammembers;
    }

    public void setTeammembers(int teammembers) {
        this.teammembers = teammembers;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getPmobile() {
        return pmobile;
    }

    public void setPmobile(int pmobile) {
        this.pmobile = pmobile;
    }

    public String getPemail() {
        return pemail;
    }

    public void setPemail(String pemail) {
        this.pemail = pemail;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCmobile() {
        return cmobile;
    }

    public void setCmobile(String cmobile) {
        this.cmobile = cmobile;
    }

    public String getCemail() {
        return cemail;
    }

    public void setCemail(String cemail) {
        this.cemail = cemail;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    private void createBookingTableIfNotExist() {
        try {
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
            ex.printStackTrace();
        }
    }

    void refreshtable(int i) {
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

    void refreshtableold() {
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

    public void ManageBookingsTable() {

    }

    public void verifyBookingPayment() {

    }

    public void createNewBooking() {

    }

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
}

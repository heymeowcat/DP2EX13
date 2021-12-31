/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AntiPatterns;

/**
 *
 * @author heymeowcat
 */
public class Booking {

    String apid;
    String date;
    String session;
    String pkg;
    String teammembers;
    String total;
    String discount;
    String advance;
    String remain;
    String pn;
    String pm;
    String pe;
    String pkgstate;
    String secretid;
    String additionstotal;

    public Booking(String apid, String date, String session, String pkg, String teammembers, String total, String finalprice, String discount, String advance, String remain, String pn, String pm, String pe, String pkgstate, String secretid, String additionstotal) {
        this.apid = apid;
        this.date = date;
        this.session = session;
        this.pkg = pkg;
        this.teammembers = teammembers;
        this.total = total;
        this.finalprice = finalprice;
        this.discount = discount;
        this.advance = advance;
        this.remain = remain;
        this.pn = pn;
        this.pm = pm;
        this.pe = pe;
        this.pkgstate = pkgstate;
        this.secretid = secretid;
        this.additionstotal = additionstotal;
    }

    public String getApid() {
        return apid;
    }

    public Booking() {
    }

    public String getPkgstate() {
        return pkgstate;
    }

    public void setPkgstate(String pkgstate) {
        this.pkgstate = pkgstate;
    }

    public void setApid(String apid) {
        this.apid = apid;
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

    public String getPkg() {
        return pkg;
    }

    public void setPkg(String pkg) {
        this.pkg = pkg;
    }

    public String getTeammembers() {
        return teammembers;
    }

    public void setTeammembers(String teammembers) {
        this.teammembers = teammembers;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getPn() {
        return pn;
    }

    public void setPn(String pn) {
        this.pn = pn;
    }

    public String getPm() {
        return pm;
    }

    public void setPm(String pm) {
        this.pm = pm;
    }

    public String getPe() {
        return pe;
    }

    public String getSecretid() {
        return secretid;
    }

    public void setSecretid(String secretid) {
        this.secretid = secretid;
    }

    public void setPe(String pe) {
        this.pe = pe;
    }

    public String getFinalprice() {
        return finalprice;
    }

    public void setFinalprice(String finalprice) {
        this.finalprice = finalprice;
    }

    String finalprice;

    public String getAdvance() {
        return advance;
    }

    public void setAdvance(String advance) {
        this.advance = advance;
    }

    public String getRemain() {
        return remain;
    }

    public void setRemain(String remain) {
        this.remain = remain;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getAdditionstotal() {
        return additionstotal;
    }

    public void setAdditionstotal(String additionstotal) {
        this.additionstotal = additionstotal;
    }

}

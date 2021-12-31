package AntiPatterns;

import java.util.ArrayList;
import java.util.HashMap;

public class locationPackages {
    String packageid;
    String packagename;
    String packageprice;
    HashMap<String,ItemInPackage> ItemsInPackage;



    public locationPackages() {

    }


    public String getPackageid() {
        return packageid;
    }

    public void setPackageid(String packageid) {
        this.packageid = packageid;
    }

    public String getPackagename() {
        return packagename;
    }

    public void setPackagename(String packagename) {
        this.packagename = packagename;
    }

    public String getPackageprice() {
        return packageprice;
    }

    public void setPackageprice(String packageprice) {
        this.packageprice = packageprice;
    }

    public HashMap<String, ItemInPackage> getItemsInPackage() {
        return ItemsInPackage;
    }

    public void setItemsInPackage(HashMap<String, ItemInPackage> itemsInPackage) {
        ItemsInPackage = itemsInPackage;
    }
}

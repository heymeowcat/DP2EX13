package AntiPatterns;

public class ItemInPackage {
    String ItemId;
    String ItemName;

    public ItemInPackage() {
    }

    String ItemPerPrice;

    public String getItemId() {
        return ItemId;
    }

    public void setItemId(String itemId) {
        ItemId = itemId;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public String getItemPerPrice() {
        return ItemPerPrice;
    }

    public void setItemPerPrice(String itemPerPrice) {
        ItemPerPrice = itemPerPrice;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getLineprice() {
        return lineprice;
    }

    public void setLineprice(String lineprice) {
        this.lineprice = lineprice;
    }

    public ItemInPackage(String itemId, String itemName, String itemPerPrice, String quantity, String lineprice) {
        ItemId = itemId;
        ItemName = itemName;
        ItemPerPrice = itemPerPrice;
        Quantity = quantity;
        this.lineprice = lineprice;
    }

    String Quantity;
    String lineprice;
}

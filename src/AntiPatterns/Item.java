package AntiPatterns;

public class Item {
    String ItemId;

    public Item() {
    }

    String ItemName;

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

    public String getItemPrice() {
        return ItemPrice;
    }

    public void setItemPrice(String itemPrice) {
        ItemPrice = itemPrice;
    }

    String ItemPrice;

    public Item(String itemId, String itemName, String itemPrice) {
        ItemId = itemId;
        ItemName = itemName;
        ItemPrice = itemPrice;
    }
}

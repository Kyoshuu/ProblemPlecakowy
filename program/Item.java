package program;

/**
 * Class describing items using id, weight and value
 */
public class Item {
    private int itemId;
    private int itemWeight;
    private int itemValue;

    public Item(int itemId, int itemWeight, int itemValue) {
        this.itemId = itemId;
        this.itemWeight = itemWeight;
        this.itemValue = itemValue;
    }

    public Item(String[] itemData) {
        this(Integer.parseInt(itemData[0]), Integer.parseInt(itemData[1]), Integer.parseInt(itemData[2]));
    }

    public int getItemId() {
        return itemId;
    }

    public int getItemWeight() {
        return itemWeight;
    }

    public int getItemValue() {
        return itemValue;
    }

    @Override
    public String toString() {
        return "Item #" + itemId + " { " + "weight: " + itemWeight + ", value: " + itemValue + " }";
    }
}

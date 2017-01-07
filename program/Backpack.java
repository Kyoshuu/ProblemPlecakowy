package program;

import selectionMethods.ItemSelectionMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Backpack gives functionality to fill it with items using
 * implementation of ItemSelectionMethod interface
 */
public class Backpack {
    private ArrayList<Item> items;
    private int size;

    public Backpack(int size) {
        items = new ArrayList<>();
        this.size = size;
    }

    /**
     * Fill backpack with items selected using ItemSelectionMethod
     * @param allItems items from which few are selected by ItemSelectionMethod
     * @param itemSelectionMethod class defining method which is used to select items
     */
    public void fill(List<Item> allItems, ItemSelectionMethod itemSelectionMethod) {
        items.addAll(itemSelectionMethod.selectItems(allItems, size));
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public int getTotalWeight() {
        int totalWeight = 0;

        for (Item item :
                items) {
            totalWeight += item.getItemWeight();
        }

        return totalWeight;
    }

    public int getTotalValue() {
        int totalValue = 0;

        for (Item item :
                items) {
            totalValue += item.getItemValue();
        }

        return totalValue;
    }

    @Override
    public String toString() {
        String result = "";

        int weightSum = 0, valueSum = 0;

        for (Item i :
                items) {
            result += i + "\n";
            weightSum += i.getItemWeight();
            valueSum += i.getItemValue();
        }

        result += "\n";
        result += "Total weight: " + weightSum + "\n";
        result += "Total value: " + valueSum + "\n";

        return result;
    }
}

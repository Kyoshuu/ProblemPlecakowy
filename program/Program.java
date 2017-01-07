package program;

import selectionMethods.ItemSelectionMethod;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Program {
    private Backpack backpack;
    private List<Item> allItems;

    ItemSelectionMethod itemSelectionMethod;

    /**
     * Constructor instantiates backpack and item list
     *
     * @param pathToItemsData path to csv containing items data
     * @param backpackSize maximum number of items backpack can contain
     */
    public Program(String pathToItemsData, int backpackSize) {
        backpack = new Backpack(backpackSize);
        allItems = getItemsFromFile(pathToItemsData);
    }

    /**
     * Constructor instantiates backpack, item list and itemSelectionMethod
     *
     * @param pathToItemsData path to csv containing items data
     * @param backpackSize maximum number of items backpack can contain
     * @param itemSelectionMethod defines method that program will use to select items for backpack
     */
    public Program(String pathToItemsData, int backpackSize, ItemSelectionMethod itemSelectionMethod) {
        this(pathToItemsData, backpackSize);

        this.itemSelectionMethod = itemSelectionMethod;
    }

    /**
     * Method select items using ItemSelectionMethod and add them to backpack.
     * @param itemSelectionMethod defines method that program will use to select items for backpack
     */
    public void fillBackpack(ItemSelectionMethod itemSelectionMethod) {
        backpack.fill(allItems, itemSelectionMethod);
    }

    /**
     * Method select items using previously set ItemSelectionMethod and add them to backpack.
     * If itemSelectionMethod is not set backpack will not change.
     * @return if itemSelectionMethod is null method will return false else true
     */
    public boolean fillBackpack() {
        if(itemSelectionMethod == null)
            return false;

        fillBackpack(itemSelectionMethod);

        return true;
    }

    public void setItemSelectionMethod(ItemSelectionMethod itemSelectionMethod) {
        this.itemSelectionMethod = itemSelectionMethod;
    }

    /**
     * Method opens file from given path and parse it. As a result it uses data to
     * create items and return it in arraylist.
     * @param pathToItemsData path to csv containing items data
     * @return items from csv file
     */
    private ArrayList<Item> getItemsFromFile(String pathToItemsData) {
        ArrayList<Item> items = new ArrayList<>();

        try (BufferedReader itemsDataReader = new BufferedReader(new FileReader(pathToItemsData))) {
            String line;

            // Skip line containing columns description
            itemsDataReader.readLine();

            // Reads each line of file, create items out of data and add it to the list
            while((line = itemsDataReader.readLine()) != null) {
                String[] itemData = line.split(";");
                Item item = new Item(itemData);
                items.add(item);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return items;
    }

    /**
     * Write the contents of backpack(items), sum of its weight and value
     * @param printStream stream that it will be written into
     */
    public void showBackpack(PrintStream printStream) {
        printStream.println(backpack);
    }

    public Backpack getBackpack() { return backpack; }
}

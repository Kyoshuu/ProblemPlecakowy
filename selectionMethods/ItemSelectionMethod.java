package selectionMethods;

import program.Item;

import java.util.List;

/**
 * Interface used to select items that will fill backpack
 */
public interface ItemSelectionMethod {
    List<Item> selectItems(List<Item> item, int backpackSize);
}

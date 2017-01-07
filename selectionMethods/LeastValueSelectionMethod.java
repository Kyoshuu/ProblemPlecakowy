package selectionMethods;

import program.Item;

import java.util.List;

public class LeastValueSelectionMethod implements ItemSelectionMethod {

    @Override
    public List<Item> selectItems(List<Item> items, int backpackSize) {
        items.sort((firstItem, secondItem) -> firstItem.getItemValue() - secondItem.getItemValue());
        return items.subList(0, backpackSize);
    }
}
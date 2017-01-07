package selectionMethods;

import program.Item;

import java.util.List;

public class GreatestValueSelectionMethod implements ItemSelectionMethod {

    @Override
    public List<Item> selectItems(List<Item> items, int backpackSize) {
        items.sort((firstItem, secondItem) -> secondItem.getItemValue() - firstItem.getItemValue());
        return items.subList(0, backpackSize);
    }
}

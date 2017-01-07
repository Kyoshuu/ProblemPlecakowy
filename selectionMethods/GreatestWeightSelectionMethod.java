package selectionMethods;

import program.Item;

import java.util.List;

public class GreatestWeightSelectionMethod implements ItemSelectionMethod {

    @Override
    public List<Item> selectItems(List<Item> items, int backpackSize) {
        items.sort((firstItem, secondItem) -> secondItem.getItemWeight() - firstItem.getItemWeight());
        return items.subList(0, backpackSize);
    }
}

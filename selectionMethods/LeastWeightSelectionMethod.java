package selectionMethods;


import program.Item;

import java.util.List;

public class LeastWeightSelectionMethod implements ItemSelectionMethod {

    @Override
    public List<Item> selectItems(List<Item> items, int backpackSize) {
        items.sort((firstItem, secondItem) -> firstItem.getItemWeight() - secondItem.getItemWeight());
        return items.subList(0, backpackSize);
    }
}

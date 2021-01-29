package solid.lsp;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Store {
    private List<Food> foods = new ArrayList<>();

    @Override
    public void add(Food food) {
        System.out.println("delivery to garbage");
        foods.add(food);
    }
}

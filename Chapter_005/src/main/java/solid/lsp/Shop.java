package solid.lsp;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Store {
    private List<Food> foods = new ArrayList<>();

    @Override
    public void add(Food food) {
        System.out.println("delivery to the shop");
        foods.add(food);
    }

    @Override
    public boolean accept(Food food) {
       double result = this.getFreshness(food);
        if (result > 0.75 && result < 1d) {
            food.setDiscount(0.5d);
        }
        return result > 0.25 && result < 1d;
    }
}

package solid.lsp;

import java.util.ArrayList;
import java.util.List;

public class WareHouse implements Store {
    private List<Food> foods;

    public WareHouse(List<Food> foods) {
        this.foods = foods;
    }

    public static WareHouse getEmptyInstance() {
        return new WareHouse(new ArrayList<>());
    }

    @Override
    public void add(Food food) {
        System.out.println("delivery to the warehouse");
        foods.add(food);
    }

    @Override
    public boolean accept(Food food) {
        double result = this.getFreshness(food);
        return result < 0.25;
    }

    @Override
    public List<Food> getAll() {
        return foods;
    }
}

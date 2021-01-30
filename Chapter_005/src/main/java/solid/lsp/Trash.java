package solid.lsp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Trash implements Store {
    private List<Food> foods = new ArrayList<>();

    @Override
    public void add(Food food) {
        System.out.println("delivery to garbage");
        foods.add(food);
    }

    @Override
    public boolean accept(Food food) {
        long lifeCircle = food.getExpireDate().getTime() - food.getCreateDate().getTime();
        long timeAfterCreate = new Date().getTime() - food.getCreateDate().getTime();
        double result = (double) timeAfterCreate / lifeCircle;
        return result > 1d;
    }
}

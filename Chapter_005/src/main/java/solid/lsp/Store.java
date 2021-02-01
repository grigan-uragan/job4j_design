package solid.lsp;

import java.util.Date;

public interface Store {

    void add(Food food);

    boolean accept(Food food);

    default double getFreshness(Food food) {
        long lifeCircle = food.getExpireDate().getTime() - food.getCreateDate().getTime();
        long timeAfterCreate = new Date().getTime() - food.getCreateDate().getTime();
        return (double) timeAfterCreate / lifeCircle;
    }
}

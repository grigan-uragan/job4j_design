package solid.lsp;

import java.util.Calendar;
import java.util.Date;

public class ControlQuality {
    private Store store;
    private Food food;

    public ControlQuality(Food food) {
        this.food = food;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    private double controlDate() {
        long lifeCircle = food.getExpireDate().getTime() - food.getCreateDate().getTime();
        long timeAfterCreate = new Date().getTime() - food.getCreateDate().getTime();
        return (double) timeAfterCreate / lifeCircle;
    }

    public void logistic() {
        double foodQuality = controlDate();
        if (foodQuality < 0.25) {
            setStore(new WareHouse());
            store.add(food);
        } else if (foodQuality > 0.25 && foodQuality < 1d) {
            setStore(new Shop());
            if (foodQuality > 0.75) {
                food.setDiscount(0.5);
            }
            store.add(food);
        } else {
            setStore(new Trash());
            store.add(food);
        }
    }

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021, Calendar.JANUARY, 1);
        Date create = calendar.getTime();
        calendar.set(2021, Calendar.JANUARY, 31);
        Date exp = calendar.getTime();
        Food cheese = new Food("cheese", exp, create, 1000d, 0);
        ControlQuality controlQuality = new ControlQuality(cheese);
        controlQuality.logistic();
    }
}

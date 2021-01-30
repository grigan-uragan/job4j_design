package solid.lsp;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ControlQuality {
    private List<Store> stores;
    private Food food;

    public ControlQuality(Food food) {
        this.food = food;
    }

    public List<Store> getStores() {
        return stores;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }

    public void logistic() {
        if (stores == null) {
            throw new IllegalStateException("add store");
        }
        for (Store store : stores) {
            if (store.accept(food)) {
                store.add(food);
                break;
            }
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
        controlQuality.setStores(List.of(new Trash(), new Shop(), new WareHouse()));
        controlQuality.logistic();
    }
}

package solid.lsp;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ControlQuality {
    private List<Store> stores;

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }

    public void logistic(Food food) {
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

    void restore() {
        List<Food> foods = stores.stream()
                .flatMap(store -> store.getAll().stream())
                .collect(Collectors.toList());
        stores.forEach(store -> store.getAll().clear());
        foods.forEach(this::logistic);
    }

    public static void main(String[] args) throws InterruptedException {
        long createInMillis = new Date().getTime();
        Date create = new Date(createInMillis);
        Date exp = new Date(createInMillis + 5000);
        Food cheese = new Food("cheese", exp, create, 1000d, 0);
        ControlQuality controlQuality = new ControlQuality();
        controlQuality.setStores(List.of(Trash.getEmptyInstance(),
                Shop.getEmptyInstance(), WareHouse.getEmptyInstance()));
        controlQuality.logistic(cheese);
        Thread.sleep(2000);
        controlQuality.restore();
        Thread.sleep(3000);
        controlQuality.restore();
    }
}

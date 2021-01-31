package solid.lsp;

public interface Store {

    void add(Food food);

    boolean accept(Food food);
}

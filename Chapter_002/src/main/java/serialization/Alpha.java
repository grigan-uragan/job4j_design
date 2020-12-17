package serialization;

import org.json.JSONPropertyIgnore;

public class Alpha {
    private Betta betta;

    @JSONPropertyIgnore
    public Betta getBetta() {
        return betta;
    }

    public void setBetta(Betta betta) {
        this.betta = betta;
    }

    public String sayHello() {
        return "Hello";
    }
}

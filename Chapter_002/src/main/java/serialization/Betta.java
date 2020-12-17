package serialization;

import org.json.JSONObject;

public class Betta {
    private Alpha alpha;

    public Alpha getAlpha() {
        return alpha;
    }

    public void setAlpha(Alpha alpha) {
        this.alpha = alpha;
    }

    public static void main(String[] args) {
        Alpha alpha = new Alpha();
        Betta betta = new Betta();
        alpha.setBetta(betta);
        betta.setAlpha(alpha);
        System.out.println(new JSONObject(betta));
        System.out.println(new JSONObject(alpha));
    }
}

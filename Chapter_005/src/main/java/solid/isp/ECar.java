package solid.isp;

public class ECar implements Auto {
    @Override
    public int move() {
        return 0;
    }

    @Override
    public double fuelLevel() {
        throw new UnsupportedOperationException();
    }

    public void charge() {
        System.out.println("insert the plug into the socket");
    }
}

interface Auto {
    int move();

    double fuelLevel();
}

package solid.lsp;

public class AutoParking implements Parking {
    private Auto[] carPlace;
    private Auto[] truckPlace;

    public AutoParking(int cars, int trucks) {
        this.carPlace = new Auto[cars];
        this.truckPlace = new Auto[trucks];
    }

    @Override
    public boolean parkIn(Auto auto) {
       return false;
    }

    @Override
    public boolean parkOut(Auto auto) {
        return false;
    }
}

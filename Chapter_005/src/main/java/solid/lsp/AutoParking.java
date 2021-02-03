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
        if (auto.size() > 1) {
            if (parkingMove(truckPlace, null, auto)) {
                return true;
            }
            int carSize = auto.size();
            for (int i = 0; i < carPlace.length; i++) {
                if (carPlace[i] == null) {
                   if (checkEmptyParkingPlace(i, carSize)) {
                       standByTruckOnCarPlaces(auto, i, carSize);
                       return true;
                   }
                }
            }
        } else  {
            if (parkingMove(carPlace, null, auto)) {
                return true;
            }
        }
       return false;
    }

    @Override
    public boolean parkOut(Auto auto) {
        int carSize = auto.size();
        if (carSize > 1) {
            if (parkingMove(truckPlace, auto, null)) {
                return true;
            }
            for (int i = 0; i < carPlace.length; i++) {
                if (carPlace[i].equals(auto)) {
                    carPlace[i] = null;
                    carSize--;
                    if (carSize == 0) {
                        return true;
                    }
                }
            }
        } else {
            if (parkingMove(carPlace, auto, null)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkEmptyParkingPlace(int indexStart, int size) {
        for (int i = indexStart; i < carPlace.length; i++) {
            if (carPlace[i] == null) {
                size--;
                if (size == 0) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }

    private void standByTruckOnCarPlaces(Auto auto, int start, int size) {
        for (int i = start; i < size; i++) {
            carPlace[i] = auto;
        }
    }

    private boolean parkingMove(Auto[] parking, Auto target, Auto forChange) {
        for (int i = 0; i < parking.length; i++) {
            if (target != null && target.equals(parking[i]) || parking[i] == target) {
                parking[i] = forChange;
                return true;
            }
        }
        return false;
    }
}

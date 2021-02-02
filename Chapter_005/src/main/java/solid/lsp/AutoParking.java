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
            for (int i = 0; i < truckPlace.length; i++) {
                if (truckPlace[i] == null) {
                    truckPlace[i] = auto;
                    return true;
                }
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
            for (int i = 0; i < carPlace.length; i++) {
                if (carPlace[i] == null) {
                    carPlace[i] = auto;
                    return true;
                }
            }
        }
       return false;
    }

    @Override
    public boolean parkOut(Auto auto) {
        int carSize = auto.size();
        if (carSize > 1) {
            for (int i = 0; i < truckPlace.length; i++) {
               if (truckPlace[i].equals(auto)) {
                   truckPlace[i] = null;
                   return true;
               }
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
            for (int i = 0; i < carPlace.length; i++) {
                if (carPlace[i].equals(auto)) {
                    carPlace[i] = null;
                    return true;
                }
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
}

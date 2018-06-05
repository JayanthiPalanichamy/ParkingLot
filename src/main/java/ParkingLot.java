import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private final int maxSpacesAvailable;
    private List<Car> parkedCarList;

    public ParkingLot(int maxSpacesAvailable) {
        this.maxSpacesAvailable = maxSpacesAvailable;
        parkedCarList = new ArrayList<>();
    }

    public int park(Car car) {
        if(parkedCarList.size()< maxSpacesAvailable) {
            parkedCarList.add(car);
            return maxSpacesAvailable - parkedCarList.size();
        }
        else return -1;
    }

    public int unPark(Car car) {
        for (int i = 0; i < parkedCarList.size(); i++) {
            if(parkedCarList.get(i) == car) parkedCarList.remove(i);
        }
        return maxSpacesAvailable - parkedCarList.size();

    }
}

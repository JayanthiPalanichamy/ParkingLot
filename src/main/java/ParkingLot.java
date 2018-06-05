import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private final int maxSpacesAvaliable;
    private List<Car> parkedCarList;

    public ParkingLot(int maxSpacesAvaliable) {
        this.maxSpacesAvaliable = maxSpacesAvaliable;
        parkedCarList = new ArrayList<>();
    }

    public int park(Car car) {
        if(parkedCarList.size()<maxSpacesAvaliable) {
            parkedCarList.add(car);
            return maxSpacesAvaliable - parkedCarList.size();
        }
        else return -1;
    }
}

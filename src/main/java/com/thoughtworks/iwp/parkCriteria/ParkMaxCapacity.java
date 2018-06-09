import java.util.Comparator;
import java.util.List;

public class ParkMaxCapacity implements ParkCriteria {
    @Override
    public ParkingLot giveParkingLot(List<ParkingLot> parkingLotList) {
        return parkingLotList.stream().filter(parking -> parking.isNotFull()).sorted(Comparator.comparing(ParkingLot::capacity).reversed()).findFirst().orElse(null);
    }
}

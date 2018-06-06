import java.util.Comparator;
import java.util.List;

public class ParkMaxAvailable implements ParkCriteria {
    @Override
    public ParkingLot giveParkingLot(List<ParkingLot> parkingLotList) {
        return parkingLotList.stream().filter(parking -> parking.isNotFull()).sorted(Comparator.comparing(ParkingLot::getAvailableSpaces).reversed()).findFirst().orElse(null);
    }
}

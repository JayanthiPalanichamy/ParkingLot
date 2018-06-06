
import java.util.ArrayList;
import java.util.List;

public class ParkingLotAttendant {
    private final Criteria criteria;
    private List<ParkingLot> parkingLotList;

    public ParkingLotAttendant(Criteria criteria) {
        this.criteria = criteria;
        this.parkingLotList = new ArrayList<>();
    }

    public static ParkingLotAttendant createFirstPark() {
        return new ParkingLotAttendant(Criteria.PARK_FIRST);
    }

    public static ParkingLotAttendant createMaxPark() {
        return new ParkingLotAttendant(Criteria.PARK_MAX);
    }

    public static ParkingLotAttendant createAvailablePark() {
        return new ParkingLotAttendant(Criteria.PARK_MAX_AVAILABLE);
    }

    public void addParkingLot(ParkingLot parkingLot) {
        parkingLotList.add(parkingLot);
    }

    public Object park(Object car) throws ParkingLotException {
        ParkCriteria parkCriteria = selectCriteria(criteria);
        ParkingLot parkingLot =  parkCriteria.giveParkingLot(parkingLotList);
        if (parkingLot == null) throw new FullParkingLot("All the parking lotS are full");
        return parkingLot.park(car);
    }

    private ParkCriteria selectCriteria(Criteria criteria) {
        switch (criteria){
            case PARK_FIRST: return new ParkFirst();
            case PARK_MAX: return new ParkMaxCapacity();
            case PARK_MAX_AVAILABLE: return new ParkMaxAvailable();
            default: return new ParkFirst();
        }
    }

    public Object unPark(Object ticket) {
        ParkingLot parkingLot = parkingLotList.stream().filter(parking -> parking.hasTicket(ticket)).findFirst().orElse(null);
        if (parkingLot == null) throw new CarNotFound("Cannot find your car anywhere");
        return parkingLot.unPark(ticket);
    }
}

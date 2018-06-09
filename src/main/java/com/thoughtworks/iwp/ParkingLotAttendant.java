
import java.util.ArrayList;
import java.util.List;

public class ParkingLotAttendant {
    private final ParkCriteria parkCriteria;
    private List<ParkingLot> parkingLotList;

    public ParkingLotAttendant(ParkCriteria parkCriteria) {
        this.parkCriteria = parkCriteria;
        this.parkingLotList = new ArrayList<>();
    }

    public static ParkingLotAttendant createFirstPark() {
        return new ParkingLotAttendant(new ParkFirst());
    }

    public static ParkingLotAttendant createMaxPark() {
        return new ParkingLotAttendant(new ParkMaxCapacity());
    }

    public static ParkingLotAttendant createAvailablePark() {
        return new ParkingLotAttendant(new ParkMaxAvailable());
    }

    public void addParkingLot(ParkingLot parkingLot) {
        parkingLotList.add(parkingLot);
    }

    public Object park(Object car) throws ParkingLotException {
        ParkingLot parkingLot =  parkCriteria.giveParkingLot(parkingLotList);
        if (parkingLot == null) throw new FullParkingLot("All the parking lotS are full");
        return parkingLot.park(car);
    }

    public Object unPark(Object ticket) {
        ParkingLot parkingLot = parkingLotList.stream().filter(parking -> parking.hasTicket(ticket)).findFirst().orElse(null);
        if (parkingLot == null) throw new CarNotFound("Cannot find your car anywhere");
        return parkingLot.unPark(ticket);
    }
}

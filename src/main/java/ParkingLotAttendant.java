import java.util.ArrayList;
import java.util.List;

public class ParkingLotAttendant {
    private List<ParkingLot> parkingLotList;

    public ParkingLotAttendant() {
        this.parkingLotList = new ArrayList<>();
    }

    public void addParkingLot(ParkingLot parkingLot) {
        parkingLotList.add(parkingLot);
    }

    public Object park(Object car) throws ParkingLotException {
        ParkingLot parkingLot = parkingLotList.stream().filter(parking -> parking.isNotFull()).findFirst().orElse(null);
        if (parkingLot == null) throw new FullParkingLot("All the parking lotS are full");
        return parkingLot.park(car);
    }

    public Object unPark(Object ticket) {
        ParkingLot parkingLot = parkingLotList.stream().filter(parking -> parking.hasTicket(ticket)).findFirst().orElse(null);
        if (parkingLot == null) throw new CarNotFound("Cannot find your car anywhere");
        return parkingLot.unPark(ticket);
    }
}

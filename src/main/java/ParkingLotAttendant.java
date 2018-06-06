import java.util.ArrayList;
import java.util.List;

public class ParkingLotAttendant {
    private final ParkingLotAssistant parkingLotAssistant;
    private List<ParkingLot> parkingLotList;

    public ParkingLotAttendant(ParkingLotAssistant parkingLotAssistant) {
        this.parkingLotAssistant = parkingLotAssistant;
        this.parkingLotList = new ArrayList<>();
    }

    public void addParkingLot(ParkingLot parkingLot) {
        parkingLotList.add(parkingLot);
    }

    public Object park(Object car) throws ParkingLotException {
        for (ParkingLot parkingLot : parkingLotList) {
            if (!parkingLot.isNotFull())
                parkingLotAssistant.sendFullNotification("Parking Lot " + (parkingLotList.indexOf(parkingLot) + 1) + " is full");
            else return parkingLot.park(car);
        }
        throw new FullParkingLot("All the parking lotS are full");
    }

    public Object unPark(Object ticket) {
        ParkingLot parkingLotWithCar = parkingLotList.stream().filter(parkingLot -> parkingLot.hasTicket(ticket)).findFirst().orElse(null);
        if (parkingLotWithCar == null) throw new CarNotFound("Cannot find your car anywhere");
        return parkingLotWithCar.unPark(ticket);
    }
}

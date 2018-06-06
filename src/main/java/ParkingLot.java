import java.util.HashMap;

public class ParkingLot {
    private final int maxSpacesAvailable;
    private final ParkingLotOwner parkingLotOwner;
    private HashMap<Object, Object> parkedCarMap;

    public ParkingLot(int maxSpacesAvailable, ParkingLotOwner parkingLotOwner) {
        this.maxSpacesAvailable = maxSpacesAvailable;
        this.parkingLotOwner = parkingLotOwner;
        parkedCarMap = new HashMap<>();
    }

    public Object park(Object car) throws ParkingLotException {
        if (parkedCarMap.size() >= maxSpacesAvailable) {
            parkingLotOwner.sendNotification("Parking lot is full");
            throw new FullParkingLot("You cannot park your car because parking lot is full");
        }
        Object ticket = new Object();
        parkedCarMap.put(ticket, car);
        return ticket;
    }

    public Object unPark(Object ticket) throws ParkingLotException {
        if (parkedCarMap.isEmpty()) throw new EmptyParkingLot("The parking lot is empty");
        Object car = parkedCarMap.get(ticket);
        if (car == null) throw new CarNotFound("Your car is not found");
        parkedCarMap.remove(ticket);
        return car;
    }

    public boolean isNotFull() {
        return parkedCarMap.size() < maxSpacesAvailable;
    }

    public boolean hasTicket(Object ticket) {
        return parkedCarMap.containsKey(ticket);
    }

    public boolean isEmpty() {
        return parkedCarMap.isEmpty();
    }
}

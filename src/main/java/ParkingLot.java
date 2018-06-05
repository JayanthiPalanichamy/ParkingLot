import java.util.HashMap;

public class ParkingLot {
    private final int maxSpacesAvailable;
    private final ParkingLotOwner parkingLotOwner;
    private HashMap<Object,Object> parkedCarMap;

    public ParkingLot(int maxSpacesAvailable, ParkingLotOwner parkingLotOwner) {
        this.maxSpacesAvailable = maxSpacesAvailable;
        this.parkingLotOwner = new ParkingLotOwner();
        parkedCarMap = new HashMap<>();
    }

    public Object park(Object car) throws ParkingLotException {
        if (parkedCarMap.size() >= maxSpacesAvailable) {
            parkingLotOwner.sendNotification("Parking lot is full");
            throw new FullParkingLot("You cannot park your car because parking lot is full");
        }
        Object ticket = new Object();
        parkedCarMap.put(ticket,car);
        return ticket;
    }

    public Object unPark(Object ticket) throws ParkingLotException {
        if(parkedCarMap.isEmpty()) throw new EmptyParkingLot("The parking lot is empty");
        for (Object ticketObject: parkedCarMap.keySet()
             ) {
            if(ticketObject == ticket) {
                Object car  = parkedCarMap.get(ticket);
                parkedCarMap.remove(ticket);
                return car;
            }
        }
        throw new CarNotFound("Cannot find the car for your ticket");
    }

    public boolean isNotFull(){
        return parkedCarMap.size() < maxSpacesAvailable;
    }

    public boolean hasTicket(Object ticket) {
        return parkedCarMap.containsKey(ticket);
    }
}

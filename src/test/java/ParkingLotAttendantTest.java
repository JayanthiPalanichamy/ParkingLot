import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParkingLotAssistantTest {
    Object car;
    ParkingLot parkingLot1;
    ParkingLot parkingLot2;
    ParkingLotAttendant parkingLotAttendant;
    ParkingLotOwner parkingLotOwner;

    @Before
    public void setUp() {
        car = new Object();
        parkingLotOwner = new ParkingLotOwner();
        parkingLot1 = new ParkingLot(2, parkingLotOwner);
        parkingLot2 = new ParkingLot(2, parkingLotOwner);
        parkingLotAttendant = new ParkingLotAttendant();
        parkingLotAttendant.addParkingLot(parkingLot1);
        parkingLotAttendant.addParkingLot(parkingLot2);
    }

    @Test
    public void returnTicketWhenParkingLotAssistantParksTheCar() {
        Object car = new Object();

        assertEquals(Object.class, parkingLotAttendant.park(car).getClass());
    }

    @Test
    public void returnCarWhenTicketIsGivenToParkingLotAssistant() {
        Object car = new Object();
        Object ticket = parkingLotAttendant.park(car);

        assertEquals(car, parkingLotAttendant.unPark(ticket));
    }

    @Test(expected = CarNotFound.class)
    public void throwExceptionWhenCarIsNotFoundByParkingLotAssistant() {
        Object ticket = new Object();
        parkingLotAttendant.unPark(ticket);
    }

    @Test(expected = FullParkingLot.class)
    public void throwExceptionWhenAllTheParkingLotIsFull() {
        Object car1 = new Object();
        Object car2 = new Object();
        Object car3 = new Object();
        Object car4 = new Object();
        Object car5 = new Object();
        parkingLotAttendant.park(car1);
        parkingLotAttendant.park(car2);
        parkingLotAttendant.park(car3);
        parkingLotAttendant.park(car4);
        parkingLotAttendant.park(car5);
    }
}

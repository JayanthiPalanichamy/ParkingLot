import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParkingLotAttendantTest {
    Object car;
    ParkingLot parkingLot1;
    ParkingLot parkingLot2;
    ParkingLotAttendant parkingLotAttendant;

    @Before
    public void setUp() {
        car = new Object();
        parkingLot1 = new ParkingLot(2);
        parkingLot2 = new ParkingLot(4);
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

    @Test
    public void parkInTheFirstAvailableParkingLot(){
        parkingLotAttendant.park(car);

        assertEquals(1,parkingLot1.getAvailableSpaces());
    }
}

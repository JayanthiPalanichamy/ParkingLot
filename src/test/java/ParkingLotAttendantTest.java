import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParkingLotAttendantTest {
    Object car1;
    Object car2;
    Object car3;
    Object car4;
    ParkingLot parkingLot1;
    ParkingLot parkingLot2;
    ParkingLotAttendant parkingLotAttendant;

    @Before
    public void setUp() {
        car1 = new Object();
        car2 = new Object();
        car3 = new Object();
        car4 = new Object();
        parkingLot1 = new ParkingLot(2);
        parkingLot2 = new ParkingLot(4);
        parkingLotAttendant = new ParkingLotAttendant(Criteria.PARK_FIRST);
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
        Object car5 = new Object();
        Object car6 = new Object();
        Object car7 = new Object();
        parkingLotAttendant.park(car1);
        parkingLotAttendant.park(car2);
        parkingLotAttendant.park(car3);
        parkingLotAttendant.park(car4);
        parkingLotAttendant.park(car5);
        parkingLotAttendant.park(car6);
        parkingLotAttendant.park(car7);
    }

    @Test
    public void parkInTheFirstAvailableParkingLot() {
        ParkingLotAttendant parkingAttendantFirstPark = ParkingLotAttendant.createFirstPark();
        parkingAttendantFirstPark.addParkingLot(parkingLot1);
        parkingAttendantFirstPark.addParkingLot(parkingLot2);
        parkingAttendantFirstPark.park(car4);

        assertEquals(1, parkingLot1.getAvailableSpaces());
    }

    @Test
    public void parkInParkingLotWithLargestSpaces() {
        ParkingLotAttendant parkingAttendantMaxCapacity = ParkingLotAttendant.createMaxPark();
        parkingAttendantMaxCapacity.addParkingLot(parkingLot1);
        parkingAttendantMaxCapacity.addParkingLot(parkingLot2);
        parkingAttendantMaxCapacity.park(car4);

        assertEquals(3, parkingLot2.getAvailableSpaces());
    }

    @Test
    public void parkInParkingLotWithLargestAvailableSpace() {
        ParkingLotAttendant parkingAttendantMaxAvailable = ParkingLotAttendant.createAvailablePark();
        parkingAttendantMaxAvailable.addParkingLot(parkingLot1);
        parkingAttendantMaxAvailable.addParkingLot(parkingLot2);
        parkingAttendantMaxAvailable.park(car4);
        parkingAttendantMaxAvailable.park(car1);
        parkingAttendantMaxAvailable.park(car2);

        assertEquals(1, parkingLot1.getAvailableSpaces());
    }
}

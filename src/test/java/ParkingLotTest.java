import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParkingLotTest {
    Object car;
    ParkingLot parkingLot1;
    ParkingLot parkingLot2;
    ParkingLotOwner parkingLotOwner;

    @Before
    public void setUp() {
        car = new Object();
        parkingLotOwner = new ParkingLotOwner();
        parkingLot1 = new ParkingLot(2, parkingLotOwner);
        parkingLot2 = new ParkingLot(2, parkingLotOwner);
    }

    @Test
    public void returnParkingTicketAfterParkingOneCar() {
        assertEquals(Object.class, parkingLot1.park(car).getClass());
    }

    @Test(expected = FullParkingLot.class)
    public void throwExceptionWhenTheParkingLotIsFull() {
        Object car1 = new Object();
        Object car2 = new Object();
        Object car3 = new Object();

        parkingLot2.park(car1);
        parkingLot2.park(car2);
        parkingLot2.park(car3);
    }

    @Test
    public void returnCarWhenTicketIsPassedToUnPark() {
        Object ticket = parkingLot1.park(car);

        assertEquals(car, parkingLot1.unPark(ticket));
    }

    @Test(expected = EmptyParkingLot.class)
    public void throwExceptionWhenEmptyParkingLotIsUnParked() {
        Object ticket = parkingLot2.park(car);
        parkingLot1.unPark(ticket);
    }

    @Test(expected = CarNotFound.class)
    public void throwExceptionWhenCarIsNotFound() {
        parkingLot1.park(car);
        Object car1 = new Object();
        Object ticket1 = parkingLot2.park(car1);
        parkingLot1.unPark(ticket1);
    }

}

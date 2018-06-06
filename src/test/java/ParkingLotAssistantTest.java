import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class ParkingLotAssistantTest {
    ParkingLotOwner parkingLotOwner;
    ParkingLot parkingLot1;
    ParkingLot parkingLot2;
    ParkingLotAssistant parkingLotAssistant;
    ParkingLotAttendant parkingLotAttendant;
    Object car1;
    Object car2;
    Object car3;

    @Before
    public void setUp(){
        parkingLotOwner = new ParkingLotOwner();
        parkingLot1 = new ParkingLot(2,parkingLotOwner);
        parkingLot2 = new ParkingLot(2,parkingLotOwner);
        parkingLotAssistant = new ParkingLotAssistant();
        parkingLotAttendant = new ParkingLotAttendant(parkingLotAssistant);
        parkingLotAttendant.addParkingLot(parkingLot1);
        parkingLotAttendant.addParkingLot(parkingLot2);
        car1 = new Object();
        car2 = new Object();
        car3 = new Object();
    }

    @Test
    public void assistantGetNotifiedWhenParkingLotIsFull(){
        parkingLotAttendant.park(car1);
        parkingLotAttendant.park(car2);
        parkingLotAttendant.park(car3);

        assertTrue(parkingLotAssistant.isFullNotified());

    }

    @Test
    public void assistantGetNotifiedWhenParkingLotIsEmpty() {
        Object ticket =parkingLotAttendant.park(car1);
        parkingLotAttendant.unPark(ticket);

        assertTrue(parkingLotAssistant.isEmptyNotified());
    }
}

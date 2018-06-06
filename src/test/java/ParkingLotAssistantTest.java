import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class ParkingLotAssistantTest {
    @Test
    public void assistantGetNotifiedWhenParkingLotIsFull(){
        ParkingLotOwner parkingLotOwner = new ParkingLotOwner();
        ParkingLot parkingLot1 = new ParkingLot(2,parkingLotOwner);
        ParkingLot parkingLot2 = new ParkingLot(2,parkingLotOwner);
        ParkingLotAssistant parkingLotAssistant = new ParkingLotAssistant();
        ParkingLotAttendant parkingLotAttendant = new ParkingLotAttendant(parkingLotAssistant);
        parkingLotAttendant.addParkingLot(parkingLot1);
        parkingLotAttendant.addParkingLot(parkingLot2);
        Object car1 = new Object();
        Object car2 = new Object();
        Object car3 = new Object();
        parkingLotAttendant.park(car1);
        parkingLotAttendant.park(car2);
        parkingLotAttendant.park(car3);

        assertTrue(parkingLotAssistant.isNotified());

    }
}

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class ParkingLotOwnerTest {

    @Test(expected = FullParkingLot.class)
    public void returnTrueForIsNotifiedByOwnerWhenParkingLotIsFull() {
        Listener parkingLotOwner = new ParkingLotOwner();
        ParkingLot parkingLot = new ParkingLot(2);
        parkingLot.assignListener(parkingLotOwner);
        Object car1 = new Object();
        Object car2 = new Object();
        Object car3 = new Object();
        parkingLot.park(car1);
        parkingLot.park(car2);
        parkingLot.park(car3);

        assertTrue(parkingLotOwner.isEmptyNotified());
    }
}

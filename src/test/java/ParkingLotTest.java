import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParkingLotTest {
    @Test
    public void returnNoOfEmptySpacesAs24AfterParkingOneCar() {
        Car car = new Car("Benz",12334);
        ParkingLot parkingLot = new ParkingLot(25);
        assertEquals(24,parkingLot.park(car));
    }


}

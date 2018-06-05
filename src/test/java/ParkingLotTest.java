import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParkingLotTest {
    @Test
    public void returnNoOfEmptySpacesAs24AfterParkingOneCar() {
        Car car = new Car("Benz",12334);
        ParkingLot parkingLot = new ParkingLot(25);

        assertEquals(24,parkingLot.park(car));
    }

    @Test
    public void returnMinus1WhenTheParkingLotIsFull() {
        Car car1 = new Car("Benz",12334);
        Car car2 = new Car("Mercedes",12336);
        Car car3 = new Car("Ferrari",12338);
        ParkingLot parkingLot = new ParkingLot(2);
        parkingLot.park(car1);
        parkingLot.park(car2);

        assertEquals(-1,parkingLot.park(car3));
    }

    @Test
    public void returnNoOfEmptySpacesAs25AfterUnParking() {
        Car car = new Car("Benz",12334);
        ParkingLot parkingLot = new ParkingLot(25);
        parkingLot.park(car);
        assertEquals(25,parkingLot.unPark(car));
    }
}

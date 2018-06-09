package com.thoughtworks.iwp;

import com.thoughtworks.iwp.exception.FullParkingLot;
import com.thoughtworks.iwp.listeners.ParkingLotAssistant;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class ParkingLotAssistantTest {
    ParkingLot parkingLot1;
    ParkingLotAssistant parkingLotAssistant;
    Object car1;
    Object car2;
    Object car3;

    @Before
    public void setUp() {
        parkingLotAssistant = new ParkingLotAssistant();
        parkingLot1 = new ParkingLot(2);
        parkingLot1.assignListener(parkingLotAssistant);
        car1 = new Object();
        car2 = new Object();
        car3 = new Object();
    }

    @Test(expected = FullParkingLot.class)
    public void assistantGetNotifiedWhenParkingLotIsFull() {
        parkingLot1.park(car1);
        parkingLot1.park(car2);
        parkingLot1.park(car3);

        assertTrue(parkingLotAssistant.isFullNotified());
    }

    @Test
    public void assistantGetNotifiedWhenParkingLotIsEmpty() {
        Object ticket = parkingLot1.park(car1);
        parkingLot1.unPark(ticket);

        assertTrue(parkingLotAssistant.isEmptyNotified());
    }
}

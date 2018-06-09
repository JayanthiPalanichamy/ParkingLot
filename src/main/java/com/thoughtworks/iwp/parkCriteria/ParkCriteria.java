package com.thoughtworks.iwp.parkCriteria;

import com.thoughtworks.iwp.ParkingLot;

import java.util.List;

public interface ParkCriteria {
    ParkingLot giveParkingLot(List<ParkingLot> parkingLotList);
}

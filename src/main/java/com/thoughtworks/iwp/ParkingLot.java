package com.thoughtworks.iwp;

import com.thoughtworks.iwp.exception.CarNotFound;
import com.thoughtworks.iwp.exception.EmptyParkingLot;
import com.thoughtworks.iwp.exception.FullParkingLot;
import com.thoughtworks.iwp.exception.ParkingLotException;
import com.thoughtworks.iwp.listeners.Listener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParkingLot {
    private final int maxSpacesAvailable;
    private HashMap<Object, Object> parkedCarMap;
    private List<Listener> listeners;

    public ParkingLot(int maxSpacesAvailable) {
        this.maxSpacesAvailable = maxSpacesAvailable;
        parkedCarMap = new HashMap<>();
        listeners = new ArrayList<>();
    }

    public Object park(Object car) throws ParkingLotException {
        if (parkedCarMap.size() >= maxSpacesAvailable) {
            sendFullNotification();
            throw new FullParkingLot("You cannot park your car because parking lot is full");
        }
        Object ticket = new Object();
        parkedCarMap.put(ticket, car);
        return ticket;
    }

    private void sendFullNotification() {
        for (Listener listener : listeners) {
            listener.sendFullNotification("The parking Lot is full");
        }
    }


    public Object unPark(Object ticket) throws ParkingLotException {
        if (parkedCarMap.isEmpty()) {
            throw new EmptyParkingLot("The parking lot is empty");
        }
        Object car = parkedCarMap.get(ticket);
        if (car == null) throw new CarNotFound("Your car is not found");
        parkedCarMap.remove(ticket);
        if (parkedCarMap.isEmpty()) sendEmptyNotification();
        return car;
    }

    private void sendEmptyNotification() {
        for (Listener listener : listeners) {
            listener.sendEmptyNotification("The parking Lot is Empty");
        }
    }

    public boolean isNotFull() {
        return parkedCarMap.size() < maxSpacesAvailable;
    }

    public boolean hasTicket(Object ticket) {
        return parkedCarMap.containsKey(ticket);
    }

    public void assignListener(Listener parkingLotOwner) {
        listeners.add(parkingLotOwner);
    }


    public int getAvailableSpaces() {
        return maxSpacesAvailable - parkedCarMap.size();
    }

    public int capacity() {
        return maxSpacesAvailable;
    }
}

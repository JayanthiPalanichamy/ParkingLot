package com.thoughtworks.iwp.listeners;

public class ParkingLotOwner implements Listener {
    private boolean fullNotification;
    private boolean emptyNotification;

    public ParkingLotOwner() {
        emptyNotification = false;
        fullNotification = false;
    }

    @Override
    public boolean isFullNotified() {
        return fullNotification;
    }

    @Override
    public void sendFullNotification(String message) {
        fullNotification = true;
        System.out.println(message);
    }

    @Override
    public boolean isEmptyNotified() {
        return emptyNotification;
    }

    @Override
    public void sendEmptyNotification(String message) {
        emptyNotification = true;
        System.out.println(message);
    }
}

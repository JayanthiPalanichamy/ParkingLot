

public class ParkingLotAssistant implements Listener {
    private boolean fullNotification;
    private boolean emptyNotification;

    public ParkingLotAssistant() {
        emptyNotification = false;
        fullNotification = false;
    }

    public boolean isFullNotified() {
        return fullNotification;
    }

    public void sendFullNotification(String message) {
        fullNotification = true;
        System.out.println(message);
    }

    public boolean isEmptyNotified() {
        return emptyNotification;
    }

    public void sendEmptyNotification(String message) {
        emptyNotification = true;
        System.out.println(message);
    }
}
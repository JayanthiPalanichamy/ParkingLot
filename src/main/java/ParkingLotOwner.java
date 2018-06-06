

public class ParkingLotOwner {
    private boolean fullNotification;

    public ParkingLotOwner() {
        fullNotification = false;
    }

    public boolean isNotified() {
        return fullNotification;
    }

    public void sendNotification(String message) {
        fullNotification = true;
        System.out.println(message);
    }
}

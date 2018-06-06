public class ParkingLotAssistant {
    private boolean fullNotification;

    public ParkingLotAssistant() {
        fullNotification = false;
    }

    public boolean isNotified() {
        return fullNotification;
    }

    public void sendFullNotification(String message) {
        fullNotification = true;
        System.out.println(message);
    }

}

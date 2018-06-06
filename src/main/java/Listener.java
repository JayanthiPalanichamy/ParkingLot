public interface Listener {
    boolean isFullNotified();

    void sendFullNotification(String message);

    boolean isEmptyNotified();

    void sendEmptyNotification(String message);
}

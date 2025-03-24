public class FlightTimeCalculator {
    private static final double AVERAGE_GROUND_SPEED = 450.0;

    public static String calculateFlightTime(double distance) {
        double time = distance / AVERAGE_GROUND_SPEED;
        int hours = (int) time;
        int minutes = (int) ((time - hours) * 60);
        return String.format("%02d:%02d", hours, minutes);
    }
}

public class DistanceCalculator {
    public static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        double theta = lon1 - lon2;
        double distance = Math.sin(degToRad(lat1)) * Math.sin(degToRad(lat2))
                + Math.cos(degToRad(lat1)) * Math.cos(degToRad(lat2)) * Math.cos(degToRad(theta));
        distance = Math.acos(distance);
        distance = radToDeg(distance);
        return distance * 60 * 1.1515; // Distance in miles
    }

    private static double degToRad(double deg) {
        return deg * Math.PI / 180.0;
    }

    private static double radToDeg(double rad) {
        return rad * 180.0 / Math.PI;
    }
}

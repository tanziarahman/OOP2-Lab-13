public class Flight{
private final String flightNumber;
private final String flightSchedule;
private final String fromCity;
private final String toCity;
private final String gate;
private final double distanceInMiles;
private final double distanceInKm;
private final String flightTime;
private final int numOfSeats;

public Flight(String flightNumber, String flightSchedule, String fromCity, String toCity,
              String gate, double distanceInMiles, double distanceInKm, int numOfSeats) {
    this.flightNumber = flightNumber;
    this.flightSchedule = flightSchedule;
    this.fromCity = fromCity;
    this.toCity = toCity;
    this.gate = gate;
    this.distanceInMiles = distanceInMiles;
    this.distanceInKm = distanceInKm;
    this.flightTime = FlightTimeCalculator.calculateFlightTime(distanceInMiles);
    this.numOfSeats = numOfSeats;
}

public String getFlightNumber() { return flightNumber; }
public String getFlightSchedule() { return flightSchedule; }
public String getFromCity() { return fromCity; }
public String getToCity() { return toCity; }
public String getGate() { return gate; }
public double getDistanceInMiles() { return distanceInMiles; }
public double getDistanceInKm() { return distanceInKm; }
public String getFlightTime() { return flightTime; }
public int getNumOfSeats() { return numOfSeats; }
}
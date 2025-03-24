import java.util.ArrayList;
import java.util.List;

public class FlightScheduler {
    private final List<Flight> flightList = new ArrayList<>();

    public void scheduleFlight(Flight flight) {
        flightList.add(flight);
    }

    public void cancelFlight(String flightNumber) {
        flightList.removeIf(flight -> flight.getFlightNumber().equalsIgnoreCase(flightNumber));
    }

    public List<Flight> getFlights() {
        return new ArrayList<>(flightList);
    }
}

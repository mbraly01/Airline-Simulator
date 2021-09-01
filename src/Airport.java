import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

public class Airport {


    private ArrayList<Flight> arrivals;
    private ArrayList<Flight> departures;
    private HashMap<Plane, Integer> planes;
    private Queue<Passenger> passengers;
    private String name;

    public Airport() {}
    public Airport(String name) {
        this.name = name;
    }

    public String getName() { return name;}

    public void addArrivals(Flight arrival) {
        this.arrivals.add(arrival);
    }

    public ArrayList<Flight> getArrivals() {
        return this.arrivals;
    }

    public void addDepartures(Flight departure) {
        this.departures.add(departure);
    }

    public ArrayList<Flight> getDeparturues() {
        return this.departures;
    }

    public void setDepartures(ArrayList<Flight> departures) {
        this.departures = departures;
    }

    public HashMap<Plane, Integer> getPlanes() {
        return this.planes;
    }

    public void setPlanes(HashMap planes) {
        this.planes = planes;
    }

    public void addPlane(Plane plane) {
        planes.put(plane, planes.get(plane) + 1);
    }

    public void addPlane(Plane plane, int num) {
        planes.put(plane, num);
    }

    public boolean removePlane(Plane plane) {
        if (planes.get(plane) != 0) {
            planes.put(plane, planes.get(plane) - 1);
            return true;
        }
        return false;
    }

    public Queue<Passenger> getPassengers() {
        return passengers;
    }

    public void addPassenger(Passenger pass) {
        this.passengers.add(pass);
    }

    public Passenger removePassenger() {
        return this.passengers.remove();
    }

}

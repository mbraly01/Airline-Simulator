import java.util.ArrayList;
import java.util.HashMap;

public class Airport {



    private ArrayList<Flight> flightsIn;
    private ArrayList<Flight> flightsOut;
    private HashMap<String, Integer> planes;
    private String name;

    public Airport(String name) {
        this.name = name;
    }

    public ArrayList<Flight> getFlightsIn() {
        return this.flightsIn;
    }

    public void setFlightsIn(ArrayList<Flight> flightsIn) {
        this.flightsIn = flightsIn;
    }

    public ArrayList<Flight> getFlightsOut() {
        return this.flightsOut;
    }

    public void setFlightsOut(ArrayList<Flight> flightsOut) {
        this.flightsOut = flightsOut;
    }

    public HashMap<String, Integer> getPlanes() {
        return this.planes;
    }

    public void setPlanes(HashMap planes) {
        this.planes = planes;
    }

    public void addPlane(String plane) {
        planes.put(plane, planes.get(plane) + 1);
    }

    public boolean removePlane(String plane) {
        if (planes.get(plane) != 0) {
            planes.put(plane, planes.get(plane) - 1);
            return true;
        }
        return false;
    }

}

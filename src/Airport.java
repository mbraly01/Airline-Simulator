import java.util.ArrayList;
import java.util.HashMap;

public class Airport {



    private ArrayList<Flight> flightsIn;
    private ArrayList<Flight> flightsOut;
    private HashMap<Plane, Integer> planes;
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

    public void addFlightsIn(Flight flightIn) {
        this.flightsOut.add(flightIn);
    }

    public ArrayList<Flight> getFlightsOut() {
        return this.flightsOut;
    }

    public void setFlightsOut(ArrayList<Flight> flightsOut) {
        this.flightsOut = flightsOut;
    }

    public void addFlightsOut(Flight flightOut) {
        this.flightsOut.add(flightOut);
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

}

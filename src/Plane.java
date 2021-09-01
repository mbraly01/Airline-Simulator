import java.util.LinkedList;
import java.util.Queue;

public class Plane {

    private String model;
    private int seats;
    private int weight;
    private int passCount;
    private Queue<Passenger> passengers;
    private double totalWeight;

    public Plane(String model, int seats, int weight) {
        this.model = model;
        this.seats = seats;
        this.weight = weight;
        this.totalWeight = 0;
        passengers = new LinkedList<Passenger>();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean fill(Passenger pass) {
        if (this.passCount == this.seats) return false;
        else {
            this.passengers.add(pass);
            this.passCount ++;
            return true;
        }
    }

    public Passenger removePass() {
        return this.passengers.remove();
    }

    public boolean addWeight(double lug) {
        if (this.totalWeight + lug > weight) {
            return false;
        }
        else {
            this.totalWeight += lug;
            return true;
        }
    }
}

import java.util.ArrayList;

public class Plane {

    private String model;
    private int seats;
    private int weight;
    private ArrayList<Passenger> filled;
    private double totalWeight;

    public Plane(String model, int seats, int weight) {
        this.model = model;
        this.seats = seats;
        this.weight = weight;
        this.totalWeight = 0;
        filled = new ArrayList<>();
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
        if (this.filled.size() == this.seats) return false;
        else {
            this.filled.add(pass);
            return true;
        }
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

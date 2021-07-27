public class Flight {

    private String uuid;
    private String start;
    private String end;
    private int totalSeats;
    private int seatsFilled;
    private double distance;
    private String model;
    private double totalWeight;


    public Flight(String uuid, String start, String end, double distance,
                  String model, int totalSeats, double totalWeight)
    {
        this.uuid = uuid;
        this.start= start;
        this.end = end;
        this.totalSeats = totalSeats;
        this.seatsFilled = 0;
        this.distance = distance;
        this.model = model;
        this.totalWeight = totalWeight;
    }

    public String getUUID() { return uuid; }

    public void setUUID(String uuid) {this.uuid = uuid;}

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getSeatsFilled() {
        return seatsFilled;
    }

    public void setSeatsFilled(int seatsFilled) {
        this.seatsFilled = seatsFilled;
    }

    public boolean addPassenger() {
        if (totalSeats == seatsFilled) {
            return false;
        }
        else {
            seatsFilled ++;
            return true;
        }
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }





}

public class Flight {

    private String uuid;
    private String start;
    private String end;
    private double distance;
    private int time;
    private Plane plane;


    public Flight() {}

    public Flight( String start, String end, String uuid, double distance, String time)
    {
        this.uuid = uuid;
        this.start= start;
        this.end = end;
        this.distance = distance;
        this.plane = new Plane("A1", 5, 50);
        this.time = Integer.parseInt(time);
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

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public boolean addPass(Passenger pass) {
        return plane.fill(pass);
    }

    public boolean addWeight(double lug) {
        return plane.addWeight(lug);
    }





}

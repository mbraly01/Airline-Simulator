import java.util.ArrayList;
import java.util.UUID;

public class Passenger {

    private String first;
    private String uuid;
    private String start;
    private String end;
    private ArrayList<Luggage> luggage;

    public Passenger(String start, String end, String first, String uuid) {
        this.first = first;
        this.uuid = uuid;
        this.start = start;
        this.end = end;
        this.luggage = new ArrayList<>();

    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getUuid() {
        return uuid;
    }

    public ArrayList<Luggage> getLuggage() { return luggage; }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

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

    public void addLuggage(Luggage toAdd) {
        this.luggage.add(toAdd);
    }

    public void removeLuggage(int i) {
        this.luggage.remove(i);
    }
}

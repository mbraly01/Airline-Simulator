import java.util.ArrayList;
import java.util.UUID;

public class Passenger {

    private String id;
    private String first;
    private String last;
    private String start;
    private String end;
    private String finalDestination;

    public Passenger(String first, String last, String finalDestination){
        this.first = first;
        this.last = last;
        this.finalDestination = finalDestination;
        UUID id = UUID.randomUUID();

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getFinalDestination() {
        return finalDestination;
    }

    public void setFinalDestination(String finalDestination) {
        this.finalDestination = finalDestination;
    }
}

import java.util.UUID;

public class Luggage {

    private String id;
    private String ownerId;
    private String name;
    private String color;
    private float weight;

    public Luggage(String ownerId, String name, float weight) {
        this.ownerId = ownerId;
        this.name = name;
        this.weight = weight;
        UUID id = UUID.randomUUID();
    }

    public String getId() {
        return id;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public String getName() {
        return name;
    }

    public float getWeight() {
        return weight;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}

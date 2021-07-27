import java.util.UUID;

public class Luggage {

    private String id;
    private String owner_id;
    private int lug_num;
    private String name;
    private String color;
    private float weight;

    public Luggage(String owner_id, int lug_num, String name, String color, float weight) {
        this.owner_id = owner_id;
        this.lug_num = lug_num;
        this.name = name;
        this.color = color;
        this.weight = weight;
        UUID id = UUID.randomUUID();
    }

    public String getId() {
        return id;
    }

    public String getOwner_id() {
        return owner_id;
    }

    public int getLug_num() {
        return lug_num;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public float getWeight() {
        return weight;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setOwner_id(String owner_id) {
        this.owner_id = owner_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}

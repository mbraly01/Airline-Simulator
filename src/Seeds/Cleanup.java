package Seeds;
import java.io.*;
import java.util.ArrayList;

public class Cleanup {

    static void cleanupFirst() throws IOException {
        String line = "";
        ArrayList<String> names= new ArrayList<>();

        FileReader file = new FileReader("/Users/mattbraly/Documents/Summer/Airline/src/Seeds/FirstNames.csv");
        BufferedReader csvReader = new BufferedReader(file);
        while((line = csvReader.readLine()) != null) {
            String[] rawData = line.split(",");
            String name = rawData[1];
            name = name.replaceAll("^\"|\"$", "");
            names.add(name);
        }
        File myObj = new File("First.csv");
        FileWriter writer = new FileWriter("/Users/mattbraly/Documents/Summer/Airline/src/Seeds/First.csv");
        for (int i = 0; i < names.size(); i ++) {
            writer.append(names.get(i));
            writer.append("\n");
        }
        writer.close();
    }

    public static void main(String[] args) throws IOException {
       cleanupFirst();
    }
}

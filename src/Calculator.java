import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class Calculator {

    public HashMap assignFlights() throws IOException {
        HashMap<Airport, ArrayList<Flight>> flightHash = new HashMap<>();
        File flightsFile = new File(" /Users/mattbraly/Documents/Summer/Airline/src/Records/Flights.csv");
        BufferedReader brFlights = new BufferedReader(new FileReader(flightsFile));
        String line = "";
        while ((line = brFlights.readLine()) != null) {
            String[] flightSplit = line.split(",");
            Flight tempFlight = new Flight(flightSplit[0],
                    flightSplit[1], flightSplit[2],
                    Double.parseDouble(flightSplit[3]),
                    null, null, null);
            Airport keyAirport = new Airport(flightSplit[1]);
            if (flightHash.get(keyAirport) == null) {
                ArrayList<Flight> flightArray = new ArrayList<>();
                Airport tempAirport = new Airport(flightSplit[1]);
                flightArray.add(tempFlight);
                flightHash.put(tempAirport, flightArray);
            }
            else {
                ArrayList<Flight> flightArray = flightHash.get(keyAirport);
                flightArray.add(tempFlight);
            }
        }

        return flightHash;
    }

    //Still working on this section
    public ArrayList<Flight> assignPassengers(HashMap<> Flights) {

    }
}

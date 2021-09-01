import java.io.*;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;


public class Calculator {

    public static int MAX_PLANES = 100;

    public HashMap assignAirports() throws IOException {
        File airports = new File("/Users/mattbraly/Documents/Summer/Airline/src/Seeds/us-airports.csv");
        BufferedReader br_airport = new BufferedReader(new FileReader(airports));
        HashMap<String, Airport> airportHash = new HashMap<>();
        String line = "";
        while ((line = br_airport.readLine()) != null) {
            String[] splitLine = line.split(",");
            if (splitLine[1].charAt(0) == 'K') {
                Airport temp = new Airport(splitLine[1]);
                airportHash.put(splitLine[1], temp);
            }
        }

        return airportHash;

    }

    public HashMap assignPassengers(HashMap<String, Airport> airportHash, ArrayList<Flight> flights) throws IOException {
        File passFile = new File("/Users/mattbraly/Documents/Summer/Airline/src/Records/Passengers.csv");
        BufferedReader brPassFile = new BufferedReader(new FileReader(passFile));
        String line = "";
        String prevAirport = "";
        Airport tempAirport = new Airport();
        while ((line = brPassFile.readLine()) != null) {
            String[] lineSplit = line.split(",");
            Passenger tempPass = new Passenger(lineSplit[0], lineSplit[1], lineSplit[2], lineSplit[3]);
            if (!lineSplit[0].equals(prevAirport)) {
                airportHash.put(tempAirport.getName(), tempAirport);
                tempAirport = airportHash.get(lineSplit[0]);
                prevAirport = lineSplit[0];
            }
            int i = 4;
            while (i < lineSplit.length) {
                Luggage temp = new Luggage(lineSplit[3], lineSplit[i], Float.valueOf(lineSplit[i + 1]));
                i += 2;
                tempPass.addLuggage(temp);
            }
            tempAirport.addPassenger(tempPass);
        }
        return airportHash;
    }

    //Assigns planes to airports
    public HashMap assignPlanes(HashMap<String, Airport> airportHash) throws IOException {
        Random rand = new Random();
        String[] keys = airportHash.keySet().toArray(new String[0]);
        int total_planes = MAX_PLANES;
        for (int i = 0; i < keys.length; i++) {
            File file = new File("/Users/mattbraly/Documents/Summer/Airline/src/Seeds/Models.csv");
            BufferedReader brPlanes = new BufferedReader(new FileReader(file));
            Airport tempAirport = airportHash.get(keys[i]);
            String line = "";
            while ((line = brPlanes.readLine()) != null) {
                String[] plane_split = line.split(",");
                int seats = Integer.valueOf(plane_split[1]);
                int weight = Integer.valueOf(plane_split[2]);
                Plane tempPlane = new Plane(plane_split[0], seats, weight);
                int planes = rand.nextInt(total_planes);
                total_planes -= planes;
                tempAirport.addPlane(tempPlane, planes);
            }

            airportHash.put(keys[i], tempAirport);
        }

        return airportHash;
    }

    static HashMap assignArrivals(HashMap<String, Airport> airportHash) throws IOException {
        //Opening up files
        File flightsFile = new File("/Users/mattbraly/Documents/Summer/Airline/src/Records/Arrivals.csv");
        BufferedReader brArrivals = new BufferedReader(new FileReader(flightsFile));
        String line = "";
        String prevAirport = "";
        Airport tempAirport = new Airport();
        while ((line = brArrivals.readLine()) != null) {
            String[] lineSplit = line.split(",");
            Flight tempFlight = new Flight(lineSplit[0], lineSplit[1], lineSplit[4], Double.valueOf(lineSplit[2]), lineSplit[3]);
            if (!lineSplit[0].equals(prevAirport)) {
                airportHash.put(tempAirport.getName(), tempAirport);
                tempAirport = airportHash.get(lineSplit[0]);
                prevAirport = lineSplit[0];
            }
            tempAirport.addArrivals(tempFlight);
        }
        return airportHash;
    }

    static HashMap assignDepartures(HashMap<String, Airport> airportHash) throws IOException {
        //Opening up files
        File flightsFile = new File("/Users/mattbraly/Documents/Summer/Airline/src/Records/Departures.csv");
        BufferedReader brDepartures = new BufferedReader(new FileReader(flightsFile));
        String line = "";
        String prevAirport = "";
        Airport tempAirport = new Airport();
        while ((line = brDepartures.readLine()) != null) {
            String[] lineSplit = line.split(",");
            Flight tempFlight = new Flight(lineSplit[0], lineSplit[1], lineSplit[4], Double.valueOf(lineSplit[2]), lineSplit[3]);
            if (!lineSplit[0].equals(prevAirport)) {
                airportHash.put(tempAirport.getName(), tempAirport);
                tempAirport = airportHash.get(lineSplit[0]);
                prevAirport = lineSplit[0];
            }
            tempAirport.addDepartures(tempFlight);
        }
        return airportHash;
    }


};
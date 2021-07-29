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

    //Assigns Flights to airports
//    public HashMap assignFlights() throws IOException {
//        HashMap<String, Airport> flightHash = new HashMap<>();
//        File flightsFile = new File(" /Users/mattbraly/Documents/Summer/Airline/src/Records/Flights.csv");
//        BufferedReader brFlights = new BufferedReader(new FileReader(flightsFile));
//        String line = "";
//        while ((line = brFlights.readLine()) != null) {
//            String[] flightSplit = line.split(",");
//            Flight tempFlight = new Flight(flightSplit[0],
//                    flightSplit[1], flightSplit[2],
//                    Double.parseDouble(flightSplit[3]),
//                    null,flightSplit[4]);
//            String key = flightSplit[1];
//            if (flightHash.get(key) == null) {
//                Airport tempAirport = new Airport(key);
//                tempAirport.addFlightsOut(tempFlight);
//                flightHash.put(key,tempAirport);
//                if (flightHash.get(flightSplit[2]) == null) {
//                    Airport tempAirport2 = new Airport(key);
//                    tempAirport2.addFlightsIn(tempFlight);
//                    flightHash.put(flightSplit[2], tempAirport2);
//                }
//                else {
//                    Airport tempAirport2 = flightHash.get(flightSplit[2]);
//                    tempAirport2.addFlightsIn(tempFlight);
//                    flightHash.put(flightSplit[2], tempAirport2);
//                }
//            }
//            else {
//                Airport tempAirport = flightHash.get(key);
//                tempAirport.addFlightsOut(tempFlight);
//                flightHash.put(key, tempAirport);
//                if (flightHash.get(flightSplit[2]) == null) {
//                    Airport tempAirport2 = new Airport(key);
//                    tempAirport2.addFlightsIn(tempFlight);
//                    flightHash.put(flightSplit[2], tempAirport2);
//                }
//                else {
//                    Airport tempAirport2 = flightHash.get(flightSplit[2]);
//                    tempAirport2.addFlightsIn(tempFlight);
//                    flightHash.put(flightSplit[2], tempAirport2);
//                }
//            }
//        }
//
//        return flightHash;
//    }

    //Assigns planes to airports
    public HashMap assignPlanes(HashMap<String, Airport> flightHash) throws IOException {
        Random rand = new Random();
        String[] keys = flightHash.keySet().toArray(new String[0]);
        int total_planes = MAX_PLANES;
        for (int i = 0; i < keys.length; i ++) {
            File file = new File("/Users/mattbraly/Documents/Summer/Airline/src/Seeds/Models.csv");
            BufferedReader brPlanes = new BufferedReader(new FileReader(file));
            Airport tempAirport = flightHash.get(keys[i]);
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

            flightHash.put(keys[i], tempAirport);
        }

        return flightHash;
    }

//    public HashMap countPass(HashMap<String, Airport> flightHash) throws IOException {
//        //Gets all the flights out of the hash
//        String[] keys = flightHash.keySet().toArray(new String[0]);
//        HashMap<Flight, Integer> planeHash = new HashMap<>();
//        for (int i = 0; i < keys.length; i ++) {
//            Airport tempAirport = flightHash.get(keys[i]);
//            ArrayList<Flight> flightList = tempAirport.getFlightsOut();
//            for (int j = 0; j < flightList.size(); j ++) {
//                planeHash.put(flightList.get(j), 0);
//            }
//        }
//
//        File file = new File("/Users/mattbraly/Documents/Summer/Airline/src/Records/Passengers.csv");
//        BufferedReader brPass = new BufferedReader(new FileReader(file));
//        String line = "";
//        HashMap<String, Flight> flightKeys = new HashMap<>();
//        for (Flight tempFlight : planeHash.keySet()) {
//            String combo = tempFlight.getStart() + "," + tempFlight.getEnd();
//            while (flightKeys.get(combo) != null) {
//                combo += "0";
//            }
//            flightKeys.put(combo, tempFlight);
//        }
//
//        File leftOvers = new File("/Users/mattbraly/Documents/Summer/Airline/src/Records/Leftovers.csv");
//        while ((line = brPass.readLine()) != null) {
//            String[] passSplit = line.split(",");
//            String combo = passSplit[0] + "," + passSplit[1];
//            Passenger tempPass = new Passenger(passSplit[2],
//                    passSplit[3],)
//
//        }
//
//        return null;
//    }

     static HashMap AssignFlights() throws IOException {
        //Opening up files
        File flightsFile = new File("/Users/mattbraly/Documents/Summer/Airline/src/Records/Flights.csv");
        File passFile = new File("/Users/mattbraly/Documents/Summer/Airline/src/Records/Passengers.csv");
        File leftFile = new File("/Users/mattbraly/Documents/Summer/Airline/src/Records/Leftovers.csv");
         File boardedFile = new File("/Users/mattbraly/Documents/Summer/Airline/src/Records/Boarded.csv");
        BufferedReader brFlights = new BufferedReader(new FileReader(flightsFile));
        BufferedReader brPassFile = new BufferedReader(new FileReader(passFile));
        BufferedWriter bwLeft = new BufferedWriter(new FileWriter(leftFile));
        BufferedWriter bwBoarded = new BufferedWriter(new FileWriter(boardedFile));
        DecimalFormat df = new DecimalFormat("0000");

        HashMap<String, Flight> flightsHash = new HashMap<>();
        //Starting loop by reading the first line from passenger list
        String passForLeft = brPassFile.readLine();
        String[] passSplit = passForLeft.split(",");
        double tempWeight = 0;
        String line = "";
        //loops through flight in sorted order
        while ((line = brFlights.readLine()) != null) {
            //creates a new flight
            String[] flightSplit = line.split(",");
            Flight tempFlight = new Flight(flightSplit[0], flightSplit[1],
                flightSplit[2], Double.parseDouble(flightSplit[3]),
                    flightSplit[4]);
            //creates hashmap key of start location, landing location, and time
            String key = tempFlight.getStart() + "," + tempFlight.getEnd()
                    + "," + df.format(tempFlight.getTime());
            if (flightsHash.get(key) == null) {
                //Looks alphabetically at the start location and compares to passenger start
                while (tempFlight.getStart().compareTo(passSplit[0]) > 0) {
                    //writes all passengers that start at an airport which is
                    //alphabetically before the current flight's start location
                    //and adds them to leftover list
                    bwLeft.write(passForLeft + "\n");
                    passForLeft = brPassFile.readLine();
                    if (passForLeft== null) {
                        break;
                    }
                    else {
                        passSplit = passForLeft.split(",");
                    }
                }
                //writes all passengers that start at an airport which is
                //alphabetically before the current flight's end location
                //and adds them to leftover list
                while (tempFlight.getEnd().compareTo(passSplit[1]) > 0) {
                    bwLeft.write(passForLeft + "\n");
                    passForLeft = brPassFile.readLine();
                    if (passForLeft== null) {
                        break;
                    }
                    else {
                        passSplit = passForLeft.split(",");
                    }
                }
                int countDebug = 0;
                //writes all passengers who are on the same flight to the flight roster
                while (tempFlight.getStart().equals(passSplit[0]) && tempFlight.getEnd().equals(passSplit[1])) {
                    Passenger tempPass = new Passenger(passSplit[0], passSplit[1], passSplit[2], passSplit[3]);
                    //checks to see if there is room on the flight
                    boolean isAdded = tempFlight.addPass(tempPass);
                    bwBoarded.write(passForLeft + "\n");
                    if (isAdded == false) {
                        bwLeft.write(passForLeft + "\n");
                        break;
                    } else {
                        int counter = 5;
                        while (counter < passSplit.length) {
                            tempWeight += Double.parseDouble(passSplit[counter]);
                            counter++;
                            counter++;
                        }
                        tempFlight.addWeight(tempWeight);
                        tempWeight = 0;
                        passForLeft = brPassFile.readLine();
                        if (passForLeft == null) {
                            break;
                        } else {
                            passSplit = passForLeft.split(",");
                        }
                    }
                }
                flightsHash.put(key, tempFlight);
            }

        }
        //closes both writers and returns hash table
        bwLeft.close();
        bwBoarded.close();
        return flightsHash;
    }
}

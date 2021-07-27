import java.io.*;
import java.nio.Buffer;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.UUID;

import static java.lang.Integer.parseInt;
import static java.util.UUID.randomUUID;

public class Generator {

    static int MAX_LUGGAGE = 5;
    static int MAX_PASSENGERS = 200;
    static int MAX_FLIGHTS = 10;

    static void generatePassengers() throws IOException {
        //Creates arraylist of first names
        File first = new File("/Users/mattbraly/Documents/Summer/Airline/src/Seeds/First.csv");
        BufferedReader brfirst = new BufferedReader(new FileReader(first));
        ArrayList<String> firstArray = new ArrayList<>();

        String line = "";
        while ((line = brfirst.readLine()) != null) {
            firstArray.add(line);
        }

        //Creates arraylist of airports
        File airport = new File("/Users/mattbraly/Documents/Summer/Airline/src/Seeds/us-airports.csv");
        BufferedReader brairport = new BufferedReader(new FileReader(airport));
        ArrayList<String> airportArray = new ArrayList<>();

        int counter = 0;
        brairport.readLine();
        brairport.readLine();
        while (counter < 25) {
            counter ++;
            line = brairport.readLine();
            airportArray.add(line);
        }

        //Creates luggage array
        File lug = new File("/Users/mattbraly/Documents/Summer/Airline/src/Seeds/Luggage.csv");
        BufferedReader brlug = new BufferedReader(new FileReader(lug));

        ArrayList<String> lugArray = new ArrayList<>();
        while ((line = brlug.readLine()) != null) {
            lugArray.add(line);
        }
        Random rand = new Random();

        //Creates a line which contains an id number, name, a start location,
        //An end location, and luggage of various weights

        DecimalFormat df = new DecimalFormat("0.00");
        BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/mattbraly/Documents/Summer/Airline/src/Records/Passengers.csv"));
        String pass_uuid = "";
        ArrayList<String> sortedPass = new ArrayList<>();
        for (int i = 0; i < MAX_PASSENGERS; i ++) {
            String[] airport_split = airportArray.get(rand.nextInt(airportArray.size())).split(",");
            String pass_line = airport_split[1] + ",";
            airport_split = airportArray.get(rand.nextInt(airportArray.size())).split(",");
            pass_line += airport_split[1] + ",";
            pass_uuid = randomUUID().toString();
            pass_line += firstArray.get(rand.nextInt(firstArray.size())) + ",";
            pass_line += pass_uuid + ",";
            int lug_num = rand.nextInt(MAX_LUGGAGE);

            for (int j = 0; j < lug_num; j ++) {
                int rand_lug = rand.nextInt(lugArray.size());
                String[] lug_split = lugArray.get(rand_lug).split(",");
                double lug_low = Double.valueOf(lug_split[1]);
                double lug_hi = Double.valueOf(lug_split[2]);
                String lug_weight = df.format(lug_low + (lug_hi - lug_low) * rand.nextDouble());
                pass_line += lug_split[0] + ",";
                pass_line += lug_weight;
            }
            pass_line += "\n";
            sortedPass.add(pass_line);
        }

        //Sorts the array of passengers by airport they start at
        Collections.sort(sortedPass);

        for (int i = 0; i < sortedPass.size(); i ++) {
            writer.write(sortedPass.get(i));
        }
        writer.close();
    }

    static void sortPassengers() throws IOException {
        File passengers = new File("/Users/mattbraly/Documents/Summer/Airline/src/Records/Passengers.csv");
        BufferedReader brPass = new BufferedReader(new FileReader(passengers));
        String line = "";
        while ((line = brPass.readLine()) != null) {

        }
    }
    static void generateFlights() throws IOException {

        //creates an arraylist of an airport
        DecimalFormat df = new DecimalFormat("0000");
        File airport = new File("/Users/mattbraly/Documents/Summer/Airline/src/Seeds/us-airports.csv");
        BufferedReader br_airport = new BufferedReader(new FileReader(airport));

        String line = "";
        ArrayList<String> airportArray = new ArrayList<>();
        br_airport.readLine();
        br_airport.readLine();
        int counter = 0;
        while (counter < 25) {
            counter ++;
            airportArray.add(br_airport.readLine());
        }

        //Writes to a csv which contains a airport id, a start location, an end location
        //and a distance between the two
        int flight_id = 0;
        BufferedWriter writer = new BufferedWriter((new FileWriter("/Users/mattbraly/Documents/Summer/Airline/src/Records/Flights.csv")));
        Random rand = new Random();
        String flight_uuid = "";
        for (int i = 0; i < MAX_FLIGHTS; i ++) {
            flight_uuid = randomUUID().toString();
            String[] airport_split1 = airportArray.get(rand.nextInt(airportArray.size())).split(",");
            String[] airport_split2 = airportArray.get(rand.nextInt(airportArray.size())).split(",");

            String flight_line = flight_uuid + "," + airport_split1[1] + "," + airport_split2[1] + ",";
            double lat1 = Double.parseDouble(airport_split1[4]);
            double lon1 = Double.parseDouble(airport_split1[5]);
            double lat2 = Double.parseDouble(airport_split2[4]);
            double lon2 = Double.parseDouble(airport_split2[5]);

            double distance = calculateDistance(lat1, lat2, lon1, lon2);

            flight_line += String.valueOf(distance);
            int hour = rand.nextInt(25) * 100;
            int min = rand.nextInt(60);
            int time = hour + min;

            flight_line += df.format(time) +  "\n";
            writer.write(flight_line);
        }

        writer.close();


    }

    static double calculateDistance(double lat1, double lat2, double lon1, double lon2) {
        //Calculates the distance between airports using the Haversine formula
        double R = 6371;
        double degLat = (lat2-lat1) * (Math.PI/180);
        double degLon = (lon2 - lon1) * (Math.PI/180);

        double a = Math.sin(degLat/2) * Math.sin(degLat/2) +
                Math.cos((lat1) * (Math.PI/180)) * Math.cos((lat2) * (Math.PI/180)) *
                        Math.sin(degLon/2) * Math.sin(degLon/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        double d = R * c;
        return d;
    }

    public static void main(String[] args) throws IOException {

        generatePassengers();
        generateFlights();
    }
}

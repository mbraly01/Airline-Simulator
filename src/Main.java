import java.io.IOException;

public class Main {

    public static void main(String[] args) {

//        try {
//            Generator.generatePassengers();
//            Generator.generateFlights();
//        }
//        catch(IOException e) {
//            System.out.println(e);
//        }

        try {
            Calculator.AssignFlights();
        }
        catch(IOException e){
            System.out.println(e);
        }


    }
}

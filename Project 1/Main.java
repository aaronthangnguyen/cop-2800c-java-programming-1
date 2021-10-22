import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);


        // FIRST VEHICLE: SEDAN
        // declare, instantiate, assign
        var sedan = new Vehicle();

        // set instance variables
        sedan.setYear(2004);
        sedan.setMiles(156_112);
        sedan.setMpg(18);

        // output variables
        System.out.println("SEDAN-");
        System.out.println("Year: " + sedan.getYear());
        System.out.println("Miles: " + sedan.getMiles() + " miles. (Mpg: " + sedan.getMpg() + ")");


        // prompt input
        System.out.print("> Plan your next trip (miles): ");
        var trip = scanner.nextInt();

        // drive
        sedan.drive(trip);

        // output new miles
        System.out.println("New miles: " + sedan.getMiles() + " miles.");

        // SECOND VEHICLE: TRUCK
        // declare, instantiate, assign
        var truck = new Vehicle();

        // set instance variables
        truck.setYear(2021);
        truck.setMiles(7_012);
        truck.setMpg(24);

        // output variables
        System.out.println("\nTRUCK-");
        System.out.println("Year: " + truck.getYear());
        System.out.println("Miles: " + truck.getMiles() + " miles. (Mpg: " + truck.getMpg() + ")");

        // prompt input
        System.out.print("> Plan your next trip (miles): ");
        var secondTrip = scanner.nextInt();

        // drive
        truck.drive(secondTrip);

        // output new miles
        System.out.println("New miles: " + truck.getMiles() + " miles.");


        // EXTRAS
        System.out.println("\nEXTRAS!");
        // instance method wash
        sedan.wash();
        // set VIN number
        sedan.setVinNumber("4Y1SL65848Z411439");
        // get VIN number
        System.out.println("VIN number: " + sedan.getVinNumber());
        // provoke static method
        System.out.println("VIN number is valid? " + (Vehicle.checkVinNumberLength(sedan.getVinNumber()) ? "Yes" : "No"));

        // instantiate with overloaded constructor
        var amazonPrimeTruck = new Vehicle("9Y1SL12848Y411434");
    }
}

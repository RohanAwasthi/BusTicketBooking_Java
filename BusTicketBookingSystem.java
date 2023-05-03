import java.util.Scanner;
public class BusTicketBookingSystem {
    public static void main(String[] args) throws InvalidBookingException {
        Scanner scanner = new Scanner(System.in);
        BusBookingSystem busBookingSystem = new BusBookingSystem();
        while (true) {
            System.out.println("Welcome to the Bus Ticket Booking System!");
            System.out.println("1. Book a bus ticket");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter source: ");
                    String source = scanner.nextLine();
                    System.out.print("Enter destination: ");
                    String destination = scanner.nextLine();
                    busBookingSystem.bookTicket(source, destination);
                    break;
                case 2:
                    System.out.println("Thank you for using the Bus Ticket Booking System!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
interface BusBooking {
    void bookTicket(String source, String destination) throws InvalidBookingException;
}
class BusBookingSystem implements BusBooking {
    public static final String[] BUS_NAMES = {"Bus1", "Bus2", "Bus3"};
    public static final int[] BUS_PRICES = {100, 150, 200};
    @Override
    public void bookTicket(String source, String destination) throws InvalidBookingException {
        System.out.println("Available buses:");
        for (int i = 0; i < BUS_NAMES.length; i++) {
            System.out.println((i + 1) + ". " + BUS_NAMES[i] + " - Rs." + BUS_PRICES[i]);
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter bus number: ");
        int busNumber = scanner.nextInt();
        if (busNumber < 1 || busNumber > BUS_NAMES.length) {
            throw new InvalidBookingException("Invalid bus number");
        }
        System.out.print("Enter name: ");
        String name = scanner.next();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter date of booking: ");
        String dateOfBooking = scanner.nextLine();
        System.out.println("Booking done for " + name + " (age " + age + ") on " + BUS_NAMES[busNumber - 1] +
                " from " + source + " to " + destination + " on " + dateOfBooking + ". Total fare: Rs." + BUS_PRICES[busNumber - 1]);
    }
}
class InvalidBookingException extends Exception {
    public InvalidBookingException(String message) {
        super(message);
    }
}
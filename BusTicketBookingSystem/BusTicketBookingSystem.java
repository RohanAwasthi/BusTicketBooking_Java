package BusTicketBookingSystem;

import java.util.*;
import java.util.stream.Collectors;
public class BusTicketBookingSystem {
    private Map<String, List<String>> availableSeats;
    public BusTicketBookingSystem() {
        availableSeats = new HashMap<>();
    }
    public void addBus(String busName, List<String> seats) {
        availableSeats.put(busName, seats);
    }
    public void bookSeat(String busName, String seat) {
        if (!availableSeats.containsKey(busName)) {
            System.out.println("Bus not found!");
            return;
        }
        List<String> seats = availableSeats.get(busName);
        if (!seats.contains(seat)) {
            System.out.println("Seat not found!");
            return;
        }
        seats.remove(seat);
        System.out.println("Seat " + seat + " booked on " + busName);
    }
    public void printAvailableSeats(String busName, String filter) {
        if (!availableSeats.containsKey(busName)) {
            System.out.println("Bus not found!");
            return;
        }
        List<String> seats = availableSeats.get(busName);
        if (filter != null && !filter.isEmpty()) {
            seats = seats.stream()
                    .filter(s -> s.toLowerCase().contains(filter.toLowerCase()))
                    .collect(Collectors.toList());
        }
        String availableSeatString = seats.stream()
                .collect(Collectors.joining(", "));
        System.out.println("Available seats for " + busName + ": " + availableSeatString);
    }
    public static void main(String[] args) {
        BusTicketBookingSystem system = new BusTicketBookingSystem();
        List<String> seats1 = Arrays.asList("1A", "1B", "2A", "2B");
        system.addBus("Bus 1", seats1);
        List<String> seats2 = Arrays.asList("1C", "1D", "2C", "2D");
        system.addBus("Bus 2", seats2);
        system.printAvailableSeats("Bus 1", null); // Available seats for Bus 1: 1A, 1B, 2A, 2B
        system.bookSeat("Bus 1", "1A"); // Seat 1A booked on Bus 1
        system.printAvailableSeats("Bus 1", null); // Available seats for Bus 1: 1B, 2A, 2B
        system.printAvailableSeats("Bus 2", "1"); // Available seats for Bus 2: 1C, 1D
    }
}
















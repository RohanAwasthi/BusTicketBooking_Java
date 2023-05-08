import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
public class BusTicketBookingSystemTest {
    private BusTicketBookingSystem system;
    @BeforeEach
    void setUp() {
        system = new BusTicketBookingSystem();
        List<String> seats1 = Arrays.asList("1A", "1B", "2A", "2B");
        system.addBus("Bus 1", seats1);
        List<String> seats2 = Arrays.asList("1C", "1D", "2C", "2D");
        system.addBus("Bus 2", seats2);
    }
    @Test
    void testBookSeat() {
        system.bookSeat("Bus 1", "1A");
        List<String> availableSeats = system.getAvailableSeats("Bus 1");
        Assertions.assertEquals(Arrays.asList("1B", "2A", "2B"), availableSeats);
    }
    @Test
    void testBookSeatNotFound() {
        system.bookSeat("Bus 1", "3A");
        List<String> availableSeats = system.getAvailableSeats("Bus 1");
        Assertions.assertEquals(Arrays.asList("1A", "1B", "2A", "2B"), availableSeats);
    }
    @Test
    void testPrintAvailableSeats() {
        String expectedOutput = "Available seats for Bus 1: 1A, 1B, 2A, 2B";
        Assertions.assertEquals(expectedOutput, system.printAvailableSeats("Bus 1", null));
    }
    @Test
    void testPrintAvailableSeatsWithFilter() {
        String expectedOutput = "Available seats for Bus 2: 1C, 1D";
        Assertions.assertEquals(expectedOutput, system.printAvailableSeats("Bus 2", "1"));
    }
    @Test
    void testPrintAvailableSeatsNotFound() {
        String expectedOutput = "Bus not found!";
        Assertions.assertEquals(expectedOutput, system.printAvailableSeats("Bus 3", null));
    }
}

import java.util.*;
import java.time.LocalDateTime;
import Booking.BookingStatus;

public class SimpleHotelSystem {
    private static List<Room> rooms = new ArrayList<>();
    private static List<Customer> customers = new ArrayList<>();
    private static List<Booking> bookings = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeRooms();
        int choice;
        do {
            System.out.println("\n=== Hotel Management System ===");
            System.out.println("1. Add Customer");
            System.out.println("2. View Customers");
            System.out.println("3. Manage Rooms");
            System.out.println("4. Make Booking");
            System.out.println("5. Manage Bookings");
            System.out.println("6. Generate Bill");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: addCustomer(); break;
                case 2: viewCustomers(); break;
                case 3: manageRooms(); break;
                case 4: makeBooking(); break;
                case 5: manageBookings(); break;
                case 6: generateBill(); break;
                case 0: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }

    private static void initializeRooms() {
        rooms.add(new Room("R101", "Single", 1000, 1, false, true));
        rooms.add(new Room("R102", "Double", 1800, 2, false, false));
        rooms.add(new Room("R103", "Suite", 3000, 4, false, true));
    }

    private static void addCustomer() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter contact number: ");
        String contact = scanner.nextLine();
        System.out.print("Enter gender: ");
        String gender = scanner.nextLine();
        Customer customer = new Customer(name, contact, gender);
        customers.add(customer);
        System.out.println("Customer added: " + customer);
    }

    private static void viewCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers found.");
            return;
        }
        for (Customer c : customers) System.out.println(c);
    }

    private static void manageRooms() {
        System.out.println("\n--- Room List ---");
        for (Room r : rooms) System.out.println(r);
    }

    private static void makeBooking() {
        if (customers.isEmpty()) {
            System.out.println("No customers available. Add customer first.");
            return;
        }

        System.out.println("Select customer by ID:");
        for (Customer c : customers) System.out.println(c.getCustomerId() + " - " + c.getName());
        String custId = scanner.nextLine();

        Customer customer = customers.stream()
                .filter(c -> c.getCustomerId().equals(custId))
                .findFirst().orElse(null);
        if (customer == null) {
            System.out.println("Invalid customer ID.");
            return;
        }

        System.out.println("Available rooms:");
        for (Room r : rooms) if (!r.isOccupied()) System.out.println(r);

        System.out.print("Enter room ID: ");
        String roomId = scanner.nextLine();
        Room room = rooms.stream()
                .filter(r -> r.toString().contains(roomId))
                .findFirst().orElse(null);
        if (room == null || room.isOccupied()) {
            System.out.println("Invalid or occupied room.");
            return;
        }

        System.out.print("Enter number of nights: ");
        int nights = scanner.nextInt();
        scanner.nextLine();
        LocalDateTime checkIn = LocalDateTime.now();
        LocalDateTime checkOut = checkIn.plusDays(nights);

        Booking booking = new Booking(customer.getCustomerId(), roomId, checkIn, checkOut);
        bookings.add(booking);
        room.checkIn(customer.getCustomerId());
        customer.checkIn(roomId);
        System.out.println("Booking successful: " + booking);
    }

    private static void manageBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings found.");
            return;
        }
        for (Booking b : bookings) System.out.println(b);
    }

    private static void generateBill() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings available.");
            return;
        }
        System.out.println("Enter booking ID: ");
        String bid = scanner.nextLine();
        Booking booking = bookings.stream()
                .filter(b -> b.getBookingId().equals(bid))
                .findFirst().orElse(null);
        if (booking == null) {
            System.out.println("Invalid booking ID.");
            return;
        }

        Room room = rooms.stream()
                .filter(r -> r.getCustomerId() != null && r.getCustomerId().equals(booking.getCustomerId()))
                .findFirst().orElse(null);
        if (room == null) {
            System.out.println("Room not found for this booking.");
            return;
        }

        booking.calculateFinalBill(room.getPricePerNight(), 12); // 12% tax
        System.out.println("Bill generated:");
        System.out.println("Room Charges: " + booking.getRoomCharges());
        System.out.println("Tax: " + booking.getTaxAmount());
        System.out.println("Total: " + booking.getTotalAmount());

        room.checkOut();
    }
}

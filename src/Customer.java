import java.time.LocalDateTime;
import java.util.UUID;

public class Customer {
    private String customerId;
    private String name;
    private String contactNumber;
    private String gender;
    private String roomId;
    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;

    public Customer(String name, String contactNumber, String gender) {
        this.customerId = UUID.randomUUID().toString();
        this.name = name;
        this.contactNumber = contactNumber;
        this.gender = gender;
        this.roomId = null;
    }

    public String getCustomerId() { return customerId; }
    public String getName() { return name; }
    public String getContactNumber() { return contactNumber; }
    public String getRoomId() { return roomId; }
    public LocalDateTime getCheckInTime() { return checkInTime; }
    public LocalDateTime getCheckOutTime() { return checkOutTime; }

    public void checkIn(String roomId) { this.roomId = roomId; this.checkInTime = LocalDateTime.now(); }
    public void checkOut() { this.roomId = null; this.checkOutTime = LocalDateTime.now(); }

    @Override
    public String toString() {
        return "ID: " + customerId + " | Name: " + name + " | Contact: " + contactNumber + " | Gender: " + gender;
    }
}

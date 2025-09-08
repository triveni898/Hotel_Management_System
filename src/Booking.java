import Booking.BookingStatus;
import java.time.LocalDateTime;
import java.util.UUID;

public class Booking {
    private String bookingId;
    private String customerId;
    private String roomId;
    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;
    private BookingStatus status;
    private double roomCharges;
    private double foodCharges;
    private double discountAmount;
    private String discountCode;
    private double taxAmount;
    private double totalAmount;

    public Booking(String customerId, String roomId, LocalDateTime checkInTime, LocalDateTime checkOutTime) {
        this.bookingId = UUID.randomUUID().toString();
        this.customerId = customerId;
        this.roomId = roomId;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
        this.status = BookingStatus.CONFIRMED;
    }

    public String getBookingId() { return bookingId; }
    public String getCustomerId() { return customerId; }
    public String getRoomId() { return roomId; }
    public BookingStatus getStatus() { return status; }
    public LocalDateTime getCheckInTime() { return checkInTime; }
    public LocalDateTime getCheckOutTime() { return checkOutTime; }
    public int getNumberOfNights() { return (int) java.time.Duration.between(checkInTime, checkOutTime).toDays(); }
    public double getRoomCharges() { return roomCharges; }
    public double getFoodCharges() { return foodCharges; }
    public double getDiscountAmount() { return discountAmount; }
    public String getDiscountCode() { return discountCode; }
    public double getTaxAmount() { return taxAmount; }
    public double getTotalAmount() { return totalAmount; }

    public void checkIn() { this.status = BookingStatus.CHECKED_IN; }
    public void checkOut() { this.status = BookingStatus.CHECKED_OUT; }
    public void cancel() { this.status = BookingStatus.CANCELLED; }

    public void applyDiscount(String code, double amount) { this.discountCode = code; this.discountAmount = amount; }

    public void calculateFinalBill(double pricePerNight, double taxRate) {
        roomCharges = pricePerNight * getNumberOfNights();
        taxAmount = ((roomCharges + foodCharges - discountAmount) * taxRate / 100);
        totalAmount = roomCharges + foodCharges - discountAmount + taxAmount;
    }

    @Override
    public String toString() {
        return "Booking ID: " + bookingId + " | Customer ID: " + customerId + " | Room ID: " + roomId + " | Status: " + status;
    }
}

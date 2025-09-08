/**public class Room {
    private String roomId;
    private String type;
    private double pricePerNight;
    private int capacity;
    private boolean occupied;
    private boolean hasAC;
    private String customerId;

    public Room(String roomId, String type, double pricePerNight, int capacity, boolean occupied, boolean hasAC) {
        this.roomId = roomId;
        this.type = type;
        this.pricePerNight = pricePerNight;
        this.capacity = capacity;
        this.occupied = occupied;
        this.hasAC = hasAC;
        this.customerId = null;
    }

    public boolean isOccupied() { return occupied; }
    public void checkIn(String customerId) { this.occupied = true; this.customerId = customerId; }
    public void checkOut() { this.occupied = false; this.customerId = null; }
    public double getPricePerNight() { return pricePerNight; }
    public String getCustomerId() { return customerId; }

    @Override
    public String toString() {
        return roomId + " - " + type + " - $" + pricePerNight + " per night - Capacity: " + capacity + " - AC: " + hasAC + " - Occupied: " + occupied;
    }
}**/
public class Room {
    private String roomId;
    private String type;
    private double pricePerNight;
    private int capacity;
    private boolean occupied;
    private boolean hasAC;
    private String customerId;

    public Room(String roomId, String type, double pricePerNight, int capacity, boolean occupied, boolean hasAC) {
        this.roomId = roomId;
        this.type = type;
        this.pricePerNight = pricePerNight;
        this.capacity = capacity;
        this.occupied = occupied;
        this.hasAC = hasAC;
        this.customerId = null;
    }

    public boolean isOccupied() { return occupied; }
    public void checkIn(String customerId) { this.occupied = true; this.customerId = customerId; }
    public void checkOut() { this.occupied = false; this.customerId = null; }
    public double getPricePerNight() { return pricePerNight; }
    public String getCustomerId() { return customerId; }

    // 🔑 FIX: Added getter for roomId
    public String getRoomId() {
        return roomId;
    }

    @Override
    public String toString() {
        return roomId + " - " + type + " - $" + pricePerNight + " per night - Capacity: " + capacity + " - AC: " + hasAC + " - Occupied: " + occupied;
    }
}


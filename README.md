**Hotel Management System**
**Overview**

This is a Simple Hotel Management System implemented in Java. It provides functionalities for managing rooms, customers, bookings, food orders, checkout, billing, and admin operations. The system is designed to be user-friendly and efficient for small hotel operations.

**Features**
1. Room Management

View all rooms.

View available rooms.

View room details including type, capacity, price, and amenities.

2. Customer Management

Add new customers with name, contact number, and gender.

View all customers.

Search customers by name or contact number.

3. Booking Management

Create new bookings with check-in and check-out dates.

View active bookings.

Check-in and cancel bookings.

Automatically update room and customer status.

4. Food Ordering

View food menu.

Place food orders (integration ready for future updates).

View customer orders.

5. Checkout & Billing

Apply discount codes (WELCOME10, SUMMER20, LOYALTY15).

Automatically calculate total bill including room charges, food charges, discounts, and tax.

Generate a detailed bill for each booking.

6. Search Operations

Search room by customer (name/contact).

Search customer by room.

7. Admin Dashboard

View revenue statistics and tax rate.

View room statistics (total, booked, available).

View all bookings.

Change tax rate.

Manage customers (add, remove, view, search).

**Installation**

Clone the repository:

git clone <your-repo-url>
cd <repository-folder>


Compile the Java files:

javac *.java


Run the application:

java SimpleHotelSystem

**Usage**

Navigate through the menus by entering the corresponding number.

Add customers before making bookings.

Use valid room IDs and customer IDs for bookings.

Admin operations are accessible through the Admin Dashboard in the main menu.

Discount codes are case-insensitive and applied during checkout.

**Data Storage**
The system uses in-memory storage (HashMap) for rooms, customers, bookings, menu, and discount codes.

No database is required, but future updates can integrate persistent storage.

**Tax & Discounts**

Default tax rate: 5% (can be changed via admin panel).

**Supported discount codes:**

WELCOME10 — 10% off

SUMMER20 — 20% off

LOYALTY15 — 15% off

**Notes**

Food ordering is partially implemented; full integration is planned for future versions.

Check-in and checkout times are handled automatically.

Admin cannot remove customers with active bookings or currently checked-in rooms.

**License**

This project is open-source and free to use for educational purposes.

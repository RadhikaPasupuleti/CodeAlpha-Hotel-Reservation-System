import java.util.ArrayList;
import java.util.Scanner;

class Room {
    private int roomNumber;
    private String category;
    private boolean booked;
    private String customerName;

    public Room(int roomNumber, String category) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.booked = false;
        this.customerName = "";
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getCategory() {
        return category;
    }

    public boolean isBooked() {
        return booked;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void bookRoom(String customerName) {
        this.booked = true;
        this.customerName = customerName;
    }

    public void cancelBooking() {
        this.booked = false;
        this.customerName = "";
    }
}

public class hrs {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Room> rooms = new ArrayList<>();

        rooms.add(new Room(101, "Standard"));
        rooms.add(new Room(102, "Standard"));
        rooms.add(new Room(201, "Deluxe"));
        rooms.add(new Room(202, "Deluxe"));
        rooms.add(new Room(301, "Suite"));

        int choice;

        do {
            System.out.println("\n===== HOTEL RESERVATION SYSTEM =====");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. View Booking Details");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\nAvailable Rooms:");
                    for (Room room : rooms) {
                        if (!room.isBooked()) {
                            System.out.println(
                                    "Room " + room.getRoomNumber()
                                            + " - " + room.getCategory());
                        }
                    }
                    break;

                case 2:
                    System.out.print("Enter Room Number: ");
                    int roomNo = sc.nextInt();
                    sc.nextLine();

                    boolean found = false;

                    for (Room room : rooms) {
                        if (room.getRoomNumber() == roomNo && !room.isBooked()) {

                            System.out.print("Enter Customer Name: ");
                            String name = sc.nextLine();

                            room.bookRoom(name);

                            System.out.println("Room booked successfully!");

                            System.out.println("Payment Status: Payment Simulated Successfully");

                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Room not available.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Room Number to Cancel: ");
                    int cancelRoom = sc.nextInt();

                    boolean cancelled = false;

                    for (Room room : rooms) {
                        if (room.getRoomNumber() == cancelRoom && room.isBooked()) {
                            room.cancelBooking();
                            System.out.println("Reservation cancelled successfully!");
                            cancelled = true;
                            break;
                        }
                    }

                    if (!cancelled) {
                        System.out.println("No booking found.");
                    }
                    break;

                case 4:
                    System.out.println("\nBooking Details:");
                    for (Room room : rooms) {
                        if (room.isBooked()) {
                            System.out.println(
                                    "Room: " + room.getRoomNumber()
                                            + " | Category: " + room.getCategory()
                                            + " | Customer: " + room.getCustomerName());
                        }
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using the Hotel Reservation System.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        sc.close();
    }
}
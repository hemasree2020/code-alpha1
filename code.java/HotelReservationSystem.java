
import java.util.*;

class Room {
    int roomNumber;
    String category;
    boolean isAvailable;

    Room(int roomNumber, String category) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.isAvailable = true;
    }
}

class Reservation {
    String guestName;
    int roomNumber;
    String category;
    double payment;

    Reservation(String guestName, int roomNumber, String category, double payment) {
        this.guestName = guestName;
        this.roomNumber = roomNumber;
        this.category = category;
        this.payment = payment;
    }
}

public class HotelReservationSystem {
    static List<Room> rooms = new ArrayList<>();
    static List<Reservation> reservations = new ArrayList<>();

    public static void main(String[] args) {
        initializeRooms();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Hotel Reservation System ---");
            System.out.println("1. Search for Available Rooms");
            System.out.println("2. Make a Reservation");
            System.out.println("3. View Booking Details");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> searchRooms();
                case 2 -> makeReservation(scanner);
                case 3 -> viewReservations();
                case 4 -> {
                    System.out.println("Thank you for using the Hotel Reservation System!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    static void initializeRooms() {
        rooms.add(new Room(101, "Single"));
        rooms.add(new Room(102, "Single"));
        rooms.add(new Room(201, "Double"));
        rooms.add(new Room(202, "Double"));
        rooms.add(new Room(301, "Suite"));
    }

    static void searchRooms() {
        System.out.println("\n--- Available Rooms ---");
        for (Room room : rooms) {
            if (room.isAvailable) {
                System.out.println("Room Number: " + room.roomNumber + ", Category: " + room.category);
            }
        }
    }

    static void makeReservation(Scanner scanner) {
        System.out.print("\nEnter your name: ");
        String guestName = scanner.next();
        System.out.print("Enter room number: ");
        int roomNumber = scanner.nextInt();

        for (Room room : rooms) {
            if (room.roomNumber == roomNumber && room.isAvailable) {
                System.out.print("Enter payment amount: ");
                double payment = scanner.nextDouble();
                room.isAvailable = false;
                reservations.add(new Reservation(guestName, roomNumber, room.category, payment));
                System.out.println("Reservation successful for Room Number: " + roomNumber);
                return;
            }
        }
        System.out.println("Room is not available or doesn't exist.");
    }

    static void viewReservations() {
        System.out.println("\n--- Booking Details ---");
        for (Reservation res : reservations) {
            System.out.println("Name: " + res.guestName + ", Room Number: " + res.roomNumber + ", Category: " + res.category + ", Payment: " + res.payment);
        }
    }
}

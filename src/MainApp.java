import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  // Scanner allows user input from command line
        SQLDatabase db = new SQLDatabase();   // Create database object
        db.connect();  // Connects to the database (runs silently, no output)

        while (true) {   // Loop keeps showing the menu until user exits
            // Show menu options
            System.out.println("\n===== Event Management System =====");
            System.out.println("1. Admin - Add Event");
            System.out.println("2. View Events");
            System.out.println("3. Register Participant");
            // System.out.println("4. Register for Event"); // (commented option)
            System.out.println("5. View Participants in Event");
            System.out.println("6. Exit");
            System.out.print("Enter choice: "); // Command line waits for user input

            int ch = sc.nextInt();  // Reads choice from user
            sc.nextLine();  // Clears the input buffer (important after nextInt)

            switch (ch) {
                case 1 -> {
                    // Admin must enter secret code before adding event
                    System.out.print("Enter admin code: ");
                    String adminCode = sc.nextLine();

                    if (adminCode.equals("ADMIN123")) { // Valid admin
                        System.out.print("Enter event name: ");
                        String en = sc.nextLine();
                        System.out.print("Enter event date: ");
                        String dt = sc.nextLine();
                        db.insertEvent(en, dt);  // Insert into DB
                        // Example CLI run:
                        // Enter admin code: ADMIN123
                        // Enter event name: Tech Fest
                        // Enter event date: 2025-09-21
                        // Event added successfully!
                    } else {
                        System.out.println(" Invalid admin code. Access denied.");
                    }
                }

                case 2 -> {
                    db.viewEvents();  
                    // Example CLI run:
                    // --- List of Events ---
                    // ID: 1 | Name: Tech Fest | Date: 2025-09-21
                }

                case 3 -> {
                    // Register a new participant
                    System.out.print("Enter participant name: ");
                    String pn = sc.nextLine();
                    System.out.print("Enter email: ");
                    String em = sc.nextLine();
                    db.insertParticipant(pn, em);
                    // Example CLI run:
                    // Enter participant name: Arjun
                    // Enter email: arjun@email.com
                    // Participant registered successfully!
                }

                case 4 -> {
                    // Register participant into an event
                    db.viewEvents();  // Show available events first
                    System.out.print("Enter event ID: ");
                    int eid = sc.nextInt();
                    System.out.print("Enter participant ID: ");
                    int pid = sc.nextInt();
                    db.registerForEvent(eid, pid);
                    // Example CLI run:
                    // --- List of Events ---
                    // ID: 1 | Name: Fest | Date: 2025-09-21
                    // Enter event ID: 1
                    // Enter participant ID: 1
                    // Participant registered for event successfully!
                }

                case 5 -> {
                    // View participants of a specific event
                    System.out.print("Enter event ID: ");
                    int ev = sc.nextInt();
                    db.viewParticipants(ev);
                    // Example CLI run:
                    // Enter event ID: 1
                    // --- Participants in Event (ID: 1) ---
                    // 1. Mathu | Email: mathu@email.com
                }

                case 6 -> {
                    // Exit the program
                    System.out.println("Exiting...");
                    System.exit(0);
                }

                default -> System.out.println("Invalid choice."); // For wrong input
            }
        }
    }
}

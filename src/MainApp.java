import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SQLDatabase db = new SQLDatabase();
        db.connect();

        while (true) {
            System.out.println("\n===== Event Management System =====");
            System.out.println("1. Admin - Add Event");
            System.out.println("2. View Events");
            System.out.println("3. Register Participant");
            System.out.println("4. Register for Event");
            System.out.println("5. View Participants in Event");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1 -> {
                    System.out.print("Enter admin code: ");
                    String adminCode = sc.nextLine();
                    if (adminCode.equals("ADMIN123")) {
                        System.out.print("Enter event name: ");
                        String en = sc.nextLine();
                        System.out.print("Enter event date: ");
                        String dt = sc.nextLine();
                        db.insertEvent(en, dt);
                    } else {
                        System.out.println(" Invalid admin code. Access denied.");
                    }
                }
                case 2 -> db.viewEvents();
                case 3 -> {
                    System.out.print("Enter participant name: ");
                    String pn = sc.nextLine();
                    System.out.print("Enter email: ");
                    String em = sc.nextLine();
                    db.insertParticipant(pn, em);
                }
                case 4 -> {
                    db.viewEvents();
                    System.out.print("Enter event ID: ");
                    int eid = sc.nextInt();
                    System.out.print("Enter participant ID: ");
                    int pid = sc.nextInt();
                    db.registerForEvent(eid, pid);
                }
                case 5 -> {
                    System.out.print("Enter event ID: ");
                    int ev = sc.nextInt();
                    db.viewParticipants(ev);
                }
                case 6 -> {
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}

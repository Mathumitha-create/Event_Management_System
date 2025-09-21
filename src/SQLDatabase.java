import java.sql.*;

// Implements a database handler for managing events and participants using MySQL
public class SQLDatabase implements Database {

    // Stores the live connection to the database
    private Connection connection;

    // Opens a connection to the MySQL server
    @Override
    public void connect() {
        try {
            // Replace credentials with your own database info
            String dbURL = "jdbc:mysql://localhost:3306/eventdb";
            String username = "root";
            String password = "root123";

            connection = DriverManager.getConnection(dbURL, username, password);
            System.out.println("Successfully connected to the database.");
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database.");
            e.printStackTrace();
        }
    }

    // Adds a new event to the events table
    @Override
    public void insertEvent(String eventName, String eventDate) {
        try {
            String sql = "INSERT INTO events(event_name, event_date) VALUES(?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, eventName);
            stmt.setString(2, eventDate);
            stmt.executeUpdate();
            System.out.println("Event has been successfully added!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Lists all events currently in the database
    @Override
    public void viewEvents() {
        try {
            String sql = "SELECT * FROM events";
            Statement stmt = connection.createStatement();
            ResultSet results = stmt.executeQuery(sql);

            System.out.println("\nList of Events:");
            while (results.next()) {
                System.out.println(
                    results.getInt("event_id") + ". " +
                    results.getString("event_name") +
                    " on " + results.getString("event_date")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Inserts a new participant into the participants table
    @Override
    public void insertParticipant(String participantName, String participantEmail) {
        try {
            String sql = "INSERT INTO participants(name, email) VALUES(?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, participantName);
            stmt.setString(2, participantEmail);
            stmt.executeUpdate();
            System.out.println("Participant has been registered!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Records a participant's registration for a specific event
    @Override
    public void registerForEvent(int eventId, int participantId) {
        try {
            String sql = "INSERT INTO registrations(event_id, participant_id) VALUES(?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, eventId);
            stmt.setInt(2, participantId);
            stmt.executeUpdate();
            System.out.println("Registration completed successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Displays all participants for a particular event
    @Override
    public void viewParticipants(int eventId) {
        try {
            String sql = "SELECT p.participant_id, p.name, p.email FROM participants p " +
                         "INNER JOIN registrations r ON p.participant_id = r.participant_id " +
                         "WHERE r.event_id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, eventId);
            ResultSet results = stmt.executeQuery();

            System.out.println("\nParticipants for Event ID " + eventId + ":");
            while (results.next()) {
                System.out.println(
                    results.getInt("participant_id") + ". " +
                    results.getString("name") +
                    " (" + results.getString("email") + ")"
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

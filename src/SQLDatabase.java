import java.sql.*;

public class SQLDatabase implements Database {
    private Connection conn;

    @Override
    public void connect() {
        try {
            String url = "jdbc:mysql://localhost:3306/eventdb";
            String user = "root"; // change as per your system
            String pass = "root123"; // change as per your system
            conn = DriverManager.getConnection(url, user, pass);
            System.out.println(" Connected to MySQL Database.");
        } catch (Exception e) {
            System.out.println(" Database Connection Failed!");
            e.printStackTrace();
        }
    }

    @Override
    public void insertEvent(String name, String date) {
        try {
            String query = "INSERT INTO events(event_name, event_date) VALUES(?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, date);
            ps.executeUpdate();
            System.out.println(" Event Added Successfully!");
        } catch (Exception e) { e.printStackTrace(); }
    }

    @Override
    public void viewEvents() {
        try {
            String query = "SELECT * FROM events";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            System.out.println("\nAvailable Events:");
            while (rs.next()) {
                System.out.println(rs.getInt("event_id") + ". " +
                                   rs.getString("event_name") +
                                   " (Date: " + rs.getString("event_date") + ")");
            }
        } catch (Exception e) { e.printStackTrace(); }
    }

    @Override
    public void insertParticipant(String name, String email) {
        try {
            String query = "INSERT INTO participants(name, email) VALUES(?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.executeUpdate();
            System.out.println(" Participant Registered!");
        } catch (Exception e) { e.printStackTrace(); }
    }

    @Override
    public void registerForEvent(int eventId, int participantId) {
        try {
            String query = "INSERT INTO registrations(event_id, participant_id) VALUES(?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, eventId);
            ps.setInt(2, participantId);
            ps.executeUpdate();
            System.out.println(" Registered for Event!");
        } catch (Exception e) { e.printStackTrace(); }
    }

    @Override
    public void viewParticipants(int eventId) {
        try {
            String query = "SELECT p.participant_id, p.name, p.email FROM participants p " +
                           "JOIN registrations r ON p.participant_id = r.participant_id " +
                           "WHERE r.event_id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, eventId);
            ResultSet rs = ps.executeQuery();
            System.out.println("\n👥 Participants in Event " + eventId + ":");
            while (rs.next()) {
                System.out.println(rs.getInt("participant_id") + ". " +
                                   rs.getString("name") +
                                   " (" + rs.getString("email") + ")");
            }
        } catch (Exception e) { e.printStackTrace(); }
    }
}

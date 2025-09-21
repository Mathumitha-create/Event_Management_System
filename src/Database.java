// This interface defines the basic operations that any Database implementation should provide
public interface Database {

    // Establishes a connection to the database
    void connect();

    // Inserts a new event record with its name and date into the database
    void insertEvent(String name, String date);

    // Displays or retrieves the list of all events stored in the database
    void viewEvents();

    // Inserts a new participant record with their name and email into the database
    void insertParticipant(String name, String email);

    // Registers a participant (by participantId) for a specific event (by eventId)
    void registerForEvent(int eventId, int participantId);

    // Displays or retrieves the list of participants for a given event
    void viewParticipants(int eventId);
}

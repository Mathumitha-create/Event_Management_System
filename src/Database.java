public interface Database {
    void connect();
    void insertEvent(String name, String date);
    void viewEvents();
    void insertParticipant(String name, String email);
    void registerForEvent(int eventId, int participantId);
    void viewParticipants(int eventId);
}

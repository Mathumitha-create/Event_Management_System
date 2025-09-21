// This class represents a registration record linking a participant to an event
public class Registration {

    // Unique ID for this registration entry
    private int regId;

    // ID of the event the participant is registering for
    private int eventId;

    // ID of the participant who is registering
    private int participantId;

    // Creates a new registration with its registration ID, event ID, and participant ID
    public Registration(int regId, int eventId, int participantId) {
        this.regId = regId;
        this.eventId = eventId;
        this.participantId = participantId;
    }

    // Returns the registration ID
    public int getRegId() { return regId; }

    // Returns the event ID associated with this registration
    public int getEventId() { return eventId; }

    // Returns the participant ID associated with this registration
    public int getParticipantId() { return participantId; }
}

public class Registration {
    private int regId;
    private int eventId;
    private int participantId;

    public Registration(int regId, int eventId, int participantId) {
        this.regId = regId;
        this.eventId = eventId;
        this.participantId = participantId;
    }

    public int getRegId() { return regId; }
    public int getEventId() { return eventId; }
    public int getParticipantId() { return participantId; }
}

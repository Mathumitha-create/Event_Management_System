// This class represents an Event with an ID, name, and date
public class Event {
    // Unique identifier for the event
    private int id;

    // Name/title of the event
    private String name;

    // Date of the event (could be stored as a String or a Date object)
    private String date;

    // Constructor to create a new Event with its id, name, and date
    public Event(int id, String name, String date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    // Returns the event's unique ID
    public int getId() { return id; }

    // Returns the event's name
    public String getName() { return name; }

    // Returns the event's date
    public String getDate() { return date; }
}

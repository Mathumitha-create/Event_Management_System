// Participant class - represents a user who takes part in an event
// Extends the User class (inheritance concept in Java)

public class Participant extends User {

    // constructor to initialize participant details
    public Participant(String name, String email) {
        // calling parent class constructor
        super(name, email);
    }

    // overriding method to show participant details
    @Override
    public void displayDetails() {
        System.out.println("---- Participant Details ----");
        System.out.println("Name  : " + name);
        System.out.println("Email : " + email);
    }

    // extra method (student style - makes class more useful)
    public void registerForEvent(Event e) {
        System.out.println(name + " has registered for the event: " + e.getEventName());
    }
}

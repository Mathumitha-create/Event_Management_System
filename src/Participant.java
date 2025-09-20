public class Participant extends User {
    public Participant(String name, String email) {
        super(name, email);
    }

    @Override
    public void displayDetails() {
        System.out.println("Participant -> Name: " + name + ", Email: " + email);
    }
}

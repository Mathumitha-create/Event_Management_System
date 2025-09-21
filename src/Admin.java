// This class represents an Admin user, extending the User class and overriding displayDetails() to show admin-specific information.
public class Admin extends User {

    // Constructor: calls the parent (User) constructor to initialize name and email for the Admin
    public Admin(String name, String email) {
        super(name, email);
    }

    // Overrides the displayDetails() method from User to print Admin-specific details
    @Override
    public void displayDetails() {
        System.out.println("Admin -> Name: " + name + ", Email: " + email);
    }
}

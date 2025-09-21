// Represents a general user with a name and email, and includes a method to display user information
public class User {

    // The user's full name
    protected String name;

    // The user's email address
    protected String email;

    // Constructor to create a new User with a specified name and email
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Prints the user's details to the console
    public void displayDetails() {
        System.out.println("Name: " + name + ", Email: " + email);
    }
}

public class Admin extends User {
    public Admin(String name, String email) {
        super(name, email);
    }

    @Override
    public void displayDetails() {
        System.out.println("Admin -> Name: " + name + ", Email: " + email);
    }
}

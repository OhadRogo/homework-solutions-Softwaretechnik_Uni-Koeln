package src.homework_codes;

public class User {
    private String UserID;
    private String firstName;
    private String lastName;

    public User(String UserID, String firstName, String lastName) {
        this.UserID = UserID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void login() {
        // login code here
    }

    //getters
    public String getUserID() {
        return UserID;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }

}

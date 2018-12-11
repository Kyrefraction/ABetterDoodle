package betterdoodle.project.mmu.ac.uk.betterdoodleappServer;

/**
 * Created by Pugs on 07/11/2017.
 */

public class Users {

    int id;
    String userUsername;
    String userEmail;

    //constructs
    public Users() {
    }

    public Users(String userUsername, String userEmail) {
        this.userUsername = userUsername;
        this.userEmail = userEmail;
    }

    public Users(int id, String userUsername, String userEmail) {
        this.id = id;
        this.userUsername = userUsername;
        this.userEmail = userEmail;
    }
    //gets the values
    public long getId() {
        return this.id;
    }

    public String getUserUsername() {
        return this.userUsername;
    }

    public String getUserEmail() {
        return this.userEmail;
    }
    //sets the values
    public void setId(int id) {
        this.id = id;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}

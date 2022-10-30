package de.cronn.poolleague.api.requests;

public class AddPlayerRequest {

    private String firstName;
    private String lastName;

    public AddPlayerRequest() {}

    public AddPlayerRequest(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

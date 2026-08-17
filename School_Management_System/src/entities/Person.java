package entities;

import interfaces.Displayable;

public class Person implements Displayable {
    private String id;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String gender;
    private String phoneNumber;
    private String email;
    private String address;
}
public Person(String id, String firstName, String lastName, String dateOfBirth,String gender, String phoneNumber, String email, String address){
    setId(id);

    this.firstName = firstName;
    this.lastName = lastName;
    this.dateOfBirth = dateOfBirth;
    this.gender = gender;
    this.phoneNumber = phoneNumber;
    this.email = email;
    this.address = address;
}

// getters
public String getId() { return id; }
public String getFirstName() { return firstName; }
public String getLastName() { return lastName; }
public String getDateOfBirth() { return dateOfBirth; }
public String getGender() { return gender; }
public String getPhoneNumber() { return phoneNumber; }
public String getEmail() { return email; }
public String getAddress() { return address; }

}
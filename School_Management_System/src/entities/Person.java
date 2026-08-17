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
}
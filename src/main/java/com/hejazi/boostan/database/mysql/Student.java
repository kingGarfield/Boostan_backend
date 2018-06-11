package com.hejazi.boostan.database.mysql;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
public class Student {
    @Id
    private int id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String nationalID;

    @Column
    private String phoneNumber;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String email;

    @Column
    private String address;

    @Column
    private String registerationDate;

    @Column
    private String fatherName;

    @Column
    private String birthDate;

    public void setId(int id) { this.id = id; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public String getRegisterationDate() { return registerationDate; }

    public void setRegisterationDate(String registerationDate) { this.registerationDate = registerationDate; }

    public String getBirthDate() { return birthDate; }

    public void setBirthDate(String birthDate) { this.birthDate = birthDate; }

    public int getId() { return id; }

    public String getUsername() {
        return username;
    }

    public String getFatherName() { return fatherName; }

    public void setFatherName(String fatherName) { this.fatherName = fatherName; }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) { this.username = username; }

    public String getNationalID() { return nationalID; }

    public void setNationalID(String nationalID) { this.nationalID = nationalID; }

    public String getPhoneNumber() { return phoneNumber; }

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }
}

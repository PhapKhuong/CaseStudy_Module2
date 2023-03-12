package models;

import java.time.LocalDate;

public abstract class Person {
    private String name;
    private LocalDate dateOfBirth;
    private boolean gender;
    private String idCard;
    private String phone;
    private String email;

    public Person() {
    }

    public Person(String name, LocalDate dateOfBirth, boolean gender, String idCard, String phone, String email) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender=" + gender +
                ", idCard='" + idCard + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' + ", ";
    }
}

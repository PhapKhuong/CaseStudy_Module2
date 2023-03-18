package models;

import libs.DateOfBirthException;
import utils.MyUtil;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public abstract class Person {
    private String name;
    private LocalDate dateOfBirth;
    private String gender;
    private String idCard;
    private String phone;
    private String email;

    public Person() {
    }

    public Person(String name, String dateOfBirth, String gender, String idCard, String phone, String email) {
        this.name = name;
        this.dateOfBirth = MyUtil.parseDate(dateOfBirth);
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

    public String getDateOfBirth() {
        return MyUtil.parseString(dateOfBirth);
    }

    public void setDateOfBirth(String dateOfBirth) throws DateTimeParseException, DateOfBirthException {
        LocalDate date = MyUtil.parseDate(dateOfBirth);
        LocalDate minDate = date.plusYears(18);
        LocalDate maxDate = date.plusYears(100);
        LocalDate now = LocalDate.now();

        if(minDate.isBefore(now) && maxDate.isAfter(now)) {
            this.dateOfBirth = MyUtil.parseDate(dateOfBirth);
        } else {
            throw new DateOfBirthException();
        }
    }

    public String isGender() {
        return gender;
    }

    public void setGender(String gender) {
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

    abstract void showNotification();

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", dateOfBirth=" + this.getDateOfBirth() +
                ", gender=" + gender +
                ", idCard='" + idCard + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' + ", ";
    }
}

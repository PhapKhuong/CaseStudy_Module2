package models;

import java.time.LocalDate;

public class Customer extends Person {
    private int customerID;
    private String customerType;
    private String address;

    public Customer() {
    }

    public Customer(String name, String dateOfBirth, String gender, String idCard, String phone, String email,
                    int customerID, String customerType, String address) {
        super(name, dateOfBirth, gender, idCard, phone, email);
        this.customerID = customerID;
        this.customerType = customerType;
        this.address = address;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void showNotification() {
        System.out.println("This is the list of customers!");
    }

    @Override
    public String toString() {
        return "Customer{" +
                super.toString() +
                "customerID=" + customerID +
                ", customerType=" + customerType +
                ", address='" + address + '\'' +
                '}';
    }
}
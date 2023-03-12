package services;

import models.Customer;

import java.util.List;

public interface CustomerService extends Service {

    List<Customer> displayCustomer();

    void addCustomer(Customer customer);

    void editCustomer(int customerID);
}

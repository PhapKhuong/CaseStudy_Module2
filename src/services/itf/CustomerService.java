package services.itf;

import models.Customer;

import java.util.List;

public interface CustomerService extends Service {

    List<Customer> display();

    void add(Customer customer);

    void edit(int id, Customer customer);
}

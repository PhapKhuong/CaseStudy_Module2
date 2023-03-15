package services.impl;

import models.Customer;
import services.itf.CustomerService;

import java.util.LinkedList;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    public static List<Customer> customerList = new LinkedList<>();
    static {
        customerList.add(new Customer("Thành", "01/01/2001", "Men", "3452345", "34534", "ewjje",
                1, "Diamond", "gsdfgf"));

        customerList.add(new Customer("Hà", "02/02/2002", "Women", "3452345", "34534", "ewjje",
                2, "Silver", "gsdfgf"));
    }


    @Override
    public List<Customer> display() {
        return customerList;
    }

    @Override
    public void add(Customer customer) {
        customerList.add(customer);
    }

    @Override
    public void edit(int id, Customer customer) {
        int i = 0;
        for (Customer c : customerList) {
            if (id == c.getCustomerID()) {
                break;
            } else {
                i++;
            }
        }
        customerList.set(i, customer);
    }
}

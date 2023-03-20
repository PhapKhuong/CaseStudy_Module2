package services.impl;

import data.class_data.CustomerData;
import models.Customer;
import services.itf.CustomerService;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private static List<Customer> customerList = new LinkedList<>();

    static {
        try {
            customerList = CustomerData.readFile();
        } catch (IOException e) {
            System.out.println("File is not exist");
        }
    }

    @Override
    public List<Customer> display() {
        try {
            customerList = CustomerData.readFile();
            return customerList;
        } catch (IOException e) {
            System.out.println("File is not exist");
        }
        return null;
    }

    @Override
    public void add(Customer customer) {
        try {
            CustomerData.writeFile(customer);
        } catch (IOException e) {
            System.out.println("File is not exist");
        }
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

        try {
            CustomerData.clear();
            for (Customer c : customerList) {
                CustomerData.writeFile(c);
            }
        } catch (IOException e) {
            System.out.println("File is not exist");
        }
    }
}

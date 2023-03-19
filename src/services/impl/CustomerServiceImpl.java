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
            customerList = CustomerData.readCustomerFile();
        } catch (IOException e) {
            System.out.println("File is not exist");
        }
    }

    @Override
    public List<Customer> display() {
        try {
            customerList = CustomerData.readCustomerFile();
            return customerList;
        } catch (IOException e) {
            System.out.println("File is not exist");
        }
        return null;
    }

    @Override
    public void add(Customer customer) {
        try {
            CustomerData.writeCustomerFile(customer);
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
            CustomerData.clearCustomerData();
            for (Customer c : customerList) {
                CustomerData.writeCustomerFile(c);
            }
        } catch (IOException e) {
            System.out.println("File is not exist");
        }
    }
}

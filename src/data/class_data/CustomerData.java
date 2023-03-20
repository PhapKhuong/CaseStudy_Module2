package data.class_data;

import models.Customer;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class CustomerData {
    private static final String CUSTOMER_PATH =
            "C:\\Dropbox\\Codegym\\FuramaResort\\src\\data\\csv_file\\customer.csv";

    private CustomerData() {
    }

    public static List<Customer> readFile() throws IOException {
        FileReader fileReader = new FileReader(CUSTOMER_PATH);
        BufferedReader buffReader = new BufferedReader(fileReader);

        List<Customer> customerDataList = new LinkedList<>();

        String line = buffReader.readLine();
        String[] temp;
        Customer customer;

        while (line != null) {
            temp = line.split(",");

            String name = temp[0];
            String dateOfBirth = temp[1];
            String gender = temp[2];
            String idCard = temp[3];
            String phone = temp[4];
            String email = temp[5];
            int customerID = Integer.parseInt(temp[6]);
            String customerType = temp[7];
            String address = temp[8];

            customer = new Customer(
                    name, dateOfBirth, gender, idCard, phone, email, customerID, customerType, address);

            customerDataList.add(customer);
            line = buffReader.readLine();
        }
        buffReader.close();
        return customerDataList;
    }

    public static void writeFile(Customer customer) throws IOException {
        FileWriter fileWriter = new FileWriter(CUSTOMER_PATH, true);
        BufferedWriter buffWriter = new BufferedWriter(fileWriter);

        buffWriter.write(
                customer.getName() + ","
                        + customer.getDateOfBirth() + ","
                        + customer.getGender() + ","
                        + customer.getIdCard() + ","
                        + customer.getPhone() + ","
                        + customer.getEmail() + ","
                        + customer.getCustomerID() + ","
                        + customer.getCustomerType() + ","
                        + customer.getAddress() + "\n"
        );
        buffWriter.close();
    }

    public static void clear() throws IOException {
        FileWriter fileWriter = new FileWriter(CUSTOMER_PATH);
        BufferedWriter buffWriter = new BufferedWriter(fileWriter);
        buffWriter.flush();
        buffWriter.close();
    }
}

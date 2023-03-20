package data.class_data;

import models.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeData {
    private static final String EMPLOYEE_PATH =
            "C:\\Dropbox\\Codegym\\FuramaResort\\src\\data\\csv_file\\employee.csv";

    private EmployeeData() {
    }

    public static List<Employee> readFile() throws IOException {
        FileReader fileReader = new FileReader(EMPLOYEE_PATH);
        BufferedReader buffReader = new BufferedReader(fileReader);

        List<Employee> employeeDataList = new ArrayList<>();

        String line = buffReader.readLine();
        String[] temp;
        Employee employee;

        while (line != null) {
            temp = line.split(",");

            String name = temp[0];
            String dateOfBirth = temp[1];
            String gender = temp[2];
            String idCard = temp[3];
            String phone = temp[4];
            String email = temp[5];
            int employeeID = Integer.parseInt(temp[6]);
            String level = temp[7];
            String position = temp[8];
            long salary = Long.parseLong(temp[9]);

            employee = new Employee(
                    name, dateOfBirth, gender, idCard, phone, email, employeeID, level, position, salary);

            employeeDataList.add(employee);
            line = buffReader.readLine();
        }
        buffReader.close();
        return employeeDataList;
    }

    public static void writeFile(Employee employee) throws IOException {
        FileWriter fileWriter = new FileWriter(EMPLOYEE_PATH, true);
        BufferedWriter buffWriter = new BufferedWriter(fileWriter);

        buffWriter.write(
                employee.getName() + ","
                        + employee.getDateOfBirth() + ","
                        + employee.getGender() + ","
                        + employee.getIdCard() + ","
                        + employee.getPhone() + ","
                        + employee.getEmail() + ","
                        + employee.getEmployeeID() + ","
                        + employee.getLevel() + ","
                        + employee.getPosition() + ","
                        + employee.getSalary() + "\n"
        );
        buffWriter.close();
    }

    public static void clear() throws IOException {
        FileWriter fileWriter = new FileWriter(EMPLOYEE_PATH);
        BufferedWriter buffWriter = new BufferedWriter(fileWriter);
        buffWriter.flush();
        buffWriter.close();
    }
}
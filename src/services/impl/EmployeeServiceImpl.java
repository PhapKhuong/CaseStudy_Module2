package services.impl;

import models.Employee;
import services.itf.EmployeeService;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    public static List<Employee> employeeList = new ArrayList<>();

    static {
        employeeList.add(new Employee("A1B1C1", "01/01/1987","Men", "123456", "123456789",
                "abc@gmail.com", 1, "Intermediate", "x", 1000));

        employeeList.add(new Employee("A2B2C2", "02/02/1988", "Women", "123456", "123456789",
                "abc@gmail.com", 2, "College", "y", 3000));

        employeeList.add(new Employee("A3B3C3", "03/03/1989", "Women", "234567", "123456789",
                "abc@gmail.com", 3, "College", "z", 20000));
    }

    @Override
    public List<Employee> display() {
        return employeeList;
    }

    @Override
    public void add(Employee employee) {
        employeeList.add(employee);
    }

    @Override
    public void edit(int id, Employee employee) {
        int i = 0;
        for (Employee e : employeeList) {
            if (id == e.getEmployeeID()) {
                break;
            } else {
                i++;
            }
        }
        employeeList.set(i, employee);
    }
}

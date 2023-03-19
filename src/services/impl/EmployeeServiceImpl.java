package services.impl;

import data.class_data.EmployeeData;
import models.Employee;
import services.itf.EmployeeService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private static List<Employee> employeeList = new ArrayList<>();

    static {
        try {
            employeeList = EmployeeData.readEmployeeFile();
        } catch (IOException e) {
            System.out.println("File is not exist");
        }
    }

    @Override
    public List<Employee> display() {
        try {
            employeeList = EmployeeData.readEmployeeFile();
            return employeeList;
        } catch (IOException e) {
            System.out.println("File is not exist");
        }
        return null;
    }

    @Override
    public void add(Employee employee) {
        try {
            EmployeeData.writeEmployeeFile(employee);
        } catch (IOException e) {
            System.out.println("File is not exist");
        }
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

        try {
            EmployeeData.clearEmployeeData();
            for (Employee e : employeeList) {
                EmployeeData.writeEmployeeFile(e);
            }
        } catch (IOException e) {
            System.out.println("File is not exist");
        }
    }
}

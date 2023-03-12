package services;

import controllers.FuramaController;
import models.Employee;
import models.Level;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    public static List<Employee> employeeList = new ArrayList<>();

    static {
        Employee e1 = new Employee("ABC", LocalDate.of(2000, 07, 29), true, "123456", "123456789", "abc@gmail.com", 1,
                Level.INTERMEDIATE, "xyz", 1000);
        employeeList.add(e1);
    }


    @Override
    public List<Employee> displayEmployee() {
        return employeeList;
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    @Override
    public void editEmployee(int employeeID, Employee newEmployee) {
        int i = 0;
        for (Employee e : employeeList) {
            if (employeeID == e.getEmployeeID()) {
                break;
            } else {
                i++;
            }
        }
        employeeList.set(i, newEmployee);
    }

    @Override
    public void returnMainMenu() {
        FuramaController.displayMainMenu();
    }
}

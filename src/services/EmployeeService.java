package services;

import models.Employee;

import java.util.List;

public interface EmployeeService extends Service {

    List<Employee> displayEmployee();

    void addEmployee(Employee employee);

    void editEmployee(int employeeID, Employee newEmployee);
}

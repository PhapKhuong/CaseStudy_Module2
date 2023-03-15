package services.itf;

import models.Employee;

import java.util.List;

public interface EmployeeService extends Service {

    List<Employee> display();

    void add(Employee employee);

    void edit(int id, Employee employee);
}

package models;

import java.time.LocalDate;

public class Employee extends Person{
    private int employeeID;
    private Level level;
    private String position;
    private long salary;

    public Employee(){
    }

    public Employee(String name, LocalDate dateOfBirth, boolean gender, String idCard, String phone, String email,
                    int employeeID, Level level, String position, long salary) {
        super(name, dateOfBirth, gender, idCard, phone, email);
        this.employeeID = employeeID;
        this.level = level;
        this.position = position;
        this.salary = salary;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                super.toString() +
                "employeeID=" + employeeID +
                ", level=" + level +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}

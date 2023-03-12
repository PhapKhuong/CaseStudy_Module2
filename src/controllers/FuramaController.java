package controllers;

import models.Employee;
import models.Level;
import services.EmployeeService;
import services.EmployeeServiceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class FuramaController {
    public static Scanner scanner = new Scanner(System.in);

    public static EmployeeService employeeService = new EmployeeServiceImpl();
    public static List<Employee> employees = employeeService.displayEmployee();

    public static void displayMainMenu() {


        int select = 0;
        do {
            System.out.println("================================");
            System.out.println("| WELCOME FURAMA RESORT DANANG |");
            System.out.println("================================");
            System.out.println("1. Employee Management");
            System.out.println("2. Customer Management");
            System.out.println("3. Facility Management");
            System.out.println("4. Booking Management");
            System.out.println("5. Promotion Management");
            System.out.println("6. Exit");
            System.out.println("================================");

            System.out.println("Please choose my service!");

            try {
                select = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please choose from 1 to 6");
            }
            switch (select) {
                case 1: // Employee Management
                    int selectEmployeeService = 0;
                    do {
                        System.out.println("========================");
                        System.out.println("| EMPLOYEE MANAGERMENT |");
                        System.out.println("========================");
                        System.out.println("1. Display list employees");
                        System.out.println("2. Add new employee");
                        System.out.println("3. Edit employee");
                        System.out.println("4. Return main menu");
                        System.out.println("========================");

                        try {
                            selectEmployeeService = Integer.parseInt(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Please choose from 1 to 4");
                        }

                        switch (selectEmployeeService) {
                            case 1: // Display list employees
                                if (employees.size() == 0) {
                                    System.out.println("Employee's list is empty");
                                } else {
                                    for (Employee e : employees) {
                                        System.out.println(e);
                                    }
                                }
                                break;
                            case 2: // Add new employee
                                System.out.println("Enter employee's name");
                                String name = scanner.nextLine();

                                System.out.println("Enter employee's birthday (yyyy-mm-dd)");
                                String birthdayStr = scanner.nextLine();
                                LocalDate dateOfBirth = LocalDate.of(
                                        Integer.parseInt(birthdayStr.substring(0, 4)), Integer.parseInt(birthdayStr.substring(5, 7)),
                                        Integer.parseInt(birthdayStr.substring(8, 10)));

                                System.out.println("Enter employee's gender");
                                boolean gender = Boolean.parseBoolean(scanner.nextLine());

                                System.out.println("Enter employee's indentity card");
                                String idCard = scanner.nextLine();

                                System.out.println("Enter employee's phone number");
                                String phone = scanner.nextLine();

                                System.out.println("Enter employee's email");
                                String email = scanner.nextLine();

                                int employeeID = 0;
                                do {
                                    boolean test = false;
                                    System.out.println("Enter employee's ID");
                                    employeeID = Integer.parseInt(scanner.nextLine());
                                    for (Employee employee : employees) {
                                        if (employeeID == employee.getEmployeeID()) {
                                            test = true;
                                            break;
                                        }
                                    }
                                    if (!test) {
                                        break;
                                    }
                                } while (true);

                                Level level = null;
                                try {
                                    System.out.println("Enter employee's level");
                                    String levelStr = scanner.nextLine();
                                    level = Level.valueOf(levelStr);
                                } catch (IllegalArgumentException e) {
                                    System.out.println("Level is incorrect. Please type level again!");
                                }

                                System.out.println("Enter employee's position");
                                String position = scanner.nextLine();

                                System.out.println("Enter employee's salary");
                                long salary = Long.parseLong(scanner.nextLine());

                                Employee addEmployee = new Employee(
                                        name, dateOfBirth, gender, idCard, phone, email, employeeID,
                                        level, position, salary);

                                employeeService.addEmployee(addEmployee);
                                break;

                            case 3: // Edit employee
                                boolean test = false;
                                System.out.println("Enter employee's ID");
                                employeeID = Integer.parseInt(scanner.nextLine());
                                for (Employee employee : employees) {
                                    if (employeeID == employee.getEmployeeID()) {
                                        System.out.println("Enter employee's name");
                                        String newName = scanner.nextLine();

                                        System.out.println("Enter employee's birthday (yyyy-mm-dd)");
                                        String newBirthdayStr = scanner.nextLine();
                                        LocalDate newDateOfBirth = LocalDate.of(
                                                Integer.parseInt(newBirthdayStr.substring(0, 4)), Integer.parseInt(newBirthdayStr.substring(5, 7)),
                                                Integer.parseInt(newBirthdayStr.substring(8, 10)));

                                        System.out.println("Enter employee's gender");
                                        boolean newGender = Boolean.parseBoolean(scanner.nextLine());

                                        System.out.println("Enter employee's indentity card");
                                        String newIdCard = scanner.nextLine();

                                        System.out.println("Enter employee's phone number");
                                        String newPhone = scanner.nextLine();

                                        System.out.println("Enter employee's email");
                                        String newEmail = scanner.nextLine();

                                        Level newLevel = null;
                                        try {
                                            System.out.println("Enter employee's level");
                                            String newLevelStr = scanner.nextLine();
                                            newLevel = Level.valueOf(newLevelStr);
                                        } catch (IllegalArgumentException e) {
                                            System.out.println("Level is incorrect. Please type level again!");
                                        }

                                        System.out.println("Enter employee's position");
                                        String newPosition = scanner.nextLine();

                                        System.out.println("Enter employee's salary");
                                        long newSalary = Long.parseLong(scanner.nextLine());

                                        Employee newEmployee = new Employee(
                                                newName, newDateOfBirth, newGender, newIdCard, newPhone, newEmail,
                                                employeeID, newLevel, newPosition, newSalary);

                                        employeeService.editEmployee(employeeID, newEmployee);
                                        test = true;
                                        break;
                                    }
                                }
                                if (!test) {
                                    System.out.println("This employee does not exist");
                                }
                                break;

                            case 4: // Return main menu
                                employeeService.returnMainMenu();
                                break;
                            default:
                                break;
                        }
                    } while (selectEmployeeService < 5);
                    break;

                case 2: // Customer Management
                    int selectCustomerService = 0;
                    do {
                        System.out.println("========================");
                        System.out.println("| CUSTOMER MANAGERMENT |");
                        System.out.println("========================");
                        System.out.println("1. Display list customers");
                        System.out.println("2. Add new customer");
                        System.out.println("3. Edit customer");
                        System.out.println("4. Return main menu");
                        System.out.println("========================");

                        try {
                            selectCustomerService = Integer.parseInt(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Please choose from 1 to 4");
                        }

                        switch (selectCustomerService) {
                            case 1: // Display list customers
                                break;
                            case 2: // Add new customer
                                break;
                            case 3: // Edit customer
                                break;
                            case 4: // Return main menu
                                displayMainMenu();
                                break;
                            default:
                                break;
                        }
                    } while (selectCustomerService < 5);
                    break;

                case 3: // Facility Management
                    int selectFacilityService = 0;
                    do {
                        System.out.println("========================");
                        System.out.println("| FACILITY MANAGERMENT |");
                        System.out.println("========================");
                        System.out.println("1. Display list facility");
                        System.out.println("2. Add new facility");
                        System.out.println("3. Display list facility maintenance");
                        System.out.println("4. Return main menu");
                        System.out.println("========================");

                        try {
                            selectFacilityService = Integer.parseInt(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Please choose from 1 to 4");
                        }

                        switch (selectFacilityService) {
                            case 1: // Display list facility
                                break;
                            case 2: // Add new facility
                                break;
                            case 3: // Display list facility maintenance
                                break;
                            case 4: // Return main menu
                                displayMainMenu();
                                break;
                            default:
                                break;
                        }
                    } while (selectFacilityService < 5);
                    break;

                case 4: // Booking Management
                    int selectBookingService = 0;
                    do {
                        System.out.println("=====================");
                        System.out.println("| BOOKING MANAGERMENT |");
                        System.out.println("=====================");
                        System.out.println("1. Add new booking");
                        System.out.println("2. Display list booking");
                        System.out.println("3. Creat new contracts");
                        System.out.println("4. Display list contracts");
                        System.out.println("5. Edit contracts");
                        System.out.println("6. Return main menu");
                        System.out.println("=====================");

                        try {
                            selectBookingService = Integer.parseInt(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Please choose from 1 to 6");
                        }

                        switch (selectBookingService) {
                            case 1: // Add new booking
                                break;
                            case 2: // Display list booking
                                break;
                            case 3: // Creat new contracts
                                break;
                            case 4: // Display list contracts
                                break;
                            case 5: // Edit contracts
                                break;
                            case 6: // Return main menu
                                displayMainMenu();
                                break;
                            default:
                                break;
                        }
                    } while (selectBookingService < 7);
                    break;

                case 5: // Promotion Management
                    int selectPromotionService = 0;
                    do {
                        System.out.println("=======================");
                        System.out.println("| PROMOTION MANAGERMENT |");
                        System.out.println("=======================");
                        System.out.println("1. Display list customers use service");
                        System.out.println("2. Display list customers get voucher");
                        System.out.println("3. Return main menu");
                        System.out.println("=======================");

                        try {
                            selectPromotionService = Integer.parseInt(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Please choose from 1 to 6");
                        }

                        switch (selectPromotionService) {
                            case 1: // Display list customers use service
                                break;
                            case 2: // Display list customers get voucher
                                break;
                            case 3: // Return main menu
                                displayMainMenu();
                                break;
                            default:
                                break;
                        }
                    } while (selectPromotionService < 7);
                    break;

                default:
                    break;
            }
        } while (select != 6);
        System.exit(0);
    }

    public static void main(String[] args) {

        displayMainMenu();
    }
}
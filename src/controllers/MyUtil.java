package controllers;

import models.Customer;
import models.Employee;

import java.util.List;
import java.util.Scanner;

public class MyUtil {
    public static Scanner scanner = new Scanner(System.in);

    private MyUtil() {
    }

    public static boolean checkID(int id, List<Integer> ids) {
        if (ids.contains(id)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkName(String name, List<String> names) {
        if (names.contains(name)) {
            return true;
        } else {
            return false;
        }
    }

    public static void editEmployeeByID(Employee employee) {
        int select = 0;
        do {
            System.out.println("1. Name");
            System.out.println("2. Date of birth");
            System.out.println("3. Gender");
            System.out.println("4. ID Card");
            System.out.println("5. Phone number");
            System.out.println("6. Email");
            System.out.println("7. Level");
            System.out.println("8. Position");
            System.out.println("9. Salary");
            System.out.println("10. Finish");

            System.out.println("Select the information to edit");
            select = Integer.parseInt(scanner.nextLine());

            switch (select) {
                case 1:
                    System.out.println("Enter new name");
                    String name = scanner.nextLine();
                    employee.setName(name);
                    break;
                case 2:
                    System.out.println("Enter new date of birth");
                    String dateOfBirth = scanner.nextLine();
                    employee.setDateOfBirth(dateOfBirth);
                    break;
                case 3:
                    System.out.println("Enter new gender");
                    String gender = MyUtil.selectGender();
                    employee.setGender(gender);
                    break;
                case 4:
                    System.out.println("Enter new ID card");
                    String idCard = scanner.nextLine();
                    employee.setIdCard(idCard);
                    break;
                case 5:
                    System.out.println("Enter new phone number");
                    String phone = scanner.nextLine();
                    employee.setPhone(phone);
                    break;
                case 6:
                    System.out.println("Enter new email");
                    String email = scanner.nextLine();
                    employee.setEmail(email);
                    break;
                case 7:
                    System.out.println("Enter new level");
                    String level = MyUtil.selectLevel();
                    employee.setLevel(level);
                    break;
                case 8:
                    System.out.println("Enter new position");
                    String position = MyUtil.selectPosition();
                    employee.setPosition(position);
                    break;
                case 9:
                    System.out.println("Enter new position");
                    long salary = Long.parseLong(scanner.nextLine());
                    employee.setSalary(salary);
                    break;
                case 10:
                    break;
            }
        } while (select < 10);
    }

    public static void editCustomerByID(Customer customer) {
        int select = 0;
        do {
            System.out.println("1. Name");
            System.out.println("2. Date of birth");
            System.out.println("3. Gender");
            System.out.println("4. ID Card");
            System.out.println("5. Phone number");
            System.out.println("6. Email");
            System.out.println("7. Customer type");
            System.out.println("8. Address");
            System.out.println("9. Finish");

            System.out.println("Select the information to edit");
            select = Integer.parseInt(scanner.nextLine());

            switch (select) {
                case 1:
                    System.out.println("Enter new name");
                    String name = scanner.nextLine();
                    customer.setName(name);
                    break;
                case 2:
                    System.out.println("Enter new date of birth");
                    String dateOfBirth = scanner.nextLine();
                    customer.setDateOfBirth(dateOfBirth);
                    break;
                case 3:
                    System.out.println("Enter new gender");
                    String gender = MyUtil.selectGender();
                    customer.setGender(gender);
                    break;
                case 4:
                    System.out.println("Enter new ID card");
                    String idCard = scanner.nextLine();
                    customer.setIdCard(idCard);
                    break;
                case 5:
                    System.out.println("Enter new phone number");
                    String phone = scanner.nextLine();
                    customer.setPhone(phone);
                    break;
                case 6:
                    System.out.println("Enter new email");
                    String email = scanner.nextLine();
                    customer.setEmail(email);
                    break;
                case 7:
                    System.out.println("Enter new customer type");
                    String customerType = MyUtil.selectCustomerType();
                    customer.setCustomerType(customerType);
                    break;
                case 8:
                    System.out.println("Enter new address");
                    String address = scanner.nextLine();
                    customer.setAddress(address);
                    break;
                case 9:
                    break;
            }
        } while (select < 9);
    }

    public static String selectGender() {
        int select;
        do {
            System.out.println("1. Men");
            System.out.println("2. Women");
            System.out.println("Select gender");
            select = Integer.parseInt(scanner.nextLine());
            switch (select) {
                case 1:
                    return "Men";
                case 2:
                    return "Women";
            }
        } while (true);
    }

    public static String selectLevel() {
        int select;
        do {
            System.out.println("1. Intermediate");
            System.out.println("2. College");
            System.out.println("3. University");
            System.out.println("4. After University");
            System.out.println("Select level");

            select = Integer.parseInt(scanner.nextLine());
            switch (select) {
                case 1:
                    return "Intermediate";
                case 2:
                    return "College";
                case 3:
                    return "University";
                case 4:
                    return "After University";
            }
        } while (true);
    }

    public static String selectCustomerType() {
        int select;
        do {
            System.out.println("1. Diamond");
            System.out.println("2. Platinum");
            System.out.println("3. Gold");
            System.out.println("4. Silver");
            System.out.println("5. Member");
            System.out.println("Select customer type");

            select = Integer.parseInt(scanner.nextLine());
            switch (select) {
                case 1:
                    return "Diamond";
                case 2:
                    return "Platinum";
                case 3:
                    return "Gold";
                case 4:
                    return "Silver";
                case 5:
                    return "Member";
            }
        } while (true);
    }

    public static String selectRentalType() {
        int select;
        do {
            System.out.println("1. by year");
            System.out.println("2. by month");
            System.out.println("3. by day");
            System.out.println("4. by hour");
            System.out.println("Select rental type");

            select = Integer.parseInt(scanner.nextLine());
            switch (select) {
                case 1:
                    return "by year";
                case 2:
                    return "by month";
                case 3:
                    return "by day";
                case 4:
                    return "by hour";
            }
        } while (true);
    }

    public static String selectPosition() {
        int select;
        do {
            System.out.println("1. Reception");
            System.out.println("2. Attendant");
            System.out.println("3. Professional");
            System.out.println("4. Supervisor");
            System.out.println("5. Manager");
            System.out.println("6. Director");
            System.out.println("Select position");

            select = Integer.parseInt(scanner.nextLine());
            switch (select) {
                case 1:
                    return "Reception";
                case 2:
                    return "Attendant";
                case 3:
                    return "Professional";
                case 4:
                    return "Supervisor";
                case 5:
                    return "Manager";
                case 6:
                    return "Director";
            }
        } while (true);
    }
}
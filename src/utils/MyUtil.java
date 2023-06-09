package utils;

import libs.DateOfBirthException;
import libs.MyRegex;
import models.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static controllers.FuramaController.bookingMap;
import static controllers.FuramaController.bookings;

public class MyUtil {
    public static Scanner scanner = new Scanner(System.in);

    private MyUtil() {
    }

    public static int inputInt() {
        int number;
        while (true) {
            try {
                System.out.println("Input ID");
                number = Integer.parseInt(scanner.nextLine());
                return number;
            } catch (NumberFormatException e) {
                System.out.println("Input must be a number!");
            }
        }
    }

    public static long inputLong() {
        long number;
        do {
            while (true) {
                try {
                    System.out.println("Input number");
                    number = Long.parseLong(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Salary must be a number!");
                }
            }
        } while (number <= 0);
        return number;
    }

    public static boolean checkID(int id, List<Integer> ids) {
        return ids.contains(id);
    }

    public static boolean checkStr(String str, List<String> strList) {
        return strList.contains(str);
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

            try {
                System.out.println("Select the information to edit");
                select = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Select from 1 to 10");
            }

            switch (select) {
                case 1:
                    System.out.println("Enter new name");
                    String name = scanner.nextLine();
                    employee.setName(name);
                    break;
                case 2:
                    while (true) {
                        try {
                            System.out.println("Enter new date of birth");
                            String dateOfBirth = scanner.nextLine();
                            employee.setDateOfBirth(dateOfBirth);
                            break;
                        } catch (DateTimeParseException e) {
                            System.out.println("Incorrect format, please input again");
                        } catch (DateOfBirthException e) {
                            System.out.println("Unreasonable age, please input again");
                        }
                    }
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
                    long salary = MyUtil.inputLong();
                    employee.setSalary(salary);
                    break;
                case 10:
                    break;
            }
        }
        while (select < 10);
    }

    public static void editContractByID(Contract contract) {
        int select = 0;
        do {
            System.out.println("1. Booking ID");
            System.out.println("2. Deposits");
            System.out.println("3. Payment");
            System.out.println("4. Finish");

            try {
                System.out.println("Select the information to edit");
                select = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Select from 1 to 5");
            }

            switch (select) {
                case 1:
                    int bookingID;
                    boolean test;
                    do {
                        while (true) {
                            try {
                                System.out.println("Input booking ID to make contract");
                                bookingID = Integer.parseInt(scanner.nextLine());
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("ID is a number");
                            }
                        }
                        test = MyUtil.checkBookingID(bookingID, bookingMap);
                        if (!test) {
                            System.out.println("This booking doesn't require to contract");
                        }
                    } while (!test);

                    int customerID = 0;
                    for (Booking booking : bookings) {
                        if (booking.getBookingID() == bookingID) {
                            customerID = booking.getCustomerID();
                            break;
                        }
                    }

                    contract.setBookingID(bookingID);
                    contract.setCustomerID(customerID);
                    break;
                case 2:
                    System.out.println("Input deposits");
                    long deposits = MyUtil.inputLong();
                    contract.setDeposits(deposits);
                    break;
                case 3:
                    System.out.println("Input payment");
                    long payment = MyUtil.inputLong();
                    contract.setPayment(payment);
                    break;
                case 4:
                    break;
            }
        }
        while (select < 4);
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

            try {
                System.out.println("Select the information to edit");
                select = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Select from 1 to 9");
            }

            switch (select) {
                case 1:
                    System.out.println("Enter new name");
                    String name = scanner.nextLine();
                    customer.setName(name);
                    break;
                case 2:
                    while (true) {
                        try {
                            System.out.println("Enter new date of birth");
                            String dateOfBirth = scanner.nextLine();
                            customer.setDateOfBirth(dateOfBirth);
                            break;
                        } catch (DateTimeParseException e) {
                            System.out.println("Incorrect format, please input again!");
                        } catch (DateOfBirthException e) {
                            System.out.println("Unreasonable age, please input again");
                        }
                    }
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
            while (true) {
                try {
                    System.out.println("1. Men");
                    System.out.println("2. Women");
                    System.out.println("Select gender");
                    select = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Select 1 or 2");
                }
            }

            switch (select) {
                case 1:
                    return "Men";
                case 2:
                    return "Women";
            }
        }
        while (true);
    }

    public static String selectLevel() {
        int select;
        do {
            while (true) {
                try {
                    System.out.println("1. Intermediate");
                    System.out.println("2. College");
                    System.out.println("3. University");
                    System.out.println("4. After University");
                    System.out.println("Select level");

                    select = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Select from 1 to 4");
                }
            }

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
            while (true) {
                try {
                    System.out.println("1. Diamond");
                    System.out.println("2. Platinum");
                    System.out.println("3. Gold");
                    System.out.println("4. Silver");
                    System.out.println("5. Member");
                    System.out.println("Select customer type");

                    select = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Select from 1 to 5");
                }
            }

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
            while (true) {
                try {
                    System.out.println("1. By year");
                    System.out.println("2. By month");
                    System.out.println("3. By day");
                    System.out.println("4. By hour");
                    System.out.println("Select rental type");
                    select = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Select from 1 to 4");
                }
            }

            switch (select) {
                case 1:
                    return "By year";
                case 2:
                    return "By month";
                case 3:
                    return "By day";
                case 4:
                    return "By hour";
            }
        } while (true);
    }

    public static String selectPosition() {
        int select;
        do {
            while (true) {
                try {
                    System.out.println("1. Reception");
                    System.out.println("2. Attendant");
                    System.out.println("3. Professional");
                    System.out.println("4. Supervisor");
                    System.out.println("5. Manager");
                    System.out.println("6. Director");
                    System.out.println("Select position");

                    select = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Select from 1 to 6");
                }
            }

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

    public static int selectID(List<Customer> customers) {
        int select;
        int exit = 0;
        boolean test;

        System.out.println("List of customer:");
        for (Customer customer : customers) {
            System.out.println(customer);
        }

        do {
            test = false;
            System.out.println("Enter customer ID");
            select = Integer.parseInt(scanner.nextLine());
            for (Customer customer : customers) {
                if (customer.getCustomerID() == select) {
                    System.out.println(customer);
                    test = true;
                    break;
                }
            }
            if (!test) {
                System.out.println("Customer is not exist");
                select = -1;
            }
            do {
                System.out.println("Do you finish?");
                System.out.println("1. OK");
                System.out.println("2. Select again");
                exit = Integer.parseInt(scanner.nextLine());
            } while (exit != 1 && exit != 2);
        } while (exit == 2);

        return select;
    }

    public static String selectServiceID(List<String> ids) {
        String select;
        int exit = 0;
        boolean test;

        System.out.println("List of service:");
        for (String id : ids) {
            System.out.println(id);
        }

        do {
            test = false;
            System.out.println("Enter service ID");
            select = scanner.nextLine();
            for (String id : ids) {
                if (id.equals(select)) {
                    System.out.println("Service is selected: " + id);
                    test = true;
                    break;
                }
            }
            if (!test) {
                System.out.println("Facility is not exist");
                select = null;
            }
            do {
                System.out.println("Do you finish?");
                System.out.println("1. OK");
                System.out.println("2. Select again");
                exit = Integer.parseInt(scanner.nextLine());
            } while (exit != 1 && exit != 2);
        } while (exit == 2);

        return select;
    }

    public static LocalDate parseDate(String str) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(MyRegex.REGEX_DATE);

        return LocalDate.parse(str, formatter);
    }

    public static String parseString(LocalDate date) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(MyRegex.REGEX_DATE);

        return date.format(formatter);
    }

    public static float setArea() {
        float area;
        do {
            while (true) {
                try {
                    System.out.println("Enter area (> 30m2)");
                    area = Float.parseFloat(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Area must be a number");
                }
            }
        } while (area <= 30);
        return area;
    }

    public static long setPrice() {
        long price;
        do {
            while (true) {
                try {
                    System.out.println("Enter price");
                    price = Long.parseLong(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Price must be a number");
                }
            }
        } while (price <= 0);
        return price;
    }

    public static int setCapacity() {
        int capacity;
        do {
            while (true) {
                try {
                    System.out.println("Enter capacity");
                    capacity = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Capacity must be a number");
                }
            }
        } while (capacity <= 0 || capacity >= 20);
        return capacity;
    }

    public static int setFloor() {
        int floor;
        do {
            while (true) {
                try {
                    System.out.println("Enter floor");
                    floor = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Floor must be a number");
                }
            }
        } while (floor <= 0);
        return floor;
    }

    public static String setStandard() {
        String standard;
        boolean testStandard;
        do {
            System.out.println("Enter standard");
            standard = scanner.nextLine();
            testStandard = standard.matches(MyRegex.REGEX_NAME);
        } while (!testStandard);

        return standard;
    }

    public static boolean checkBookingID(int id, Map<Integer, String> map) {
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            boolean isVilla = entry.getValue().matches(MyRegex.REGEX_VILLA_ID);
            boolean isHouse = entry.getValue().matches(MyRegex.REGEX_HOUSE_ID);
            boolean check = isVilla || isHouse;

            if (entry.getKey() == id && check) {
                return true;
            }
        }
        return false;
    }
}
package controllers;

import libs.DateOfBirthException;
import libs.MyRegex;
import utils.MyUtil;
import models.*;
import services.impl.BookingServiceImpl;
import services.impl.CustomerServiceImpl;
import services.impl.FacilityServiceImpl;
import services.itf.BookingService;
import services.itf.CustomerService;
import services.itf.EmployeeService;
import services.impl.EmployeeServiceImpl;
import services.itf.FacilityService;

import java.time.format.DateTimeParseException;
import java.util.*;

public class FuramaController {
    public static Scanner scanner = new Scanner(System.in);

    // EMPLOYEE
    public static EmployeeService employeeService = new EmployeeServiceImpl();
    public static List<Employee> employees = employeeService.display();
    public static List<Integer> employeeIDs = new ArrayList<>();

    static {
        for (Employee employee : employees) {
            employeeIDs.add(employee.getEmployeeID());
        }
    }

    // CUSTOMER
    public static CustomerService customerService = new CustomerServiceImpl();
    public static List<Customer> customers = customerService.display();
    public static List<Integer> customerIDs = new LinkedList<>();

    static {
        for (Customer customer : customers) {
            customerIDs.add(customer.getCustomerID());
        }
    }

    // FACILITY
    public static FacilityService facilityService = new FacilityServiceImpl();
    public static Map<Facility, Integer> facilities = facilityService.display();
    public static List<String> facilityNames = new ArrayList<>();
    public static List<String> facilityIDs = new ArrayList<>();

    static {
        for (Facility key : facilities.keySet()) {
            facilityNames.add(key.getServiceName());
        }

        for (Facility key : facilities.keySet()) {
            facilityIDs.add(key.getServiceID());
        }
    }

    // BOOKING
    public static BookingService bookingService = new BookingServiceImpl();
    public static Set<Booking> bookings = bookingService.display();


    public static void main(String[] args) {
        displayMainMenu();
    }

    // PHƯƠNG THỨC HIỂN THỊ MENU CHÍNH
    private static void displayMainMenu() {
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
                case 1:
                    displayEmployeeMenu();
                    break;
                case 2:
                    displayCustomerMenu();
                    break;
                case 3:
                    displayFacilityMenu();
                    break;
                case 4:
                    displayBookingMenu();
                    break;
                case 5:
                    displayPromotionMenu();
                    break;
            }
        } while (select < 6);
        System.exit(0);
    }


    // METHOD HIỂN THỊ MENU EMPLOYEE
    private static void displayEmployeeMenu() {
        new Employee().showNotification();
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
                case 1:
                    displayEmployees();
                    break;

                case 2:
                    addEmployee();
                    break;

                case 3:
                    editEmployee();
                    break;

                case 4:
                    break;
            }
        } while (selectEmployeeService < 4);
    }

    // CÁC METHOD ĐƯỢC GỌI TỪ MENU EMPLOYEE
    private static void displayEmployees() {
        if (employees.size() == 0) {
            System.out.println("List of employees is empty");
        } else {
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }

    private static void addEmployee() {
        Employee employee = new Employee();

        int id;
        do {
            id = MyUtil.inputInt();
        } while (MyUtil.checkID(id, employeeIDs));
        employee.setEmployeeID(id);

        System.out.println("Enter employee's name");
        String name = scanner.nextLine();
        employee.setName(name);

        while (true) {
            try {
                System.out.println("Enter date of birth (dd/MM/yyyy)");
                String dateOfBirth = scanner.nextLine();
                employee.setDateOfBirth(dateOfBirth);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Incorrect format, please input again!");
            } catch (DateOfBirthException e) {
                System.out.println("Unreasonable age, please input again");
            }
        }

        System.out.println("Enter employee's gender");
        String gender = MyUtil.selectGender();
        employee.setGender(gender);

        System.out.println("Enter employee's indentity card");
        String idCard = scanner.nextLine();
        employee.setIdCard(idCard);

        System.out.println("Enter employee's phone number");
        String phone = scanner.nextLine();
        employee.setPhone(phone);

        System.out.println("Enter employee's email");
        String email = scanner.nextLine();
        employee.setEmail(email);

        System.out.println("Enter employee's level");
        String level = MyUtil.selectLevel();
        employee.setLevel(level);

        System.out.println("Enter employee's position");
        String position = MyUtil.selectPosition();
        employee.setPosition(position);

        long salary;
        salary = MyUtil.inputSalary();
        employee.setSalary(salary);

        employeeService.add(employee);
        employees = employeeService.display();
        employeeIDs.add(employee.getEmployeeID());
    }

    private static void editEmployee() {
        int id = MyUtil.inputInt();
        boolean test = MyUtil.checkID(id, employeeIDs);

        if (test) {
            int index = employeeIDs.indexOf(id);
            MyUtil.editEmployeeByID(employees.get(index));
            employeeService.edit(id, employees.get(index));
            employees = employeeService.display();
        } else {
            System.out.println("This employee is not exist!");
        }
    }


    // METHOD HIỂN THỊ MENU CUSTOMER
    private static void displayCustomerMenu() {
        new Customer().showNotification();
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
                case 1:
                    displayCustomer();
                    break;
                case 2:
                    addCustomer();
                    break;
                case 3:
                    editCustomer();
                    break;
                case 4:
                    break;
            }
        } while (selectCustomerService < 4);
    }

    // CÁC METHOD ĐƯỢC GỌI TỪ MENU CUSTOMER
    private static void displayCustomer() {
        if (customers.size() == 0) {
            System.out.println("List of customers is empty");
        } else {
            for (Customer customer : customers) {
                System.out.println(customer);
            }
        }
    }

    private static void addCustomer() {
        Customer customer = new Customer();

        int id;
        do {
            id = MyUtil.inputInt();
        } while (MyUtil.checkID(id, customerIDs));
        customer.setCustomerID(id);

        System.out.println("Enter customer's name");
        String name = scanner.nextLine();
        customer.setName(name);

        while (true) {
            try {
                System.out.println("Enter date of birth (dd/MM/yyyy)");
                String dateOfBirth = scanner.nextLine();
                customer.setDateOfBirth(dateOfBirth);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Incorrect format, please input again");
            } catch (DateOfBirthException e) {
                System.out.println("Unreasonable age, please input again");
            }
        }

        System.out.println("Enter customer's gender");
        String gender = MyUtil.selectGender();
        customer.setGender(gender);

        System.out.println("Enter customer's indentity card");
        String idCard = scanner.nextLine();
        customer.setIdCard(idCard);

        System.out.println("Enter customer's phone number");
        String phone = scanner.nextLine();
        customer.setPhone(phone);

        System.out.println("Enter customer's email");
        String email = scanner.nextLine();
        customer.setEmail(email);

        System.out.println("Enter customer type");
        String customerType = MyUtil.selectCustomerType();
        customer.setCustomerType(customerType);

        System.out.println("Enter customer's address");
        String address = scanner.nextLine();
        customer.setAddress(address);

        customerService.add(customer);
        customers = customerService.display();
        customerIDs.add(customer.getCustomerID());
    }

    private static void editCustomer() {
        int id = MyUtil.inputInt();
        boolean test = MyUtil.checkID(id, customerIDs);

        if (test) {
            int index = customerIDs.indexOf(id);
            MyUtil.editCustomerByID(customers.get(index));
            customerService.edit(id, customers.get(index));
            customers = customerService.display();
        } else {
            System.out.println("This customer is not exist!");
        }
    }


    // METHOD HIỂN THỊ MENU FACILITY
    private static void displayFacilityMenu() {
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
                case 1:
                    displayFacility();
                    break;
                case 2:
                    addFacility();
                    break;
                case 3:
                    displayFacilityMaintenance();
                    break;
                case 4:
                    break;
            }
        } while (selectFacilityService < 4);
    }

    // CÁC METHOD ĐƯỢC GỌI TỪ MENU FACILITY
    private static void displayFacility() {
        if (facilities.size() == 0) {
            System.out.println("List of facility is empty");
        } else {
            for (Map.Entry<Facility, Integer> entry : facilities.entrySet()) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }
        }
    }

    private static void addFacility() {
        int selectFacility = 0;
        do {
            System.out.println("1. Add new villa");
            System.out.println("2. Add new house");
            System.out.println("3. Add new room");
            System.out.println("4. Back to menu");

            try {
                selectFacility = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please choose from 1 to 4");
            }

            switch (selectFacility) {
                case 1:
                    addVilla();
                    break;
                case 2:
                    addHouse();
                    break;
                case 3:
                    addRoom();
                    break;
                case 4:
                    break;
            }
        } while (selectFacility < 4);
    }

    // CÁC METHOD ĐƯỢC TRIỂN KHAI TỪ ADD FACILITY
    private static void addVilla() {
        String serviceID;
        boolean firstTestID;
        boolean secondTestID;
        do {
            System.out.println("Enter facility ID");
            serviceID = scanner.nextLine();
            firstTestID = MyUtil.checkStr(serviceID, facilityIDs);
            secondTestID = serviceID.matches(MyRegex.REGEX_VILLA_ID);
        } while (firstTestID || !secondTestID);

        String serviceName;
        boolean firstTestName;
        boolean secondTestName;
        do {
            System.out.println("Enter facility name");
            serviceName = scanner.nextLine();
            firstTestName = MyUtil.checkStr(serviceName, facilityNames);
            secondTestName = serviceName.matches(MyRegex.REGEX_NAME);
        } while (firstTestName || !secondTestName);

        float usageArea = MyUtil.setArea();

        long unitPrice = MyUtil.setPrice();

        int capacity = MyUtil.setCapacity();

        System.out.println("Enter rental type");
        String rentalType = MyUtil.selectRentalType();

        String standard = MyUtil.setStandard();

        float poolArea = MyUtil.setArea();

        int numberOfFloor = MyUtil.setFloor();

        Villa villa = new Villa(
                serviceID, serviceName, usageArea, unitPrice, capacity, rentalType, standard, poolArea, numberOfFloor);

        facilityService.add(villa);
        facilities = facilityService.display();
        facilityNames.add(villa.getServiceName());
        facilityIDs.add(villa.getServiceID());
    }

    private static void addHouse() {
        String serviceID;
        boolean firstTestID;
        boolean secondTestID;
        do {
            System.out.println("Enter facility ID");
            serviceID = scanner.nextLine();
            firstTestID = MyUtil.checkStr(serviceID, facilityIDs);
            secondTestID = serviceID.matches(MyRegex.REGEX_HOUSE_ID);
        } while (firstTestID || !secondTestID);

        String serviceName;
        boolean firstTestName;
        boolean secondTestName;
        do {
            System.out.println("Enter facility name");
            serviceName = scanner.nextLine();
            firstTestName = MyUtil.checkStr(serviceName, facilityNames);
            secondTestName = serviceName.matches(MyRegex.REGEX_NAME);
        } while (firstTestName || !secondTestName);

        float usageArea = MyUtil.setArea();

        long unitPrice = MyUtil.setPrice();

        int capacity = MyUtil.setCapacity();

        System.out.println("Enter rental type");
        String rentalType = MyUtil.selectRentalType();

        String standard = MyUtil.setStandard();

        int numberOfFloor = MyUtil.setFloor();

        House house = new House(
                serviceID, serviceName, usageArea, unitPrice, capacity, rentalType, standard, numberOfFloor);

        facilityService.add(house);
        facilities = facilityService.display();
        facilityNames.add(house.getServiceName());
        facilityIDs.add(house.getServiceID());
    }

    private static void addRoom() {
        String serviceID;
        boolean firstTestID;
        boolean secondTestID;
        do {
            System.out.println("Enter facility ID");
            serviceID = scanner.nextLine();
            firstTestID = MyUtil.checkStr(serviceID, facilityIDs);
            secondTestID = serviceID.matches(MyRegex.REGEX_ROOM_ID);
        } while (firstTestID || !secondTestID);

        String serviceName;
        boolean fistTestName;
        boolean secondTestName;
        do {
            System.out.println("Enter facility name");
            serviceName = scanner.nextLine();
            fistTestName = MyUtil.checkStr(serviceName, facilityNames);
            secondTestName = serviceName.matches(MyRegex.REGEX_NAME);
        } while (fistTestName || !secondTestName);

        float usageArea = MyUtil.setArea();

        long unitPrice = MyUtil.setPrice();

        int capacity = MyUtil.setCapacity();

        System.out.println("Enter rental type");
        String rentalType = MyUtil.selectRentalType();

        System.out.println("Enter free service");
        String freeService = scanner.nextLine();

        Room room = new Room(
                serviceID, serviceName, usageArea, unitPrice, capacity, rentalType, freeService);

        facilityService.add(room);
        facilities = facilityService.display();
        facilityNames.add(room.getServiceName());
        facilityIDs.add(room.getServiceID());
    }

    private static void displayFacilityMaintenance() {
        Map<Facility, Integer> maintenances = facilityService.displayMaintenance();

        if (maintenances.size() == 0) {
            System.out.println("List of maintenance is empty");
        } else {
            for (Map.Entry<Facility, Integer> entry : maintenances.entrySet()) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }
        }
    }

    // METHOD HIỂN THỊ MENU BOOKING
    private static void displayBookingMenu() {
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
                case 1:
                    addBooking();

                    break;
                case 2:
                    displayBooking();
                    break;
                case 3:
                    creatContract();
                    break;
                case 4:
                    displayContract();
                    break;
                case 5:
                    editContract();
                    break;
                case 6:
                    break;
            }
        } while (selectBookingService < 6);
    }

    // CÁC METHOD ĐƯỢC GỌI TỪ MENU FACILITY
    private static void addBooking() {
        Booking booking = new Booking();
        /*bookingService.add(booking);*/

        int customerID;
        do {
            customerID = MyUtil.selectID(customers);
        }
        while (customerID == -1);
        booking.setCustomerID(customerID);

        int id = MyUtil.inputInt();
        booking.setBookingID(id);

        while (true) {
            try {
                System.out.println("Enter begin date (dd/MM/yyyy");
                String beginDate = scanner.nextLine();
                booking.setBeginDate(beginDate);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Incorrect format, please input again!");
            }
        }

        while (true) {
            try {
                System.out.println("Enter finish date (dd/MM/yyyy");
                String finishDate = scanner.nextLine();
                booking.setFinishDate(finishDate);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Incorrect format, please input again!");
            }
        }

        String serviceID;
        do {
            serviceID = MyUtil.selectServiceID(facilityIDs);
        } while (serviceID == null);
        booking.setServiceID(serviceID);

        String serviceName = null;
        for (Map.Entry<Facility, Integer> entry : facilities.entrySet()) {
            if (entry.getKey().getServiceID().equals(serviceID)) {
                serviceName = entry.getKey().getServiceName();
                break;
            }
        }
        booking.setServiceName(serviceName);

        System.out.println("Enter service type");
        String serviceType = scanner.nextLine();
        booking.setServiceType(serviceType);

        // Update Map Facility
        for (Map.Entry<Facility, Integer> entry : facilities.entrySet()) {
            if (entry.getKey().getServiceID().equals(serviceID)) {
                int value = entry.getValue() + 1;
                facilityService.update(entry.getKey(), value);
                facilityService.display();
                break;
            }
        }
    }

    private static void displayBooking() {
    }

    private static void creatContract() {
    }

    private static void displayContract() {
    }

    private static void editContract() {
    }


    // METHOD HIỂN THỊ MENU PROMOTION
    private static void displayPromotionMenu() {
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
                case 1:
                    displayCustomerUseService();
                    break;
                case 2:
                    displayCustomerGetVoucher();
                    break;
                case 3:
                    break;
            }
        } while (selectPromotionService < 3);
    }

    // CÁC METHOD ĐƯỢC GỌI TỪ MENU PROMOTION
    private static void displayCustomerUseService() {
    }

    private static void displayCustomerGetVoucher() {
    }
}
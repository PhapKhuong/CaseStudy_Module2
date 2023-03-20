package data.class_data;

import models.Booking;
import models.BookingSortByDate;

import java.io.*;
import java.util.Set;
import java.util.TreeSet;

public class BookingData {
    public static final String BOOKING_PATH = "C:\\Dropbox\\Codegym\\FuramaResort\\src\\data\\csv_file\\booking.csv";

    private BookingData() {
    }

    public static Set<Booking> readFile() throws IOException {
        FileReader fileReader = new FileReader(BOOKING_PATH);
        BufferedReader buffReader = new BufferedReader(fileReader);

        BookingSortByDate sortByDate = new BookingSortByDate();
        Set<Booking> bookingDataSet = new TreeSet<>(sortByDate);

        String[] temp;
        String line = buffReader.readLine();
        Booking booking;

        while (line != null) {
            temp = line.split(",");

            int bookingID = Integer.parseInt(temp[0]);
            String begin = temp[1];
            String finish = temp[2];
            int customerID = Integer.parseInt(temp[3]);
            String serviceID = temp[4];
            String serviceName = temp[5];
            String serviceType = temp[6];

            booking = new Booking(
                    bookingID, begin, finish, customerID, serviceID, serviceName, serviceType);
            bookingDataSet.add(booking);

            line = buffReader.readLine();
        }
        buffReader.close();
        return bookingDataSet;
    }

    public static void writeFile(Booking booking) throws IOException {
        FileWriter fileWriter = new FileWriter(BOOKING_PATH);
        BufferedWriter buffWriter = new BufferedWriter(fileWriter);

        buffWriter.write(
                booking.getBookingID() + ","
                        + booking.getBeginDate() + ","
                        + booking.getFinishDate() + ","
                        + booking.getCustomerID() + ","
                        + booking.getServiceID() + ","
                        + booking.getServiceName() + ","
                        + booking.getServiceType() + "\n"
        );
        buffWriter.close();
    }

    public static void clear() throws IOException {
        FileWriter fileWriter = new FileWriter(BOOKING_PATH);
        BufferedWriter buffWriter = new BufferedWriter(fileWriter);

        buffWriter.flush();
        buffWriter.close();
    }
}

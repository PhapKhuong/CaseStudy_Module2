package services.impl;

import data.class_data.BookingData;
import models.Booking;
import models.BookingSortByDate;
import services.itf.BookingService;

import java.io.IOException;
import java.util.*;

public class BookingServiceImpl implements BookingService {
    private static BookingSortByDate sortByDate = new BookingSortByDate();
    private static Set<Booking> bookingSet = new TreeSet<>(sortByDate);

    static {
        try {
            bookingSet = BookingData.readFile();
        } catch (IOException e) {
            System.out.println("File is not exist");
        }
    }

    @Override
    public void add(Booking booking) {
        try {
            BookingData.writeFile(booking);
        } catch (IOException e) {
            System.out.println("File is not exist");
        }
    }

    @Override
    public Set<Booking> display() {
        try {
            bookingSet = BookingData.readFile();
            return bookingSet;
        } catch (IOException e) {
            System.out.println("File is not exist");
        }
        return null;
    }
}
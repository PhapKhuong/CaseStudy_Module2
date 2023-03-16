package services.impl;

import models.Booking;
import services.itf.BookingService;

import java.util.*;

public class BookingServiceImpl implements BookingService {
    public static SortedSet<Booking> bookingSet = new TreeSet<>();

//    static {
//        Booking booking1 = new Booking(
//                2, "32", "32", 1, "sd", "sdf");
//        bookingSet.add(booking1);
//    }

    @Override
    public void add(Booking booking) {
        bookingSet.add(booking);
    }

    @Override
    public Set<Booking> display() {
        return bookingSet;
    }
}
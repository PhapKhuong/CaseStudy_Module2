package services.impl;

import models.Booking;
import services.itf.BookingService;

import java.util.*;

public class BookingServiceImpl implements BookingService {
    public static SortedSet<Booking> bookingSet = new TreeSet<>();

    static {

    }

    @Override
    public void add(Booking booking) {
        bookingSet.add(booking);
    }

    @Override
    public Set<Booking> display() {
        return bookingSet;
    }
}
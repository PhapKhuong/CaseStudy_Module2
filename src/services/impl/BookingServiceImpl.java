package services.impl;

import models.Booking;
import services.itf.BookingService;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BookingServiceImpl implements BookingService {
    public static Map<String, Integer> bookingServiceMap = new LinkedHashMap<>();

    @Override
    public void add(Booking booking) {
    }

    @Override
    public List<Booking> display() {
        return null;
    }
}

package services;

import models.Booking;

import java.util.List;

public interface BookingService extends Service {

    void addBooking(Booking booking);

    List<Booking> displayBooking();
}

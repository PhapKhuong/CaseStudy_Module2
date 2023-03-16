package services.itf;

import models.Booking;

import java.util.Set;

public interface BookingService extends Service {

    void add(Booking booking);

    Set<Booking> display();
}

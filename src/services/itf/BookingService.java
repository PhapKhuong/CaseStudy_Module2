package services.itf;

import models.Booking;

import java.util.List;

public interface BookingService extends Service {

    void add(Booking booking);

    List<Booking> display();
}

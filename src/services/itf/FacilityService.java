package services.itf;

import models.Facility;

import java.util.Map;

public interface FacilityService extends Service {

    Map<Facility,Integer> display();

    void add(Facility facility);

    void update(Facility facility, int value);

    Map<Facility,Integer> displayMaintenance();
}

package services.itf;

import models.Facility;

import java.util.Map;

public interface FacilityService extends Service {

    Map<Facility,Integer> display();

    void add(Facility facility);

    Map<Facility,Integer> displayMaintenance();
}

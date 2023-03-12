package services;

import models.Facility;

import java.util.List;

public interface FacilityService extends Service {

    List<Facility> displayFacility();

    void addFacility(Facility facility);

    List<Facility> displayFacMaintenance();


}

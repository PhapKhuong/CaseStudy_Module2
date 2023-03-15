package services.impl;

import models.Facility;
import models.House;
import models.Room;
import models.Villa;
import services.itf.FacilityService;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FacilityServiceImpl implements FacilityService {
    public static Map<Facility, Integer> facilityMap = new LinkedHashMap<>();

    static {
        Villa villa1 = new Villa("villa1", 100, 1000000, 20, "by day", "5 stars", 45, 3);
        House house1 = new House("house1", 75, 500000, 15, "by month", "2 stars", 2);
        Room room1 = new Room("room1", 25, 400000, 5, "by hour", "fruit");

        facilityMap.put(villa1, 2);
        facilityMap.put(house1, 5);
        facilityMap.put(room1, 3);
    }


    @Override
    public Map<Facility, Integer> display() {
        return facilityMap;
    }

    @Override
    public void add(Facility facility) {
        facilityMap.put(facility, 0);
    }

    @Override
    public Map<Facility, Integer> displayMaintenance() {
        Map<Facility, Integer> temp = new LinkedHashMap<>();

        for (Map.Entry<Facility, Integer> entry : facilityMap.entrySet()) {
            if (entry.getValue() >= 5) {
                temp.put(entry.getKey(), entry.getValue());
            }
        }
        return temp;
    }
}
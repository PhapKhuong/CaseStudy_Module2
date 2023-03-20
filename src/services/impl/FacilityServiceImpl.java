package services.impl;

import data.class_data.FacilityData;
import models.Facility;
import models.House;
import models.Room;
import models.Villa;
import services.itf.FacilityService;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class FacilityServiceImpl implements FacilityService {
    public static Map<Facility, Integer> facilityMap = new LinkedHashMap<>();

    static {
        try {
            facilityMap = FacilityData.readFile();
        } catch (IOException e) {
            System.out.println("File is not exist");
        }
    }

    @Override
    public Map<Facility, Integer> display() {
        try {
            facilityMap = FacilityData.readFile();
            return facilityMap;
        } catch (IOException e) {
            System.out.println("File is not exist");
        }
        return null;
    }

    @Override
    public void add(Facility facility) {
        try {
            FacilityData.writeFile(facility, 0);
        } catch (IOException e) {
            System.out.println("File is not exist");
        }
    }

    public void update(Facility facility, int value) {
        try {
            facilityMap = FacilityData.readFile();
            facilityMap.put(facility, value);

            FacilityData.clear();

            for (Map.Entry<Facility, Integer> entry : facilityMap.entrySet()) {
                FacilityData.writeFile(entry.getKey(), entry.getValue());
            }
        } catch (IOException e) {
            System.out.println("File is not exist");
        }
    }

    @Override
    public Map<Facility, Integer> displayMaintenance() {
        try {
            facilityMap = FacilityData.readFile();

            Map<Facility, Integer> temp = new LinkedHashMap<>();

            for (Map.Entry<Facility, Integer> entry : facilityMap.entrySet()) {
                if (entry.getValue() >= 5) {
                    temp.put(entry.getKey(), entry.getValue());
                }
            }
            return temp;
        } catch (IOException e) {
            System.out.println("File is not exist");
        }
        return null;
    }
}
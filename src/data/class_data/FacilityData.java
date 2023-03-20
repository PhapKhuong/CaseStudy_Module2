package data.class_data;

import libs.MyRegex;
import models.Facility;
import models.House;
import models.Room;
import models.Villa;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class FacilityData {
    private static final String VILLA_PATH =
            "C:\\Dropbox\\Codegym\\FuramaResort\\src\\data\\csv_file\\villa.csv";

    private static final String ROOM_PATH =
            "C:\\Dropbox\\Codegym\\FuramaResort\\src\\data\\csv_file\\room.csv";

    private static final String HOUSE_PATH =
            "C:\\Dropbox\\Codegym\\FuramaResort\\src\\data\\csv_file\\house.csv";

    private FacilityData() {
    }

    public static Map<Facility, Integer> readFile() throws IOException {
        Map<Facility, Integer> facilityDataMap = new LinkedHashMap<>();

        facilityDataMap.putAll(readVillaFile());
        facilityDataMap.putAll(readHouseFile());
        facilityDataMap.putAll(readRoomFile());

        return facilityDataMap;
    }

    private static Map<Villa, Integer> readVillaFile() throws IOException {
        FileReader fileReader = new FileReader(VILLA_PATH);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        Map<Villa, Integer> villaDataMap = new LinkedHashMap<>();
        String[] temp;

        String line = bufferedReader.readLine();
        Villa villa;

        while (line != null) {
            temp = line.split(",");

            String serviceID = temp[0];
            String serviceName = temp[1];
            float usableArea = Float.parseFloat(temp[2]);
            long unitPrice = Long.parseLong(temp[3]);
            int capacity = Integer.parseInt(temp[4]);
            String rentalType = temp[5];
            String standard = temp[6];
            float poolArea = Float.parseFloat(temp[7]);
            int floor = Integer.parseInt(temp[8]);
            int value = Integer.parseInt(temp[9]);

            villa = new Villa(
                    serviceID, serviceName, usableArea, unitPrice, capacity, rentalType, standard, poolArea, floor);

            villaDataMap.put(villa, value);
            line = bufferedReader.readLine();
        }
        bufferedReader.close();

        return villaDataMap;
    }

    private static Map<House, Integer> readHouseFile() throws IOException {
        FileReader fileReader = new FileReader(HOUSE_PATH);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        Map<House, Integer> houseDataMap = new LinkedHashMap<>();
        String[] temp;

        String line = bufferedReader.readLine();
        House house;

        while (line != null) {
            temp = line.split(",");

            String serviceID = temp[0];
            String serviceName = temp[1];
            float usableArea = Float.parseFloat(temp[2]);
            long unitPrice = Long.parseLong(temp[3]);
            int capacity = Integer.parseInt(temp[4]);
            String rentalType = temp[5];
            String standard = temp[6];
            int floor = Integer.parseInt(temp[7]);
            int value = Integer.parseInt(temp[8]);

            house = new House(
                    serviceID, serviceName, usableArea, unitPrice, capacity, rentalType, standard, floor);

            houseDataMap.put(house, value);
            line = bufferedReader.readLine();
        }
        bufferedReader.close();

        return houseDataMap;

    }

    private static Map<Room, Integer> readRoomFile() throws IOException {
        FileReader fileReader = new FileReader(ROOM_PATH);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        Map<Room, Integer> roomDataMap = new LinkedHashMap<>();
        String[] temp;

        String line = bufferedReader.readLine();
        Room room;

        while (line != null) {
            temp = line.split(",");

            String serviceID = temp[0];
            String serviceName = temp[1];
            float usableArea = Float.parseFloat(temp[2]);
            long unitPrice = Long.parseLong(temp[3]);
            int capacity = Integer.parseInt(temp[4]);
            String rentalType = temp[5];
            String freeService = temp[6];
            int value = Integer.parseInt(temp[7]);

            room = new Room(
                    serviceID, serviceName, usableArea, unitPrice, capacity, rentalType, freeService);

            roomDataMap.put(room, value);
            line = bufferedReader.readLine();
        }
        bufferedReader.close();

        return roomDataMap;
    }


    public static void writeFile(Facility facility, Integer value) throws IOException {
        String serviceID = facility.getServiceID();

        if(serviceID.matches(MyRegex.REGEX_VILLA_ID)) {
            writeVillaFile((Villa) facility, value);
        } else if (serviceID.matches(MyRegex.REGEX_HOUSE_ID)) {
            writeHouseFile((House) facility, value);
        } else {
            writeRoomFile((Room) facility,value);
        }
    }

    private static void writeVillaFile(Villa villa, Integer value) throws IOException {
        FileWriter fileWriter = new FileWriter(VILLA_PATH);
        BufferedWriter buffWriter = new BufferedWriter(fileWriter);

        buffWriter.write(
                villa.getServiceID() + ","
                        + villa.getServiceName() + ","
                        + villa.getUsableArea() + ","
                        + villa.getUnitPrice() + ","
                        + villa.getCapacity() + ","
                        + villa.getRentalType() + ","
                        + villa.getVillaRoomStandard() + ","
                        + villa.getPoolArea() + ","
                        + villa.getNumOfVillaFloor() + ","
                        + value + "\n"
        );
        buffWriter.close();
    }

    private static void writeHouseFile(House house, Integer value) throws IOException {
        FileWriter fileWriter = new FileWriter(HOUSE_PATH);
        BufferedWriter buffWriter = new BufferedWriter(fileWriter);

        buffWriter.write(
                house.getServiceID() + ","
                        + house.getServiceName() + ","
                        + house.getUsableArea() + ","
                        + house.getUnitPrice() + ","
                        + house.getCapacity() + ","
                        + house.getRentalType() + ","
                        + house.getHouseRoomStandard() + ","
                        + house.getNumOfHouseFloor() + ","
                        + value + "\n"
        );
        buffWriter.close();
    }

    private static void writeRoomFile(Room room, Integer value) throws IOException {
        FileWriter fileWriter = new FileWriter(ROOM_PATH);
        BufferedWriter buffWriter = new BufferedWriter(fileWriter);

        buffWriter.write(
                room.getServiceID() + ","
                        + room.getServiceName() + ","
                        + room.getUsableArea() + ","
                        + room.getUnitPrice() + ","
                        + room.getCapacity() + ","
                        + room.getRentalType() + ","
                        + room.getFreeService() + ","
                        + value + "\n"
        );
        buffWriter.close();
    }

    public static void clear() throws IOException {
        clearVillaData();
        clearHouseData();
        clearRoomData();
    }

    private static void clearVillaData() throws IOException {
        FileWriter fileWriter = new FileWriter(VILLA_PATH);
        BufferedWriter buffWriter = new BufferedWriter(fileWriter);
        buffWriter.flush();
        buffWriter.close();
    }

    private static void clearHouseData() throws IOException {
        FileWriter fileWriter = new FileWriter(HOUSE_PATH);
        BufferedWriter buffWriter = new BufferedWriter(fileWriter);
        buffWriter.flush();
        buffWriter.close();
    }

    private static void clearRoomData() throws IOException {
        FileWriter fileWriter = new FileWriter(ROOM_PATH);
        BufferedWriter buffWriter = new BufferedWriter(fileWriter);
        buffWriter.flush();
        buffWriter.close();
    }
}

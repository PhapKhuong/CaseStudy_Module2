package models;

public class Room extends Facility {
    private String freeService;

    public Room() {
    }

    public Room(String serviceName, float usableArea, long unitPrice, int capacity, String rentalType,
                String freeService) {
        super(serviceName, usableArea, unitPrice, capacity, rentalType);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    public void showPopUp() {
        System.out.println("Welcome to you our room chain!");
    }

    @Override
    public String toString() {
        return "Room{" +
                super.toString() +
                "freeService='" + freeService + '\'' +
                '}';
    }
}

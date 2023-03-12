package models;

public class Room extends Facility {
    private String freeService;

    public Room() {
    }

    public Room(String serviceName, float usableArea, long unitPrice, int capacity, RentalType rentalType,
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

    @Override
    public String toString() {
        return "Room{" +
                super.toString() +
                "freeService='" + freeService + '\'' +
                '}';
    }
}

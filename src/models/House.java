package models;

public class House extends Facility {
    private String houseRoomStandard;
    private int numOfHouseFloor;

    public House() {
    }

    public House(String serviceName, float usableArea, long unitPrice, int capacity, String rentalType,
                 String houseRoomStandard, int numOfHouseFloor) {
        super(serviceName, usableArea, unitPrice, capacity, rentalType);
        this.houseRoomStandard = houseRoomStandard;
        this.numOfHouseFloor = numOfHouseFloor;
    }

    public String getHouseRoomStandard() {
        return houseRoomStandard;
    }

    public void setHouseRoomStandard(String houseRoomStandard) {
        this.houseRoomStandard = houseRoomStandard;
    }

    public int getNumOfHouseFloor() {
        return numOfHouseFloor;
    }

    public void setNumOfHouseFloor(int numOfHouseFloor) {
        this.numOfHouseFloor = numOfHouseFloor;
    }

    public void showPopUp() {
        System.out.println("Welcome to you our housing chain!");
    }

    @Override
    public String toString() {
        return "House{" +
                super.toString() +
                "houseRoomStandard='" + houseRoomStandard + '\'' +
                ", numOfHouseFloor=" + numOfHouseFloor +
                '}';
    }
}

package models;

public class Villa extends Facility {
    private String villaRoomStandard;
    private float poolArea;
    private int numOfVillaFloor;

    public Villa() {
    }

    public Villa(String serviceID, String serviceName, float usableArea, long unitPrice, int capacity, String rentalType,
                 String villaRoomStandard, float poolArea, int numOfVillaFloor) {
        super(serviceID, serviceName, usableArea, unitPrice, capacity, rentalType);
        this.villaRoomStandard = villaRoomStandard;
        this.poolArea = poolArea;
        this.numOfVillaFloor = numOfVillaFloor;
    }

    public String getVillaRoomStandard() {
        return villaRoomStandard;
    }

    public void setVillaRoomStandard(String villaRoomStandard) {
        this.villaRoomStandard = villaRoomStandard;
    }

    public float getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(float poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumOfVillaFloor() {
        return numOfVillaFloor;
    }

    public void setNumOfVillaFloor(int numOfVillaFloor) {
        this.numOfVillaFloor = numOfVillaFloor;
    }

    public void showPopUp() {
        System.out.println("Welcome to you our villa chain!");
    }

    @Override
    public String toString() {
        return "Villa{" +
                super.toString() +
                "villaRoomStandard='" + villaRoomStandard + '\'' +
                ", poolArea=" + poolArea +
                ", numOfVillaFloor=" + numOfVillaFloor +
                '}';
    }
}

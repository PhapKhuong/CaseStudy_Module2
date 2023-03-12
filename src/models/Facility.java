package models;

public abstract class Facility {
    private String serviceName;
    private float usableArea;
    private long unitPrice;
    private int capacity;
    private RentalType rentalType;

    public Facility() {
    }

    public Facility(String serviceName, float usableArea, long unitPrice, int capacity, RentalType rentalType) {
        this.serviceName = serviceName;
        this.usableArea = usableArea;
        this.unitPrice = unitPrice;
        this.capacity = capacity;
        this.rentalType = rentalType;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public float getUsableArea() {
        return usableArea;
    }

    public void setUsableArea(float usableArea) {
        this.usableArea = usableArea;
    }

    public long getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(long unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public RentalType getRentalType() {
        return rentalType;
    }

    public void setRentalType(RentalType rentalType) {
        this.rentalType = rentalType;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "serviceName='" + serviceName + '\'' +
                ", usableArea=" + usableArea +
                ", unitPrice=" + unitPrice +
                ", capacity=" + capacity +
                ", rentalType='" + rentalType + '\'' +
                '}';
    }
}

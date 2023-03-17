package models;

public class Booking {
    private int bookingID;
    private String beginDate;
    private String finishDate;
    private int customerID;
    private String serviceID;
    private String serviceName;
    private String serviceType;

    public Booking() {
    }

    public Booking(int bookingID, String beginDate, String finishDate, int customerID,
            String serviceID, String serviceName, String serviceType) {
        this.bookingID = bookingID;
        this.beginDate = beginDate;
        this.finishDate = finishDate;
        this.customerID = customerID;
        this.serviceID = serviceID;
        this.serviceName = serviceName;
        this.serviceType = serviceType;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getServiceID() {
        return serviceID;
    }

    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingID=" + bookingID +
                ", beginDate=" + beginDate +
                ", finishDate=" + finishDate +
                ", customerID=" + customerID +
                ", serviceName='" + serviceName + '\'' +
                ", serviceType='" + serviceType + '\'' +
                '}';
    }
}
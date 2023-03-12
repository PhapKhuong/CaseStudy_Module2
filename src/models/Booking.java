package models;

import java.time.LocalDate;

public class Booking {
    private int bookingID;          // Mã Booking
    private LocalDate beginDate;    // Ngày bắt đầu
    private LocalDate finishDate;   // Ngày kết thúc
    private int bookingCustomerID;  // Mã khách hàng
    private String serviceName;     // Tên dịch vụ
    private String serviceType;     // Loại dịch vụ

    public Booking () {}

    public Booking (int bookingID, LocalDate beginDate, LocalDate finishDate, int bookingCustomerID,
                    String serviceName, String serviceType) {
        this.bookingID = bookingID;
        this.beginDate = beginDate;
        this.finishDate = finishDate;
        this.bookingCustomerID = bookingCustomerID;
        this.serviceName = serviceName;
        this.serviceType = serviceType;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public LocalDate getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(LocalDate finishDate) {
        this.finishDate = finishDate;
    }

    public int getBookingCustomerID() {
        return bookingCustomerID;
    }

    public void setBookingCustomerID(int bookingCustomerID) {
        this.bookingCustomerID = bookingCustomerID;
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
                ", bookingCustomerID=" + bookingCustomerID +
                ", serviceName='" + serviceName + '\'' +
                ", serviceType='" + serviceType + '\'' +
                '}';
    }
}

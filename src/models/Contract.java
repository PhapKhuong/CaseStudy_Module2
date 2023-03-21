package models;

public class Contract {
    private int contractID;
    private int bookingID;
    private long deposits;
    private long payment;
    private int customerID;

    public Contract() {
    }

    public Contract(int contractID, int bookingID, long deposits, long payment, int customerID) {
        this.contractID = contractID;
        this.bookingID = bookingID;
        this.deposits = deposits;
        this.payment = payment;
        this.customerID = customerID;
    }

    public int getContractID() {
        return contractID;
    }

    public void setContractID(int contractID) {
        this.contractID = contractID;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int contractBookingID) {
        this.bookingID = contractBookingID;
    }

    public long getDeposits() {
        return deposits;
    }

    public void setDeposits(long deposits) {
        this.deposits = deposits;
    }

    public long getPayment() {
        return payment;
    }

    public void setPayment(long payment) {
        this.payment = payment;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int contractCustomerID) {
        this.customerID = contractCustomerID;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "contractID=" + contractID +
                ", bookingID=" + bookingID +
                ", deposits=" + deposits +
                ", payment=" + payment +
                ", customerID=" + customerID +
                '}';
    }
}

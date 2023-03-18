package models;

public class Contract {
    private int contractID;
    private int contractBookingID;
    private long deposits;
    private long payment;
    private int contractCustomerID;

    public Contract() {
    }

    public Contract(int contractID, int contractBookingID, long deposits, long payment, int contractCustomerID) {
        this.contractID = contractID;
        this.contractBookingID = contractBookingID;
        this.deposits = deposits;
        this.payment = payment;
        this.contractCustomerID = contractCustomerID;
    }

    public int getContractID() {
        return contractID;
    }

    public void setContractID(int contractID) {
        this.contractID = contractID;
    }

    public int getContractBookingID() {
        return contractBookingID;
    }

    public void setContractBookingID(int contractBookingID) {
        this.contractBookingID = contractBookingID;
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

    public int getContractCustomerID() {
        return contractCustomerID;
    }

    public void setContractCustomerID(int contractCustomerID) {
        this.contractCustomerID = contractCustomerID;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "contractID=" + contractID +
                ", contractBookingID=" + contractBookingID +
                ", deposits=" + deposits +
                ", payment=" + payment +
                ", contractCustomerID=" + contractCustomerID +
                '}';
    }
}

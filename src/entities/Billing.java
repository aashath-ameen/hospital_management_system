package entities;

public class Billing {
    private int billingId;
    private int patientId;
    private double amount;
    private String paymentStatus;

    public Billing(int patientId, double amount, String paymentStatus) {
        this.patientId = patientId;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
    }

    public Billing(int billingId, int patientId, double amount, String paymentStatus) {
        this.billingId = billingId;
        this.patientId = patientId;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
    }

    public int getBillingId() {
        return billingId;
    }

    public void setBillingId(int billingId) {
        this.billingId = billingId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}

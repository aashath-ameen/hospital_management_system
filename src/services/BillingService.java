package services;

import dao.BillingDAO;
import entities.Billing;

import java.util.List;

public class BillingService {
    private BillingDAO billingDAO;

    public BillingService() {
        billingDAO = new BillingDAO();
    }

    public void addBilling(Billing billing) {
        billingDAO.addBilling(billing);
    }

    public Billing getBillingById(int billingId) {
        return billingDAO.getBillingById(billingId);
    }

    public List<Billing> getAllBillings() {
        return billingDAO.getAllBillings();
    }

    public void updateBilling(Billing billing) {
        billingDAO.updateBilling(billing);
    }

    public void deleteBilling(int billingId) {
        billingDAO.deleteBilling(billingId);
    }
}

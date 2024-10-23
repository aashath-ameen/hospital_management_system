package dao;


import entities.Appointment;
import entities.Billing;
import entities.Patient;
import utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BillingDAO {

    public void addBilling(Billing billing) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO Billing (patient_id, amount, payment_status) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, billing.getPatientId());
            stmt.setDouble(2, billing.getAmount());
            stmt.setString(3, billing.getPaymentStatus());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Billing getBillingById(int billingId) {
        Billing billing=null;
        try(Connection conn = DatabaseConnection.getConnection()){
            String query = "SELECT * FROM billing WHERE billing_id="+billingId+";";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            if (rs.next()) {
                billing = new Billing(
                        rs.getInt("billing_id"),
                        rs.getInt("patient_id"),
                        rs.getDouble("amount"),
                        rs.getString("payment_status")
                );
            }

        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return billing;
    }

    public List<Billing> getAllBillings() {
        List<Billing> billingList = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Billing");
            while (rs.next()) {
                Billing billing = new Billing(
                        rs.getInt("billing_id"),
                        rs.getInt("patient_id"),
                        rs.getDouble("amount"),
                        rs.getString("payment_status")
                );
                billingList.add(billing);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return billingList;
    }


    public void updateBilling(Billing billing) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "UPDATE Billing SET patient_id = ?, amount = ?, payment_status = ? WHERE billing_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, billing.getPatientId());
            stmt.setDouble(2, billing.getAmount());
            stmt.setString(3, billing.getPaymentStatus());
            stmt.setInt(4, billing.getBillingId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to delete a billing record by billing_id
    public void deleteBilling(int billingId) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "DELETE FROM Billing WHERE billing_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, billingId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

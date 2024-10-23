package services;

import dao.StaffDAO;
import entities.Staff;

import java.util.List;

public class StaffService {

    private StaffDAO staffDAO;

    public StaffService(){
        staffDAO = new StaffDAO();
    }

    public void addStaff(Staff staff){
        staffDAO.addStaff(staff);
    }

    public Staff getStaffById(int staffId){
        return staffDAO.getStaffById(staffId);
    }

    public List<Staff> getAllStaffs(){
        return staffDAO.getAllStaffs();
    }

    public void deleteStaff(int staffId){
        staffDAO.deleteStaff(staffId);
    }

    public void updateStaff(Staff staff){
        staffDAO.updateStaff(staff);
    }

}

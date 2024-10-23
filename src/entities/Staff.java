package entities;

public class Staff {
    private int staffId;
    private String name;
    private String role;
    private String department;

    public Staff(String name, String role, String department) {

        this.name = name;
        this.role = role;
        this.department = department;
    }

    public Staff(int staffId, String name, String role, String department) {
        this.staffId = staffId;
        this.name = name;
        this.role = role;
        this.department = department;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}

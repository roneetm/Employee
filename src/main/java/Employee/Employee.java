package Employee;

import java.util.Date;

public class Employee {
    private int id;
    private String name;
    private String joiningDate;
    private String employeeLevel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getEmployeeLevel() {
        return employeeLevel;
    }

    public void setEmployeeLevel(String employeeLevel) {
        this.employeeLevel = employeeLevel;
    }

    public Employee() {
    }

    public Employee(int id, String name, String joiningDate, String employeeLevel) {
        this.id = id;
        this.name = name;
        this.joiningDate = joiningDate;
        this.employeeLevel = employeeLevel;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", joiningDate=" + joiningDate +
                ", employeeLevel='" + employeeLevel + '\'' +
                '}';
    }
}

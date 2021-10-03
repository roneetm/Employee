package Employee;

import java.util.Date;

public class Employee {
    private Long id;
    private String name;
    private Date joiningDate;
    private String employeeLevel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
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

    public Employee(Long id, String name, Date joiningDate, String employeeLevel) {
        this.id = id;
        this.name = name;
        this.joiningDate = joiningDate;
        this.employeeLevel = employeeLevel;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", joiningDate=" + joiningDate +
                ", employeeLevel='" + employeeLevel + '\'' +
                '}';
    }
}

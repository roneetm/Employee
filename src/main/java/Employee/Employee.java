package Employee;


import java.io.Serializable;

public class Employee implements Serializable {
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
        return "{" + "\n"+
                "\"id\"" + ":" +"  \"" +id+ "\"" + ",\n" +
                "\"name\"" + ":" + "  \"" +name + "\""+ ",\n" +
                "\"joiningDate\"" + ":" + "  \""+joiningDate +"\"" + ",\n" +
                "\"employeeLevel\"" + ":" + "  \"" +employeeLevel+ "\"" + "\n" +
                "}";
    }
}
// Todo 1: Array Manipulation in json file, CRUD, Search, without Jackson, RestAPI extending HTTPServlet
// Todo 2: Unit testing Junit & Mock
// Todo 3: Dockerize your application
// Todo 4: End to end testing
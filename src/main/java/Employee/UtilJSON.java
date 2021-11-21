package Employee;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.*;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;


public class UtilJSON implements Serializable {

    public static void addNewEmployee(ArrayList<Employee> employees) throws IOException {
        Scanner scanner = new Scanner(System.in);
        try (FileWriter fileWriter = new FileWriter("src/main/resources/Employee.json");
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            System.out.println("Enter the ID of the Employee");
            int id = scanner.nextInt();
            System.out.println("Enter the Name of the Employee");
            String name = scanner.next();
            System.out.println("Enter the Joining Date of the Employee");
            String date = scanner.next();
            System.out.println("Enter the Level of the Employee");
            String level = scanner.next();
            Employee employee = new Employee(id, name, date, level);
            try {
                employees.add(employee);
                bufferedWriter.write(employees.toString());
                System.out.println("Record Added");

                try {
                    FileOutputStream fileOutputStream = new FileOutputStream("src/main/resources/Employee.txt");
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                    objectOutputStream.writeObject(employees);
                    System.out.println("Serialised");
                } catch (IOException fileNotFoundException) {
                    fileNotFoundException.getMessage();
                }

            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        } catch (IOException ioException) {
            System.out.println("Unable to Add to the file");
        }
    } // Closed Add New Employee

    public static void displayEmployee(File file) {

        String line;
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException ioException) {
            System.out.println("Unable to Read File");
        }

    } // Closed Display Method

    public static void deleteEmployee(ArrayList<Employee> employees) throws IOException {

        System.out.print("Enter the ID of the Employee ");
        Scanner scanner = new Scanner(System.in);
        int employeeId = scanner.nextInt();
        ListIterator<Employee> iterator = employees.listIterator();

        while (iterator.hasNext())
        {
            Employee employee = iterator.next();
            if(employee.getId() == employeeId){
                System.out.println("Employee Record Deleted");
                iterator.remove();
                updateFile(employees);
                break;
            }
            else{
                System.out.println("No Records Found");
            }
        }
        System.out.println("Collected"+ employees);

    } // Delete Method Close

    public static void updateEmployee(ArrayList<Employee> employees) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the Employee ID you want to update");
        int employeeId = scanner.nextInt();

        System.out.println("Enter the new Name");
        String name = scanner.next();
        System.out.println("Enter the new joining date");
        String date = scanner.next();
        System.out.println("Enter the new Employee level");
        String level = scanner.next();

        ListIterator<Employee> iterator = employees.listIterator();
        while (iterator.hasNext())
        {
            Employee employee = iterator.next();
            if(employee.getId() == employeeId){
                System.out.println("Employee Record Found");
                employee.setName(name);
                employee.setJoiningDate(date);
                employee.setEmployeeLevel(level);

                updateFile(employees);
                break;
            }
            else{
                System.out.println("No Records Found");
            }
        }
        System.out.println("Collected"+ employees);

        try (FileReader fileReader = new FileReader("src/main/resources/Employee.json");
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {


        } // Try with Resource Closed
    } // Updated Method Closed

    public static ArrayList<Employee> Deserialize() {

        String line;
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/Employee.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
                    ArrayList<Employee> employees = (ArrayList) ois.readObject();
//                    for (Employee employee : employees) {
//                        System.out.println(employee);
//                    }
            fis.close();
            ois.close();
            return employees;
        } // try block closed

        catch (IOException ioe) {
            ioe.printStackTrace();
            return null;
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
            return null;
        } // Close catch
    } // Closed Deserialize Method

    public static void updateFile(ArrayList<Employee> employees) {

        try (FileWriter fileWriter = new FileWriter("src/main/resources/Employee.json");
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            try {
                bufferedWriter.write(employees.toString());
                System.out.println("Record Updated");
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream("src/main/resources/Employee.txt");
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                    objectOutputStream.writeObject(employees);
                    System.out.println("Serialised");
                } catch (IOException fileNotFoundException) {
                    fileNotFoundException.getMessage();
                }

            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        } catch (IOException ioException) {
            System.out.println("Unable to Add to the file");
        }
    } // Update File Method Closed

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        File file = new File("src/main/resources/Employee.json");
        ArrayList<Employee> employees = new ArrayList<>(Deserialize());

        while (true) {
            System.out.println("1. Add New Employee");
            System.out.println("2. Edit an Employee Record");
            System.out.println("3. Delete an Employee Record");
            System.out.println("4. Display all employee");
            System.out.println("5. Exit");
            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    addNewEmployee(employees);
                    break;

                case 2:
                    updateEmployee(employees);
                    break;

                case 3:
                    deleteEmployee(employees);
                    break;

                case 4:
                    displayEmployee(file);
                    break;

                case 5:
                    System.exit(0);
            } // Switch close
        } // While close
    } // Main Method closed
}
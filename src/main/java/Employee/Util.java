package Employee;

import java.io.*;
import java.util.Scanner;

public class Util {

    public static void addNewEmployee(File file) throws IOException {

        Scanner scanner = new Scanner(System.in);
        try (FileWriter fileWriter= new FileWriter(file, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)){

            System.out.println("Enter the ID of the Employee");
            int id = scanner.nextInt();
            System.out.println("Enter the Name of the Employee");
            String name = scanner.next();
            System.out.println("Enter the Joining Date of the Employee");
            String date = scanner.next();
            System.out.println("Enter the Level of the Employee");
            String level = scanner.next();

            bufferedWriter.write("{ ID:" +id + ", Name: " + name + ", Date of Joining: "+ date + ", Employee Level: "+ level + " },\n");
            System.out.println("Record Added");

        }catch (IOException ioException){
            System.out.println("Unable to Add to the file");
        }
    }

    public static void displayEmployee(File file){

        String line;
        try (FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader)){

            while( (line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }

        } catch (IOException ioException){
            System.out.println("Unable to Read File");
        }

    }

    public static void deleteEmployee(File file) throws IOException {

        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        File tempFile = new File("temp.json");

        FileWriter fileWriter = new FileWriter(tempFile);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        try( FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)){

            String line;

            while((line = bufferedReader.readLine()) != null ){

                if( line.contains(String.valueOf(id)) ){
                    continue;
                }
                bufferedWriter.write(line);

            }
            bufferedWriter.close();
            file.delete();
            tempFile.renameTo(file);
            System.out.println("Record Deleted");


        }
        catch (IOException ioException){
            System.out.println("Unable to Delete from the file");
        }
    }

    public static void updateEmployee(File file) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the Employee ID you want to update");
        int ID = scanner.nextInt();

        System.out.println("Enter the new Name");
        String name = scanner.next();
        System.out.println("Enter the new joining date");
        String date = scanner.next();
        System.out.println("Enter the new Employee level");
        String level = scanner.next();

        File tempFile = new File("temp.json");
        String line;
        try(FileWriter fileWriter = new FileWriter(tempFile);
            FileReader fileReader = new FileReader(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            BufferedReader bufferedReader = new BufferedReader(fileReader)){

            while ( (line = bufferedReader.readLine()) != null){
                if(line.contains(String.valueOf(ID))){
                    System.out.println("Value Found");
                    bufferedWriter.write("{ ID:" +ID + ", Name: " + name + ", Date of Joining: "+ date + ", Employee Level: "+ level + " },\n");
                }
                else
                    bufferedWriter.write(line);
            }
            file.delete();
            tempFile.renameTo(file);
        }
    }

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        File file = new File("src/main/resources/Employee.json");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

       while (true){
           System.out.println("1. Add New Employee");
           System.out.println("2. Edit an Employee Record");
           System.out.println("3. Delete an Employee Record");
           System.out.println("4. Display all employee");
           System.out.println("5. Exit");
           int choice = scanner.nextInt();

           switch (choice){

               case 1: addNewEmployee(file);
                   break;

               case 2: updateEmployee(file);
                   break;

               case 3: deleteEmployee(file);
                   break;

               case 4: displayEmployee(file);
                   break;

               case 5: System.exit(0);
           }
       }
    }
}

package Employee;

import org.json.*;
import java.io.*;
import java.io.IOException;
import java.nio.file.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Util {

    public static void readAllLines(Path fileLocation){
        try{
            List<String> data = Files.readAllLines(fileLocation);
            for(String s: data){
                System.out.println(s);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    private static void writeInFile(Path path) throws IOException {

            Employee employee = new Employee(001L, "Roneet Michael", new Date(1995, Calendar.NOVEMBER, 10), "Junior Developer");
            Employee employee2 = new Employee(002L, "Varun Mathur", new Date(1995, Calendar.NOVEMBER, 10), "Senior Developer");

            JSONArray jsonArray = new JSONArray();
            JSONObject jsonObject = new JSONObject(employee);

            //jsonArray.put(jsonObject);
            //Files.write(path, jsonArray.toString().getBytes());
//          Files.write(path, employee.toString().getBytes(), employee2.toString().getBytes());

            FileWriter fileWriter = new FileWriter(String.valueOf(path), true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            JSONObject jsonObject1 = new JSONObject(employee2);

//            fileWriter.write(String.valueOf(jsonObject1));
//
            bufferedWriter.write(String.valueOf(jsonArray.put(jsonObject)));
            bufferedWriter.write(String.valueOf(jsonArray.put(jsonObject1)));

        bufferedWriter.close();
    }
    public static void main(String[] args) throws IOException {

        String fileLocation = "src/main/resources/Employee.json";

        writeInFile(Paths.get(fileLocation));
        readAllLines(Paths.get(fileLocation));

    }
}
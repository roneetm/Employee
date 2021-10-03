package Employee;

import java.nio.file.*;
import java.util.List;

public class Util {

    public static void readAllLines(Path fileLocation){
        try{
            List<String> data = Files.readAllLines(fileLocation);
            System.out.println("Location Found");

            for(String s: data){
                System.out.println(s);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {

        String fileLocation = "src/main/resources/Employee.json";

        readAllLines(Paths.get(fileLocation));
        
    }
}
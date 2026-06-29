package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class FileHandler {

    public static ArrayList<Doctor> bulkLoadDoctor(String filePath, int startId) {
        ArrayList<Doctor> newDoctors = new ArrayList<>();
        int currentId = startId;
        try (BufferedReader reader  =  new BufferedReader(new FileReader(filePath)))
        {
            String line;
         while ((line = reader.readLine())!=null)
            {
                if(line.trim().isEmpty()) continue; //skip empty lines
                String parts[] = line.split(",");
                if(parts.length ==4)
                {
                    String id = String.format("D%04d", currentId++);
                    String name = parts[0].trim();
                    Specialization specialization = Specialization.valueOf(parts[1].trim().toUpperCase());
                    int exp = Integer.parseInt(parts[2].trim());
                    Shift shift = Shift.valueOf(parts[3].trim().toUpperCase());
                    newDoctors.add(new Doctor(id, name, specialization, exp, shift));
                }
            }

        }
        catch (Exception e)
        {
            System.out.println(" Bulk Upload  Error : Check file format or Enum values :"+e.getMessage());
        }
        return newDoctors;
    }

    /*
    Reads a CSV file and converts lines into Doctor objects
    Expects format: Name, specialization, Experience, Shift
     */


}

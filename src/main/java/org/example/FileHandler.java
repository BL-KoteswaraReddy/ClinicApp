package org.example;

import com.opencsv.CSVReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class FileHandler {

    public static ArrayList<Doctor> bulkLoadDoctor(String filePath, int startId, ArrayList<Doctor> doctorList) {
        ArrayList<Doctor> newDoctors = new ArrayList<>();
        int currentId = startId;
        try (CSVReader reader  =  new CSVReader(new FileReader(filePath))) {
            String[] parts;
            while ((parts = reader.readNext()) != null) {
                try {
                    if (parts.length == 0) continue; //skip empty lines
                    if (parts.length == 4) {
                        String id = String.format("D%04d", currentId++);
                        String name = parts[0].trim();
                        Specialization specialization = Specialization.valueOf(parts[1].trim().toUpperCase());
                        int exp = Integer.parseInt(parts[2].trim());
                        Shift shift = Shift.valueOf(parts[3].trim().toUpperCase());
                        boolean duplicate = false;
                        for(Doctor d: doctorList)
                        {
                            if(d.getName().equalsIgnoreCase(name) && d.getSpecialization() == specialization && d.getExperience() == exp)
                            {
                                duplicate = true;
                                break;
                            }
                        }
                        if(duplicate)
                        {
                            System.out.println("Duplicate Doctor :"+name);
                        }
                        else {
                            Doctor doctor = new Doctor(id, name, specialization, exp, shift);
                            newDoctors.add(doctor);
                            doctorList.add(doctor);
                            AuditLogger.log("Doctor added successfully", "InfoInfo");
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Skipped Record :" + String.join(", ", parts));
                    System.out.println("Reason :" + e.getMessage());
                    continue;
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

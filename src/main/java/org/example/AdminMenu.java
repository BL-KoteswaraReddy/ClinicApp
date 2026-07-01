package org.example;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class AdminMenu
{
    public static final int Doctor_Entry  = 1;
    public static final int Bulk_Entry = 2;
    public static final int Display_Doctors = 4;
    public static final int Logout = 5;

    private static ArrayList<Doctor> doctorList = new ArrayList<>();
    private static int counterID = 1;

    public static Logger logger = LogManager.getLogger(AdminMenu.class);



    public static void displayAdminOptions(Scanner scanner)
    {
        System.out.println("=======Clinic Admin Menu========");
        System.out.println("1. for Doctors data entry \n 2. for Bulk data entry(CSV) \n 3.View audit logs \n 4.Display all Doctors \n 5.Logout");
        System.out.println("Please enter choice ");
        int input = scanner.nextInt();
        scanner.nextLine();   // Consume the newline
        switch (input)
        {
            case Doctor_Entry: registerDoctor(scanner); break;
            case Bulk_Entry: bulkEntry(scanner); break;
            case Display_Doctors: displayDoctors();break;
            case Logout: break;
        }
    }

    private static void bulkEntry(Scanner scanner) {
        System.out.println("Enter the full path of the CSV file(e.g doctors.csv)");
        String filePath = scanner.nextLine();

        //call the FileHandler to get the list
        ArrayList<Doctor> uploadList = FileHandler.bulkLoadDoctor(filePath, counterID, doctorList);
        if(!uploadList.isEmpty())
        {
            doctorList.addAll(uploadList);//add all new doctors to our main list
            counterID+= uploadList.size(); //update our Global id
            logger.info("Uploaded Doctor");
            System.out.println(" Success " +uploadList.size() + " Doctors uploaded");

        }
        else
        {
            System.out.println("Upload failed or file was empty.");
        }
    }

    private static void registerDoctor(Scanner scanner) {
        System.out.println("Registering new Doctor");
        String generatedID = String.format("D%04d", counterID++);

        System.out.println("Please enter Details for Doctor :"+generatedID);
        String docName = ScannerHelper.readStrWithPrompt(scanner, "Please enter Doc1 name: ");
        Specialization docSpec = ScannerHelper.readEnumChoice(scanner, Specialization.values());
        int docExp = ScannerHelper.readIntWithPrompt(scanner, "Please enter Doc1 experience");
        Shift docShift = ScannerHelper.readEnumChoice(scanner,  Shift.values());
        Doctor doctor = new Doctor(generatedID, docName, docSpec, docExp, docShift);
        doctorList.add(doctor);
        logger.info("Doctor Added successfully \n ID :"+doctor.getId()+" Name:"+doctor.getName()+" \n Specialization: "+doctor.getSpecialization());
        System.out.println("Doctor added successfully with ID : "+generatedID);
    }

    public static void displayDoctors()
    {
        System.out.println(doctorList);
    }

    public static ArrayList<Doctor> getDoctorList() {
        return doctorList;
    }
}

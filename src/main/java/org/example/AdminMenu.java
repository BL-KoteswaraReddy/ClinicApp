package org.example;
import java.util.ArrayList;
import java.util.Scanner;


public class AdminMenu
{
    public static final int Doctor_Entry  = 1;
    public static final int Bulk_Entry = 2;
    public static final int View_Audit_Logs = 3;
    public static final int Display_Doctors = 4;
    public static final int Logout = 5;

    private static ArrayList<Doctor> doctorList = new ArrayList<>();
    private static int counterID = 1;


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
            case Bulk_Entry: break;
            case View_Audit_Logs: break;
            case Display_Doctors: displayDoctors();break;
            case Logout: break;
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
        System.out.println("Doctor added successfully with ID : "+generatedID);
    }


    public static void displayDoctors()
    {
        System.out.println(doctorList);
    }

}

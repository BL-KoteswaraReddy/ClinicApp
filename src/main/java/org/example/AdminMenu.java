package org.example;
import java.util.Scanner;


public class AdminMenu
{
    public static final int Doctor_Entry  = 1;
    public static final int Bulk_Entry = 2;
    public static final int View_Audit_Logs = 3;
    public static final int Display_Doctors = 4;
    public static final int Logout = 5;

    public static String doc1Name="";
    public static String doc1Spec="";
    public static String doc1Shift="";
    public static int doc1Exp = 0;

    public static String doc2Name="";
    public static String doc2Spec="";
    public static String doc2Shift="";
    public static int doc2Exp = 0;

    public static String doc3Name="";
    public static String doc3Spec="";
    public static String doc3Shift="";
    public static int doc3Exp = 0;



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
        doc1Name = ScannerHelper.readStrWithPrompt(scanner, "Please enter Doc1 name: ");
        doc1Spec = ScannerHelper.readStrWithPrompt(scanner, "Please enter Doc1 Specialization: ");
        doc1Shift = ScannerHelper.readStrWithPrompt(scanner, "Please enter Doc1 slots");
        doc1Exp = ScannerHelper.readIntWithPrompt(scanner, "Please enter Doc1 experience");
    }

    public static void displayDoctors()
    {
        System.out.println("\n Clinic : Registered Doctors");
        if(doc1Name.isEmpty() && doc2Name.isEmpty() && doc3Name.isEmpty())
        {
            System.out.println("No Doctors are registered");
        }

        if(!doc1Name.isEmpty())
        {
//            System.out.println("Doctor 1 Name: "+doc1Name);
//            System.out.println("Doctor 1 specialization: "+doc1Spec);
//            System.out.println("Doctor 1 Experience: "+doc1Exp);
//            System.out.println("Doctor 1 Shift: "+doc1Shift);
            System.out.println("ID D001: | Name: "+doc1Name +" | spec :"+doc1Spec+ " | Exp :"+doc1Exp+" | Shift: "+doc1Shift);
        }
        if(!doc2Name.isEmpty()){
            System.out.println("ID D002: | Name: "+doc2Name +" | spec :"+doc2Spec+ " | Exp :"+doc2Exp+" | Shift: "+doc2Shift);
        }
        if(!doc3Name.isEmpty()){
            System.out.println("ID D003: | Name: "+doc3Name +" | spec :"+doc3Spec+ " | Exp :"+doc3Exp+" | Shift: "+doc3Shift);
    }

    }

}

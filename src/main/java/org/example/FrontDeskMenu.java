package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class FrontDeskMenu {
    public static final int Register_New_Patient = 1;
    public static final int Book_Appointment = 2;
    public static final int View_PatientDetails = 3;
    public static final int Logout = 4;

    public static int counterId = 1;

    private static  ArrayList<Patient> patientList = new ArrayList<>();

    public static void showExecutiveMenu(Scanner scanner) {
        System.out.println("=======Front Desk Executive Menu========");
        System.out.println("1. for Register new Patient \n 2. for Book Appointment \n 3. for Patient Details\n 4.Logout");
        int input = ScannerHelper.readIntegerInput(scanner);
        switch (input) {
            case Register_New_Patient: registerPatient(scanner); break;
            case Book_Appointment: break;
            case View_PatientDetails:viewPatientDetais();break;
            case Logout: break;
        }

    }

    private static void viewPatientDetais() {
        if(patientList.isEmpty())
        {
            System.out.println("No patients are registered");
        }
        else
        {
            for(Patient patient : patientList)
            {
                System.out.println(patient);
            }
        }
    }

    private static void registerPatient(Scanner scanner) {
        String patientId = String.format("D%04d", counterId++);
        String name = ScannerHelper.readStrWithPrompt(scanner, "please enter patient Name");
        String gender = ScannerHelper.readStrWithPrompt(scanner, "Please enter gender");
        int age = ScannerHelper.readIntWithPrompt(scanner, "Please enter age");
        String number = ScannerHelper.readMobileNumber(scanner, "Please enter mobile number");

        Patient patient = new Patient(patientId, name, gender, age, number);
        patientList.add(patient);
        System.out.println("Patient Registered successfully");
    }
}

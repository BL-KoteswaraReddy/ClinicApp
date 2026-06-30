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
    private static ArrayList<Appointment> appointmentList = new ArrayList<>();
    static Patient patientData;


    public static void showExecutiveMenu(Scanner scanner) {
        System.out.println("=======Front Desk Executive Menu========");
        System.out.println("1. for Register new Patient \n 2. for Book Appointment \n 3. for Patient Details\n 4.Logout");
        int input = ScannerHelper.readIntegerInput(scanner);
        switch (input) {
            case Register_New_Patient: registerPatient(scanner); break;
            case Book_Appointment: bookAppointment(scanner); break;
            case View_PatientDetails:viewPatientDetais(); break;
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
        String number = ScannerHelper.readMobileNumber(scanner, "Please enter mobile number");
       //1.identify patient
        patientData = findByMobileNumber(number);
        if(patientData == null) {
            String patientId = String.format("D%04d", counterId++);
            String name = ScannerHelper.readStrWithPrompt(scanner, "please enter patient Name");
            String gender = ScannerHelper.readStrWithPrompt(scanner, "Please enter gender");
            int age = ScannerHelper.readIntWithPrompt(scanner, "Please enter age");

            Patient patient = new Patient(patientId, name, gender, age, number);
            patientList.add(patient);
            System.out.println("Patient Registered successfully");

        }
        else
        {
            System.out.println("Record found : The patient already Registered");
            System.out.println(patientData);
            System.out.println("Registration cancelled to avoid duplication");
            return;
        }
    }


    public static Patient findByMobileNumber(String mobile)
    {
        for(Patient p: patientList)
        {
            if(p.getMobileNumber().equals(mobile))
                return p;
        }
        return null;
    }

    public static void bookAppointment(Scanner scanner)
    {
        //2.identify slot
        String requestedTime = ScannerHelper.selectSlotFromList(scanner);
        //3.Find an Available doctor
        ArrayList<Doctor> doctorList = AdminMenu.getDoctorList();
        System.out.println("Doctors list: "+doctorList);
        Doctor assignedDoctor = null;
        System.out.println("Requested Time is "+requestedTime);
        System.out.println("reaching appointment method");
        for(Doctor d: doctorList ) {
            boolean checkDoctor = d.isSlotFree(requestedTime);
            System.out.println("Checked doctor :"+checkDoctor);
            if (checkDoctor) {
                assignedDoctor = d;
                break; //Stop at the first doctor who is free
            }
        }
        System.out.println("Assigned Doctor :"+assignedDoctor);
            if(assignedDoctor != null)
            {
                assignedDoctor.bookSlot(requestedTime);
                Appointment newAppointment = new Appointment(patientData, assignedDoctor, requestedTime);
                appointmentList.add(newAppointment);
                System.out.println("Success : DR. "+assignedDoctor.getName() +"assigned for "+requestedTime);
            }
            else
            {
                System.out.println("Doctors are not available in this slot :"+requestedTime);
            }
    }
}

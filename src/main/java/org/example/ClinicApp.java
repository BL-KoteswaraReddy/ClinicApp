package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ClinicApp {
    private static final int ROLE_ADMIN = 1;
    private static final int ROLE_FRONT_DESK = 2;
    private static final int EXIT_SYSTEM = 3;
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        boolean exitSystem = false;
        System.out.println("Welcome to clinic Ops");
        System.out.println("*****Main Menu******");

        while (!exitSystem)
        {
            System.out.println("Select Persona: \n 1. for Admin \n 2. for front desk executes \n 3. for exit");
            System.out.println("Please Enter your choice");
            int roleChoice = ScannerHelper.readIntegerInput(scanner);
            switch (roleChoice)
            {
                case ROLE_ADMIN:AdminMenu.displayAdminOptions(scanner); break;
                case ROLE_FRONT_DESK:FrontDeskMenu.showExecutiveMenu(scanner); break;
                case EXIT_SYSTEM:
                    System.out.println("Shutting Down Clinic Ops app......Good Bye");
                    exitSystem = true;
                    break;

            }
        }


        }
    }
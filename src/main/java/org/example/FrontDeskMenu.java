package org.example;

import java.util.Scanner;

public class FrontDeskMenu {
    public static final int Register_New_Patient = 1;
    public static final int Book_Appointment = 2;
    public static final int Logout = 3;

    public static void showExecutiveMenu(Scanner scanner) {
        System.out.println("=======Front Desk Executive Menu========");
        System.out.println("1. for Register new Patient \n 2. for Book Appointment \n 3.Logout");
        int input = ScannerHelper.readIntegerInput(scanner);
        switch (input) {
            case Register_New_Patient: break;
            case Book_Appointment: break;
            case Logout: break;
        }

    }
}

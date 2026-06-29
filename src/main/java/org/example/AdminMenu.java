package org.example;

import java.util.Scanner;

public class AdminMenu {
    public static final int Doctor_Entry  = 1;
    public static final int Bulk_Entry = 2;
    public static final int View_Audit_Logs = 3;
    public static final int logout = 4;

    public static void showMenu(Scanner scanner) {
        System.out.println("1. for Doctors data entry \n 2. for Bulk data entry \n 3.View audit logs \n 4.Logout");
        int input = ScannerHelper.readIntegerInput(scanner);
        switch (input)
        {
            case Doctor_Entry: break;
            case Bulk_Entry: break;
            case View_Audit_Logs:break;
            case logout: break;
        }

    }

}

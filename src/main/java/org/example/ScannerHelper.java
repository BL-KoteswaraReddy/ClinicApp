package org.example;

import java.util.Scanner;

public class ScannerHelper {
    public static int readIntegerInput(Scanner scanner)
    {
        try {
            int input = scanner.nextInt();
            scanner.nextLine();//clear the buffer
            return input;
        }
        catch (Exception e)
        {
            scanner.nextLine(); // clear the input
            System.out.println("Please enter a numeric value");
            return -1;
        }

    }

    public static String readStrWithPrompt(Scanner scanner, String s) {
        System.out.println(s);
        return scanner.nextLine();


    }

    public static int readIntWithPrompt(Scanner scanner, String pleaseEnterDoc1Experience)
    {
        System.out.println(pleaseEnterDoc1Experience);
        int input = scanner.nextInt();
        return input;
    }
}

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
}

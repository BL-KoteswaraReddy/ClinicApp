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

    public static int readIntWithPrompt(Scanner scanner, String message)
    {
        while (true) {
            System.out.println(message);
            int input = scanner.nextInt();
            scanner.nextLine();
            return input;
        }
    }

    //Display Enum constants as a numbered list and returns the selection.
    public static <T extends Enum<T>> T readEnumChoice(Scanner scanner, T[] values)
    {
        /*
       values the array of enum constants
       @return The selected enum constant
         */
        while (true)
        {
        for(int i=0; i<values.length; i++)
        {
            System.out.println((i+1) + ". "+values[i]);
        }
        int choice = readIntWithPrompt(scanner, "Select choice (Number):");
        if(choice>0 && choice<values.length)
        {
            return values[choice-1];
        }
            System.out.println("Invalid input please try again");
       }
    }

    public static long readLongWithPrompt(Scanner scanner, String message) {
        System.out.println(message);
        return scanner.nextLong();
    }

    public static String readMobileNumber(Scanner scanner, String prompt) {
        String mobileRegex = "^[6-9]\\d{9}$";
        while (true)
        {
            System.out.println(prompt);
            String input = scanner.nextLine().trim();
            if(input.matches(mobileRegex))
                return input;
            else
            {
                System.out.println("Invalid mobile numbers must starts with 9, 8, 7 or 6");
            }
        }
    }
}

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
}

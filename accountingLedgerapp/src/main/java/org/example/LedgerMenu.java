package org.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LedgerMenu {

    public static void displayAll() {

        //Create list to store line as String
        List<String> lines = new ArrayList<>();

        // Open and read file
        try (BufferedReader reader = new BufferedReader(new FileReader("transactions.csv"))) {

            //Variable to hold each line
            String line;

            // File reading loop
            while ((line = reader.readLine()) != null) {
                lines.add(line);  // stores each line in list
            }

            // print newest first (reverse order)
            for (int i = lines.size() - 1; i >= 0; i--) {
                System.out.println(lines.get(i));
            }

        }
        catch (IOException e) {
            System.out.println("Error reading file.");
        }



    }

    public static void displayDeposit () {

    }

    public static void displayPayments () {

    }

    public static void reports () {

    }



// closing bracket for LedgerMenu
    }


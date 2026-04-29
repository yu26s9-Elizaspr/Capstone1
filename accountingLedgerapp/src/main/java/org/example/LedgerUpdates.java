package org.example;
import java.io.IOException;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class LedgerUpdates {

    // Method for "D" add deposit
    public static void addDeposit (Scanner input) {

        //auto-generate time/date
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        //Prompt user for info needed
        System.out.println("Enter description: ");
        String description = input.nextLine();

        System.out.println("Enter the vendor: ");
        String vendor = input.nextLine();

        System.out.println("Enter the amount: ");
        double amount = input.nextDouble();


        // Format like CSV file
        String record = date + "|" + time + "|" + description + "|" +
                vendor + "|" + amount;

        //Filewriting

        //open print to file
        try (FileWriter writer = new FileWriter("transactions.csv", true)) {
            writer.write(record + "\n");
            System.out.println("Deposit saved!");
        } catch (IOException e) {
            System.out.println("Error writing file.");
        }

    }

}

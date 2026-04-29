package org.example;
import java.io.IOException;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class LedgerUpdates {

    // Method for "D" add deposit
    public static void addDeposit(Scanner input) {

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

        //open & print to file
        try (FileWriter writer = new FileWriter("transactions.csv", true)) {
            writer.write(record + "\n");
            System.out.println("Deposit saved!");
        } catch (IOException e) {
            System.out.println("Error writing file.");
        }

    }

    //method for "P"
    public static void makePayment(Scanner input) {

        // Auto generate time and date
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();


        // prompt user for info
        System.out.println("Enter a description: ");
        String description = input.nextLine();

        System.out.println("Enter the vendor: ");
        String vendor = input.nextLine();

        System.out.println("Enter the amount: ");
        double amount = Double.parseDouble(input.nextLine());

        //Forces a negative (just in case)
        amount = -Math.abs(amount);

        // Format like CSV file
        String record = date + "|" + time + "|" + description + "|" +
                vendor + "|" + amount;

        //open & print to file
        try (FileWriter writer = new FileWriter("transactions.csv", true)) {
            writer.write(record + "\n");
            System.out.println("Payment saved!");
        } catch (IOException e) {
            System.out.println("Error writing file.");
        }


    }

    public static void LedgerScreen(Scanner input) {

        //Sout for Ledger Menu
        System.out.println("Ledger screen: Please choose one ");
        System.out.println(); // Space
        System.out.println("A - View All ");
        System.out.println("D - View Deposits");
        System.out.println("P - View Payments ");
        System.out.println("R - View Reports");
        System.out.println("H - Go Back to Home Page");


        // Prompt user for choice
        String ledgerChoice = input.nextLine();

        //switch statements ?
        switch (ledgerChoice) {
            case "A":

                break;
            case "D":
                break;
            case "P":
                break;
            case "R":
                break;
            case "H":
                break;
            default:
                System.out.println("Invalid input! Please try again");


        }




    }




    // close bracket for LedgerUpdates
}





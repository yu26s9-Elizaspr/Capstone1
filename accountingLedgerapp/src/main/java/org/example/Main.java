package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        // Added scanner for user input
        Scanner input = new Scanner(System.in);

        // Added variables
        boolean running = true;


        // Looping
        while (running) {

        //SOUT Menu options
        System.out.println("D - Add Deposit");
        System.out.println("P - Make Payment");
        System.out.println("L - Ledger");
        System.out.println("X - Exit");

        //User input
        String choice = input.nextLine().toUpperCase();



            //Switch statements for home screen
            switch (choice) {
                case "D":
                    System.out.println("Add a deposit?");
                    LedgerUpdates.addDeposit(input);
                    break;
                case "P":
                    System.out.println("Make a payment?");
                    LedgerUpdates.makePayment(input);
                    break;
                case "L":
                    System.out.println("Go to ledger?");
                    LedgerUpdates.LedgerScreen(input);
                    break;
                case "X":
                    System.out.println("Exit?");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid input! Please try again");


            }
        }
        input.close();
    }
}
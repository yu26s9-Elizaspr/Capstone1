package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        // Added scanner for user input
        Scanner input = new Scanner(System.in);

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
                break;
            case "P":
                break;
            case "L":
                break;
            case "X":
                break;
            default:
                System.out.println("Invalid input! Please try again");


        }
    }
}
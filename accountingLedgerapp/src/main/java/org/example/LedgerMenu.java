package org.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

        //Create list to store line as String
        List<String> lines = new ArrayList<>();

        // Open and read file
        try (BufferedReader reader = new BufferedReader(new FileReader("transactions.csv"))) {

            //Variable to hold each line
            String line;

            reader.readLine(); // Skip first line

            // File reading loop
            while ((line = reader.readLine()) != null) {
                lines.add(line);  // stores each line in list
            }

            // Loop backwards - showing newest first
            for (int i = lines.size() - 1; i >= 0; i--) {


                String[] tokens = lines.get(i).split("\\|"); // breaks lines up into Date, time, description, etc
                double amount = Double.parseDouble(tokens[4].trim());    // Converts amount

                // only prints positive amounts
                 if (amount > 0)
                     System.out.println(lines.get(i));

            }

        } catch (IOException e) {
            System.out.println("Error");
        }
    }


    public static void displayPayments () {

        //Create list to store line as String
        List<String> lines = new ArrayList<>();

        // Open and read file
        try (BufferedReader reader = new BufferedReader(new FileReader("transactions.csv"))) {

            //Variable to hold each line
            String line;

            reader.readLine(); // Skip first line

            // File reading loop
            while ((line = reader.readLine()) != null) {
                lines.add(line);  // stores each line in list
            }

            // Loop backwards - showing newest first
            for (int i = lines.size() - 1; i >= 0; i--) {


                String[] tokens = lines.get(i).split("\\|"); // breaks lines up into Date, time, description, etc
                double amount = Double.parseDouble(tokens[4].trim());    // Converts amount

                // only prints negative amounts
                if (amount < 0)
                    System.out.println(lines.get(i));

            }
        } catch (IOException e) {
            System.out.println("Error");
        }
    }


    public static void reports (Scanner input) {

        boolean inReports = true;

        while (inReports) {

            System.out.println("Pick the type of report you want to view: ");
            System.out.println();
            System.out.println("1 - Month to Date");
            System.out.println("2 - Previous Month");
            System.out.println("3 - Year to Date");
            System.out.println("4 - Previous Year");
            System.out.println("5 - Search by Vendor ");
            System.out.println("0 - Back");
            System.out.println("H - Back to Home Page");

            String choice = input.nextLine().toUpperCase();


            switch (choice) {
                case "1":
                        LedgerMenu.monthToDate();
                    break;
                case "2":
                    LedgerMenu.previousMonth();
                    break;
                case "3":
                    LedgerMenu.yearToDate();
                    break;
                case "4":
                    LedgerMenu.previousYear();
                    break;
                case "5":
                    LedgerMenu.vendorSearch(input);
                case "0":
                    inReports = false; // go back to Ledger Menu
                    break;
                case "H":
                    return; // jump back to home


                default:
                    System.out.println("Invalid option");

            }

        }

    }


    //methods for reports

    private static void monthToDate () {
        System.out.println("Month to Date report");


        // Gets todays date & Creates first day of current month
        LocalDate today = LocalDate.now();
        LocalDate firstOfMonth = today.withDayOfMonth(1);

        // create list to store every line from file
        List<String> lines = new ArrayList<>();

        // Open file and auto close when finish
        try (BufferedReader reader = new BufferedReader(new FileReader("transactions.csv"))) {
            reader.readLine(); // skip header

            String line; // holds each line


            // reads files line by line. Store lines into "line" variables
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }

            // newest first
            for (int i = lines.size() - 1; i >= 0; i--) {

                String[] tokens = lines.get(i).split("\\|"); // split lines using /

                LocalDate date = LocalDate.parse(tokens[0]); // convert date to string

                if (!date.isBefore(firstOfMonth) && !date.isAfter(today)) {
                    System.out.println(lines.get(i));
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file.");
        }

        }

        private static void previousMonth () {
            System.out.println("Previous Month report");

            LocalDate today = LocalDate.now();
            LocalDate firstDayPreviousMonth = today.minusMonths(1).withDayOfMonth(1);
            LocalDate lastDayPreviousMonth = today.withDayOfMonth(1).minusDays(1);

            List<String> lines = new ArrayList<>();

            try (BufferedReader reader = new BufferedReader(new FileReader("transactions.csv"))) {
                reader.readLine(); // skip header

                String line;

                while ((line = reader.readLine()) != null) {
                    lines.add(line);
                }

                // newest first
                for (int i = lines.size() - 1; i >= 0; i--) {

                    String[] tokens = lines.get(i).split("\\|");

                    LocalDate date = LocalDate.parse(tokens[0]);

                    // range change first day last month - last day of last month
                    if (!date.isBefore(firstDayPreviousMonth) && !date.isAfter(lastDayPreviousMonth)) {
                        System.out.println(lines.get(i));
                    }
                }

            } catch (IOException e) {
                System.out.println("Error reading file.");
            }

        }


        private  static void yearToDate(){

            System.out.println("Year to Date Report");

            LocalDate today = LocalDate.now();
            LocalDate firstofYear = today.withDayOfYear(1);

            List<String> lines = new ArrayList<>();

            try (BufferedReader reader = new BufferedReader(new FileReader("transactions.csv"))) {
                reader.readLine(); // skip header

                String line;

                while ((line = reader.readLine()) != null) {
                    lines.add(line);
                }

                // newest first
                for (int i = lines.size() - 1; i >= 0; i--) {

                    String[] tokens = lines.get(i).split("\\|");

                    LocalDate date = LocalDate.parse(tokens[0]);

                    if (!date.isBefore(firstofYear) && !date.isAfter(today)) {
                        System.out.println(lines.get(i));
                    }
                }
            } catch (IOException e) {
                System.out.println("Error reading file.");
            }

        }

        private static void previousYear () {

            System.out.println("Previous Year");


            LocalDate lastYear = LocalDate.now().minusYears(1);

            LocalDate start = lastYear.withDayOfYear(1);
            LocalDate end = lastYear.withMonth(12).withDayOfMonth(31);

            List<String> lines = new ArrayList<>();

            try (BufferedReader reader = new BufferedReader(new FileReader("transactions.csv"))) {
                reader.readLine(); // skip header

                String line;

                while ((line = reader.readLine()) != null) {
                    lines.add(line);
                }

                // newest first
                for (int i = lines.size() - 1; i >= 0; i--) {

                    String[] tokens = lines.get(i).split("\\|");

                    LocalDate date = LocalDate.parse(tokens[0]);

                    if (!date.isBefore(start) && !date.isAfter(end)) {
                        System.out.println(lines.get(i));
                    }
                }
            } catch (IOException e) {
                System.out.println("Error reading file.");
            }


        }

        private static void vendorSearch (Scanner input) {
            System.out.println("Enter a vendor to seach for: ");
            String search = input.nextLine();

            List<String> lines = new ArrayList<>();

            try (BufferedReader reader = new BufferedReader(new FileReader("transactions.csv"))) {
                reader.readLine();

                String line;


                while ((line = reader.readLine()) != null) {
                    lines.add(line);
                }

                for (int i = lines.size() - 1; i >= 0; i--) {

                    String[] tokens = lines.get(i).split("\\|");
                    String vendor = tokens[3].toLowerCase();

                    //can "half" search something
                    if (vendor.contains(search)) {
                        System.out.println(lines.get(i));
                    }
                }
            } catch (IOException e) {
                System.out.println("Error reading file.");
            }
            }

// closing bracket for LedgerMenu
}




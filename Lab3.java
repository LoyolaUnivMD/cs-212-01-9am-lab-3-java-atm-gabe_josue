// Programmers:  Gabe and Josue
// Course:  CS 212
// Due Date: 2/11/24
// Lab Assignment: Lab 3
// Problem Statement: Need to create a functional ATM
// Data In: Name and choices
// Data Out: The balance, receipt, total withdrawn/added,

import java.text.DecimalFormat;
import java.util.Scanner;


class Lab3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        DecimalFormat formatter = new DecimalFormat("0.##");

        System.out.println("What is your name?");
        String name = scanner.nextLine();
        ATM myAtm = new ATM(name);


        boolean running = true;

        while (running) {

            System.out.println("You have 4 options:");
            System.out.println("1. Withdraw\n2. Deposit\n3. Check balance\n4. Leave");
            System.out.println("Please enter the number corresponding to your choice.");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("How much would you like to withdraw?");
                    double withdrawAmount = scanner.nextDouble();
                    if (withdrawAmount < 0){
                        System.out.println("Please only enter positive numbers. Try again");
                        break;
                    }
                    scanner.nextLine();
                    if (myAtm.getBalance() > withdrawAmount) {
                        myAtm.withdraw(withdrawAmount);
                        System.out.println("Transaction successful! Balance is now $" +
                                formatter.format(myAtm.getBalance()));
                    } else {
                        System.out.println("Unable to complete transaction. Insufficient funds");
                    }
                    break;

                case 2:
                    System.out.println("How much would you like to deposit?");
                    double depositAmount = scanner.nextDouble();
                    if (depositAmount < 0){
                        System.out.println("Please only enter positive numbers. Try again");
                        break;
                    }
                    scanner.nextLine();
                    myAtm.deposit(depositAmount);
                    System.out.println("Deposit successful! Balance is now $" +
                            formatter.format(myAtm.getBalance()));
                    break;

                case 3:
                    System.out.println("Balance is: $" + formatter.format(myAtm.getBalance()));
                    break;

                case 4:
                    System.out.println("Leaving...");
                    running = false;
                    break;


            }

        }

        System.out.println("Would you like your receipt (1) emailed or (2) printed?");
        System.out.println("Enter the number corresponding to your choice");

        int choice = scanner.nextInt();

        System.out.println("Total Amount Deposited: $" + formatter.format(myAtm.getTotalDeposited()) + "\n" +
                "Total Amount Withdrawn: $" + formatter.format(myAtm.getTotalWithdrawn()) + "\n\n" +
                "Final balance: $" + formatter.format(myAtm.getBalance()));

        if (choice == 1){
            System.out.println("Don't forget to check your email!");
        } else {
            System.out.println("Don't forget to take your receipt!");
        }



        }
    }



import java.util.Scanner;

public class ATM {

    private double balance;
    private double totalWithdrawn;
    private double totalDeposited;
    private int choice;
    private Scanner scanner = new Scanner(System.in);
    final String name;


    // Setting up the constructor
    public ATM(String name){
        this.name = name;
        balance = 212.90;
        totalDeposited = 0.0;
        totalWithdrawn = 0.0;
        System.out.println("Welcome " + name + "!");
    }

    // Withdraws money from account and returns the new balance
    public void withdraw(double amount){

        balance -= amount;
        totalWithdrawn += amount;

    }

    public void deposit(double amount){

        balance += amount;
        totalDeposited += amount;

    }

    public double getBalance(){
        return balance;
    }
    public double getTotalWithdrawn(){
        return totalWithdrawn;
    }
    public double getTotalDeposited(){
        return totalDeposited;
    }










}

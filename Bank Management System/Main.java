import java.util.Random;
import java.util.Scanner;

class Account {
    private int accountNo;
    private int balance;
    private String accountHolderName;

    public Account(String accountHolderName, int initialBalance) {
        this.accountNo = generateAccountNumber();
        this.balance = initialBalance;
        this.accountHolderName = accountHolderName;
    }

    private int generateAccountNumber() {
        if (accountNo == 0) {
            Random rand = new Random();
            return rand.nextInt(900000) + 100000;
        }
        return accountNo;
    }

    public void showBalance() {
        System.out.println("Name : " + accountHolderName);
        System.out.println("Available Balance : " + balance);
        System.out.println("Account Number : " + accountNo);
    }

    public void showBalance(int amount, boolean deposit, boolean withdraw) {
        if (deposit) {
            System.out.println("Amount " + amount + " successfully desposited");
        }
        if (withdraw) {
            System.out.println("Amount " + amount + " successfully withdrawn");

        }
        System.out.println("Name : " + accountHolderName);
        System.out.println("Available Balance : " + balance);
        System.out.println("Account Number : " + accountNo);
    }

    public void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
            this.showBalance(amount, true, false);
        } else {
            System.out.println("Enter correct amount");
        }
    }

    public void withdraw(int amount) {
        if (balance > amount) {
            balance -= amount;
            this.showBalance(amount, false, true);
        } else {
            System.out.println("Insufficient balance");

        }
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name : ");
        String userName = sc.nextLine();

        System.out.print("Initial Balance : ");
        int initialBal = sc.nextInt();

        Account user = new Account(userName, initialBal);
        sc.close();
    }
}
package atmSimulator;

import java.util.Scanner;

public class ATMSimulator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int balance = 10000; // Starting balance
        int chances = 3; // Number of attempts to enter the correct PIN
        String correctPin = "1234"; // Simulated correct PIN

        while (chances > 0) {
            System.out.println("Enter your 4-digit PIN:");
            String enteredPin = sc.nextLine();

            if (enteredPin.equals(correctPin)) {
                boolean flag = true;

                while (flag) {
                    System.out.println("Choose an operation:");
                    System.out.println("1: Balance Inquiry");
                    System.out.println("2: Cash Withdrawal");
                    System.out.println("3: Fund Transfer");
                    System.out.println("4: Exit");

                    int choice = sc.nextInt();

                    switch (choice) {
                        case 1:
                            balanceInquiry(balance);
                            break;
                        case 2:
                            balance = cashWithdraw(balance, sc);
                            break;
                        case 3:
                            balance = fundTransfer(balance, sc);
                            break;
                        case 4:
                            flag = false;
                            System.out.println("Exiting...");
                            break;
                        default:
                            System.out.println("Invalid choice. Please select a valid operation.");
                    }
                }
                break; // Exit the loop after successful operation
            } else {
                chances--;
                System.out.println("Invalid PIN. You have " + chances + " attempt(s) left.");
                if (chances == 0) {
                    System.out.println("Your account has been locked due to multiple incorrect PIN attempts.");
                }
            }
        }
        sc.close();
    }

    private static void balanceInquiry(int balance) {
        System.out.println("Your current balance is: " + balance);
    }

    private static int cashWithdraw(int balance, Scanner sc) {
        System.out.println("Enter the amount to withdraw:");
        int withdrawAmount = sc.nextInt();

        if (withdrawAmount <= balance) {
            balance -= withdrawAmount;
            System.out.println("Please take your cash. Your new balance is: " + balance);
        } else {
            System.out.println("Insufficient funds. Your current balance is: " + balance);
        }
        return balance;
    }

    private static int fundTransfer(int balance, Scanner sc) {
        System.out.println("Enter the amount to transfer:");
        int transferAmount = sc.nextInt();
        sc.nextLine(); // Consume the newline
        System.out.println("Enter the recipient's account number:");
        String recipientAccount = sc.nextLine();

        if (transferAmount <= balance) {
            balance -= transferAmount;
            System.out.println("Successfully transferred " + transferAmount + " to account " + recipientAccount);
            System.out.println("Your new balance is: " + balance);
        } else {
            System.out.println("Insufficient funds. Your current balance is: " + balance);
        }
        return balance;
    }
}

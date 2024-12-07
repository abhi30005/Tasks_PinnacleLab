import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class ATM {
    private static Scanner input = new Scanner(System.in);
    private static double balance = 1000.0;
    private static ArrayList<String> history = new ArrayList<>();
    private static String pin, accNo, name; 

    public static void main(String[] args) {
        CreateAc();

        while (true) {
            System.out.print("\nEnter your PIN: ");
            if (input.nextLine().equals(pin)) {
                System.out.println("\nWelcome to SBI  " + name);
                System.out.println("Your account Number: " + accNo);

                int choice;
                do {
                    showMenu();
                    System.out.print("Choose an option: ");
                    choice = input.nextInt();

                    switch (choice) {
                        case 1 -> showHistory();
                        case 2 -> showBalance();
                        case 3 -> withdraw();
                        case 4 -> deposit();
                        case 5 -> transfer();
                        case 6 -> System.out.println("Thank you for Connect with SBI. Thank You !!\n Visit again..");
                        default -> System.out.println("Invalid option !! Try again...");
                    }
                } while (choice != 6);
                break;
            } else {
                System.out.println("Incorrect PIN !! Please try again..");
            }
        }
    }

    private static void CreateAc() {
        System.out.println("SBI Welcome You !!");
        System.out.print("Enter your name: ");
        name = input.nextLine();
        accNo = generateAccNo();
        System.out.println("Your Account number: " + accNo);
        System.out.print("Set a 4-digit PIN: ");
        pin = input.nextLine();
        while (pin.length() != 4 || !pin.matches("\\d+")) {
            System.out.print("Invalid PIN. Enter a 4-digit number: ");
            pin = input.nextLine();
        }
        System.out.println("Account Created Successfully..");
    }
    private static String generateAccNo() {
        return String.valueOf(100 + new Random().nextInt(900)); // 9-digit number
    }

    // Show ATM menu
    private static void showMenu() {
        System.out.println("\n*** Menu ***:");
        System.out.println("1. Transaction History.");
        System.out.println("2. Check Balance.");
        System.out.println("3. Withdraw.");
        System.out.println("4. Deposit.");
        System.out.println("5. Transfer.");
        System.out.println("6. Quit.");
    }

    private static void showHistory() {
        System.out.println("\nTransaction History:");
        if (history.isEmpty()) {
            System.out.println("No transactions available.");
        } else {
            history.forEach(System.out::println);
        }
    }

    private static void showBalance() {
        System.out.println("\nCurrent Balance: $" + balance);
    }

    private static void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = input.nextDouble();

        if (amount > balance) {
            System.out.println("Insufficient Balance.");
        } else if (amount <= 0) {
            System.out.println("Invalid amount.");
        } else {
            balance -= amount;
            history.add("Withdrawn: $" + amount);
            System.out.println("Withdrawal successful. New Balance: $" + balance);
        }
    }

    private static void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = input.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid amount.");
        } else {
            balance += amount;
            history.add("Deposited: $" + amount);
            System.out.println("Deposit successful. New Balance: $" + balance);
        }
    }
    private static void transfer() {
        System.out.print("Enter recipient account number: ");
        input.nextLine();
        String recipient = input.nextLine();
        System.out.print("Enter amount to transfer: ");
        double amount = input.nextDouble();

        if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else if (amount <= 0) {
            System.out.println("Invalid amount.");
        } else {
            balance -= amount;
            history.add("Transferred: $" + amount + " to Account: " + recipient);
            System.out.println("Transfer successful. New Balance: $" + balance);
        }
    }
}

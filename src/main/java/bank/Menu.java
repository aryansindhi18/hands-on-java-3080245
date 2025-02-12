package bank;

import java.util.Scanner;

import javax.security.auth.login.LoginException;

import bank.exceptions.AmountException;

public class Menu {
  private Scanner scanner;

  public static void main(String[] args) {
    System.out.println("Welcome to Globe Bank International...");
    Menu menu = new Menu();
    menu.scanner = new Scanner(System.in);
    Customer customer = menu.authenticateUser();
    if (customer != null) {
      System.out.println("Hello " + customer.getUsername());
      Account account = DataSource.getAccount(customer.getAccountId());
      menu.showMenu(customer, account);
    } else {
      System.out.println("customer == null");
    }
    menu.scanner.close();
  }

  private Customer authenticateUser() {
    System.out.println("Please enter your username");
    String username = scanner.next();
    System.out.println("Enter the password");
    String password = scanner.next();

    Customer customer = null;
    try {
      customer = Authenticate.login(username, password);
    } catch (LoginException e) {
      System.out.println("There was an error: " + e.getMessage());
    }
    return customer;
  }

  private void showMenu(Customer customer, Account account) {
    int selection = 1;
    while ((selection > 0 && selection < 4) && customer.isAuthenticated()) {
      System.out.println("===========================================");
      System.out.println("Please select one of the following options");
      System.out.println("1: Deposit");
      System.out.println("2: Withdraw");
      System.out.println("3: Check Balance");
      System.out.println("4: Exit");
      System.out.println("===========================================");

      selection = scanner.nextInt();
      double amt;
      switch (selection) {
        case 1:
          System.out.println("How much would you like to deposit?");
          amt = scanner.nextDouble();
          try {
            account.deposit(amt);
          } catch (AmountException e) {
            System.out.println(e.getMessage());
            System.out.println("Please try again with valid input");
          }
          break;
        case 2:
          System.out.println("How much would you like to withdraw?");
          amt = scanner.nextDouble();
          try {
            account.withdraw(amt);
          } catch (AmountException e) {
            System.out.println(e.getMessage());
            System.out.println("Please try again with valid input");
          }
          break;
        case 3:
          System.out.println(account.getBalance());
          break;
        default:
          System.out.println("Thanks for banking at Globe International Bank, logging out...");
          Authenticate.logout(customer);

      }
    }
  }
}

package application;

import entities.Account;
import exceptions.WithdrawException;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);

        try {

            System.out.println("Enter account data");
            System.out.print("Number: ");
            int number = sc.nextInt();
            sc.nextLine();

            System.out.print("Holder: ");
            String holder = sc.nextLine();

            System.out.print("Inicial balance: ");
            double balance = sc.nextDouble();


            System.out.print("Withdraw limit: ");
            double withdrawLimit = sc.nextDouble();

            sc.nextLine();

            Account account = new Account(number, holder, balance, withdrawLimit);

            System.out.println();

            System.out.print("Enter amount for withdraw: ");
            double amountWithdraw = sc.nextDouble();

            account.withdraw(amountWithdraw);


        } catch (WithdrawException e) {
            System.out.println("Withdraw error: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }

    }

}

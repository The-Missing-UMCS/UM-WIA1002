package com.umwia1002.solution.lab.version1.lab01.l1q4.l1q4b;

public class Main {

    public static void main(String[] args) {
        Account1 account = new Account1("George", 1122, 1000);

        account.setAnnualInterestRate(1.5);
        account.deposit(30, "1st deposit");
        account.deposit(40, "2nd deposit");
        account.deposit(50, "3rd deposit");
        account.withdraw(5, "1st withdraw");
        account.withdraw(4, "2nd withdraw");
        account.withdraw(2, "3rd withdraw");

        System.out.println(account);
        account.getTransactions().forEach(System.out::println);
    }
}

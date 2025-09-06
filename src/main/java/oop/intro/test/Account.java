package oop.intro.test;

public abstract class Account {
    protected double balance;
    private final String accountNumber;

    public Account (String accountNumber, double initialBalance){
        this.accountNumber = accountNumber;
        if(initialBalance > 0){
            this.balance = initialBalance;
        } else {
            this.balance = 0;
        }
    }

    // Ini memaksa setiap turunan Account WAJIB membuat implementasi withdraw-nya sendiri.
    public abstract boolean withdraw(double amount);

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Deposit " + amount + " berhasil. Saldo baru: " + this.balance);
        } else {
            System.out.println("Jumlah deposit harus positif.");
        }
    }

    public double getBalance() {
        return this.balance;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }
}
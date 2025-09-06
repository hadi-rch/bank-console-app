package oop.intro.test;

public class CheckingAccount extends Account {
    private double overdraftLimit;

    public CheckingAccount(String accountNumber, double initialBalance, double overdraftLimit) {
        super(accountNumber, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && (balance + this.overdraftLimit) >= amount) {
            this.balance -= amount;
            System.out.println("Penarikan dari Rek. Giro sebesar " + amount + " berhasil.");
            return true;
        } else {
            System.out.println("Penarikan dari Rek. Giro gagal. Melebihi limit overdraft.");
            return false;
        }
    }
}
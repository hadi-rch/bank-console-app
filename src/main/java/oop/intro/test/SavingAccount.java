package oop.intro.test;

public class SavingAccount extends Account {
    public SavingAccount(String accountNumber, double initialBalance) {
        super(accountNumber, initialBalance);
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            this.balance -= amount;
            System.out.println("Penarikan dari Rek. Tabungan sebesar " + amount + " berhasil.");
            return true;
        } else {
            System.out.println("Penarikan dari Rek. Tabungan gagal. Saldo tidak mencukupi.");
            return false;
        }
    }
}
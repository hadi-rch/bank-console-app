package oop.intro.test;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String bankName;
    private List<Customer> customerList;

    public String getBankName() {
        return bankName;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public Bank(String bankName){
        this.bankName = bankName;
        this.customerList = new ArrayList<>();
    }

    public void addCustomer(Customer customer){
        customerList.add(customer);
    }

    public Customer findCustomer(String customerId){
        for(Customer customer : customerList){
            if(customer.getCustomerId().equals(customerId)){
                return customer;
            }
        }
        return null;
    }

    // Cari account berdasarkan nomor akun (loop dalam loop)
    public Account findAccount(String accountNumber) {
        for (Customer customer : customerList) {
            for (Account account : customer.getAccountList()) {
                if (account.getAccountNumber().equals(accountNumber)) {
                    return account;
                }
            }
        }
        return null;
    }

    public void executeTransfer(String fromAccountNumber, String toAccountNumber, double amount){
        Account fromAccount = findAccount(fromAccountNumber);
        Account toAccount = findAccount(toAccountNumber);

        if(fromAccount == null || toAccount == null){
            System.out.println("Transfer gagal norek gk ketemu");
            return;
        }

        boolean success = fromAccount.withdraw(amount);
        if (success) {
            toAccount.deposit(amount);
            System.out.println("Transfer berhasil: " + amount +
                    " dari " + fromAccountNumber +
                    " ke " + toAccountNumber);
        } else {
            System.out.println("Transfer gagal: saldo tidak mencukupi.");
        }

    }
}

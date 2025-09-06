package oop.intro.test;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String customerId;
    private String name;
    private List<Account> accountList;

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public Customer(String customerId, String name){
        this.customerId = customerId;
        this.name = name;
        this.accountList = new ArrayList<>();
    }

    public void addAccount(Account account){
        accountList.add(account);
    }

    public List<Account> getAccountList(){
        return accountList;
    }
}

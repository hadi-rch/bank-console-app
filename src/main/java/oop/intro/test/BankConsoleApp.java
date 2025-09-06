package oop.intro.test;

import java.util.Scanner;

public class BankConsoleApp {
    private Bank bank;
    private Scanner scanner;

    public BankConsoleApp(){
        this.bank = new Bank("Bank Digital Indonesia");
        this.scanner = new Scanner(System.in);

        // siapkan beberapa data awal agar aplikasi bisa langsung dites
        setupInitialData();
    }

    public void run(){
        System.out.println("Selamat datang di " + bank.getBankName());

        while(true){
            printMenu();
            System.out.println("Pilih Menu 1-4: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 1:
                    handleCekSaldo();
                    break;
                case 2:
                    handleTransfer();
                    break;
                case 3:
                    handleTampilSemuaData();
                    break;
                case 4:
                    System.out.println("Terima kasih telah menggunakan layanan kami");
                    return;
                default:
                    System.out.println("pilihan gak valid. coba lagi dongs");
            }
            System.out.println("tekan enter buat balik ke menu");
            scanner.nextLine();
        }
    }

    private void printMenu(){
        System.out.println("\n===== MENU UTAMA =====");
        System.out.println("1. Cek Saldo");
        System.out.println("2. Transfer Dana");
        System.out.println("3. Tampilkan Semua Nasabah & Rekening");
        System.out.println("4. Keluar");
    }

    private void handleCekSaldo(){
        System.out.println("Masukan Nomor Rekening");
        String accountNumber = scanner.nextLine();
        Account account = bank.findAccount(accountNumber);

        if(account != null){
            System.out.println("Saldo Untuk Rekening " + accountNumber + " adalah: " + account.getBalance());
        }else {
            System.out.println("Rekening Tidak Ditemukan");
        }
    }

    private void handleTransfer(){
        System.out.println("Masukan Nomor Rekening Pengirim: ");
        String fromAccount = scanner.nextLine();
        System.out.println("Masukan Nomor Rekening Penerima: ");
        String toAccount = scanner.nextLine();
        System.out.println("Masukan Jumlah Transfer: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        bank.executeTransfer(fromAccount, toAccount, amount);
    }

    private void handleTampilSemuaData(){
        System.out.println("==== Data Semua Nasabah Dan Rekening ====");
        for(Customer customer : bank.getCustomerList()){
            System.out.println("Nasabah: " + customer.getName() + " (ID: " + customer.getCustomerId() + ")");
            if(customer.getAccountList().isEmpty()){
                System.out.println("Belum memiliki rekening");
            } else {
                for(Account account : customer.getAccountList()){
                    System.out.println("  - Rekening: " + account.getAccountNumber() + " | Saldo: Rp " + account.getBalance());
                }
            }
        }
        System.out.println("-----------------------------------------");
    }

    public void setupInitialData(){
        Customer cust1 = new Customer("CUST-001", "Budi");
        Customer cust2 = new Customer("CUST-002", "Sari");

        Account acc1 = new SavingAccount("ACC-001", 10000000);
        Account acc2 = new CheckingAccount("ACC-002", 5000000, 2000000);
        Account acc3 = new SavingAccount("ACC-003", 15000000);

        cust1.addAccount(acc1);
        cust1.addAccount(acc2);
        cust2.addAccount(acc3);

        bank.addCustomer(cust1);
        bank.addCustomer(cust2);
        System.out.println("Data awal berhasil dimuat.");
    }
}

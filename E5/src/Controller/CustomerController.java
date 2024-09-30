package Controller;

import Entity.Account;
import Entity.Customer;
import Entity.Invoice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CustomerController {
    private static List<Customer> customers;
    private static List<Account> accounts;
    private static List<Invoice> invoices;

    public CustomerController(List<Customer> customers, List<Account> accounts, List<Invoice> invoices) {
        CustomerController.customers = customers;
        CustomerController.accounts = accounts;
        CustomerController.invoices = invoices;
    }

    public List<Customer> sortByName() {
        return customers.stream()
                .sorted(Comparator.comparing(Customer::getName))
                .toList();
    }

    public List<Customer> sortById() {
        return customers.stream()
                .sorted(Comparator.comparingInt(Customer::getId_Customer))
                .toList();
    }

    public List<Customer> searchByIDorName(String keyword) {
        return customers.stream()
                .filter(customer -> String.valueOf(customer.getId_Customer()).toLowerCase().contains(keyword) ||
                        customer.getName().toLowerCase().contains(keyword))
                .toList();
    }

    public List<Account> balances() {
        for (Account account : accounts) {
            account.getBalance();
        }
        return accounts;
    }

    public List<Invoice> amountsDiscount() {
        for (Invoice invoice : invoices) {
            invoice.amountAfterDiscount();
        }
        return invoices;
    }

    public List<Invoice> amounts() {
        for (Invoice invoice : invoices) {
            invoice.getAmount();
        }
        return invoices;
    }

    public List<Customer> canPay() {
        List<Account> balanceAccounts = balances();
        List<Invoice> amountInvoices = amountsDiscount();
        List<Customer> payableInvoices = new ArrayList<>();

        for (int i = 0; i < balanceAccounts.size(); i++) {
            double balance = balanceAccounts.get(i).getBalance();
            double amount = amountInvoices.get(i).amountAfterDiscount();

            if (balance >= amount) {
                payableInvoices.add(amountInvoices.get(i));
            }
        }
        return payableInvoices;
    }

    public List<Customer> notPay() {
        List<Account> balanceAccounts = balances();
        List<Invoice> amountInvoices = amounts();
        List<Customer> unPayableInvoices = new ArrayList<>();

        for (int i = 0; i < balanceAccounts.size(); i++) {
            double balance = balanceAccounts.get(i).getBalance();
            double amount = amountInvoices.get(i).amountAfterDiscount();

            if (balance < amount) {
                unPayableInvoices.add(amountInvoices.get(i));
            }
        }
        return unPayableInvoices;
    }

}
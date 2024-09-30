

import Controller.AccountController;
import Controller.CustomerController;
import Controller.InvoiceController;
import Entity.Account;
import Entity.Customer;
import Entity.Gender;
import Entity.Invoice;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("ga", 1001, Gender.Male, 13));
        customers.add(new Customer("lon", 1003, Gender.Female, 220));
        customers.add(new Customer("vit", 1005, Gender.Female, 203));


        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account(1, "ga", 1001, Gender.Female, 13, 111));
        accounts.add(new Account(2, "lon", 1003, Gender.Male, 220, 222));
        accounts.add(new Account(3, "vit", 1005, Gender.Female, 203, 333));


        List<Invoice> invoices = new ArrayList<>();
        invoices.add(new Invoice(1, "ga", 1001, Gender.Male, 13, 111, LocalDate.of(2023, 1, 15)));
        invoices.add(new Invoice(2, "lon", 1003, Gender.Male, 220, 222, LocalDate.of(2023, 8, 20)));
        invoices.add(new Invoice(3, "vit", 1005, Gender.Female, 203, 333, LocalDate.of(2023, 8, 10)));


        CustomerController customerController = new CustomerController(customers,accounts,invoices);
        AccountController  accountController=new AccountController(accounts);
        InvoiceController invoiceController=new InvoiceController(invoices);
        Scanner sc=new Scanner(System.in);
        while (true){
            System.out.println("Menu");
            System.out.println("1. Sort by name");
            System.out.println("2. Sort by ID");
            System.out.println("3. Search Account by ID or name");
            System.out.println("4. Search Invoice by ID or name");
            System.out.println("5. Customer can pay");
            System.out.println("6. Customer not pay");
            System.out.println("7. Discount August");
            System.out.println("0. Exit");
            System.out.print("Select method:");
            int choose = sc.nextInt();
            sc.nextLine();
            switch (choose) {
                case 1:
                    List<Customer> sortedCustomersByName=customerController.sortByName();
                    System.out.println("Customers sorted by name:");
                    sortedCustomersByName.forEach(System.out::println);
                    break;
                case 2:
                    List<Customer> sortedCustomersById=customerController.sortById();
                    System.out.println("Customers sorted by Id:");
                    sortedCustomersById.forEach(System.out::println);
                    break;
                case 3:
                    System.out.print("Enter Id or Name for search account customer: ");
                    String keywordAccount = sc.nextLine();
                    List<Account> searchAccount= accountController.searchByIDorName(keywordAccount);
                    System.out.println("Account found:");
                    searchAccount.forEach(System.out::println);
                    break;
                case 4:
                    System.out.print("Enter Id or Name for search invoice customer: ");
                    String keywordInvoice = sc.nextLine();
                    List<Invoice> searchInvoice= invoiceController.searchByIDorName(keywordInvoice);
                    System.out.println("Invoice found: ");
                    searchInvoice.forEach(System.out::println);
                    break;
                case 5:
                    List<Customer> canPay=customerController.canPay();
                    System.out.println("Customers can pay:");
                    canPay.forEach(System.out::println);
                    break;
                case 6:
                    List<Customer> notPay=customerController.notPay();
                    System.out.println("Customers not pay (excluding discounts) :");
                    notPay.forEach(System.out::println);
                    break;
                case 7:
                    List<Invoice> discountAugust = invoiceController.discount();
                    System.out.println("Discount August for customer:");
                    discountAugust.forEach(System.out::println);
                    break;
                case 0:
                    System.out.println("Exit!");
                    sc.close();
                    return;
                default:
                    System.out.println("Error!");
                    return;
            }

        }

    }
}
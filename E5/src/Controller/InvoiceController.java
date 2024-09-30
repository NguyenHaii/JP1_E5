package Controller;

import Entity.Gender;
import Entity.Invoice;

import java.time.Month;
import java.util.List;

public class InvoiceController {
    private static List<Invoice> invoices;
    public InvoiceController(List<Invoice> invoices){
        InvoiceController.invoices = invoices;
    }
    public List<Invoice> searchByIDorName(String keyword) {
        return invoices.stream()
                .filter(invoice -> String.valueOf(invoice.getId_Invoice()).toLowerCase().contains(keyword) ||
                        invoice.getName().toLowerCase().contains(keyword))
                .toList();
    }
    public List<Invoice> discount() {
        List<Invoice> discountedInvoices= invoices.stream()
                .filter(invoice -> invoice.getGender().equals(Gender.Female))
                .filter(invoice -> invoice.getDate().getMonth()== Month.AUGUST)
                .toList();

        for (Invoice invoice : discountedInvoices) {
            double amountDiscountNotAugust = invoice.amountAfterDiscount();
            double amount=invoice.getAmount();
            double discountAmount = amount-(amount * 0.10+amountDiscountNotAugust);
            invoice.setAmount(amountDiscountNotAugust - discountAmount);
        }
        return discountedInvoices;
    }

}
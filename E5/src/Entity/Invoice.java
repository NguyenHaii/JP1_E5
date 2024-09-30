package Entity;

import java.time.LocalDate;

public class Invoice extends Customer {
    private int id_Invoice;
    private double amount;
    private LocalDate date;

    public Invoice() {
    }

    public Invoice(int id_Invoice, String name, int id_Customer, Gender gender, int discount, double amount, LocalDate date) {
        super(name, id_Customer, gender, discount);
        this.id_Invoice = id_Invoice;
        this.amount = amount;
        this.date = date;
    }

    public int getId_Invoice() {
        return id_Invoice;
    }

    public void setId_Invoice(int id_Invoice) {
        this.id_Invoice = id_Invoice;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double amountAfterDiscount() {
        int discount = this.getDiscount();
        return amount - (amount * discount / 100);
    }
    @Override
    public String toString() {
        return "Invoice{" +
                "id_Invoice=" + id_Invoice +
                ", name=" + this.getName() +
                ", gender=" + this.getGender() +
                ", amount=" + amount +
                ", amountDiscount=" + amountAfterDiscount() +
                ", date=" + date +
                '}';
    }
}
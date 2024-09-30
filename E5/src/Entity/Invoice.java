package Entity;

import java.time.LocalDate;

public class Invoice extends Customer {
    private int id3;
    private double amount;
    private LocalDate date;

    public Invoice() {
    }

    public Invoice(int id3, String name, int id2, Gender gender, int discount, double amount, LocalDate date) {
        super(name, id2, gender, discount);
        this.id3 = id3;
        this.amount = amount;
        this.date = date;
    }

    public int getid3() {
        return id3;
    }

    public void setid3(int id3) {
        this.id3 = id3;
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
                "id3=" + id_Invoice +
                ", name=" + this.getName() +
                ", gender=" + this.getGender() +
                ", amount=" + amount +
                ", amountDiscount=" + amountAfterDiscount() +
                ", date=" + date +
                '}';
    }
}

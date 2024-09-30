package Entity;

public class Account extends Customer {
    private int Id_Account;
    private double balance;

    public Account() {
    }

    public Account(int id_Account,String name, int id_Customer, Gender gender, int discount, double balance) {
        super(name, id_Customer, gender, discount);
        Id_Account = id_Account;
        this.balance = balance;
    }

    public int getId_Account() {
        return Id_Account;
    }

    public void setId_Account(int id_Account) {
        Id_Account = id_Account;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Balance: " + balance);
    }
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Amount withdrawn exceeds the current balance.");
        }else{
            balance -= amount;
            System.out.println("Balance: " + balance);
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "Id_Account=" + Id_Account +
                ", balance=" + balance +
                '}';
    }
}
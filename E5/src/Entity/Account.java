package Entity;

public class Account extends Customer {
    private int id1;
    private double balance;

    public Account() {
    }

    public Account(int id1,String name, int id2, Gender gender, int discount, double balance) {
        super(name, id2, gender, discount);
        id1 = id1;
        this.balance = balance;
    }

    public int getid1() {
        return id1;
    }

    public void setid1(int id1) {
        id1 = id1;
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
                "id1=" + id1 +
                ", balance=" + balance +
                '}';
    }
}

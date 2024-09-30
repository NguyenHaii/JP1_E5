package Entity;

public class Customer {
    private int Id_Customer;
    private String Name;
    private Gender gender;
    private int discount;

    public Customer() {
    }

    public Customer(String name, int id_Customer, Gender gender, int discount) {
        Name = name;
        Id_Customer = id_Customer;
        this.gender = gender;
        this.discount = discount;
    }

    public int getId_Customer() {
        return Id_Customer;
    }

    public void setId_Customer(int id_Customer) {
        Id_Customer = id_Customer;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "Id_Customer=" + Id_Customer +
                ", Name='" + Name + '\'' +
                ", gender=" + gender +
                ", discount=" + discount +
                '}';
    }
}
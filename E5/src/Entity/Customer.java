package Entity;

public class Customer {
    private int id2;
    private String Name;
    private Gender gender;
    private int discount;

    public Customer() {
    }

    public Customer(String name, int id2, Gender gender, int discount) {
        Name = name;
        id2 = id2;
        this.gender = gender;
        this.discount = discount;
    }

    public int getid2() {
        return id2;
    }

    public void setid2(int id2) {
        id2 = id2;
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
                "id2=" + id2 +
                ", Name='" + Name + '\'' +
                ", gender=" + gender +
                ", discount=" + discount +
                '}';
    }
}

package apitests;

public class Product {
    String name;
    public double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getFabricType() {
        return fabricType;
    }

    public void setFabricType(String fabricType) {
        this.fabricType = fabricType;
    }

    int quantity;
    String fabricType;

    public Product(String name, double price, int quantity, String fabricType) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.fabricType = fabricType;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", fabricType='" + fabricType + '\'' +
                '}';
    }

    public int compareTo(Product o) {
        return this.name.compareTo(o.name);

    }




    static{
        System.out.println("Hello");
    }
}

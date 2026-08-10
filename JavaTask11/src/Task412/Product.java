package Task412;

class Product implements Sellable {
    private String name;
    private double price;
    private int quantity;

    // Constructor calling setters to ensure initial validation
    public Product(String name, double price, int quantity) {
        setName(name);
        setPrice(price);
        setQuantity(quantity);
    }

    public String getName() { return name; }
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
    }

    public double getPrice() { return price; }
    public void setPrice(double price) {
        // Validation: 0 to 10000 only
        if (price >= 0 && price <= 10000) {
            this.price = price;
        } else {
            System.out.println("Price out of range");
            this.price = 0;
        }
    }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) {
        // Validation: 1 to 100 only
        if (quantity >= 1 && quantity <= 100) {
            this.quantity = quantity;
        } else {
            System.out.println("Quantity must be 1 to 100");
            this.quantity = 1;
        }
    }

    public void printAllInfo() {
        System.out.println("[Product] " + this.name + " " + String.format("%.2f", this.price) + " OMR qty " + this.quantity);
    }

    public String getCategory() { return "Product"; }
}

package Task412;

class Service implements Sellable {
    private String name;
    private double price;
    private int minutes;

    public Service(String name, double price, int minutes) {
        setName(name);
        setPrice(price);
        setMinutes(minutes);
    }

    public String getName() { return name; }
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
    }

    public double getPrice() { return price; }
    public void setPrice(double price) {
        if (price >= 0 && price <= 10000) {
            this.price = price;
        } else {
            System.out.println("Price out of range");
            this.price = 0;
        }
    }

    public int getMinutes() { return minutes; }
    public void setMinutes(int minutes) {
        // Validation: must be above 0
        if (minutes > 0) {
            this.minutes = minutes;
        } else {
            this.minutes = 0;
        }
    }

    public void printAllInfo() {
        System.out.println("[Service] " + this.name + " " + String.format("%.2f", this.price) + " OMR " + this.minutes + " min");
    }

    public String getCategory() { return "Service"; }
}

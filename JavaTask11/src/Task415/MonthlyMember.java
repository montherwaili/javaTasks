package Task415;

class MonthlyMember implements Payable {
    private String name;
    private int age;
    private double fee;
    private int membershipID;

    // Constructor sets the immutable ID and uses setters for initial validation
    public MonthlyMember(int id) {
        // Rule: membership ID must be above 0 and can never change (no setter)
        if (id > 0) {
            this.membershipID = id;
        } else {
            this.membershipID = 999; // Safe fallback
        }
        setName("New Member");
        setAge(14);
        setFee(1.0);
    }

    public String getName() { return name; }
    public void setName(String name) {
        // Rule: Not empty and at least 2 characters
        if (name != null && name.trim().length() >= 2) {
            this.name = name;
        } else {
            System.out.println("Error: Name must be at least 2 characters.");
        }
    }

    public int getAge() { return age; }
    public void setAge(int age) {
        // Rule: Age between 14 and 90
        if (age >= 14 && age <= 90) {
            this.age = age;
        } else if (age < 14) {
            System.out.println("Too young to register.");
        }
    }

    public double getFee() { return fee; }
    public void setFee(double fee) {
        // Rule: Between 0 and 500
        if (fee > 0 && fee <= 500) {
            this.fee = fee;
        } else {
            System.out.println("Error: Fee out of range (1-500).");
        }
    }

    public int getMembershipID() { return membershipID; }

    public void printAllInfo() {
        System.out.println("[Monthly Member] ID: " + membershipID + " | Name: " + name + " | Age: " + age + " | Total: " + monthlyTotal() + " OMR");
    }

    public double monthlyTotal() {
        return fee;
    }
}

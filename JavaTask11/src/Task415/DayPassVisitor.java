package Task415;

class DayPassVisitor implements Payable {
    private String name;
    private int age;
    private int visits;
    private final double PRICE_PER_VISIT = 3.500;

    public DayPassVisitor() {
        setName("New Visitor");
        setAge(14);
        setVisits(1);
    }

    public String getName() { return name; }
    public void setName(String name) {
        if (name != null && name.trim().length() >= 2) {
            this.name = name;
        } else {
            System.out.println("Error: Name must be at least 2 characters.");
        }
    }

    public int getAge() { return age; }
    public void setAge(int age) {
        if (age >= 14 && age <= 90) {
            this.age = age;
        } else if (age < 14) {
            System.out.println("Too young to register.");
        }
    }

    public int getVisits() { return visits; }
    public void setVisits(int visits) {
        // Rule: Visits between 1 and 31
        /*
         * ENCAPSULATION CHECK: If 'visits' were public, a user could set it to 100
         * in the menu, skipping the 1-31 logic defined here.
         */
        if (visits >= 1 && visits <= 31) {
            this.visits = visits;
        } else {
            System.out.println("Error: Visits must be between 1 and 31.");
        }
    }

    public void printAllInfo() {
        System.out.println("[Day Pass Visitor] Name: " + name + " | Age: " + age + " | Visits: " + visits + " | Total: " + monthlyTotal() + " OMR");
    }

    public double monthlyTotal() {
        return visits * PRICE_PER_VISIT;
    }
}

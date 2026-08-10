package Task413;

class WalkInVisitor implements Attendable {
    private String name;
    private int age;
    private int arrivalOrder;

    public WalkInVisitor() {
        setName("Unknown Visitor");
        setAge(0);
        setArrivalOrder(1);
    }

    public String getName() { return name; }
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Name is required");
        }
    }

    public int getAge() { return age; }
    public void setAge(int age) {
        if (age >= 0 && age <= 120) {
            this.age = age;
        } else {
            System.out.println("Invalid age");
        }
    }

    public int getArrivalOrder() { return arrivalOrder; }
    public void setArrivalOrder(int order) {
        // Validation: must be above 0, otherwise store 1
        if (order > 0) {
            this.arrivalOrder = order;
        } else {
            this.arrivalOrder = 1;
        }
    }

    public void printAllInfo() {
        System.out.println("[" + getPriority() + "] " + name + " age " + age + " waits " + getWaitMinutes() + " min");
    }

    public String getPriority() { return "Walk-in"; }

    public int getWaitMinutes() { return arrivalOrder * 15; }
}

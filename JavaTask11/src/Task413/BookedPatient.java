package Task413;

class BookedPatient implements Attendable {
    private String name;
    private int age;
    private String slotTime; // Read-only after construction

    // Constructor sets the immutable slotTime
    public BookedPatient(String slotTime) {
        this.slotTime = slotTime;
        // Default safe values via setters to ensure validation
        setName("Unknown Patient");
        setAge(0);
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
        // Validation: from 0 to 120 only
        if (age >= 0 && age <= 120) {
            this.age = age;
        } else {
            System.out.println("Invalid age");
        }
    }

    // Getter only for slotTime (Step 2: Read-only)
    public String getSlotTime() { return slotTime; }

    public void printAllInfo() {
        System.out.println("[" + getPriority() + "] " + name + ", age " + age + ", slot " + slotTime + ", waits " + getWaitMinutes() + " min");
    }

    public String getPriority() { return "Booked"; }

    public int getWaitMinutes() { return 10; }
}

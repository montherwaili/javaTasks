package Task414;

class Car implements Rentable {
    private String plateNumber;
    private double dailyRate;
    private int seats;
    private String brand; // Field with getter but NO setter

    // Constructor sets the immutable brand and calls setters for validation
    public Car(String brand) {
        /*
         * RATIONALE: The brand is set once at creation and has no setter because
         * a vehicle's brand cannot physically change during its lifecycle.
         */
        this.brand = brand;
        setPlateNumber("PENDING");
        setDailyRate(10.0);
        setSeats(4);
    }

    public String getPlateNumber() { return plateNumber; }
    public void setPlateNumber(String plateNumber) {
        if (plateNumber != null && !plateNumber.trim().isEmpty()) {
            this.plateNumber = plateNumber;
        } else {
            System.out.println("Validation Error: Plate number cannot be empty.");
        }
    }

    public double getDailyRate() { return dailyRate; }
    public void setDailyRate(double dailyRate) {
        if (dailyRate > 0 && dailyRate <= 200) {
            this.dailyRate = dailyRate;
        } else {
            System.out.println("Validation Error: Daily rate must be between 1 and 200.");
        }
    }

    public int getSeats() { return seats; }
    public void setSeats(int seats) {
        if (seats >= 2 && seats <= 7) {
            this.seats = seats;
        } else {
            System.out.println("Validation Error: A car must have between 2 and 7 seats.");
        }
    }

    public String getBrand() { return brand; }

    public void printAllInfo() {
        System.out.println("[Car] " + brand + " (Plate: " + plateNumber + ") | Seats: " + seats + " | Rate: " + dailyRate + " OMR/day");
    }

    public double costFor(int days) {
        // Cars include a fixed insurance fee of 5.000 OMR
        return (dailyRate * days) + 5.0;
    }
}

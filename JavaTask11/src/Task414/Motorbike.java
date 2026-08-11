package Task414;

class Motorbike implements Rentable {
    private String plateNumber;
    private double dailyRate;
    private int engineCC;

    public Motorbike() {
        setPlateNumber("PENDING");
        setDailyRate(5.0);
        setEngineCC(50);
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

    public int getEngineCC() { return engineCC; }
    public void setEngineCC(int cc) {
        if (cc >= 50 && cc <= 1500) {
            this.engineCC = cc;
        } else {
            System.out.println("Validation Error: Motorbike engine must be 50-1500 cc.");
        }
    }

    public void printAllInfo() {
        System.out.println("[Motorbike] (Plate: " + plateNumber + ") | Engine: " + engineCC + "cc | Rate: " + dailyRate + " OMR/day");
    }

    public double costFor(int days) {
        // Motorbikes only charge the daily rate (no insurance fee)
        return dailyRate * days;
    }
}

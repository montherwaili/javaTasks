package Task414;

// Central interface for all vehicles that can be rented
interface Rentable {
    void printAllInfo();
    double costFor(int days);
    String getPlateNumber();
}

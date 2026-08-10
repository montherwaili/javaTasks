package Task413;

// Central interface for everyone attending the clinic
interface Attendable {
    void printAllInfo();
    String getPriority();
    int getWaitMinutes();
}

package Task411;

class Magazine implements LibraryItem {
    private String name;
    private int issueNumber;
    private String month;

    public Magazine() {
        setName("Unnamed Task411.Magazine");
        setIssueNumber(1);
        setMonth("January");
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {

        if (name != null && !name.isBlank()) {
            this.name = name;
        } else {
            System.out.println("Name cannot be empty");
        }
    }

    public int getIssueNumber() {
        return this.issueNumber;
    }

    public void setIssueNumber(int issueNumber) {

        if (issueNumber >= 1 && issueNumber <= 500) {
            this.issueNumber = issueNumber;
        } else {
            System.out.println("Invalid issue number");
        }
    }

    public String getMonth() {
        return this.month;
    }

    public void setMonth(String month) {
        if (month != null && !month.isBlank()) {
            this.month = month;
        }
    }

    public void printAllInfo() {
        System.out.println("Task411.Magazine: " + getLabel() + " [" + getShelfCode() + "]");
    }

    public String getLabel() {
        return this.name + " (Issue #" + this.issueNumber + ", " + this.month + ")";
    }

    public String getShelfCode() {
        return "Shelf M-01";
    }
}
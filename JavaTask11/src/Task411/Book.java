package Task411;

class Book implements LibraryItem {

    private String title;
    private String author;
    private int pages;

    public Book() {

        setTitle("Untitled");
        setAuthor("Unknown");
        setPages(1);
    }


    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {

        if (title != null && !title.isBlank()) {
            this.title = title;
        } else {
            System.out.println("Name cannot be empty");
        }
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        if (author != null && !author.isBlank()) {
            this.author = author;
        }
    }

    public int getPages() {
        return this.pages;
    }

    public void setPages(int pages) {

        if (pages > 0) {
            this.pages = pages;
        } else {
            this.pages = 0;
            System.out.println("Pages must be above 0");
        }
    }

    public void printAllInfo() {
        System.out.println("Task411.Book: " + getLabel() + " (" + this.pages + " pages) [" + getShelfCode() + "]");
    }

    public String getLabel() {
        return this.title + " by " + this.author;
    }

    public String getShelfCode() {
        return "Shelf B-0" + (this.pages % 9 + 1);
    }
}

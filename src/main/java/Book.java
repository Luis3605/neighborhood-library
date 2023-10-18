public class Book {
    private final int id;
    private final String isbn;
    private final String title;
    private boolean isCheckedOut;
    private String checkedOutTo;

    public Book(int id, String isbn, String title) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = false;
        this.checkedOutTo = "";
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    public void setCheckedOut(boolean checkedOut, String checkedOutTo) {
        this.isCheckedOut = checkedOut;
        this.checkedOutTo = checkedOutTo;
    }

    // Method to check out the book
    public void checkOut(String name) {
        this.isCheckedOut = true;
        this.checkedOutTo = name;
    }

    // Method to check in the book
    public void checkIn() {
        this.isCheckedOut = false;
        this.checkedOutTo = "";
    }
}

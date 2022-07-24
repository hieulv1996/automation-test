package weekThree;

public class Student {
    int no;
    String borrowDate;
    String name;
    String bookTitle;

    public Student(int no, String borrowDate, String name, String bookTitle) {
        this.no = no;
        this.borrowDate = borrowDate;
        this.name = name;
        this.bookTitle = bookTitle;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }
}

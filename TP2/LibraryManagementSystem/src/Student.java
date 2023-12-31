
public class Student extends Person implements LibraryUser {
    private String studentName;
    private int studentId;
    BookCollection borrowedBooks;
    private LibraryCard libraryCard; 
    public Student(String name, int age, int cardNumber, int expirationYear) {
        super(name, age);
        this.libraryCard = new LibraryCard(this, cardNumber, expirationYear);
        this.borrowedBooks = new BookCollection(libraryCard.getMaxBooks());
    }
    public void borrowBook(Book book,int year) {
        if (year > libraryCard.getExpirationYear()) {
            System.out.println("Library card expired");
        } else {
            System.out.println("Student " + studentName + " is borrowing the book: " + book.GetTitle());
            int r=borrowedBooks.AddBook(book);
            if (r==0) {
                System.out.println("Already reached maximum of borrowed books");
            } else if(r==1) {
                System.out.println("This book already exists in this user's borrowed books");
            } else {
                System.out.println("Book added to borrowed books");
            }
        }
    }   
    public void returnBook(Book book,int year) {
        if (year > libraryCard.getExpirationYear()) {
            System.out.println("Library card expired");
        } else {
            System.out.println("Student " + studentName + " is returning the book: " + book.GetTitle());
            int x=borrowedBooks.RemoveBook(book);
            if (x==0) {
                System.out.println("Book not in borrowed books");
            } else if(x==1) {
                System.out.println("You haven't borrowed this book yet");
            } else {
                System.out.println("Book returned");
            }
        }
    }
    public void displayBorrowedBooks() {
        borrowedBooks.ListBooks();
    }
    public LibraryCard getLibraryCard() {
        return libraryCard;
    }
}
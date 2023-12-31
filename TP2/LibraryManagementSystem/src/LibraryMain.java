public class LibraryMain {
    public static void main(String[] args) {
        // Create some books
        Book novel1 = new Novel();
        novel1.setTitle("The Great Novel");
        novel1.setAuthor("John Doe");
        novel1.setYearOfPublication(2020);

        Book textbook1 = new Textbook();
        textbook1.setTitle("Java Programming");
        textbook1.setAuthor("Jane Smith");
        textbook1.setYearOfPublication(2019);

        // Create a library
        Library library = new Library();

        // Add books to the library
        library.AddBook(novel1);
        library.AddBook(textbook1);

        // Display all books in the library
        library.ListBooks();

        // Create a student and a teacher
        Student student = new Student("Alice", 20, 123, 2025);
        Teacher teacher = new Teacher("Mr. Smith", 35, 456, 2024);

        // Display student and teacher information
        System.out.println("\nStudent Information:");
        System.out.println("Name: " + student.getName());
        System.out.println("Age: " + student.getAge());
        System.out.println("Library Card Details: " + student.getLibraryCard());

        System.out.println("\nTeacher Information:");
        System.out.println("Name: " + teacher.getName());
        System.out.println("Age: " + teacher.getAge());
        System.out.println("Library Card Details: " + teacher.getLibraryCard());

        // Student borrows a book
        student.borrowBook(novel1, 2023);

        // Teacher borrows a book
        teacher.borrowBook(textbook1, 2023);

        // Display borrowed books
        System.out.println("\nStudent's Borrowed Books:");
        student.displayBorrowedBooks();

        System.out.println("\nTeacher's Borrowed Books:");
        teacher.displayBorrowedBooks();

        // Student returns a book
        student.returnBook(novel1, 2023);

        // Display updated borrowed books
        System.out.println("\nStudent's Updated Borrowed Books:");
        student.displayBorrowedBooks();
    }
}

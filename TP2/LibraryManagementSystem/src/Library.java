
public class Library {
    BookCollection Inventory;
    public Library() {
        Inventory= new BookCollection(100);
    }
    public void AddBook(Book B) {
        int r=Inventory.AddBook(B);
        if (r==0) {
            System.out.println("Library is full");
        } else if(r==1) {
            System.out.println("This book already exists in the library's inventory");
        } else {
            System.out.println("Book added to the library");
        }
    }
    public void RemoveBook(Book B) {
        int x=Inventory.RemoveBook(B);
        if (x==0) {
            System.out.println("Library is Empty");
        } else if(x==1) {
            System.out.println("This book doesn't exist in the library's inventory");
        } else {
            System.out.println("Book removed from the library");
        }
    }
    public void ListBooks() {
        Inventory.ListBooks();
    }
}

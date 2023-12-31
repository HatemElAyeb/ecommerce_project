import java.util.List;
import java.util.ArrayList;
public class BookCollection {
    private int maxSize;
    List<Book> Collection = new ArrayList<>();
    public BookCollection(int Maxs) {
        maxSize=Maxs;
    }
    public int getMaxSize() {
        return maxSize;
    }
    public int AddBook(Book B) {
        if (Collection.size()==maxSize) {
            return 0;
        } else if (Collection.contains(B)) {
            return 1;
        } else {
            Collection.add(B);
            return 2;
        }
    }
    public int RemoveBook(Book B) {
        if (Collection.size()==0) {
            return 0;
        } else if (!Collection.contains(B)) {
            return 1;
        } else {
            Collection.remove(B);
            return 2;
        }
    }
    public void ListBooks() {
        System.out.println("List of Books in the inventory: ");
        for (int i=0;i<Collection.size();i++ ) {
            Collection.get(i).displayInformation();
        }
    }
}

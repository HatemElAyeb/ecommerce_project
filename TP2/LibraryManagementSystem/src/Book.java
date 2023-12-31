public abstract class Book {
    private String Title;
    private String Author;
    private int YearOfPublication;
    public String GetTitle() {
        return Title;
    }
    public String GetAuthor() {
        return Author;
    }
    public int GetYearOfPublication() {
        return YearOfPublication;
    }
    public abstract void displayInformation();
    public void setTitle(String T) {
        Title=T;
    }
    public void setAuthor(String A) {
        Author=A;
    }
    public void setYearOfPublication(int Y) {
        YearOfPublication=Y;
    }
}

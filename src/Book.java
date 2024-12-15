public class Book {
    private String bookName;
    private BookType bookType;
    private double bookPrice;

    enum BookType {
        Poetry,
        Romance,
        Novels,
        Fantasy,
        Horror,
        Classics
    }

    public Book(String bookName,BookType bookType){
        setBookType(bookType);
        setBookName(bookName);
        switch(bookType){
            case Classics -> setBookPrice(115);
            case Horror -> setBookPrice(860);
            case Fantasy -> setBookPrice(320);
            case Romance -> setBookPrice(299);
            case Novels -> setBookPrice(400);
            case Poetry -> setBookPrice(500);
            default ->System.out.println("Invalid Type");
        }
    }

    public double getBookPrice(){
        return bookPrice;
    }
    public void setBookPrice(double bookPrice){
        this.bookPrice = bookPrice;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public Book.BookType getBookType(){
        return bookType;
    }

    public void setBookType(Book.BookType bookType) {
        this.bookType = bookType;
    }
}
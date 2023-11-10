package ba.edu.ibu.quiz3.first;

abstract class Book {
    private String name;
    private int numOfPages;

    public Book(String name, int numOfPages) {
        this.name = name;
        this.numOfPages = numOfPages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfPages() {
        return numOfPages;
    }

    public void setNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
    }

    abstract String read();
}

class ProgrammingBook extends Book{
    private String cover;

    public ProgrammingBook(String name, int numOfPages, String cover) {
        super(name, numOfPages);
        this.cover = cover;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    @Override
    public String read(){
        return "Programming read";
    }
}

class OOPBook extends Book{
    private String cover;

    public OOPBook(String name, int numOfPages, String cover) {
        super(name, numOfPages);
        this.cover = cover;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    @Override
    public String read(){
        return "OOP read";
    }
}

class Library<T extends Book>{
    private T book;

    public Library(T book) {
        this.book = book;
    }

    public T getBook() {
        return book;
    }

    public void setBook(T book) {
        this.book = book;
    }
}

class MainC2{
    public static void main(String[] args) {
        Library<ProgrammingBook> programmingBookLibrary = new Library<>(new ProgrammingBook("Programming", 110, "https://klix.ba"));
        Library<OOPBook> oopBookLibrary = new Library<>(new OOPBook("OOP", 120, "https://klix.ba"));
        System.out.println(programmingBookLibrary.getBook().getName());
        System.out.println(programmingBookLibrary.getBook().read());
        System.out.println(oopBookLibrary.getBook().read());
    }
}

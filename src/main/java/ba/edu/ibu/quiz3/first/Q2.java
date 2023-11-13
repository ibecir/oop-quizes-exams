package ba.edu.ibu.quiz3.first;
/*
* Create an abstract class called Book that will have two properties: name of type String and numOfPages of type int.
Create a constructor for this class with both of the attributes and get and set methods. Create one abstract method called
read that returns type String.

Create a class called ProgrammingBook that extends class Book. This class should have one property called cover of type string. Provide a
constructor for this class that sets the name, numOfPages and cover (in that same order). Provide the implementation of the
read method so it, for the ProgrammingBook class returns "Programming read".

Create one more class called OOPBook that extends the Book class. This class should have one property called cover of
type String. Provide a constructor for this class that sets the name, numOfPages and cover (in that same order). Provide
the implementation of the read method so it, for the OOPBook class returns "OOP read".

Create an interface called Library that as a parameter has one attribute of generic type called book. This generic can only
be an object that inherits from the Book class. Provide the constructor that accepts that generic and sets its value. Provide
The get and set methods for it.

* */
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

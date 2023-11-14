package ba.edu.ibu.quiz3.second;
/*Create and interface called Readable that has one abstract method called getContent that returns String.

Create class called SMS that has one property called message of type String. This class should implement the interface Readable and implement the method getContent, so it returns the value of the message property for the SMS class instance. Provide the constructor that gets and sets the value of that property and implement the get and set methods for that property.

Create class called Book that has one property called page of type String. This class should implement the interface Readable and implement the method getContent, so it returns the value of page property for the Book class instance. Provide the constructor that gets and sets the value of
that property and implement the get and set methods for that property.
*/
interface Readable {
    public String getContent();
}

class SMS implements Readable {

    private String message;

    public SMS(String message) {
        this.message = message;
    }

    @Override
    public String getContent() {
        return this.message;
    }
}

class Book implements Readable {
    private String page;

    public Book(String page) {
        this.page = page;
    }

    @Override
    public String getContent() {
        return this.page;
    }
}

class MainC2 {
    public static void main(String[] args) {
        SMS sms = new SMS("My first message");
        Book book = new Book("The page");

        System.out.println(sms.getContent());
        System.out.println(book.getContent());
    }
}

package ba.edu.ibu.quiz3.firstq;

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

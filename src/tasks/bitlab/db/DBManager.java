package tasks.bitlab.db;

import java.util.ArrayList;

public class DBManager {
    private static final ArrayList<Book> books = new ArrayList<>();
    private static int id = 6;

    static {
        books.add(new Book(1,
                "Lord Of The Rings",
                "Ronald Tolkien",
                "Fantasy",
                10000,
                "The best book ever written!"));
        books.add(new Book(2,
                "Thus Spoke Zarathustra",
                "Friedrich Nietzsche",
                "Philosophy",
                8000,
                "Hard Philosophy, only for prepared ones"));
        books.add(new Book(3,
                "Democracy in America",
                "Alexis de Tocqueville",
                "Politics",
                7500,
                "The hypocritical democracy in United States"));
        books.add(new Book(4,
                "Meditations",
                "Marcus Aurelius",
                "Philosophy",
                6000,
                "Collection of philosophical thoughts of the Rome Emperor know as philosopher on the emperor's throne"));
        books.add(new Book(5,
                "A Song of Ice and Fire",
                "George Martin",
                "Fantasy",
                5000,
                "Fantastical bestseller and widely popular book"));
    }

    public static ArrayList<Book> getBooks(){
        return books;
    }

    public static void addBooks(Book book){
        book.setId(id);
        books.add(book);
        id++;
    }

    public static Book getBook(int id){
        return books.stream()
                .filter(book -> book.getId()== id)
                .findFirst()
                .orElse(null);
    }

    public static void updateBook(Book newbook){
        for (int i = 0; i < books.size(); i++) {
            if(books.get(i).getId()== newbook.getId()){
                books.set(i, newbook);
                break;
            }
        }
    }

    public static void deleteBook(int id){
        for (int i = 0; i < books.size(); i++) {
            if(books.get(i).getId()== id){
                books.remove(books.get(i));
                break;
            }
        }
    }

}

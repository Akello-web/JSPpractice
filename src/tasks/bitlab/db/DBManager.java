package tasks.bitlab.db;

import java.util.ArrayList;

public class DBManager {
    private static final ArrayList<Book> books = new ArrayList<>();
    private static int id = 6;

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

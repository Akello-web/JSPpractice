package tasks.bitlab.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tasks.bitlab.db.Book;
import tasks.bitlab.db.DBManager;

import java.io.IOException;

@WebServlet(value = "/add-book")
public class AddBookServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("book_name");
        String author = request.getParameter("book_author");
        String genre = request.getParameter("book_genre");
        double price = Double.parseDouble(request.getParameter("book_price"));
        String description = request.getParameter("book_description");

        Book book = new Book();
        book.setName(name);
        book.setAuthor(author);
        book.setGenre(genre);
        book.setPrice(price);
        book.setDescription(description);

        DBManager.addBooks(book);

        response.sendRedirect("/");//делает так, что после успешного выполнения программа сразу провалевает подальше
    }
}

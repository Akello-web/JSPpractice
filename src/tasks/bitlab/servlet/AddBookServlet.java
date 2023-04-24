package tasks.bitlab.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tasks.bitlab.db.*;

import java.io.IOException;

@WebServlet(value = "/add-book")
public class AddBookServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("currentUser");
        if(user!=null) {
            String name = request.getParameter("book_name");
            int authorId = Integer.parseInt(request.getParameter("book_author"));
            String genre = request.getParameter("book_genre");
            double price = Double.parseDouble(request.getParameter("book_price"));
            String description = request.getParameter("book_description");

            Author author = DBConnection.getAuthor(authorId);
            if (author != null) {
                Book book = new Book();
                book.setName(name);
                book.setGenre(genre);
                book.setPrice(price);
                book.setAuthor(author);
                book.setDescription(description);

                DBConnection.addBook(book);
            }
            response.sendRedirect("/");
        }else {
            response.sendRedirect("/login");
        }
    }
}

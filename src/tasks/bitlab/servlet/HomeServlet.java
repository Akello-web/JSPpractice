package tasks.bitlab.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tasks.bitlab.db.Book;
import tasks.bitlab.db.DBConnection;

import java.io.IOException;
import java.util.ArrayList;


@WebServlet(value = "/home.html")//если в браузере открыть "/home.html", заработает программа
public class HomeServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Book> books = DBConnection.getBooks();
        req.setAttribute("buks", books);
        req.getRequestDispatcher("/books.jsp").forward(req, resp);
    };
}

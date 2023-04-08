package tasks.bitlab.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tasks.bitlab.db.Book;
import tasks.bitlab.db.DBManager;

import java.io.IOException;

@WebServlet(value = "/details")
public class DetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = -1;
        try {
            id = Integer.parseInt(req.getParameter("book_id"));//присвоил айди
        }catch (Exception e){
        }

        Book book = DBManager.getBook(id);//Нашел с базы подходящую книгу по айди
        req.setAttribute("kniga", book);//записал под ключ
        req.getRequestDispatcher("/details.jsp").forward(req, resp);//перенаправил на сайт
    }
}

package tasks.bitlab.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tasks.bitlab.db.Author;
import tasks.bitlab.db.Book;
import tasks.bitlab.db.DBConnection;
import tasks.bitlab.db.User;

import java.io.IOException;

@WebServlet(value = "/add-author")
public class AddAuthorServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User currentUser = (User) request.getSession().getAttribute("currentUser");
        if(currentUser!=null && currentUser.getRole()==1) {
            String firstName = request.getParameter("first_name");
            String lastName = request.getParameter("last_name");
            String description = request.getParameter("author_description");

            Author author = new Author();
            author.setFirstName(firstName);
            author.setLastName(lastName);
            author.setDescription(description);

            DBConnection.addAuthor(author);

            response.sendRedirect("/add-page_author");
        }else {
            response.sendRedirect("/login");
        }
    }
}

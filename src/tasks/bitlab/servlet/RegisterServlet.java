package tasks.bitlab.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tasks.bitlab.db.DBConnection;
import tasks.bitlab.db.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;

@WebServlet(value = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/register.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String full_name = request.getParameter("full_name");
        String re_password = request.getParameter("re-password");
        String success = "";

        if(!Objects.equals(password, re_password)){
            success = "failed";
            request.setAttribute("issuccess", success);
            response.sendRedirect("/register");
        }else {
            User user = new User();
            user.setFullName(full_name);
            user.setEmail(email);
            user.setPassword(password);

            DBConnection.addUser(user);

            response.sendRedirect("/register?success");
        }
    }
}

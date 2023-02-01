package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello")         // name of page you'll go to
public class HelloServlet extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        String message = request.getParameter("Name");   // here is variable's name
        if(message==null) {message = "  World!";}
        request.setAttribute("message", message);     // встановлення нового атрибуту
        request.getRequestDispatcher("/jsp/hello.jsp").forward(request, response);  // forwarding message to hello.jsp file

        //PrintWriter out = response.getWriter();     // прописуємо out
        //out.println("Static output on response");   // using out
    }

}

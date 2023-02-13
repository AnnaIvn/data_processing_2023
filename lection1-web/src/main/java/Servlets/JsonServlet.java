package Servlets;

import Entity.MyEntity;
import com.google.gson.Gson;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/servlet")
public class JsonServlet extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        MyEntity entity = new MyEntity("The North Face Dolomite", "/", 2.2f, 1.9f);         // creating new entity

        ArrayList<MyEntity> entityList = new ArrayList<MyEntity>();
        entityList.add(entity);

        String someJson = new Gson().toJson(entityList);

        response.setContentType("application/json");   // відповіда тому, що ми передаємо json
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        //out.print(someJson);    // printing out entity through gson
        out.print(entityList);
        out.flush();
    }

}

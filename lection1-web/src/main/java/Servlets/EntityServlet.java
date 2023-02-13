package Servlets;

import Crud.Lab2CrudInterface;
import Entity.MyEntity;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/interface")
public class EntityServlet extends HttpServlet
{

    ServletConfigInterface servletConfig;   // implementation for interface
    Lab2CrudInterface lab2Crud;

    public EntityServlet(){
        super();
        this.servletConfig = new ServletConfig();   // realizes servletConfigInterface
        this.lab2Crud = servletConfig.getCrud();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        ArrayList<MyEntity> entityList = new ArrayList<MyEntity>();
        //data.add(crud.readEntity());

        String someJson = new Gson().toJson(entityList);

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        //out.println(lab2Crud.readEntity());

        out.print(entityList);
        out.flush();
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String name = request.getParameter("name");              // getting info
        String photo = request.getParameter("photo");
        float weight = Float.parseFloat(request.getParameter("weight"));
        float length = Float.parseFloat(request.getParameter("length"));

        lab2Crud.updateEntity(new MyEntity(name, photo, weight, length));   // updating entity (writing into file)
    }
}

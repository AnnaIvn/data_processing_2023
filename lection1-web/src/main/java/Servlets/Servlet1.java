package Servlets;
// for lab 3

import Entity.Mock;
import Entity.MyEntity;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/servlet1")
//@WebServlet("/servlet1/*")
public class Servlet1 extends HttpServlet
{
    private List<MyEntity> lu = new Mock().getEntityList();

    public Servlet1() {
        super();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        response.setContentType("application/json");
        //response.setCharacterEncoding("UTF-8");
        response.getWriter().println(lu);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        MyEntity entity = Helpers.entityParse(request);    // receiving entity
        //entity.setId(Helpers.getNextId(lu));    // here we could've set next id
        lu.add(entity);     // adding entity
        doGet(request, response);
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        MyEntity entity = Helpers.entityParse(request);    // receiving entity
        response.setContentType("application/json");
        // do not need this part right now
        // int id = Integer.parseInt(request.getPathInfo().substring(1));
        //int index = Helpers.getIndexByEntityId(id, lu);
        //lu.set(index, entity);
        doGet(request, response);
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        MyEntity entity = Helpers.entityParse(request);    // receiving entity
        response.setContentType("application/json");
        // do not need this part right now
        // int id = Integer.parseInt(request.getPathInfo().substring(1));
        //int index = Helpers.getIndexByEntityId(id, lu);
        lu.remove(entity);
        doGet(request, response);
    }

}

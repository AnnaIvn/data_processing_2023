// need for lab 4

package Servlets;

//import Entity.Mock;
import Entity.MyEntity;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jdbc.Connect;
import jdbc.SqlCrud;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/servlet1")
//@WebServlet("/servlet1/*")
public class Servlet1 extends HttpServlet
{
    // do not need this for lab 4
    // private List<MyEntity> lu = new Mock().getEntityList();
        /*public Servlet1() {
        super();
    }*/

    LabCRUDInterface<MyEntity> crud = new SqlCrud();
    Connect connect;
    // we need two methods: init and destroy, - for starting and ending connection with database
    public void init(ServletConfig config) throws ServletException{
        // we need to pass our connect to SqlCrud, but crud is other type, so, we don't have access to it
        // so we made a constructor in SqlCrud class

        crud = new SqlCrud();
    }

    public void destroy(){
        try{
            ((SqlCrud) crud).getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //connect.closeCon();                        // in Connect class
    }



    // read
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().println(crud.read());      // instead of lu -> crud.read()
    }

    // create
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        MyEntity entity = Helpers.entityParse(request);    // receiving entity
        crud.create(entity);
        doGet(request, response);
    }

    // update
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        MyEntity entity = Helpers.entityParse(request);    // receiving entity
        response.setContentType("application/json");
        int id = Integer.parseInt(request.getPathInfo().substring(1));   // passing id
        crud.update(id, entity);      // updating
        doGet(request, response);
    }

    // delete
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        MyEntity entity = Helpers.entityParse(request);    // receiving entity
        response.setContentType("application/json");

        int id = Integer.parseInt(request.getPathInfo().substring(1));
        crud.delete(id);      // deletion
        doGet(request, response);
    }

}

// for lab 4
// implements LabCRUDInterface

package jdbc;

import Entity.MyEntity;
import Servlets.LabCRUDInterface;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlCrud implements LabCRUDInterface<MyEntity>
{

    Connection connection;   // for sql to work

    public SqlCrud(){    // we'll pass here our connection to database (while CRUD initialisation)
        this.connection = new Connect().getConn();    // init + connect the Connection
    }

    public Connection getConnection()     // getter for connection
    {
        return connection;
    }

    public void setConnection(Connection connection)    // setter for connection
    {
        this.connection = connection;
    }


    // four main methods written using JDBC

    // (for main task, only read method needs to be done using JDBC)
    @Override
    public List<MyEntity> read() {          // to read all entities from database

        List<MyEntity> list = new ArrayList<>();     // list initialisation

        try(Statement st = connection.createStatement();   //
            ResultSet rs = st.executeQuery("SELECT * from entity;")   // getting result in here
            )
        {
            // now we need to put info from rs to our list, for that we need to go through all rs, while creating new entities and writing info there
            while(rs.next()) {
                list.add(new MyEntity(rs.getInt(1), rs.getString(2), rs.getInt(3)));
            }
        }  catch (SQLException e){
                e.printStackTrace();
            }
        return list;
    }

    @Override
    public void create(MyEntity t) {        // for entity creation and putting into database
        try(PreparedStatement st =
                connection.prepareStatement("INSERT into entity (name,weight) "
                                + "VALUES (?,?)")) {
            st.setString(1, t.getName());     // this is first parameter and = "?" in VALUES
            st.setInt(2, t.getWeight());      // getting second parameter
            st.executeUpdate();                           // updating
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id, MyEntity t) {    // to update entity in database
        try(PreparedStatement st =
                    connection.prepareStatement("UPDATE entity "
                            + "SET \"name\"=?, \"weight\"=? WHERE id=?;")) {
            st.setString(1, t.getName());     // this is first parameter and = "?" in VALUES
            st.setInt(2, t.getWeight());      // getting second parameter
            st.setInt(3, t.getId());          // getting third parameter
            st.executeUpdate();                           // updating
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {      // for deleting exact entity
        try(PreparedStatement st =
                    connection.prepareStatement("DELETE from entity WHERE id=?;")) {
            st.setInt(1, id);     // setting id
            st.executeUpdate();               // updating
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

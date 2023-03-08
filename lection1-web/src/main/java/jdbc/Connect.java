package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


// for lab 4

public class Connect
{
    private String url = "jdbc:postgresql://localhost:5432/dp1?user=user1&password=111&ssl=false";
    private Connection conn;

    public Connect(){
        try{
            this.conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public Connection getConn()
    {
        return conn;
    }

    public void setConn(Connection conn)
    {
        this.conn = conn;
    }

    public void closeCon() {         // to close connection
        try{
            this.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

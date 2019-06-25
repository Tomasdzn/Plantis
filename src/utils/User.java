package utils;
import javax.xml.transform.Result;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class User {
    private Integer idUser;
    private String name;
    private String email;
    private String password;

    public User(Integer idu, String n, String e, String p){
        this.email = e;
        this.name = n;
        this.password = p;
        this.idUser = idu;
    }

    public void insert(String n, String e, String p) {

        try
        {
            Conexion conn = new Conexion();
            // create a mysql database connection
            Connection cn = conn.getConn();

            // the mysql insert statement
            String query = "INSERT INTO User(name, email, password) VALUES(?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = cn.prepareStatement(query);
            preparedStmt.setString (1, n);
            preparedStmt.setString (2, e);
            preparedStmt.setString   (3, p);

            // execute the preparedstatement
            preparedStmt.execute();

            cn.close();
        }
        catch (Exception ex)
        {
            System.err.println("Got an exception!");
            System.err.println(ex.getMessage());
        }
    }

    public Integer getIdUser() {
        return idUser;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}

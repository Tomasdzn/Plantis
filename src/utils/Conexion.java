package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private static Connection conn;
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String user = "root";
    private static final String password = "";
    private static final String url = "jdbc:mysql://localhost:3306/plantis";

    public Conexion() {
        conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                System.out.println("Conexión establecida...");

            }
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    public Connection getConn() {
        return conn;
    }

    public void desconectar() {
        conn = null;
        if (conn == null) {
            System.out.println("Conexion terminada...");
        }
    }
}
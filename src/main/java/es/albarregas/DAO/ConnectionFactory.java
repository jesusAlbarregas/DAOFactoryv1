package es.albarregas.DAO;

import java.sql.Connection;

import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionFactory {

    static DataSource ds = null;
    static Connection conexion = null;
    static final String DATASOURCE_NAME_MYSQL = "java:comp/env/jdbc/FactMy";
    static final String DATASOURCE_NAME_DERBY = "java:comp/env/jdbc/FactDe";
    
    public static Connection getConnectionMySQL() {
        try {
            Context contextoInicial = new InitialContext();
            ds = (DataSource)contextoInicial.lookup(DATASOURCE_NAME_MYSQL);
            conexion = ds.getConnection();
        } catch (NamingException | SQLException e) {
            System.out.println("Error en la conexión contra MySQL");
            e.printStackTrace();
        }
        
        return conexion;
    }
    
    public static Connection getConnectionDerby(){
        try {
            Context contextoInicial = new InitialContext();
            ds = (DataSource)contextoInicial.lookup(DATASOURCE_NAME_DERBY);
            conexion = ds.getConnection();
        } catch (NamingException | SQLException e) {
            System.out.println("Error en la conexión contra Derby");
            e.printStackTrace();
        }
        
        return conexion;
    }
    
    public static void closeConnection(){
        try {
            conexion.close();
        } catch(SQLException e){
            System.out.println("Error al cerrar la conexión a la BD");
            e.printStackTrace();
        }
    }
    
}

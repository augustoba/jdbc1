
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Dao {

    protected Connection conexion;
    protected Statement sentencia;
    protected ResultSet resultado;

    protected String nombreBaseDatos = "tienda";
    protected String usuario = "root";
    protected String contrasenia = "root";
    protected String ipServidor = "localhost";
    protected String puerto = "3306";

    public void conectarDb() {
        try {
            String url = "jdbc:mysql://" + ipServidor + ":" + puerto + "/" + nombreBaseDatos + "?useSSL=false";
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, contrasenia);
        } catch (ClassNotFoundException ex) {

            System.out.println("no se encontro el driver: " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("no se pudo realizar la conexion con la DB : " + ex.getMessage());
            ex.printStackTrace();
        }

    }

    public void desconectarDb() {
        if (resultado != null) {
            try {
                resultado.close();

                if (sentencia != null) {
                    sentencia.close();
                }

                if (conexion != null) {
                    resultado.close();
                }

            } catch (SQLException ex) {
                System.out.println("error al desconectar la DB");;
            }
        }

    }

    public void insertarActualizarEliminar(String query) {
        conectarDb();
        try {
            sentencia = conexion.createStatement();
            sentencia.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println("ocurrio un error al crear la sentencia o al ejecutar la query: " + ex.getMessage());
            ex.printStackTrace();

        } finally {
            desconectarDb();
        }

    }
    
    public void consultarDb (String query){
        conectarDb();
        
        try {
            sentencia = conexion.createStatement();
            resultado= sentencia.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("ocurrio un error al crear la sentencia o ejecutar la consulta: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    
    private static Connection conexion;
    
    private Conexion(){
        conexion = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            try {
                conexion = DriverManager.getConnection("jdbc:mysql://192.168.1.7:3306/sustantiva", "root", "");                
            } catch (SQLException e) {
                System.out.println("HAY PROBLEMAS CON LA CONEXIÓN A MYSQL. REVISE SI MYSQL ESTÁ INICIADO Y ESCUCHANDO EN EL PUERTO 3306");
                e.printStackTrace();
            }
        }catch(ClassNotFoundException e){
            System.out.println("REVISE EL DRIVER");
            e.printStackTrace();
        }
    }
    
    public static Connection getConexion(){
        if(conexion == null){
            new Conexion();
        }
        return conexion;
    }
}

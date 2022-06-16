
package datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Facilitador;


public class FacilitadorDAO {
    private Facilitador facilitador;
    private List<Facilitador> Facilitadores;
    public String nombreDeExcepcionSQL = "";
    private int resultadoOperacion;
    private String sql;

    public void cargarFacilitador(int id){
        setSql("SELECT * FROM FACILITADOR WHERE id =" + id);
        try {
            Statement declaracion = Conexion.getConexion().createStatement();
            ResultSet Resultados = declaracion.executeQuery(this.getSql());
            while(Resultados.next()){
                setFacilitador(new Facilitador(Resultados.getInt("id"),Resultados.getString("rut"),Resultados.getString("nombre"),
                        Resultados.getString("email"), Resultados.getString("telefono"), Double.parseDouble(Resultados.getString("valorhora")), 
                        Resultados.getString("banco"), Resultados.getString("ctabancaria"),Resultados.getString("last_update")));
            } 
        } catch (SQLException e) {
            System.out.println("REVISA BIEN LA CONSULTA");    
            e.printStackTrace();
        }
    }    
    public void cargarFacilitadores(){
        setSql("SELECT * FROM FACILITADOR");
        try {
            Statement declaracion = Conexion.getConexion().createStatement();
            ResultSet Resultados = declaracion.executeQuery(this.getSql());
            while(Resultados.next()){
                getFacilitadores().add(new Facilitador(Resultados.getInt("id"),Resultados.getString("rut"),Resultados.getString("nombre"),
                        Resultados.getString("email"), Resultados.getString("telefono"), Double.parseDouble(Resultados.getString("valorhora")), 
                        Resultados.getString("banco"), Resultados.getString("ctabancaria"),Resultados.getString("last_update")));
            } 
        } catch (SQLException e) {
            System.out.println("REVISA BIEN LA CONSULTA");    
            e.printStackTrace();
        }
    }    
    public int eliminarFacilitador(int id){
        setSql("DELETE FROM FACILITADOR WHERE id =" + id);
        try {
            Statement declaracion = Conexion.getConexion().createStatement();
            setResultadoOperacion(declaracion.executeUpdate(this.getSql()));
            nombreDeExcepcionSQL = "";
        } catch (SQLException e) {
            System.out.println("REVISA BIEN LA CONSULTA"); 
            nombreDeExcepcionSQL = e.getClass().getSimpleName();
            e.printStackTrace();
        }
        return getResultadoOperacion();
    }
    public int insertarFacilitador(Facilitador facilitador){
        setSql("INSERT INTO FACILITADOR (rut, nombre, email, telefono, valorhora, banco, ctabancaria, last_update)"
                + "VALUES('" + facilitador.getRut() + "','" + facilitador.getNombre() + "','" + facilitador.getEmail() + "',"
                        + "'" + facilitador.getTelefono() + "', '" + facilitador.getValorHora()+ "', '" + facilitador.getBanco()+ "',"
                        + "'" + facilitador.getCtaBancaria()+ "','" + facilitador.getLastUpdate() + "')");
        try {
            Statement declaracion = Conexion.getConexion().createStatement();
            setResultadoOperacion(declaracion.executeUpdate(this.getSql()));
        } catch (SQLException e) {
            System.out.println("REVISA BIEN LA CONSULTA");    
            e.printStackTrace();
        }
        return getResultadoOperacion();
    }
    public int modificarFacilitador(Facilitador facilitador){
        setSql("UPDATE FACILITADOR SET rut= '" + facilitador.getRut() + "', nombre= '" + facilitador.getNombre() + "',"
                + " email= '" + facilitador.getEmail() + "', telefono= '" + facilitador.getTelefono() + "', valorhora= '" + facilitador.getValorHora() + "',"
                + " banco='" + facilitador.getBanco() + "', ctabancaria='" + facilitador.getCtaBancaria() + "', last_update='" + facilitador.getLastUpdate() + "' "
                        + "WHERE id =" + facilitador.getId());
        int resultadoOperacionUpdate = 0;
        try {
            Statement declaracion = Conexion.getConexion().createStatement();
            resultadoOperacionUpdate = declaracion.executeUpdate(this.getSql()); 
        } catch (SQLException e) {
            System.out.println("REVISA BIEN LA CONSULTA");    
            e.printStackTrace();
        }
        return resultadoOperacionUpdate;
    } 
    
    public List<Facilitador> getFacilitadores() {
        return Facilitadores;
    }
    public FacilitadorDAO(){
        this.Facilitadores = new ArrayList<Facilitador>();
    }
    public Facilitador getFacilitador() {
        return facilitador;
    }
    public void setFacilitador(Facilitador facilitador) {
        this.facilitador = facilitador;
    }
    public void setFacilitadores(List<Facilitador> Facilitadores) {
        this.Facilitadores = Facilitadores;
    }
    public int getResultadoOperacion() {
        return resultadoOperacion;
    }
    public void setResultadoOperacion(int resultadoOperacion) {
        this.resultadoOperacion = resultadoOperacion;
    }
    public String getSql() {
        return sql;
    }
    public void setSql(String sql) {
        this.sql = sql;
    }
}


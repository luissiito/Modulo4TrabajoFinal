
package datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Estudiante;


public class EstudianteDAO {
    private Estudiante estudiante;
    private List<Estudiante> Estudiantes;
    public String nombreDeExcepcionSQL = "";
    private int resultadoOperacion;
    private String sql;
    
    public void cargarEstudiante(int id){
        setSql("SELECT * FROM ESTUDIANTE WHERE id =" + id);
        try {
            Statement declaracion = Conexion.getConexion().createStatement();
            ResultSet Resultados = declaracion.executeQuery(this.getSql());
            while(Resultados.next()){
                setEstudiante(new Estudiante(Resultados.getInt("id"),Resultados.getString("rut"),Resultados.getString("nombre"),
                        Resultados.getString("email"), Resultados.getString("telefono"), Resultados.getString("last_update")));
            } 
        } catch (SQLException e) {
            System.out.println("REVISA BIEN LA CONSULTA");    
            e.printStackTrace();
        }
    }
    public void cargarEstudiantes(){
        setSql("SELECT * FROM ESTUDIANTE");
        try {
            Statement declaracion = Conexion.getConexion().createStatement();
            ResultSet Resultados = declaracion.executeQuery(this.getSql());
            while(Resultados.next()){
                getEstudiantes().add(new Estudiante(Resultados.getInt("id"),Resultados.getString("rut"),Resultados.getString("nombre"),
                        Resultados.getString("email"), Resultados.getString("telefono"), Resultados.getString("last_update")));
            } 
        } catch (SQLException e) {
            System.out.println("REVISA BIEN LA CONSULTA");    
            e.printStackTrace();
        }
    }
    public int eliminarEstudiante(int id){
        setSql("DELETE FROM ESTUDIANTE WHERE id =" + id);
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
    public int insertarEstudiante(Estudiante estudiante){
        setSql("INSERT INTO ESTUDIANTE (rut, nombre, email, telefono, last_update)"
                + "VALUES('" + estudiante.getRut() + "','" + estudiante.getNombre() + "','" + estudiante.getEmail() + "',"
                        + "'" + estudiante.getTelefono() + "','" + estudiante.getLastUpdate() + "')");
        try {
            Statement declaracion = Conexion.getConexion().createStatement();
            setResultadoOperacion(declaracion.executeUpdate(this.getSql()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return getResultadoOperacion();
    }
    public int modificarEstudiante(Estudiante estudiante){
        setSql("UPDATE ESTUDIANTE SET rut= '" + estudiante.getRut() + "', nombre= '" + estudiante.getNombre() + "',"
                + " email= '" + estudiante.getEmail() + "', telefono= '" + estudiante.getTelefono() + "', last_update= '" + estudiante.getLastUpdate() + "' "
                        + "WHERE id =" + estudiante.getId());
        try {
            Statement declaracion = Conexion.getConexion().createStatement();
            setResultadoOperacion(declaracion.executeUpdate(this.getSql())); 
        } catch (SQLException e) {
            System.out.println("REVISA BIEN LA CONSULTA");    
            e.printStackTrace();
        }
        return getResultadoOperacion();
    }

    public EstudianteDAO(){
        this.Estudiantes = new ArrayList<Estudiante>();
    }
    public Estudiante getEstudiante(){
        return this.estudiante;
    }
    public void setEstudiante(Estudiante nuevoEstudiante){
        this.estudiante = nuevoEstudiante;
    }
    public List<Estudiante> getEstudiantes() {
        return Estudiantes;
    }
    public void setEstudiantes(List<Estudiante> NuevosEstudiantes) {
        this.Estudiantes = NuevosEstudiantes;
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
    public void setSql(String nuevoSql) {
        this.sql = nuevoSql;
    }
}

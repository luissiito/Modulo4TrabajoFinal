package datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Curso;


public class CursoDAO {
    private Curso curso;
    private List<Curso> Cursos;
    public String mensajeDeExcepcionSQL = "";
    public String nombreDeExcepcionSQL = "";
    private int resultadoOperacion;
    private String sql;

    public void cargarCurso(int id){
        setSql("SELECT * FROM CURSO WHERE id =" + id);
        try {
            Statement declaracion = Conexion.getConexion().createStatement();
            ResultSet Resultados = declaracion.executeQuery(this.getSql());
            while(Resultados.next()){
                setCurso(new Curso(Resultados.getInt("id"),Resultados.getString("codigo"),Resultados.getString("nombre"),
                        Resultados.getInt("id_facilitador"), Resultados.getString("last_update")));
            } 
        } catch (SQLException e) {
            System.out.println("REVISA BIEN LA CONSULTA");    
            e.printStackTrace();
        }
    }
    public void cargarCursos(){
        setSql("SELECT * FROM CURSO");
        try {
            Statement declaracion = Conexion.getConexion().createStatement();
            ResultSet Resultados = declaracion.executeQuery(this.getSql());
            while(Resultados.next()){
                getCursos().add(new Curso(Resultados.getInt("id"),Resultados.getString("codigo"),Resultados.getString("nombre"),
                        Resultados.getInt("id_facilitador"), Resultados.getString("last_update")));
            } 
        } catch (SQLException e) {
            System.out.println("REVISA BIEN LA CONSULTA");    
            e.printStackTrace();
        }
    }
    public int eliminarCurso(int id){
        setSql("DELETE FROM CURSO WHERE id =" + id);
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
    public int insertarCurso(Curso curso){
        setSql("INSERT INTO CURSO (codigo, nombre, id_facilitador, last_update)"
                + "VALUES('" + curso.getCodigo() + "','" + curso.getNombre() + "','" + curso.getIdFacilitador() + "',"
                        + "'" + curso.getLastUpdate() + "')");
        try {
            Statement declaracion = Conexion.getConexion().createStatement();
            setResultadoOperacion(declaracion.executeUpdate(this.getSql()));
            mensajeDeExcepcionSQL = "";
        } catch (SQLException e) {
            e.printStackTrace();
            mensajeDeExcepcionSQL = e.getMessage();
        }
        return getResultadoOperacion();
    }
    public int modificarCurso(Curso curso){
        setSql("UPDATE CURSO SET codigo= '" + curso.getCodigo() + "', nombre= '" + curso.getNombre() + "',"
                + " id_facilitador= '" + curso.getIdFacilitador() + "', last_update= '" +  curso.getLastUpdate() + "' "
                        + "WHERE id =" + curso.getId());
        try {
            Statement declaracion = Conexion.getConexion().createStatement();
            setResultadoOperacion(declaracion.executeUpdate(this.getSql())); 
        } catch (SQLException e) {
            System.out.println("REVISA BIEN LA CONSULTA");    
            e.printStackTrace();
        }
        return getResultadoOperacion();
    }
    
    public List<Curso> getCursos() {
        return Cursos;
    }
    public CursoDAO(){
        this.Cursos = new ArrayList<Curso>();
    }

    public Curso getCurso() {
        return curso;
    }
    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    public void setCursos(List<Curso> Cursos) {
        this.Cursos = Cursos;
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
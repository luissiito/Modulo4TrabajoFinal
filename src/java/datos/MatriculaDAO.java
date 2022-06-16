package datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Matricula;

public class MatriculaDAO {
    private Matricula matricula;
    private List<Matricula> Matriculas;
    public String mensajeDeExcepcionSQL = "";
    public String nombreDeExcepcionSQL = "";
    private int resultadoOperacion;
    private String sql;

    public void cargarMatricula(int idEstudiante){
        setSql("SELECT * FROM MATRICULA WHERE id_Estudiante =" + idEstudiante);
        try {
            Statement declaracion = Conexion.getConexion().createStatement();
            ResultSet Resultados = declaracion.executeQuery(this.getSql());
            while(Resultados.next()){
                setMatricula(new Matricula(Resultados.getInt("id_estudiante"),Resultados.getInt("id_curso"),Resultados.getString("fecha"),
                        Resultados.getString("last_update")));
            } 
        } catch (SQLException e) {
            System.out.println("REVISA BIEN LA CONSULTA");    
            e.printStackTrace();
        }
    }
    public void cargarMatriculas(){
        setSql("SELECT * FROM MATRICULA");
        try {
            Statement declaracion = Conexion.getConexion().createStatement();
            ResultSet Resultados = declaracion.executeQuery(this.getSql());
            while(Resultados.next()){
                getMatriculas().add(new Matricula(Resultados.getInt("id_estudiante"),Resultados.getInt("id_curso"),Resultados.getString("fecha"),
                        Resultados.getString("last_update")));
            } 
        } catch (SQLException e) {
            System.out.println("REVISA BIEN LA CONSULTA");    
            e.printStackTrace();
        }
    } 
    public int eliminarMatricula(int idEstudiante, int idCurso){
        setSql("DELETE FROM MATRICULA WHERE id_estudiante =" + idEstudiante + " and id_curso=" + idCurso);
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
    public int insertarMatricula(Matricula matricula){
        setSql("INSERT INTO MATRICULA (id_estudiante, id_curso, fecha, last_update)"
                + "VALUES("+ matricula.getIdEstudiante() +"," + matricula.getIdCurso()+ ",'" + matricula.getFecha()+ "', '" + matricula.getLastUpdate()+ "')");
        try {
            Statement declaracion = Conexion.getConexion().createStatement();
            setResultadoOperacion(declaracion.executeUpdate(this.getSql()));
            mensajeDeExcepcionSQL = "";
        } catch (SQLException e) {
            System.out.println("REVISA BIEN LA CONSULTA"); 
            mensajeDeExcepcionSQL = e.getMessage();
            System.out.println(mensajeDeExcepcionSQL);
            e.printStackTrace();
        }
        return getResultadoOperacion();
    }
    public int modificarMatricula(Matricula matricula){
        setSql("UPDATE MATRICULA SET id_estudiante= '" + matricula.getIdEstudiante() + "', id_curso= '" + matricula.getIdCurso() + "',"
                + " fecha= '" + matricula.getFecha() + "', last_update= '" +  matricula.getLastUpdate() + "' "
                        + "WHERE id_estudiante =" + matricula.getIdEstudiante());
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
    
    public MatriculaDAO(){
        this.Matriculas = new ArrayList<Matricula>();
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }
    public List<Matricula> getMatriculas() {
        return Matriculas;
    }
    public void setMatriculas(List<Matricula> Matriculas) {
        this.Matriculas = Matriculas;
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

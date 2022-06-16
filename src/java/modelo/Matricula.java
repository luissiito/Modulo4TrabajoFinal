
package modelo;

public class Matricula {
    private int idEstudiante;
    private int idCurso;
    private String fecha;
    private String lastUpdate;

    public Matricula(int idEstudiante, int idCurso, String fecha, String lastUpdate) {
        this.idEstudiante = idEstudiante;
        this.idCurso = idCurso;
        this.fecha = fecha;
        this.lastUpdate = lastUpdate;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
    
}

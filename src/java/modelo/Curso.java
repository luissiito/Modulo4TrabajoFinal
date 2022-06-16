package modelo;

public class Curso {
    private int id;
    private String codigo;
    private String nombre;
    private int idFacilitador;
    private String lastUpdate;

    public Curso(int id, String codigo, String nombre, int idFacilitador, String lastUpdate) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.idFacilitador = idFacilitador;
        this.lastUpdate = lastUpdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdFacilitador() {
        return idFacilitador;
    }

    public void setIdFacilitador(int idFacilitador) {
        this.idFacilitador = idFacilitador;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
    
}

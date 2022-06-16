package controlador;

import datos.MatriculaDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Matricula;

public class ControladorMatricula extends HttpServlet {
    private MatriculaDAO matriculaDAO;
    private String operacion;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {                
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        setOperacion((String)request.getParameter("operacion"));
        String id = (String)request.getParameter("id");
        setMatriculaDAO(new MatriculaDAO());
        if(this.getOperacion() != null){
            if(this.getOperacion().equalsIgnoreCase("presentarInformacion")){
                getMatriculaDAO().cargarMatricula(Integer.parseInt(id));
                request.setAttribute("matricula", getMatriculaDAO().getMatricula());                
                request.getRequestDispatcher("Vistas/JSPs/Matriculas/Matricula.jsp").forward(request, response);                
            }
        }else{  
            getMatriculaDAO().setMatriculas(new ArrayList<Matricula>());
            getMatriculaDAO().cargarMatriculas();
            request.setAttribute("Matriculas", getMatriculaDAO().getMatriculas());
            request.getRequestDispatcher("Vistas/JSPs/Matriculas/Matriculas.jsp").forward(request, response);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        setOperacion((String)request.getParameter("operacion"));
        Matricula matricula;
        if(this.getOperacion().equalsIgnoreCase("actualizar")){          
            matricula = new Matricula(Integer.parseInt(request.getParameter("idEstudiante")),Integer.parseInt(request.getParameter("idCurso")),
                    (String)request.getParameter("fecha"),(String)request.getParameter("lastUpdate"));
            request.setAttribute("resultadoOperacionUpdate", getMatriculaDAO().modificarMatricula(matricula));            
            getMatriculaDAO().cargarMatricula(matricula.getIdEstudiante());
            request.setAttribute("matricula", this.getMatriculaDAO().getMatricula());  
            request.getRequestDispatcher("Vistas/JSPs/Matriculas/Matricula.jsp").forward(request, response);
        }
        if(this.getOperacion().equalsIgnoreCase("eliminar")){
            request.setAttribute("resultadoOperacionEliminar", getMatriculaDAO().eliminarMatricula(Integer.parseInt(request.getParameter("idEstudiante")), Integer.parseInt(request.getParameter("idCurso"))));  
            request.setAttribute("nombreDeExcepcionSQL", getMatriculaDAO().nombreDeExcepcionSQL);
            getMatriculaDAO().setMatriculas(new ArrayList<Matricula>());
            getMatriculaDAO().cargarMatriculas();
            request.setAttribute("Matriculas", getMatriculaDAO().getMatriculas());   
            request.getRequestDispatcher("Vistas/JSPs/Matriculas/Matriculas.jsp").forward(request, response);  
        }        
        if(this.getOperacion().equalsIgnoreCase("insertar")){  
            matricula = new Matricula(Integer.parseInt(request.getParameter("idEstudiante")),Integer.parseInt(request.getParameter("idCurso")),
                    (String)request.getParameter("fecha"),(String)request.getParameter("lastUpdate"));
            request.setAttribute("resultadoOperacionInsertar", getMatriculaDAO().insertarMatricula(matricula));
            request.setAttribute("mensajeDeExcepcionSQL", getMatriculaDAO().mensajeDeExcepcionSQL);
            getMatriculaDAO().setMatriculas(new ArrayList<Matricula>());
            getMatriculaDAO().cargarMatriculas();
            request.setAttribute("Matriculas", getMatriculaDAO().getMatriculas());
            request.getRequestDispatcher("Vistas/JSPs/Matriculas/Matriculas.jsp").forward(request, response);
        } 
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }
    public MatriculaDAO getMatriculaDAO() {
        return matriculaDAO;
    }

    public void setMatriculaDAO(MatriculaDAO matriculaDAO) {
        this.matriculaDAO = matriculaDAO;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

}

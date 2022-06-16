package controlador;

import datos.EstudianteDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Estudiante;

public class ControladorEstudiante extends HttpServlet {
    private EstudianteDAO estudianteDAO;
    private String operacion;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");        
//        try ( PrintWriter out = response.getWriter()) {}
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        setOperacion((String)request.getParameter("operacion"));
        String id = (String)request.getParameter("id");
        setEstudianteDAO(new EstudianteDAO());
        if(this.getOperacion() != null){
            if(this.getOperacion().equalsIgnoreCase("presentarInformacion")){
                getEstudianteDAO().cargarEstudiante(Integer.parseInt(id));
                request.setAttribute("estudiante", this.getEstudianteDAO().getEstudiante());                
                request.getRequestDispatcher("Vistas/JSPs/Estudiantes/Estudiante.jsp").forward(request, response);                
            }
        }else{   
            getEstudianteDAO().setEstudiantes(new ArrayList<Estudiante>());
            getEstudianteDAO().cargarEstudiantes();
            request.setAttribute("Estudiantes", getEstudianteDAO().getEstudiantes());
            request.getRequestDispatcher("Vistas/JSPs/Estudiantes/Estudiantes.jsp").forward(request, response);
        }        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        setOperacion((String)request.getParameter("operacion"));
        Estudiante estudiante;
        if(this.getOperacion().equalsIgnoreCase("actualizar")){         
            estudiante = new Estudiante(Integer.parseInt(request.getParameter("id")),(String)request.getParameter("rut"),
                    (String)request.getParameter("nombre"), (String)request.getParameter("email"),
                    (String)request.getParameter("telefono"), (String)request.getParameter("lastUpdate"));
            request.setAttribute("resultadoOperacionUpdate", getEstudianteDAO().modificarEstudiante(estudiante));            
            getEstudianteDAO().cargarEstudiante(estudiante.getId());
            request.setAttribute("estudiante", getEstudianteDAO().getEstudiante());  
            request.getRequestDispatcher("Vistas/JSPs/Estudiantes/Estudiante.jsp").forward(request, response);
        }
        if(this.getOperacion().equalsIgnoreCase("eliminar")){
            request.setAttribute("resultadoOperacionEliminar", getEstudianteDAO().eliminarEstudiante(Integer.parseInt(request.getParameter("id")))); 
            request.setAttribute("nombreDeExcepcionSQL", getEstudianteDAO().nombreDeExcepcionSQL);  
            getEstudianteDAO().setEstudiantes(new ArrayList<Estudiante>());
            getEstudianteDAO().cargarEstudiantes();
            request.setAttribute("Estudiantes", getEstudianteDAO().getEstudiantes());   
            request.getRequestDispatcher("Vistas/JSPs/Estudiantes/Estudiantes.jsp").forward(request, response);  
        }       
        if(this.getOperacion().equalsIgnoreCase("insertar")){  
            estudiante = new Estudiante(000, (String)request.getParameter("rut"),
                    (String)request.getParameter("nombre"), (String)request.getParameter("email"),
                    (String)request.getParameter("telefono"), (String)request.getParameter("lastUpdate"));
            request.setAttribute("resultadoOperacionInsertar", getEstudianteDAO().insertarEstudiante(estudiante));
            getEstudianteDAO().setEstudiantes(new ArrayList<Estudiante>());
            getEstudianteDAO().cargarEstudiantes();
            request.setAttribute("Estudiantes", getEstudianteDAO().getEstudiantes());
            request.getRequestDispatcher("Vistas/JSPs/Estudiantes/Estudiantes.jsp").forward(request, response);
        } 
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
    public EstudianteDAO getEstudianteDAO() {
        return estudianteDAO;
    }
    public void setEstudianteDAO(EstudianteDAO estudianteDAO) {
        this.estudianteDAO = estudianteDAO;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

}

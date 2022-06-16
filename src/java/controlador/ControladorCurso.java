package controlador;

import datos.CursoDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Curso;

public class ControladorCurso extends HttpServlet {
    private CursoDAO cursoDAO;
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
        setCursoDAO(new CursoDAO());
        if(this.getOperacion() != null){
            if(this.getOperacion().equalsIgnoreCase("presentarInformacion")){
                getCursoDAO().cargarCurso(Integer.parseInt(id));
                request.setAttribute("curso", this.getCursoDAO().getCurso());                
                request.getRequestDispatcher("Vistas/JSPs/Cursos/Curso.jsp").forward(request, response);  
            }
        }else{   
            getCursoDAO().setCursos(new ArrayList<Curso>());
            getCursoDAO().cargarCursos();
            request.setAttribute("Cursos", getCursoDAO().getCursos());
            request.getRequestDispatcher("Vistas/JSPs/Cursos/Cursos.jsp").forward(request, response);
        } 
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        setOperacion((String)request.getParameter("operacion"));
        Curso curso; 
        if(this.getOperacion().equalsIgnoreCase("actualizar")){     
            curso = new Curso(Integer.parseInt(request.getParameter("id")),(String)request.getParameter("codigo"),
                    (String)request.getParameter("nombre"), Integer.parseInt(request.getParameter("idFacilitador")),(String)request.getParameter("lastUpdate"));
            request.setAttribute("resultadoOperacionUpdate", getCursoDAO().modificarCurso(curso));            
            getCursoDAO().cargarCurso(curso.getId());
            request.setAttribute("curso", getCursoDAO().getCurso());  
            request.getRequestDispatcher("Vistas/JSPs/Cursos/Curso.jsp").forward(request, response);
        }
        if(this.getOperacion().equalsIgnoreCase("eliminar")){
            request.setAttribute("resultadoOperacionEliminar", getCursoDAO().eliminarCurso(Integer.parseInt(request.getParameter("id"))));  
            request.setAttribute("nombreDeExcepcionSQL", getCursoDAO().nombreDeExcepcionSQL);
            getCursoDAO().setCursos(new ArrayList<Curso>());
            getCursoDAO().cargarCursos();
            request.setAttribute("Cursos", getCursoDAO().getCursos());   
            request.getRequestDispatcher("Vistas/JSPs/Cursos/Cursos.jsp").forward(request, response);  
        }
        if(this.getOperacion().equalsIgnoreCase("insertar")){  
            curso = new Curso(000,(String)request.getParameter("codigo"),
                    (String)request.getParameter("nombre"), Integer.parseInt(request.getParameter("idFacilitador")),(String)request.getParameter("lastUpdate"));
            request.setAttribute("resultadoOperacionInsertar", getCursoDAO().insertarCurso(curso));
            request.setAttribute("mensajeDeExcepcionSQL", getCursoDAO().mensajeDeExcepcionSQL);
            getCursoDAO().setCursos(new ArrayList<Curso>());
            getCursoDAO().cargarCursos();
            request.setAttribute("Cursos", getCursoDAO().getCursos());
            request.getRequestDispatcher("Vistas/JSPs/Cursos/Cursos.jsp").forward(request, response);
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }

    public CursoDAO getCursoDAO() {
        return cursoDAO;
    }

    public void setCursoDAO(CursoDAO cursoDAO) {
        this.cursoDAO = cursoDAO;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }
}

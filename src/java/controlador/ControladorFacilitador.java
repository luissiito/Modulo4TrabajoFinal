
package controlador;

import datos.FacilitadorDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Facilitador;

public class ControladorFacilitador extends HttpServlet {
    private FacilitadorDAO facilitadorDAO;
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
        setFacilitadorDAO(new FacilitadorDAO());
        if(this.getOperacion() != null){
            if(this.getOperacion().equalsIgnoreCase("presentarInformacion")){
                getFacilitadorDAO().cargarFacilitador(Integer.parseInt(id));
                request.setAttribute("facilitador", this.getFacilitadorDAO().getFacilitador());                
                request.getRequestDispatcher("Vistas/JSPs/Facilitadores/Facilitador.jsp").forward(request, response);                
            }
        }else{     
            getFacilitadorDAO().setFacilitadores(new ArrayList<Facilitador>());
            getFacilitadorDAO().cargarFacilitadores();
            request.setAttribute("Facilitadores", getFacilitadorDAO().getFacilitadores());
            request.getRequestDispatcher("Vistas/JSPs/Facilitadores/Facilitadores.jsp").forward(request, response);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        setOperacion((String)request.getParameter("operacion"));
        Facilitador facilitador;
        if(this.getOperacion().equalsIgnoreCase("actualizar")){        
            facilitador = new Facilitador(Integer.parseInt(request.getParameter("id")),(String)request.getParameter("rut"),(String)request.getParameter("nombre"),
                    (String)request.getParameter("email"), (String)request.getParameter("telefono"),
                    Double.parseDouble(request.getParameter("valorHora")),(String)request.getParameter("banco"), (String)request.getParameter("ctaBancaria"),
                    (String)request.getParameter("lastUpdate"));
            request.setAttribute("resultadoOperacionUpdate", getFacilitadorDAO().modificarFacilitador(facilitador));            
            getFacilitadorDAO().cargarFacilitador(facilitador.getId());
            request.setAttribute("facilitador", getFacilitadorDAO().getFacilitador());  
            request.getRequestDispatcher("Vistas/JSPs/Facilitadores/Facilitador.jsp").forward(request, response);
        }
        if(this.getOperacion().equalsIgnoreCase("eliminar")){
            request.setAttribute("resultadoOperacionEliminar", getFacilitadorDAO().eliminarFacilitador(Integer.parseInt(request.getParameter("id"))));  
            request.setAttribute("nombreDeExcepcionSQL", getFacilitadorDAO().nombreDeExcepcionSQL);
            getFacilitadorDAO().setFacilitadores(new ArrayList<Facilitador>());
            getFacilitadorDAO().cargarFacilitadores();
            request.setAttribute("Facilitadores", getFacilitadorDAO().getFacilitadores());   
            request.getRequestDispatcher("Vistas/JSPs/Facilitadores/Facilitadores.jsp").forward(request, response);  
        } 
        if(this.getOperacion().equalsIgnoreCase("insertar")){  
            facilitador = new Facilitador(000,(String)request.getParameter("rut"),(String)request.getParameter("nombre"),
                    (String)request.getParameter("email"), (String)request.getParameter("telefono"),
                    Double.parseDouble(request.getParameter("valorHora")),(String)request.getParameter("banco"), (String)request.getParameter("ctaBancaria"),
                    (String)request.getParameter("lastUpdate"));
            request.setAttribute("resultadoOperacionInsertar", getFacilitadorDAO().insertarFacilitador(facilitador));  
            getFacilitadorDAO().setFacilitadores(new ArrayList<Facilitador>());
            getFacilitadorDAO().cargarFacilitadores();
            request.setAttribute("Facilitadores", getFacilitadorDAO().getFacilitadores());
            request.getRequestDispatcher("Vistas/JSPs/Facilitadores/Facilitadores.jsp").forward(request, response);
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }

    public FacilitadorDAO getFacilitadorDAO() {
        return facilitadorDAO;
    }

    public void setFacilitadorDAO(FacilitadorDAO facilitadorDAO) {
        this.facilitadorDAO = facilitadorDAO;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }
}

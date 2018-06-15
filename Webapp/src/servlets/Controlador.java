package servlets;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controlador.ControladorFacadeRemote;
import dto.AgenciaDTO;
import dto.PaqueteDTO;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controlador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    final Hashtable jndiProperties = new Hashtable();	    	    
	    jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");	    	    
	    jndiProperties.put("jboss.naming.client.ejb.context", true);    	    
	    Context context;
		
		String action = request.getParameter("action");
    	String jspPage = "index.jsp";
    	
    	switch(action){
    	
	    	case("AltaAgencia"):{
	            String nombre = request.getParameter("nombre");
	            String direccion = request.getParameter("direccion");
	            
				try {
					context = new InitialContext(jndiProperties);
					ControladorFacadeRemote cFacade = (ControladorFacadeRemote) context 		 
		    	            .lookup("ejb:OfertaPaqueteServicio/OfertaPaqueteClient//ControladorFacade!controlador.ControladorFacadeRemote");
					
					AgenciaDTO adto = new AgenciaDTO();
					adto.setNombre(nombre);
					adto.setDireccion(direccion);
					
					cFacade.altaAgencia(adto);
					
					List<AgenciaDTO> ladto= cFacade.recuperarAgencias();
					request.setAttribute("agencias", ladto);
					
				} catch (NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            
	    		jspPage = "agencias.jsp";
	            break;
	    	}
	    	case("ListarAgencias"):{    	    
				try {
					context = new InitialContext(jndiProperties);
					ControladorFacadeRemote cFacade = (ControladorFacadeRemote) context 		 
		    	            .lookup("ejb:OfertaPaqueteServicio/OfertaPaqueteClient//ControladorFacade!controlador.ControladorFacadeRemote");
					List<AgenciaDTO> ladto= cFacade.recuperarAgencias();
					request.setAttribute("agencias", ladto);
	
				} catch (NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		jspPage = "agencias.jsp";
	            break;
	    		
	    	}
	    	case("ListarPaquetes"):{    	    
				try {
					context = new InitialContext(jndiProperties);
					ControladorFacadeRemote cFacade = (ControladorFacadeRemote) context 		 
		    	            .lookup("ejb:OfertaPaqueteServicio/OfertaPaqueteClient//ControladorFacade!controlador.ControladorFacadeRemote");
					
					List<PaqueteDTO> lpdto= cFacade.recuperarPaquetes();
					request.setAttribute("paquetes", lpdto);
	
				} catch (NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		jspPage = "paquetes.jsp";
	            break;
	    		
	    	}
    	
    	//FIN SWITCH
    	}
    	
    	dispatch(jspPage, request, response);

	}
	
    protected void dispatch(String jsp, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        if (jsp != null)
        {
            RequestDispatcher rd = request.getRequestDispatcher(jsp);
            rd.forward(request, response);
        }
    }

}

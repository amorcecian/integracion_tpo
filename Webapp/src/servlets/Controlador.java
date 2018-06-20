package servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;

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
import dto.DestinoDTO;
import dto.PaqueteDTO;
import dto.TipoServicioDTO;

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
					
				} catch (Exception e) {
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
	
				} catch (Exception e) {
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
	
				} catch (Exception e) {
					e.printStackTrace();
				}
	    		jspPage = "paquetes.jsp";
	            break;
	    		
	    	}
	    	case("AddPaquete"):{    	    
				try {
					context = new InitialContext(jndiProperties);
					ControladorFacadeRemote cFacade = (ControladorFacadeRemote) context 		 
		    	            .lookup("ejb:OfertaPaqueteServicio/OfertaPaqueteClient//ControladorFacade!controlador.ControladorFacadeRemote");
					
					List<TipoServicioDTO> ltsdto= cFacade.recuperarServicios();
					request.setAttribute("TipoServicios", ltsdto);
					
					List<DestinoDTO> lddto = cFacade.recuperarDestinos();
					request.setAttribute("Destinos", lddto);
	
				} catch (Exception e) {
					e.printStackTrace();
				}
	    		jspPage = "altaPaquete.jsp";
	            break;
	    		
	    	}
	    	case("AltaPaquete"):{
	            String nombre = request.getParameter("nombre");
	            String fechaSalida = request.getParameter("fechaSalida");
	            String fechaRegreso = request.getParameter("fechaRegreso");
	            
	            String cupo = request.getParameter("cupo");
	            String cantPersonas = request.getParameter("cantPersonas");
	            
	            String destino = request.getParameter("destino");
	            String descripcion = request.getParameter("descripcion");
	            
	            String servicios = request.getParameter("servicios");
	            String imagen = request.getParameter("imagen");
	            String precio = request.getParameter("precio");
	            
	            String medioPago = request.getParameter("medioPago");
	            String politicas = request.getParameter("politicas");
	            String estado = request.getParameter("estado");
	            
	            
				try {
					context = new InitialContext(jndiProperties);
					ControladorFacadeRemote cFacade = (ControladorFacadeRemote) context 		 
		    	            .lookup("ejb:OfertaPaqueteServicio/OfertaPaqueteClient//ControladorFacade!controlador.ControladorFacadeRemote");
					
					PaqueteDTO pdto = new PaqueteDTO();
					pdto.setNombre(nombre);
					
					//Buscar Destino en BD					

					DateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");
					Date date1 = (Date) sourceFormat.parse(fechaRegreso);					
					pdto.setFechaIngreso(date1);
					
					Date date2 = (Date) sourceFormat.parse(fechaSalida);
					pdto.setFechaSalida(date2);
					
					pdto.setEstado(estado);
					

					pdto.setCupo(Integer.parseInt(cupo));
					pdto.setCantPersonas(Integer.parseInt(cantPersonas));
					
					//Falta lista de Servicios
					pdto.setPrecioPersona(Double.parseDouble(precio));
					pdto.setDescripcion(descripcion);
					pdto.setFoto(imagen);
					pdto.setPoliticasDeCancelacion(politicas);
					

					System.out.println("Paquete: " + pdto.toString());
					
					cFacade.altaPaquete(pdto);
					
					List<PaqueteDTO> lpdto= cFacade.recuperarPaquetes();
					request.setAttribute("paquetes", lpdto);
					
				} catch (Exception e) {
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

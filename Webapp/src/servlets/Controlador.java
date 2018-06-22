package servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controlador.ControladorFacadeRemote;
import dto.AgenciaDTO;
import dto.DestinoDTO;
import dto.FormasDePagoDTO;
import dto.PaqueteDTO;
import dto.ServicioDTO;
import dto.TipoServicioDTO;

import javax.servlet.http.Part;



/**
 * Servlet implementation class Controlador
 */
@WebServlet("/Controlador")
@MultipartConfig
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
					
					List<AgenciaDTO> ladto= cFacade.recuperarAgencias();
					request.setAttribute("Agencias", ladto);
					
					List<TipoServicioDTO> ltsdto= cFacade.recuperarServicios();
					request.setAttribute("TipoServicios", ltsdto);
					
					List<DestinoDTO> lddto = cFacade.recuperarDestinos();
					request.setAttribute("Destinos", lddto);
					
					List<FormasDePagoDTO> lfpdto = cFacade.recuperarFormasdePago();
					request.setAttribute("FormasdePago", lfpdto);
	
				} catch (Exception e) {
					e.printStackTrace();
				}
	    		jspPage = "altaPaquete.jsp";
	            break;
	    		
	    	}
	    	case("AltaPaquete"):{
				PaqueteDTO pdto = new PaqueteDTO();
	    		
	    		String agencia = request.getParameter("agencia");
	            String nombre = request.getParameter("nombre");
	            String fechaSalida = request.getParameter("fechaSalida");
	            String fechaRegreso = request.getParameter("fechaRegreso");
	            
	            String cupo = request.getParameter("cupo");
	            String cantPersonas = request.getParameter("cantPersonas");
	            
	            String destino = request.getParameter("destino");
	            String descripcion = request.getParameter("descripcion");
	            
  				String[] servicios = (String[]) request.getParameterValues("servicios");
	            
  		 		String imagen = UploadFile(request, response , pdto);
  		 		

	            String precio = request.getParameter("precio");
	            
				String[] medioPago = (String[]) request.getParameterValues("medioPago");
	            String politicas = request.getParameter("politicas");
	            String estado = request.getParameter("estado");
	            

				
	            
	            
				try {
					
					context = new InitialContext(jndiProperties);
					ControladorFacadeRemote cFacade = (ControladorFacadeRemote) context 		 
		    	            .lookup("ejb:OfertaPaqueteServicio/OfertaPaqueteClient//ControladorFacade!controlador.ControladorFacadeRemote");
					
					

					
					AgenciaDTO adto = new AgenciaDTO();
					adto.setId(Integer.valueOf(agencia));
					pdto.setAgencia(adto);					
					
					pdto.setNombre(nombre);
					
					DestinoDTO ddto = new DestinoDTO();
					ddto.setId(Integer.valueOf(destino));
					pdto.setDestino(ddto);
									

					DateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");
					Date date1 = (Date) sourceFormat.parse(fechaRegreso);					
					pdto.setFechaIngreso(date1);
					
					Date date2 = (Date) sourceFormat.parse(fechaSalida);
					pdto.setFechaSalida(date2);
					
					pdto.setEstado(estado);
					

					pdto.setCupo(Integer.parseInt(cupo));
					pdto.setCantPersonas(Integer.parseInt(cantPersonas));
					

					List<ServicioDTO> lsdto = new ArrayList<ServicioDTO>();
					for(String s: servicios){
						ServicioDTO sdto = new ServicioDTO();
						sdto.setId(Integer.valueOf(s));
						lsdto.add(sdto);
					}
					pdto.setServicios(lsdto);
					
					List<FormasDePagoDTO> medios = new ArrayList<FormasDePagoDTO>();
					for(String mp: medioPago){
						FormasDePagoDTO mpdto = new FormasDePagoDTO();
						mpdto.setId(Integer.valueOf(mp));
						medios.add(mpdto);
					}
					pdto.setFormPagos(medios);
					
					pdto.setPrecioPersona(Float.parseFloat(precio));
					pdto.setDescripcion(descripcion);
					

					pdto.setFoto("http://10.1.5.15:8080/Webapp/uploads/" + imagen);
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
	    	case("Inicio"):{    	    
				try {
					context = new InitialContext(jndiProperties);
					ControladorFacadeRemote cFacade = (ControladorFacadeRemote) context 		 
		    	            .lookup("ejb:OfertaPaqueteServicio/OfertaPaqueteClient//ControladorFacade!controlador.ControladorFacadeRemote");
					
					List<PaqueteDTO> lpdto= cFacade.recuperarPaquetes();
					request.setAttribute("paquetes", lpdto);
	
				} catch (Exception e) {
					e.printStackTrace();
				}
	    		jspPage = "index.jsp";
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
    
    
	private String UploadFile(HttpServletRequest request, HttpServletResponse response, PaqueteDTO pdto) throws ServletException, IOException {
	    Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
	    String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.

	    
	    //PC del laburo
	    String path="C:/APHLocal/lucas.campilongo/Desktop/IA/integracion_tpo/Webapp/WebContent/uploads/";
	    //Notebook
	    //String path="C:/Users/VM7/Desktop/TPO IA/integracion_tpo/Webapp/WebContent/uploads/";
	    
	    /*
	    //URL para pegarle desde afuera: http://10.1.5.15:8080/Webapp/uploads/test.jpg 
	    //Config JBOSS:
		<location name="/Webapp/uploads" handler="images-uploads" />
		
		<file name="images-uploads" path="C:/APHLocal/lucas.campilongo/Desktop/IA/integracion_tpo/Webapp/WebContent/uploads" directory-listing="true"/>
	    
	    */
	    File uploads = new File(path); //Carpeta donde se guardan los archivos
	    //uploads.mkdirs(); //Crea los directorios necesarios
	    File file = File.createTempFile("Paquete-", "-"+fileName, uploads); //Evita que hayan dos archivos con el mismo nombre
	
	    
	    try (InputStream input = filePart.getInputStream()){
	        Files.copy(input, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
	        input.close();
	    }
	    
	    int i = file.getName().length();
	    //String a = file.getName().substring(45, i-1);
	    String a = file.getName();
	    
	    String base64ImageString = encoder(file.toString());
	    
	    //System.out.println("Base64: " + base64ImageString);
	    
	    pdto.setFotoBase64(base64ImageString);
	    
	    uploads = null;
	    return a; //Si quiero devolver la url de la imagen
	}
	
	public static String encoder(String imagePath) {
		String base64Image = "";
		File file = new File(imagePath);
		try (FileInputStream imageInFile = new FileInputStream(file)) {
			// Reading a Image file from file system
			byte imageData[] = new byte[(int) file.length()];
			imageInFile.read(imageData);
			base64Image = Base64.getEncoder().encodeToString(imageData);
		} catch (FileNotFoundException e) {
			System.out.println("Image not found" + e);
		} catch (IOException ioe) {
			System.out.println("Exception while reading the Image " + ioe);
		}
		return base64Image;
	}
	
	

}

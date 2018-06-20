package sessions;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.google.gson.Gson;

import dto.AgenciaDTO;
import dto.DestinoDTO;
import dto.PaqueteDTO;
import dto.ServicioDTO;
import entities.Agencia;
import entities.Destino;
import entities.Paquete;
import entities.Servicio;

/**
 * Session Bean implementation class ControladorPaquete
 */
@Stateless
@LocalBean
public class ControladorPaquete implements ControladorPaqueteRemote {
	
	@PersistenceContext(unitName="MyPU")
	   private EntityManager em;
	

    /**
     * Default constructor. 
     */
    public ControladorPaquete() {
        // TODO Auto-generated constructor stub
    }
    
    public void altaPaquete(PaqueteDTO pdto)  {
    	Paquete p = new Paquete();
    	p.setNombre(pdto.getNombre());
    	
    	Destino d = new Destino();
    	d.setId(pdto.getDestino().getId());
    	d.setNombre(pdto.getDestino().getNombre());
    	p.setDestino(d);
    	
    	p.setFechaIngreso(pdto.getFechaIngreso());
    	p.setFechaSalida(pdto.getFechaSalida());
    	
    	p.setEstado(pdto.getEstado());
    	p.setCupo(pdto.getCupo());
    	p.setPrecioPersona(pdto.getPrecioPersona());
    	
    	//Falta la lista de Servicios
    	
    	p.setDescripcion(pdto.getDescripcion());
    	p.setFoto(pdto.getFoto());
    	p.setCantPersonas(pdto.getCantPersonas());
    	p.setPoliticasDeCancelacion(pdto.getPoliticasDeCancelacion());
    	
    	em.persist(p);
		em.flush();
		
		Integer id = p.getId();
		p.setId(id);
		
		pdto.setId(id);
		

		System.out.println("ID PAQUETE INGRESADO: "+id);   		

 		
 		//portalCola.envioPaquete(pdto);

    }
    
    public Paquete recuperarPaquete(int id) {
    	return em.find(Paquete.class, id);    	
    }
    

    
    
    public void actualizarPaquete(Paquete p) {
    	em.merge(p);
    }
    
    @SuppressWarnings("unchecked")
	public List<DestinoDTO> obtenerDestinos(){
    	List<DestinoDTO> lddto = new ArrayList<DestinoDTO>();
    	List<Destino> ld;
    	
		Query q = em.createQuery("SELECT d FROM Destino d ORDER BY d.nombre");
		ld = (List<Destino>) q.getResultList();
		for(Destino d : ld) {
			DestinoDTO ddto = new DestinoDTO();
			ddto.setId(d.getId());
			ddto.setLatitud("-38.0172131");
			ddto.setLongitud("-57.7406177");
			ddto.setNombre(d.getNombre());
			lddto.add(ddto);			
		}
    	
    	return lddto;
    }
    
	@SuppressWarnings("unchecked")
	public List<PaqueteDTO> recuperarPaquetes() {
		List<PaqueteDTO> lstPDTO = new ArrayList<PaqueteDTO>();
		List<Paquete> lstP;
		Query q = em.createQuery("SELECT p FROM Paquete p ");
		lstP = (List<Paquete>) q.getResultList();
		for(Paquete p: lstP) {
			PaqueteDTO pdto = new PaqueteDTO();
			
			pdto.setId(p.getId());
			pdto.setNombre(p.getNombre());
			DestinoDTO ddto = new DestinoDTO();
			ddto.setId(p.getDestino().getId());
			ddto.setNombre(p.getDestino().getNombre());
			//Faltaria mapear Latitud y Longitud, no se si los demas modulos contemplaron estas variables
						
			pdto.setDestino(ddto);
			
			pdto.setFechaIngreso(p.getFechaIngreso());
			pdto.setFechaSalida(p.getFechaSalida());
			pdto.setEstado(p.getEstado());
			
			pdto.setCupo(p.getCupo());
			pdto.setPrecioPersona(p.getPrecioPersona());
			
			List <ServicioDTO> lstSDTO = new ArrayList<ServicioDTO>();
			List <Servicio> lstS = p.getServicios();
			
			for(Servicio s : lstS) {
				ServicioDTO sdto = new ServicioDTO();
				sdto.setId(s.getId());
				sdto.setNombre(s.getNombre());
				lstSDTO.add(sdto);
			}
			
			pdto.setServicios(lstSDTO);
			
			pdto.setDescripcion(p.getDescripcion());
			pdto.setFoto(p.getFoto());
			pdto.setCantPersonas(p.getCantPersonas());
			pdto.setPoliticasDeCancelacion(p.getPoliticasDeCancelacion());
			
			lstPDTO.add(pdto);			
			
		
		}
		return lstPDTO;
	}

}

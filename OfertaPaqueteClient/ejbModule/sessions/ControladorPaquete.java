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
    
    public int altaPaquete(PaqueteDTO pdto)  {
    	//TO DO
    	return 0;
    }
    
    public Paquete recuperarPaquete(int id) {
    	return em.find(Paquete.class, id);    	
    }
    

    
    
    public void actualizarPaquete(Paquete p) {
    	em.merge(p);
    }
    
	public ArrayList<PaqueteDTO> recuperarPaquetes() {
		ArrayList<PaqueteDTO> lstPDTO = new ArrayList<PaqueteDTO>();
		ArrayList<Paquete> lstP;
		Query q = em.createQuery("SELECT p FROM Paquete p ");
		lstP = (ArrayList<Paquete>) q.getResultList();
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

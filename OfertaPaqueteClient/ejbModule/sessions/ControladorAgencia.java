package sessions;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.google.gson.Gson;

import dto.AgenciaDTO;
import entities.Agencia;

/**
 * Session Bean implementation class ControladorAgencia
 */
@Stateless
@LocalBean
public class ControladorAgencia implements ControladorAgenciaRemote {
	
	@PersistenceContext(unitName="MyPU")
	   private EntityManager em;
	

    /**
     * Default constructor. 
     */
    public ControladorAgencia() {
        // TODO Auto-generated constructor stub
    }
    

    
    public int altaAgencia(AgenciaDTO adto)  {
    	if(!validarAgencia(adto.getNombre(),adto.getDireccion())) {

    		Agencia nAgencia = new Agencia();
    		nAgencia.setNombre(adto.getNombre());
    		nAgencia.setDireccion(adto.getDireccion());
    		nAgencia.setEstado("Pendiente");
    		em.persist(nAgencia);
    		
     		Gson gson = new Gson();
     		
     		System.out.println(gson.toJson(nAgencia));
     		

    		
     		
    		return nAgencia.getId();
    	}else {    		
    		System.out.println("La agencia existe");
    		return 0;
    	}
    	
    }
    
    private boolean validarAgencia(String nombre, String direccion) {
		try {
			Query q = em.createQuery("SELECT COUNT(a.nombre) FROM Agencia a WHERE a.nombre LIKE :nom AND a.direccion LIKE :dire ")
					.setParameter("nom", nombre)
					.setParameter("dire", direccion);			
			Long x = (Long) q.getSingleResult();			
			if(x >= 1 ) {				
				return true;
			}else {
				return false;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
    
    
    public Agencia recuperarAgencia(int id) {
    	return em.find(Agencia.class, id);    	
    }
    

    
    
    public void actualizarAgencia(Agencia a) {
    	em.merge(a);
    }

	@SuppressWarnings("unchecked")
	public ArrayList<AgenciaDTO> recuperarAgencias() {
		ArrayList<AgenciaDTO> lstADTO = new ArrayList<AgenciaDTO>();
		ArrayList<Agencia> lstA;
		Query q = em.createQuery("SELECT a FROM Agencia a ");
		lstA = (ArrayList<Agencia>) q.getResultList();
		for(Agencia a: lstA) {
			AgenciaDTO adto = new AgenciaDTO();
			adto.setId(a.getId());
			adto.setNombre(a.getNombre());
			adto.setDireccion(a.getDireccion());
			adto.setEstado(a.getEstado());
			lstADTO.add(adto);			
		}
		return lstADTO;
	}



}

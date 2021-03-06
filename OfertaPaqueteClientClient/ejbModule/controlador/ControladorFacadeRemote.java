package controlador;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;

import dto.AgenciaDTO;
import dto.DestinoDTO;
import dto.FormasDePagoDTO;
import dto.PaqueteDTO;
import dto.TipoServicioDTO;

@Remote
public interface ControladorFacadeRemote {
	
	public void altaAgencia(AgenciaDTO a);
	
	public List<AgenciaDTO> recuperarAgencias();
	
	public AgenciaDTO recuperarAgenciaDTO(int id);
	
	public List<PaqueteDTO> recuperarPaquetes();

	public List<TipoServicioDTO> recuperarServicios();
	
	public List<DestinoDTO> recuperarDestinos();
	
	public void altaPaquete(PaqueteDTO p);
	
	public DestinoDTO recuperarDestino(int id);

	public List<FormasDePagoDTO> recuperarFormasdePago();
}

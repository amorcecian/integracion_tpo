package json;

import java.io.Serializable;

public class AgenciaJson implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idBackoffice;

	public AgenciaJson(int idBackoffice) {
		super();
		this.idBackoffice = idBackoffice;
	}

	public int getIdBackoffice() {
		return idBackoffice;
	}

	public void setIdBackoffice(int idBackoffice) {
		this.idBackoffice = idBackoffice;
	}
		

}

package servicios.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Posicion {
	
	private Double latitud;
	private Double longitud;
	
	public Posicion() {
		super();
	}

	public Posicion(Double latitud, Double longitud) {
		super();
		this.latitud = latitud;
		this.longitud = longitud;
	}

	public Double getLatitud() {
		return latitud;
	}
	
	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}
	
	public Double getLongitud() {
		return longitud;
	}
	
	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}

}

package servicios.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Ubicacion {

	private Posicion posicion;
	private String icon; 
	private String title;
	
	
	public Ubicacion() {
		super();
	}

	public Ubicacion(Posicion posicion, String icon, String title) {
		super();
		this.posicion= posicion;
		this.icon = icon;
		this.title = title;
	}
	
	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

	public String getIcon() {
		return icon;
	}
	
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
}

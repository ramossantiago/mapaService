package servicios.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Ubicacion {

	private Posicion posicion;
	private String imagen;
	private String descripcion;
	private Double distancia;

	public Ubicacion() {
		super();
	}

	public Ubicacion(Posicion posicion, String imagen, String descripcion, Double distancia) {
		super();
		this.posicion = posicion;
		this.imagen = imagen;
		this.descripcion = descripcion;
		this.distancia = distancia;
	}

	public Ubicacion(Posicion posicion, String icon, String title) {
		super();
		this.posicion = posicion;
		this.imagen = icon;
		this.descripcion = title;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getDistancia() {
		return distancia;
	}

	public void setDistancia(Double distancia) {
		this.distancia = distancia;
	}

}

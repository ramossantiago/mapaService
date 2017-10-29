package servicios.rest;

import servicios.model.Posicion;

public class Request {

	private Posicion posicionActual;
	private Double distancia;

	public Posicion getPosicionActual() {
		return posicionActual;
	}

	public void setPosicionActual(Posicion posicionActual) {
		this.posicionActual = posicionActual;
	}

	public Double getDistancia() {
		return distancia;
	}

	public void setDistancia(Double distancia) {
		this.distancia = distancia;
	}

	@Override
	public String toString() {
		return "Posicion: latitud:" + posicionActual.getLatitud() + ", longitud:" + posicionActual.getLongitud()
				+ ", distancia:" + distancia;
	}

}

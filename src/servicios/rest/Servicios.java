package servicios.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import net.sf.json.JSONObject;
import servicios.model.Posicion;
import servicios.model.Ubicacion;
import servicios.utils.DistanceUtil;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/servicio")
public class Servicios {

	@POST
	@Path("/ubicaciones")
	public Object getLocations(Request request) {

		System.out.println("Request " + request.toString());

		JSONObject json = new JSONObject();
		List<Ubicacion> listado = obtenerUbicaciones(request);
		json.put("ubicaciones", listado);

		return json.toString();
	}

	private List<Ubicacion> obtenerUbicaciones(Request request) {

		Double distanciaMaxima = request.getDistancia();
		Posicion posicion = request.getPosicionActual();
		Double latitudCentro = posicion.getLatitud();
		Double longitudCentro = posicion.getLongitud();
		List<Ubicacion> listadoTotalUbicaciones = obtenerTotalUbicaciones();

		List<Ubicacion> listado = new ArrayList<>();

		for (Ubicacion ubicacionElemento : listadoTotalUbicaciones) {
			posicion = ubicacionElemento.getPosicion();
			Double distanciaEntrePuntos = DistanceUtil.distFrom(latitudCentro, longitudCentro, posicion.getLatitud(),
					posicion.getLongitud());
			System.out.println("Distancia " + distanciaEntrePuntos);
			if (distanciaEntrePuntos <= distanciaMaxima) {
				ubicacionElemento.setDistancia(distanciaEntrePuntos);
				listado.add(ubicacionElemento);
			}
		}
		System.out.println("");

		return listado;
	}

	private List<Ubicacion> obtenerTotalUbicaciones() {
		List<Ubicacion> listado = new ArrayList<>();
		Ubicacion ub1 = new Ubicacion(new Posicion(-0.292018, -78.477846), "img1.jpg", "Posicion 1");
		listado.add(ub1);
		Ubicacion ub2 = new Ubicacion(new Posicion(-0.285014, -78.472250), "img1.jpg", "Posicion 2");
		listado.add(ub2);
		Ubicacion ub3 = new Ubicacion(new Posicion(-0.308758, -78.452609), "img2.jpg", "Posicion 3");
		listado.add(ub3);
		Ubicacion ub4 = new Ubicacion(new Posicion(-0.312426, -78.479969), "img3.jpg", "Posicion 4");
		listado.add(ub4);

		return listado;
	}

}

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
		Ubicacion ub5 = new Ubicacion(new Posicion(-0.17679463836506806, -78.47511614943755), "img3.jpg", "Posicion 5");
		listado.add(ub5);
		Ubicacion ub6 = new Ubicacion(new Posicion(-0.18137225359546577, -78.4818395535865), "img3.jpg", "Posicion 6");
		listado.add(ub6);
		Ubicacion ub7 = new Ubicacion(new Posicion(-0.1692606462073677, -78.48436679037945), "img3.jpg", "Posicion 7");
		listado.add(ub7);
		Ubicacion ub8 = new Ubicacion(new Posicion(-0.164301561355471, -78.47893084688508), "img3.jpg", "Posicion 8");
		listado.add(ub8);

		return listado;
	}

}

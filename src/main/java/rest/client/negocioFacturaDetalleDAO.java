package rest.client;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;

import rest.entity.Factura_detalle;


public class negocioFacturaDetalleDAO {
	
	

	/**
	 * Metodo facturaDetalle
	 * <p>
	 * Descripción: El metodo facturaDetalle sirve para recibir los parametros enviados y ubicarlos de acuerdo al tipo de
	 * solicitud que requiera el facturaDetalle.
	 * <p>
	 * Parametros:
	 * <p>
	 * Nombre / Tipo: String / tipoSolicitudfacturaDetalle
	 * <p>
	 * Descripción: Indicara el tipo de solicitud que se desea realizar.
	 * <p>
	 * Nombre / Tipo: JSONObject / jsonObjfacturaDetalle
	 * <p>
	 * Descripción: condiciones a evaluar en la solicitud.
	 * <p>
	 */
	public static Response facturaDetalle(String tipoSolicitudfacturaDetalle, JSONObject jsonObjfacturaDetalle) throws JSONException {

		
		Conexion conectar = new Conexion();
		ArrayList<Factura_detalle> lista = new ArrayList<Factura_detalle>();
		
	
		try {
			switch (tipoSolicitudfacturaDetalle) {
			
			case "listar":
			
				conectar.Conectar();
				String querylistar = "Select * from usuario";
				PreparedStatement smtlistar = conectar.getCnx().prepareStatement(querylistar);
				ResultSet rt = smtlistar.executeQuery();

				while (rt.next()) {
					Factura_detalle u = new Factura_detalle();
					
					lista.add(u);
				}
				System.out.println(lista);

				conectar.Desconectar();

				return Response.ok(lista).build();

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	
	}
}

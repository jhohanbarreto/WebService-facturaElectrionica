package rest.client;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;

import rest.entity.Cliente_factura;


public class negocioClienteFacturaDAO {
	
	

	/**
	 * Metodo clienteFactura
	 * <p>
	 * Descripción: El metodo clienteFactura sirve para recibir los parametros enviados y ubicarlos de acuerdo al tipo de
	 * solicitud que requiera el clienteFactura.
	 * <p>
	 * Parametros:
	 * <p>
	 * Nombre / Tipo: String / tipoSolicitudclienteFactura
	 * <p>
	 * Descripción: Indicara el tipo de solicitud que se desea realizar.
	 * <p>
	 * Nombre / Tipo: JSONObject / jsonObjclienteFactura
	 * <p>
	 * Descripción: condiciones a evaluar en la solicitud.
	 * <p>
	 */
	public static Response clienteFactura(String tipoSolicitudclienteFactura, JSONObject jsonObjclienteFactura) throws JSONException {

		
		Conexion conectar = new Conexion();
		ArrayList<Cliente_factura> lista = new ArrayList<Cliente_factura>();
		
	
		try {
			switch (tipoSolicitudclienteFactura) {
			
			case "listar":
			
				

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	
	}
}

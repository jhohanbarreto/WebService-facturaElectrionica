package rest.client;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;

import rest.entity.Producto;


public class negocioProductoDAO {
	
	

	/**
	 * Metodo producto
	 * <p>
	 * Descripción: El metodo producto sirve para recibir los parametros enviados y ubicarlos de acuerdo al tipo de
	 * solicitud que requiera el producto.
	 * <p>
	 * Parametros:
	 * <p>
	 * Nombre / Tipo: String / tipoSolicitudproducto
	 * <p>
	 * Descripción: Indicara el tipo de solicitud que se desea realizar.
	 * <p>
	 * Nombre / Tipo: JSONObject / jsonObjproducto
	 * <p>
	 * Descripción: condiciones a evaluar en la solicitud.
	 * <p>
	 */
	public static Response producto(String tipoSolicitudproducto, JSONObject jsonObjproducto) throws JSONException {

		
		Conexion conectar = new Conexion();
		ArrayList<Producto> lista = new ArrayList<Producto>();
		
	
		try {
			switch (tipoSolicitudproducto) {
			
			case "listar":
			
				conectar.Conectar();
				String querylistar = "Select * from usuario";
				PreparedStatement smtlistar = conectar.getCnx().prepareStatement(querylistar);
				ResultSet rt = smtlistar.executeQuery();

				while (rt.next()) {
					Producto u = new Producto();
				
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

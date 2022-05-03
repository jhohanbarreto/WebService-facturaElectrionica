package rest.services;

import java.io.IOException;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;
import rest.client.negocioClienteDAO;
import rest.client.negocioClienteFacturaDAO;
import rest.client.negocioFacturaDetalleDAO;
import rest.client.negocioProductoDAO;
import rest.client.negocioCategoriaDAO;

@Path("/")
public class usuarioTiendaWS {

	@POST
	@Path("/{parametro1}/{parmTipoSolicitud}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	
	public Response isJSONValid(String json, @PathParam("parametro1") String parametro,
			@PathParam("parmTipoSolicitud") String tipoSolicitudString) throws JSONException, IOException {

		try {

			if (tipoSolicitudString.isEmpty()) {
				return Response.status(Response.Status.NOT_FOUND)
						.entity("ERROR: No se ha encontrado el campo 'tipoSolicitud' o formato inv�lido").build();
			}

		} catch (Exception e) {

			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("Ha ocurrido un problema, por favor, verifique si su JSON es valido").build();
		}
		
		switch (parametro) {
		
		case "cliente":

			JSONObject jsonObjCliente = new JSONObject(json);

			String tipoSolicitudCliente = String.format(tipoSolicitudString);

			return negocioClienteDAO.cliente(tipoSolicitudCliente, jsonObjCliente);

		case "clienteFactura":
			
			JSONObject jsonClienteFactura = new JSONObject(json);

			String tipoSolicitudClienteFactura = String.format(tipoSolicitudString);

			return negocioClienteFacturaDAO.clienteFactura(tipoSolicitudClienteFactura, jsonClienteFactura);
			
		case "facturaDetalle":
			
			JSONObject jsonFacturaDetalle = new JSONObject(json);

			String tipoSolicitudFacturaDetalle = String.format(tipoSolicitudString);

			return negocioFacturaDetalleDAO.facturaDetalle(tipoSolicitudFacturaDetalle, jsonFacturaDetalle);
			
		case "producto":
			
			JSONObject jsonProducto = new JSONObject(json);

			String tipoSolicitudProducto = String.format(tipoSolicitudString);

			return negocioProductoDAO.producto(tipoSolicitudProducto, jsonProducto);
			
		case "categoria":
			
			JSONObject jsonCategoria = new JSONObject(json);

			String tipoSolicitudCategoria = String.format(tipoSolicitudString);

			return negocioCategoriaDAO.categoria(tipoSolicitudCategoria, jsonCategoria);


		}
		return null;

	}

}

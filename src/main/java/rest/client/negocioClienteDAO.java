package rest.client;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;

import rest.error.CrudSQLException;
import rest.entity.Cliente;

public class negocioClienteDAO {

	public static void main(String args[]) {

		JSONObject mapParam = new JSONObject();
		// mapParam.put(null, null);
		negocioClienteDAO.cliente("listar", mapParam);

	}

	/**
	 * Metodo cliente
	 * <p>
	 * Descripción: El metodo cliente sirve para recibir los parametros enviados y
	 * ubicarlos de acuerdo al tipo de solicitud que requiera el cliente.
	 * <p>
	 * Parametros:
	 * <p>
	 * Nombre / Tipo: String / tipoSolicitudCliente
	 * <p>
	 * Descripción: Indicara el tipo de solicitud que se desea realizar.
	 * <p>
	 * Nombre / Tipo: JSONObject / jsonObjCliente
	 * <p>
	 * Descripción: condiciones a evaluar en la solicitud.
	 * <p>
	 */
	public static Response cliente(String tipoSolicitudCliente, JSONObject jsonObjCliente) throws JSONException {

		final String MENSAJE_CRUD_ERROR_SQL = "ERROR SINTAXIS SQL";
		final String MENSAJE_ERROR_SQL = "DEBE INGRESAR CORRRECTAMENTE LOS DATOS";
		final String MENSAJE_ERROR_CATCH = "ALGO SALIO MAL";

		Conexion conectar = new Conexion();
		ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();
		String errorConsul;

		try {
			switch (tipoSolicitudCliente) {

			/**
			 * Listar Cliente
			 */
			case "listarCliente":
				if (jsonObjCliente.length() == 0) {

					try {
						conectar.Conectar();
						String querylistar = "Select * from cliente";
						PreparedStatement smtlistar = conectar.getCnx().prepareStatement(querylistar);
						ResultSet rt = smtlistar.executeQuery();

						while (rt.next()) {
							Cliente u = new Cliente();

							u.setApellidoCliente(rt.getString("apellidoCliente"));
							u.setDireccion(rt.getString("direccion"));
							u.setEmail(rt.getString("email"));
							u.setId_cliente(rt.getInt("id_cliente"));
							u.setNombreCliente(rt.getString("nombreCliente"));
							u.setTelefono(rt.getInt("telefono"));

							listaCliente.add(u);
						}

						return Response.ok(listaCliente).build();

					} catch (CrudSQLException e) {
						e.printStackTrace();
						errorConsul = MENSAJE_CRUD_ERROR_SQL;
						return Response.ok(errorConsul).build();

					} catch (SQLException e) {
						e.printStackTrace();
						errorConsul = MENSAJE_ERROR_SQL;
						return Response.ok(errorConsul).build();

					} catch (Exception e) {
						e.printStackTrace();
						errorConsul = MENSAJE_ERROR_CATCH;
						return Response.ok(errorConsul).build();
					} finally {
						conectar.Desconectar();
					}
				}

				/**
				 * Listar por id Cliente
				 */
			case "listarClienteId":
				if (jsonObjCliente.length() != 0) {

					try {
						conectar.Conectar();
						Integer id_cliente = jsonObjCliente.getInt("id_cliente");
						String querylistarId = "Select * from cliente where id_cliente='" + id_cliente + "'";
						PreparedStatement smtlistar = conectar.getCnx().prepareStatement(querylistarId);
						ResultSet rt = smtlistar.executeQuery();

						while (rt.next()) {
							Cliente u = new Cliente();

							u.setApellidoCliente(rt.getString("apellidoCliente"));
							u.setDireccion(rt.getString("direccion"));
							u.setEmail(rt.getString("email"));
							u.setId_cliente(rt.getInt("id_cliente"));
							u.setNombreCliente(rt.getString("nombreCliente"));
							u.setTelefono(rt.getInt("telefono"));

							listaCliente.add(u);
						}

						return Response.ok(listaCliente).build();

					} catch (CrudSQLException e) {
						e.printStackTrace();
						errorConsul = MENSAJE_CRUD_ERROR_SQL;
						return Response.ok(errorConsul).build();

					} catch (SQLException e) {
						e.printStackTrace();
						errorConsul = MENSAJE_ERROR_SQL;
						return Response.ok(errorConsul).build();

					} catch (Exception e) {
						e.printStackTrace();
						errorConsul = MENSAJE_ERROR_CATCH;
						return Response.ok(errorConsul).build();
					} finally {
						conectar.Desconectar();
					}
				}

				/**
				 * Lista Paginado
				 */
			case "listarPaginadoCliente":
				if (jsonObjCliente.length() != 0) {

					try {
						int desde = jsonObjCliente.getInt("desde");
						int total = jsonObjCliente.getInt("total");

						conectar.Conectar();
						String querylistar = "Select * from cliente LIMIT '" + desde + "','" + total + "'";
						PreparedStatement smtlistar = conectar.getCnx().prepareStatement(querylistar);
						ResultSet rt = smtlistar.executeQuery();

						while (rt.next()) {
							Cliente u = new Cliente();

							u.setApellidoCliente(rt.getString("apellidoCliente"));
							u.setDireccion(rt.getString("direccion"));
							u.setEmail(rt.getString("email"));
							u.setId_cliente(rt.getInt("id_cliente"));
							u.setNombreCliente(rt.getString("nombreCliente"));
							u.setTelefono(rt.getInt("telefono"));

							listaCliente.add(u);
						}

						return Response.ok(listaCliente).build();

					} catch (CrudSQLException e) {
						e.printStackTrace();
						errorConsul = MENSAJE_CRUD_ERROR_SQL;
						return Response.ok(errorConsul).build();

					} catch (SQLException e) {
						e.printStackTrace();
						errorConsul = MENSAJE_ERROR_SQL;
						return Response.ok(errorConsul).build();

					} catch (Exception e) {
						e.printStackTrace();
						errorConsul = MENSAJE_ERROR_CATCH;
						return Response.ok(errorConsul).build();
					} finally {
						conectar.Desconectar();
					}
				}

				/**
				 * Agregar Cliente
				 */
			case "insertarCliente":
				if (jsonObjCliente.length() != 0) {

					try {

						String nombreCliente = jsonObjCliente.getString("nombreCliente");
						String apellidoCliente = jsonObjCliente.getString("apellidoCliente");
						String direccion = jsonObjCliente.getString("direccion");
						String email = jsonObjCliente.getString("email");
						Integer telefono = jsonObjCliente.getInt("telefono");

						conectar.Conectar();
						String queryInsertar = "INSERT INTO cliente(nombreCliente,apellidoCliente,direccion,email,telefono) "
								+ "values('" + nombreCliente + "','" + apellidoCliente + "','" + direccion + "','"
								+ email + "','" + telefono + "')";
						PreparedStatement smt = conectar.getCnx().prepareStatement(queryInsertar);
						smt.executeUpdate();
						return Response.status(Response.Status.OK).entity("Tipo solicitud:  " + tipoSolicitudCliente)
								.build();

					} catch (CrudSQLException e) {
						e.printStackTrace();
						errorConsul = MENSAJE_CRUD_ERROR_SQL;
						return Response.ok(errorConsul).build();

					} catch (SQLException e) {
						e.printStackTrace();
						errorConsul = MENSAJE_ERROR_SQL;
						return Response.ok(errorConsul).build();

					} catch (Exception e) {
						e.printStackTrace();
						errorConsul = MENSAJE_ERROR_CATCH;
						return Response.ok(errorConsul).build();
					} finally {
						conectar.Desconectar();
					}
				}

				/**
				 * Editar Cliente
				 */
			case "editarCliente":
				if (jsonObjCliente.length() != 0) {

					try {
						Integer id_cliente = jsonObjCliente.getInt("id_cliente");
						String nombreCliente = jsonObjCliente.getString("nombreCliente");
						String apellidoCliente = jsonObjCliente.getString("apellidoCliente");
						String direccion = jsonObjCliente.getString("direccion");
						String email = jsonObjCliente.getString("email");
						Integer telefono = jsonObjCliente.getInt("telefono");

						conectar.Conectar();
						String queryActualizar = "UPDATE cliente SET nombreCliente = '" + nombreCliente
								+ "',apellidoCliente='" + apellidoCliente + "'," + "direccion = '" + direccion
								+ "',email='" + email + "',telefono='" + telefono + "' WHERE id_cliente = '"
								+ id_cliente + "'";

						PreparedStatement smt = conectar.getCnx().prepareStatement(queryActualizar);
						smt.executeUpdate();
						return Response.status(Response.Status.OK).entity("Tipo solicitud:  " + tipoSolicitudCliente)
								.build();

					} catch (CrudSQLException e) {
						e.printStackTrace();
						errorConsul = MENSAJE_CRUD_ERROR_SQL;
						return Response.ok(errorConsul).build();

					} catch (SQLException e) {
						e.printStackTrace();
						errorConsul = MENSAJE_ERROR_SQL;
						return Response.ok(errorConsul).build();

					} catch (Exception e) {
						e.printStackTrace();
						errorConsul = MENSAJE_ERROR_CATCH;
						return Response.ok(errorConsul).build();
					} finally {
						conectar.Desconectar();
					}
				}

				/**
				 * Eliminar Cliente
				 */
			case "eliminarCliente":
				if (jsonObjCliente.length() != 0) {

					try {
						Integer id_cliente = jsonObjCliente.getInt("id_cliente");

						conectar.Conectar();
						String queryActualizar = "DELETE FROM cliente WHERE id_cliente = '" + id_cliente + "'";

						PreparedStatement smt = conectar.getCnx().prepareStatement(queryActualizar);
						smt.executeUpdate();
						return Response.status(Response.Status.OK).entity("Tipo solicitud:  " + tipoSolicitudCliente)
								.build();

					} catch (CrudSQLException e) {
						e.printStackTrace();
						errorConsul = MENSAJE_CRUD_ERROR_SQL;
						return Response.ok(errorConsul).build();

					} catch (SQLException e) {
						e.printStackTrace();
						errorConsul = MENSAJE_ERROR_SQL;
						return Response.ok(errorConsul).build();

					} catch (Exception e) {
						e.printStackTrace();
						errorConsul = MENSAJE_ERROR_CATCH;
						return Response.ok(errorConsul).build();
					} finally {
						conectar.Desconectar();
					}
				}

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	}
}

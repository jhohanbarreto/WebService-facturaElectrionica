package rest.client;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;

import rest.entity.Categoria;
import rest.error.CrudSQLException;

public class negocioCategoriaDAO {

	/**
	 * Metodo categoria
	 * <p>
	 * Descripción: El metodo categoria sirve para recibir los parametros enviados y
	 * ubicarlos de acuerdo al tipo de solicitud que requiera el categoria.
	 * <p>
	 * Parametros:
	 * <p>
	 * Nombre / Tipo: String / tipoSolicitudCategoria
	 * <p>
	 * Descripción: Indicara el tipo de solicitud que se desea realizar.
	 * <p>
	 * Nombre / Tipo: JSONObject / jsonObjCategoria
	 * <p>
	 * Descripción: condiciones a evaluar en la solicitud.
	 * <p>
	 */
	public static Response categoria(String tipoSolicitudCategoria, JSONObject jsonObjCategoria) throws JSONException {

		final String MENSAJE_CRUD_ERROR_SQL = "ERROR SINTAXIS SQL";
		final String MENSAJE_ERROR_SQL = "DEBE INGRESAR CORRRECTAMENTE LOS DATOS";
		final String MENSAJE_ERROR_CATCH = "ALGO SALIO MAL";

		Conexion conectar = new Conexion();
		ArrayList<Categoria> listaCategoria = new ArrayList<Categoria>();
		String errorConsul;

		try {
			switch (tipoSolicitudCategoria) {

			// Listar
			case "listarCategoria":
				if (jsonObjCategoria.length() == 0) {

					try {
						conectar.Conectar();
						String querylistar = "Select * from categoria";
						PreparedStatement smtlistar = conectar.getCnx().prepareStatement(querylistar);
						ResultSet rt = smtlistar.executeQuery();

						while (rt.next()) {
							Categoria u = new Categoria();
							u.setDescripcionCategoria(rt.getString("descripcionCategoria"));
							u.setId_categoria(rt.getInt("id_categoria"));
							u.setNombreCategoria(rt.getString("nombreCategoria"));

							listaCategoria.add(u);
						}

						return Response.ok(listaCategoria).build();

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

				// Listar id
			case "listarCategoriaId":
				if (jsonObjCategoria.length() != 0) {

					try {
						conectar.Conectar();
						Integer id_categoria = jsonObjCategoria.getInt("id_categoria");
						String querylistar = "Select * from categoria where id_categoria = '" + id_categoria + "'";
						PreparedStatement smtlistar = conectar.getCnx().prepareStatement(querylistar);
						ResultSet rt = smtlistar.executeQuery();

						while (rt.next()) {
							Categoria u = new Categoria();
							u.setDescripcionCategoria(rt.getString("descripcionCategoria"));
							u.setId_categoria(rt.getInt("id_categoria"));
							u.setNombreCategoria(rt.getString("nombreCategoria"));

							listaCategoria.add(u);
						}

						return Response.ok(listaCategoria).build();

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

				// Listar id
			case "listarPaginadoCategoria":
				if (jsonObjCategoria.length() != 0) {

					try {
						int desde = jsonObjCategoria.getInt("desde");
						int total = jsonObjCategoria.getInt("total");

						conectar.Conectar();
						String querylistar = "Select * from categoria LIMIT '" + desde + "','" + total + "'";
						PreparedStatement smtlistar = conectar.getCnx().prepareStatement(querylistar);
						ResultSet rt = smtlistar.executeQuery();

						while (rt.next()) {
							Categoria u = new Categoria();
							u.setDescripcionCategoria(rt.getString("descripcionCategoria"));
							u.setId_categoria(rt.getInt("id_categoria"));
							u.setNombreCategoria(rt.getString("nombreCategoria"));

							listaCategoria.add(u);
						}

						return Response.ok(listaCategoria).build();

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

				// Agregar
			case "insertarCategoria":
				if (jsonObjCategoria.length() != 0) {

					try {

						String nombreCategoria = jsonObjCategoria.getString("nombreCategoria");
						String descripcionCategoria = jsonObjCategoria.getString("descripcionCategoria");

						conectar.Conectar();
						String queryInsertar = "INSERT INTO categoria(nombreCategoria,descripcionCategoria) "
								+ "values('" + nombreCategoria + "','" + descripcionCategoria + "')";
						PreparedStatement smt = conectar.getCnx().prepareStatement(queryInsertar);
						smt.executeUpdate();
						return Response.status(Response.Status.OK).entity("Tipo solicitud:  " + tipoSolicitudCategoria)
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

				// Editar
			case "editarCategoria":
				if (jsonObjCategoria.length() != 0) {

					try {
						Integer id_categoria = jsonObjCategoria.getInt("id_categoria");
						String nombreCategoria = jsonObjCategoria.getString("nombreCategoria");
						String descripcionCategoria = jsonObjCategoria.getString("descripcionCategoria");

						conectar.Conectar();
						String queryInsertar = "UPDATE categoria SET nombreCategoria ='"+nombreCategoria+"',descripcionCategoria='"+descripcionCategoria+"'"
								+ "WHERE id_categoria='"+id_categoria+"'";
						PreparedStatement smt = conectar.getCnx().prepareStatement(queryInsertar);
						smt.executeUpdate();
						return Response.status(Response.Status.OK).entity("Tipo solicitud:  " + tipoSolicitudCategoria)
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
				

				// Eliminar
			case "eliminarCategoria":
				if (jsonObjCategoria.length() != 0) {

					try {
						Integer id_categoria = jsonObjCategoria.getInt("id_categoria");

						conectar.Conectar();
						String queryActualizar = "DELETE FROM categoria WHERE id_categoria = '" + id_categoria + "'";

						PreparedStatement smt = conectar.getCnx().prepareStatement(queryActualizar);
						smt.executeUpdate();
						return Response.status(Response.Status.OK).entity("Tipo solicitud:  " + tipoSolicitudCategoria)
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

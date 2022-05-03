package rest.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	private static final String Controlador = "com.mysql.cj.jdbc.Driver";
	private static  String db = "canviapagoelectronico";
	private static  String user = "root";
	private static  String clave = "";
	private static  String ruta = "jdbc:mysql://localhost:3306/" + db;

	private Connection cnx;

	public Connection getCnx() {
		return cnx;
	}

	public void setCnx(Connection cnx) {
		this.cnx = cnx;
	}
		static {
			try {
				Class.forName(Controlador);
			}catch (ClassNotFoundException e){
				
				System.out.print("No se pudo conectar");
				e.printStackTrace();
				
			}
		}

	public void Conectar() throws Exception {

		try {
			

			this.cnx = DriverManager.getConnection(ruta, user, clave);

			if (this.cnx != null) {
				
				System.out.print("Conexion exitosa");

			} else {
				System.out.print("Error al conectarse");
			}
		} catch (SQLException e) {

			throw e;

		}

	}

	public void Desconectar() throws Exception{
		try {
			//si esixte la conexion 
			if(this.cnx != null) {
				if(this.cnx.isClosed() != true) {
					//cerramos la conexion
					this.cnx.close();
				}
			}
		} catch (Exception e) {
			throw e;
		}
	}


}
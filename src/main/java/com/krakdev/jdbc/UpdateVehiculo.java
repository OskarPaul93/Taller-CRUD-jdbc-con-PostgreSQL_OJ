package com.krakdev.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UpdateVehiculo {
	private static final Logger log = LogManager.getLogger(UpdateVehiculo.class);


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection con= null;
		PreparedStatement ps= null;
		
		try {
			con = Conexion.getConnection();
			String sql = """
					UPDATE vehiculos SET marca= ?, modelo=?, anio=?, 
					precio=?, color=?, disponible=?
					WHERE placa =?		
					""";
			
			ps=con.prepareStatement(sql);
				
			
			ps= con.prepareStatement(sql);
			
			ps.setString(1, "KIA");
			ps.setString(2, "SOLUTO - Nuevo");
			ps.setInt(3, 2026);
			ps.setDouble(4, 16500.99);
			ps.setString(5, "Gris");
			ps.setBoolean (6, true);
			ps.setString(7, "5522334455");
			
			int filas =ps.executeUpdate();
			log.info("Filas actualizadas: " + filas);

			
			}catch(Exception e){
			log.error("Error al actualizar: " + e.getMessage());
			
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}

}

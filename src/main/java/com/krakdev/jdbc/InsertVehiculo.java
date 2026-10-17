package com.krakdev.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InsertVehiculo {

	private static final Logger log = LogManager.getLogger(InsertVehiculo.class);
	private static final String URL = "jdbc:postgresql://localhost:5432/tallerjdbc";
	private static final String USER = "postgres";
	private static final String PASSWORD= "Pumpitup93";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection con=null;
		PreparedStatement ps;
		String sql= """  
				INSERT INTO vehiculos (placa, marca, modelo, anio, precio, color, disponible)
				VALUES(?,?,?,?,?,?,?)
				""";
		//Aqui me aparece un erro pero lo puedo mandar a try catch
		//ps= con.prepareStatement(sql);
		
		
		
		try {
			con= DriverManager.getConnection(URL, USER, PASSWORD);
			ps= con.prepareStatement(sql);
			ps.setString(1, "5522334455");
			ps.setString(2, "KIA");
			ps.setString(3, "SOLUTO");
			ps.setInt(4, 2026);
			ps.setDouble(5, 16000.5);
			ps.setString(6, "Gris");
			ps.setBoolean (7, true);
			
			int filas= ps.executeUpdate();
			
			log.info("Conexion Exitosa");
			log.info("Filas insertadas: "+ filas);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error("Eroor en la conexion: "+e.getMessage());
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

package com.krakdev.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConexionTest {
	private static final Logger log = LogManager.getLogger(ConexionTest.class);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection con =null;
		
		try {
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tallerjdbc","postgres", "Pumpitup93");
			log.info("Conexion Exitosa");
			
		} catch (SQLException e) {
			log.error("Error de conexion: "+ e.getMessage());
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				log.error("Error de conexion: "+ e.getMessage());
			}
		}
		
		

	}

}

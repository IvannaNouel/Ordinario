package com.mayab.calidad.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

import com.mayab.calidad.doubles.Alumno;

public class AlumnoDAOforTest implements DAO {
	public HashMap<Integer, Alumno> registros = new HashMap<Integer, Alumno>();

	
public HashMap<Integer, Alumno> getRegistros() {
		return registros;
	}

	public void setRegistros(HashMap<Integer, Alumno> registros) {
		this.registros = registros;
	}

public Connection getConnection()
{
	
	Connection con = null;
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","dbunit","dbunit");
	}catch(Exception e) {
		
		System.out.println(e);
		
	}
	
	return con;
    
}

public void addAlumno (Alumno a)
{
	Connection con=getConnection();
	PreparedStatement ps;
	try {
		ps = con.prepareStatement("insert into alumnos (nombre, id, edad, promedio, correo) values (?,?,?,?,?)");
	
		ps.setString(1, a.getNombre());
		ps.setInt(2, a.getId());
		ps.setInt(3, a.getEdad());
		ps.setFloat(4, a.getPromedio());
		ps.setString(5, a.getEmail());
	
		
		int aux = ps.executeUpdate();
		con.close();
	}
		catch(SQLException e)
	{
			e.printStackTrace();
	}

}


public Boolean eliminarAlumno(Alumno alumno) {
	// TODO Auto-generated method stub
	try {
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("DELETE FROM alumno WHERE id = ?");
	ps.setString(1, String.valueOf(alumno.getId()));
		int status = ps.executeUpdate();
		con.close();
		
	}catch(Exception e) {
		e.printStackTrace();}
	return null;

}
public Boolean actualizarPromedio(Alumno alumno, Float promedio) {
	// TODO Auto-generated method stub
	return null;
}

public String getAlumno(String id) {
	// TODO Auto-generated method stub
	Connection con=getConnection();
	PreparedStatement ps;
	
	return null;

	


}

@Override
public void deleteAlumno(Alumno a) {
	// TODO Auto-generated method stub
	
}

@Override
public void updatePromedio(Alumno a, float NuevoPromedio) {
	// TODO Auto-generated method stub
	
}

@Override
public int getNumeroAlumnos() {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public String getAlumno(int id) {
	// TODO Auto-generated method stub
	return null;
}



}

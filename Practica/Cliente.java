package Practica;

import java.io.Serializable;

public class Cliente implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String nombre;
	private String direccion;
	private String poblacion;
	private String telefono;
	private String nif;
	
	public Cliente (int id,String nombre, String direccion, String poblacion, String telefono, String nif) {
		
		this.id=id;
		this.nombre=nombre;
		this.direccion=direccion;
		this.poblacion=poblacion;
		this.telefono=telefono;
		this.nif=nif;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getNIF() {
		return nif;
	}

	public void setNIF(String nif) {
		this.nif = nif;
	}

}

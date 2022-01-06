package Tipos_XML;

import java.io.Serializable;

public class Persona implements Serializable{
	private String nombre;
	private int edad;
	//Identifica a la clase univocamente, ya que el nombre podría estar repetido
	private static final long serialVersionUID=1L; 
	
	public Persona(String n, int e){
		nombre=n;
		edad=e;
	}
	public Persona(){
		nombre=null;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public int getEdad(){
		return edad;
	}
	
	public void setNombre(String n){
		nombre=n;
	}
	public void setEdad(int e){
		edad=e;
	}
	
} //Fin Persona

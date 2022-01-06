package Escribir_Leer_Ficheros;

import java.io.Serializable;

public class Alumno implements Serializable{
		//Creamos los atributos
		private String Nombre;
		private int edad;
		private double calificacion;
		
		//Creamos el metodo constructor
		public Alumno(String n,int e,double c){
			
			this.setNombre(n);
			this.setEdad(e);
			this.setCalificacion(c);
			
		}

		public void setNombre(String nombre) {
			Nombre = nombre;
		}

		public String getNombre() {
			return Nombre;
		}

		public void setEdad(int edad) {
			this.edad = edad;
		}

		public int getEdad() {
			return edad;
		}

		public void setCalificacion(double calificacion) {
			this.calificacion = calificacion;
		}

		public double getCalificacion() {
			return calificacion;
		}
	
}

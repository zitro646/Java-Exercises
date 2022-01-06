package Inicio;

public class Libro {
	
	//encapsulamos los atributos de la clase
	private String titulo; 			//lectura y escritura
	private String autor;  			//lectura y escritura
	private int nPag;	  			//lectura y escritura
	private double calificacion;	//lectura y escritura
	
	//creamos el metodo constructor
	public Libro(String titulo, String autor, int nPag, double calificacion) {
		this.titulo=titulo;
		this.autor=autor;
		this.nPag=nPag;
		this.calificacion=calificacion;
	}
	
	//creamos los metodos getter y setter de los atributos
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titu) {
		titulo=titu;
	}
	
	public String getAutor() {
		return autor;
	}
	public void setAutor(String nombre) {
		autor=nombre;
	}
	
	public int getPags() {
		return nPag;
	}
	public void setPags(int pag) {
		nPag=pag;
	}
	
	public double getCalificacion() {
		return calificacion;
	}
	
	public void setCalificacion(double cal) {
		if(cal>=0 && cal<=10){
			calificacion=cal;
		}
		else {
			calificacion=-1;
		}
	}
}

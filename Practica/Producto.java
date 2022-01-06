package Practica;

public class Producto {
	
	//Creamos las variables
	private int id;
	private String descripcion;
	private int stockanual;
	private double pvp;
	
	//Creamos el constructor
	public Producto (int i,String d,int s,double p) {
		
		this.setId(i);
		this.setDescripcion(d);
		this.setStockanual(s);
		this.setPvp(p);
		
	}
	
	//Creamos los metodos
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getStockanual() {
		return stockanual;
	}

	public void setStockanual(int stockanual) {
		this.stockanual = stockanual;
	}

	public double getPvp() {
		return pvp;
	}

	public void setPvp(double pvp) {
		this.pvp = pvp;
	}
	
}

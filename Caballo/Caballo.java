package Caballo;

import java.util.Observable;

public class Caballo extends Observable implements Runnable{
	//Declaramos las variables
	private String nombre;
	
	//Declaramos el constructor
	public Caballo(String n) {
		setNombre(n);
	}
	
	public void run() {
		
		int porcentaje = 0;
		try {
			
		
			while(porcentaje <= 100) {
				porcentaje = porcentaje + this.generarnumero(15, 1);
				System.out.println("Caballo " +nombre+ " aumenta a "+porcentaje);
				
				this.setChanged();
				this.notifyObservers(porcentaje);
				this.clearChanged();
				
				Thread.sleep(1000);
			}
		
		
		}catch(InterruptedException ex) {
			System.out.println("Hilo interrumpido");
		}
	}
	public int generarnumero(int max, int min) {
		
		int n = (int)Math.floor(Math.random()*(max-min+1)+(min));
		
		return n;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}

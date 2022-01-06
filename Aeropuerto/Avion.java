package Aeropuerto;

import java.util.Observable;

public class Avion extends Observable implements Runnable{
	//Creamos las variable
	public String nombre;
	public Thread a ;
	//Creamos el constructor
	public Avion(String n) {
		nombre=n;
	}
	
	public void run() {
		
		int tiempo = this.generarTiempoAire(15, 1);
		try {
				
				
				
				System.out.println("Avion "+nombre+" volara por "+tiempo+" segundos");
				Thread.sleep(tiempo);
				this.setChanged();
				this.notifyObservers();
				this.clearChanged();
				
				
			
		
		
		}catch(InterruptedException ex) {
			System.out.println("Hilo interrumpido");
		}
	}
	
	public int generarTiempoAire(int max, int min) {
		
		int n = (int)Math.floor(Math.random()*(max-min+1)+(min));
		n = n * 1000;
		return n;
	}
	
	public Thread getThread() {
		return a;
	}

	public void setThread(Thread n) {
		this.a = n;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String n) {
		this.nombre = n;
	}
	
}

package Caballo;

import java.util.Observable;
import java.util.Observer;

public class Carrera extends Observable implements Observer {
	
	public Thread[] hilos = new Thread[4];
	
	public Carrera() {
		
	}
	
	public void inicioCarrera() {
		
		
		
		for(int i=0;i<hilos.length;i++) {
			
			Caballo c = new Caballo((i+1)+"");
			c.addObserver(this);
			hilos[i] = new Thread(c);
			hilos[i].start();
		}
		
	}
	
	public void update(Observable o,Object arg) {
		
		Caballo c =  (Caballo) o;
		int porcentaje = (int) arg; 
		
		if(porcentaje>=100) {
			this.terminar();
			System.out.println("El ganador es "+c.getNombre());
		}
		
	}

	public void terminar() {
		// TODO Auto-generated method stub
		for(int i=0;i<hilos.length;i++) {
			hilos[i].interrupt();
		}
	}

}

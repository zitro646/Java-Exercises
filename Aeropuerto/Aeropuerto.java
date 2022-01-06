package Aeropuerto;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.Semaphore;

public class Aeropuerto extends Observable implements Observer{

	//Creamos las clases
	public Thread[] lista = new Thread[4];
	public Semaphore semaforo = new Semaphore(1);
	public Thread n;
	
	public Aeropuerto() {
			
	}
	
	public void despegue() {
		
		for(int i=0;i<lista.length;i++) {
			
			Avion c = new Avion(i+"");
			c.addObserver(this);
			lista[i]= new Thread(c);
			c.setThread(lista[i]);
			lista[i].start();
			
			try {
				semaforo.acquire();
				System.out.println("Avion "+ i +" despegando");
				Thread.sleep(2000);
				semaforo.release();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
		try {
			Avion c = (Avion) o;
			semaforo.acquire();
			System.out.println("El avion "+c.getNombre()+" esta aterrizando, tardara 2 segundos");
			
			Thread.sleep(2000);
			
			semaforo.release();
			
			
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
}

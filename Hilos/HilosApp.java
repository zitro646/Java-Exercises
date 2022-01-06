package Hilos;

public class HilosApp {
	
	public static  void main (String[] args) {
		
		THilo hilo1 = new THilo(1);
		hilo1.start();
		THilo hilo3 = new THilo(2);
		hilo3.start();
		//hilo1.join();
		
		//Thread hilo2 = new Thread(new RHilo(2));
		//hilo2.start();
		//hilo2.join();
		
		
		
		
		
	}
	
}

package Hilos;

public class RHilo implements Runnable {

	private int id;

	public RHilo(int i) {
		this.id = i ;
	}
	
	public synchronized void run(){
		
		for (int i= 0; i<25; i++) {
			System.out.println("El hilo "+this.getId()+" se esta ejecutando");
		}
		
	}
	
	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}

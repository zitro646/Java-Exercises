package Hilos;

public class THilo extends Thread{

	
	private int id;

	public THilo(int i) {
		this.id = i ;
	}
	
	public static  void main (String[] args) {
		
		new Thread(new THilo(1)).start();
		new Thread(new THilo(2)).start();
	}
	
	public synchronized void  run(){
		
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

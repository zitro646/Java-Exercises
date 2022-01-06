package Inicio;

public class ConjuntoLibros {
	//encapsulamos los atributos de la clase
	private Libro[] conjunto;		//lectura, escritura
	
	//creamos el metodo constructor del objeto
	public ConjuntoLibros() {
		conjunto=new Libro[5];
	}
	
	//creamos los metodos necesarios (setter y getter)
	
	//comprobamos si se puede añadir un nuevo libro
	public boolean didAdd(Libro libro){
		for(int i=0; i<5; i++) {
			if(conjunto[i]==null) {
				conjunto[i]=libro;
				return true;
			}			
		}
		return false;
	}
	//comprobamos si existe titulo del libro para borrarlo
	public boolean didDeleteTitulo(String titulo) {
		for(int i=0; i<5; i++) {
			if(conjunto[i].getTitulo().equalsIgnoreCase(titulo)) {
				conjunto[i]=null;
				return true;
			}
		}
		return false;
	}
	//comprobamos si se existe el libro de x autor para borrarlo
	public boolean didDeleteAutor(String autor) {
			for(int i=0; i<5; i++) {
				if(conjunto[i].getAutor().equalsIgnoreCase(autor)) {
					conjunto[i]=null;
					return true;
				}
			}
			return false;
		
	}
	//obtenemos el libro con mayor nota
	public Libro getMayor() {
		Libro mayor;
		mayor=conjunto[0];
		for(int i=1; i<5; i++) {
			if(conjunto[i].getCalificacion()>mayor.getCalificacion()) {
				mayor.setCalificacion(conjunto[i].getCalificacion());
			}	
		}
		return mayor;
	}
	//obtenemos el libro con menor nota
	public Libro getMenor() {
		Libro menor;
		menor=conjunto[0];
		for(int i=1; i<5; i++) {
			if(conjunto[i].getCalificacion()>menor.getCalificacion()) {
				menor.setCalificacion(conjunto[i].getCalificacion());
			}	
		}
		return menor;
	}
	//obtener todos los atributos de los objetos
	public String getAll() {
		String todos="";
		for(int i=0; i<5; i++) {
			if(conjunto[i]!=null) {
				todos="Autor: "+conjunto[i].getAutor()+" , Título: "+conjunto[i].getTitulo()+" , Nº Hojas: "
						+conjunto[i].getPags()+" , Calificación"+conjunto[i].getCalificacion()+"\n";
			}
		}
		return todos;
	}
}

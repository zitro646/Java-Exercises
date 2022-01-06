package Inicio;

import java.util.Scanner;


//hay que crear 2 libros
//añadirlos al array
//eliminarlos por los dos criterios
//añadir otro libro
//mostrar el contenido total
public class PruebaLibros {

	public static void main(String[] args) {
	//creamos las variables necesarias
		String titulo="";
		String autor="";
		int nPags=0;
		double calificacion=0;
	//habilitamos la entrada por teclado
		Scanner entrada=new Scanner(System.in);
		
		
		
	//añadimos los dos libros
	//LIBRO 1
		Libro uno = new Libro(titulo, autor, nPags, calificacion);
		uno.setTitulo("Paca");
		uno.setAutor("Paco");
		uno.setPags(13);
		uno.setCalificacion(1.3);
				
	//LIBRO 2
		Libro dos = new Libro(titulo, autor, nPags, calificacion);
		dos.setTitulo("1984");
		dos.setAutor("George");
		dos.setPags(230);
		dos.setCalificacion(10);
		
		
		
	//los introducimos en el array
		ConjuntoLibros conj = new ConjuntoLibros();
		if(conj.didAdd(uno)==true) {
			System.out.println("Libro añadido correctamente");
		}
		else {
			System.out.println("El libro no se ha podido añadir (no se pueden añadir más)");
		}
		if(conj.didAdd(dos)==true) {
			System.out.println("Libro añadido correctamente");
		}
		else {
			System.out.println("El libro no se ha podido añadir (no se pueden añadir más)");
		}
		
		
		
		
	//los eliminamos
	//TITULO
		System.out.println("¿Cual es el nombre del libro que desea eliminar?");
		titulo=entrada.nextLine();
		if(conj.didDeleteTitulo(titulo)==true) {
			System.out.println("Libro eliminado");
		}
		else {
			System.out.println("No se ha encontrado ese libro");
		}
	//AUTOR
		System.out.println("¿Cual es el autor del libro que desea eliminar?");
		autor=entrada.nextLine();
		if(conj.didDeleteAutor(autor)==true) {
			System.out.println("Libro eliminado");
		}
		else {
			System.out.println("Ese autor no ha escrito ningun libro en nuestra biblioteca");
		}
		
		
	//AÑADIMOS EL ULTIMO LIBRO
		System.out.println("Introduzca el título del libro 1");
			titulo=entrada.nextLine();
		System.out.println("Introduzca el autor del libro 1");
			autor=entrada.nextLine();
		System.out.println("Introduzca el número de páginas del libro 1");
			nPags=entrada.nextInt();
			entrada.nextLine();
		System.out.println("Introduzca la calificación del libro 1");
			calificacion=entrada.nextDouble();
			entrada.nextLine();
		Libro tres = new Libro(titulo, autor, nPags, calificacion);
		if(conj.didAdd(tres)) {
			System.out.println("Libro añadido correctamente");
		}
		else {
			System.out.println("No se ha podido añadir el libro");
		}
		
		
	//MOSTRAMOS TODo
		
		System.out.println(conj.getAll());
		
		
		
		
		
		entrada.close();
	}
}

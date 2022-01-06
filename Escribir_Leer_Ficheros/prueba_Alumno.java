package Escribir_Leer_Ficheros;

public class prueba_Alumno {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Alumno a1 = new Alumno("Miguel",18,5);
		Alumno a2 = new Alumno("Angel",70,3);
		Alumno a3 = new Alumno("Miguelo",19,10);
		
		Lista_Alumnos a = new Lista_Alumnos();
		a.anadeAlumno(a1);
		a.anadeAlumno(a2);
		a.anadeAlumno(a3);
		String lista = a.transformaListaString();
		//a.imprimeLista(a.devuelvaLista());
		
		//a.escribeListaFileWriter("FileWriter.txt");
		//a.leeListaFileWriter("FileWriter.txt");
		
		//a.escribeListaBufferedWriter("BufferedWriter.txt");
		//a.leeListaBuferedWriter("BufferedWriter.txt");
		
		//a.escribeListaBinario("BinaryWriter.dat");
		//a.leeListaBinario("BinaryWriter.dat");
		
		//a.escribeListaData("DataWrite.txt");
		//a.leeListaData("DataWrite.txt");
		
		a.escribeListaObjetos("ObjectWrite.txt");
		a.leeListaObjetos("ObjectWrite.txt");
		
		System.out.println("DONE");
	}

}

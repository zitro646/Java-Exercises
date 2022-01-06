package Escribir_Leer_Ficheros;

import java.io.*;
import java.util.ArrayList;

public class Lista_Alumnos {
	//Creamos las variables
	private ArrayList<Alumno> lista ;
	
	//Creamos el constructor
	public Lista_Alumnos(){
		lista = new ArrayList<Alumno>();
	};
	
	//Creamos los metodos
	
	//Metodo que añade alumnos a la lista
	public void anadeAlumno(Alumno a){
		
		lista.add(a);
		
	}
	
	//Metodo para eliminar la lista
	public void eliminaLista(){
		lista.clear();
	}
	
	//Metodo para devuelva la lista
	public ArrayList<Alumno> devuelvaLista(){
		return lista;
	}
	
	//Añadimos el metodo Imprime Lista
	public void imprimeLista(ArrayList<Alumno> lista){
		
		for(int i=0;i<lista.size();i++){
			System.out.println("Nombre: "+lista.get(i).getNombre()+"\nEdad: "+lista.get(i).getEdad()+"\nCalificacion: "+lista.get(i).getCalificacion()+"\n______________\n");
		}
		
	}
	
	//Añadimos el metodo convierta Lista a String
	public String transformaListaString(){
		String list="";
		for(int i=0;i<lista.size();i++){
			list=list+"Nombre: "+lista.get(i).getNombre()+"\nEdad: "+lista.get(i).getEdad()+"\nCalificacion: "+lista.get(i).getCalificacion()+"\n______________\n";
		}
		
		return list;
		
	}
	
	//Metodo de Escritura/Lectura
	
	//Escritura FileWriter
	public void escribeListaFileWriter(String direcctorio){
			try {
				FileWriter grabador = new FileWriter("direcctorio");//Se instancia el fichero a escribir.
				for(int pos=0;pos<lista.size();pos++){
					grabador.write(lista.get(pos).getNombre()+"\n"+ lista.get(pos).getEdad()+"\n"+ lista.get(pos).getCalificacion()+"\n");
				}
				grabador.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	//Lectura FileReader
	public void leeListaFileWriter(String directorio){
		try {
			FileReader lector = new FileReader(directorio);//Instanciamos el lector
			int let = 0;
			for(int pos=0;let!=-1;pos++){
				let = lector.read();//metemos los valores en una variable(lee en int)
				if(let!=-1) {
					System.out.print(((char)(let)));
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
	
	//____________________________________________
	
	//Metodo Buffered
	
	//Escritura BufferedWriter
	public void escribeListaBufferedWriter(String directorio){
		try {
			BufferedWriter grabador = new BufferedWriter (new FileWriter(directorio));//Crea un fichero apartir de un FileWriter
			for(int pos=0;pos<lista.size();pos++){
				grabador.write(lista.get(pos).getNombre());
				grabador.newLine();
				grabador.write(lista.get(pos).getEdad());
				grabador.write((int) lista.get(pos).getCalificacion());
			}
			grabador.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Lectura BufferedReader
	public void leeListaBuferedWriter(String directorio){
		try {
			BufferedReader lector = new BufferedReader(new FileReader(directorio));//Crea un fichero apartir de un FileWriter
			while(lector.ready()) { //lee el fichero hasta que no continue
						System.out.println("Nombre : " + lector.readLine());//Lee la linea entera y la interpreta como String
						System.out.println("Edad : "+lector.read()); //Lee el caracter como un int
						System.out.println("Calificacion : "+lector.read());
			}
			lector.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//____________________________________________________
	
	//Metodo Binario(Bytes)
	//Escritura FileOutputStream
	
	public void escribeListaBinario(String directorio){
		
		String texto_grabar=this.transformaListaString();
	
		
		try {
			FileOutputStream grabador = new FileOutputStream (directorio);//Crea un fichero en bytes
			for(int i=0;i<=texto_grabar.length()-1;i++){
				
				grabador.write((int)(texto_grabar.charAt(i))); //Introduce el caracter en el fichero como un byte
				
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	//Lectura FileInputStream
	public void leeListaBinario(String directorio){
		
		try {
			FileInputStream lee = new FileInputStream(directorio);
			
			int i=0;
			
				while ((i = lee.read()) != -1){
					   System.out.print((char)(i));
				   } 
				
			   lee.close();    
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	//___________________________________________________________
		
	//Metodo Ficheros Data
	//Escritura DataOutputStream
	
	public void escribeListaData(String directorio){
		
		try {
			FileOutputStream g = new FileOutputStream (directorio,false);
			DataOutputStream grabador = new DataOutputStream(g);
			for(int i=0;i<lista.size();i++){
				grabador.writeUTF(lista.get(i).getNombre());
				grabador.writeInt(lista.get(i).getEdad());
				grabador.writeDouble(lista.get(i).getCalificacion());
				
			}
			
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//*************************************************************************************
	//Lectura DataInputStream
	public void leeListaData (String directorio){
		
		
		try{
			FileInputStream l = new FileInputStream (directorio);
			DataInputStream lee = new DataInputStream(l);
			
			String n="";
			int e=0;
			double d=0;
			try {
				while (true){
					
					n = lee.readUTF();
					e = lee.readInt();
					d = lee.readDouble();
					System.out.println("\nNombre : "+n+"\nEdad : "+e+"\nCalificacion : "+d);
					   
				   }
			}catch (EOFException eo) {}
			
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	//*************************************************************
	

	//_________________________________________
	
	//Metodo Ficheros de Objetos
	//Escribir Objetos
	
	public void escribeListaObjetos(String directorio) {
		
		
		try {
			FileOutputStream  fileout = new FileOutputStream(directorio,false);
			ObjectOutputStream grabador = new ObjectOutputStream(fileout);  
			
			for(int i=0;i<lista.size();i++){
				 
				grabador.writeObject(lista.get(i));
				
			}
			
			grabador.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//Leer Objetos
	public void leeListaObjetos(String directorio) {
		
		
		try {
			ObjectInputStream dataIS = new ObjectInputStream(new FileInputStream(directorio));
			
			int i=1;
			
			while (true) { // lectura del fichero
				Alumno a = (Alumno) dataIS.readObject(); // leer una Persona
				System.out.print(i + "=>");
				i++;
				System.out.printf("Nombre: "+a.getNombre()+"\n Edad: "+a.getEdad()+"\n Calificacion: "+a.getCalificacion()+"\n");

			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}

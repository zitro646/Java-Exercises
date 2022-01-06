package Practica;

import java.io.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class CrearFichCliente {
	
	public static class MiObjectOutputStream extends ObjectOutputStream {
		//Constructor que recibe OutputStream
		public MiObjectOutputStream(OutputStream out) throws IOException {
			super(out);
		}
		
		//Constructor sin parametros
		protected MiObjectOutputStream() throws IOException, SecurityException {
			super();
		}
		
		//Redefinimos el método de escribir la cabecera para que no haga nada
		protected void writeStreamHeader() throws IOException {
			
		}

	}


	public static void main(String[] args) throws IOException{
		Scanner entradaEleccion=new Scanner(System.in);
		Scanner entradaObjeto=new Scanner (System.in);
		
		// Instanciamos la fecha 
		Date fecha=new Date();
		DateFormat formatoFecha=new SimpleDateFormat("dd-MM-yyyy");
		String historial=formatoFecha.format(fecha);
		
		//Definimos la variable Cliente
		Cliente cliente;
		
		int id=0;
		int nFicheros=0;
		int opcion=0;
		String nombre, direccion, poblacion, telef, nif;
		
		//Definimos el directorio
		File dir=new File("C:\\Users\\diego\\eclipse-workspace\\Practica_1ºTrim");
		
		//Con el siguiente metodo recuperaremos el numero de ficheros contenidos en la ruta especificada
		String [] cuentaFicheros=dir.list();
		
		if(cuentaFicheros == null) {
			System.out.println("No hay ficheros en el directorio");
		}else {
			for (int i=0; i<cuentaFicheros.length; i++) {
			System.out.println(cuentaFicheros[i]);	
			}
		}
		//Obtenemos el numero de ficheros
		nFicheros=cuentaFicheros.length-8;
		//Declaramos el fichero
		File fichero=new File("CLIENTES_"+historial+"_"+nFicheros+".bin");
		
		//Conectamos el flujo de bytes al flujo de datos
		ObjectOutputStream dataOS;
		
		//Si el fichero no existe tenemos que incluir la cabecera de clase
		if (!fichero.exists()) {
			FileOutputStream ficheroOut=new FileOutputStream(fichero, false);
			dataOS=new ObjectOutputStream(ficheroOut);
		}else {//De lo contrario, no incluimos la cabecera de clase
			FileOutputStream ficheroOut=new FileOutputStream(fichero, true);
			dataOS= new MiObjectOutputStream(ficheroOut);
		}
		
		while (opcion != 2) {
			System.out.println("¿Que desea hacer?");
			System.out.println("Añadir un cliente: (1)");
			System.out.println("Salir: (2)");
			opcion=entradaEleccion.nextInt();
			
			switch(opcion) {
			case 1:
				
				System.out.println("Nombre del cliente");
				nombre=entradaObjeto.nextLine();	
				System.out.println("Direccion");
				direccion=entradaObjeto.nextLine();
				System.out.println("Poblacion");
				poblacion=entradaObjeto.nextLine();
				System.out.println("Telefono");
				telef=entradaObjeto.nextLine();
				/*while(telef.length()>=10 || telef.length()<=8) {
					System.out.println("Nº incorrecto, vuelve a introducirlo");
					telef=entradaObjeto.nextLine();
				}*/
				System.out.println("NIF");
				nif=entradaObjeto.nextLine();
				System.out.println("ID del cliente");
				id=entradaObjeto.nextInt();
				
				//Escribimos el objeto
				cliente=new Cliente(id, nombre, direccion, poblacion, telef, nif);
				//Y lo introducimos en el fichero
				dataOS.writeObject(cliente);
				
				System.out.println("Cliente creado correctamente");
				
				break;
			case 2:
				System.out.println("Operación finalizada");
				
				break;
			default:
				System.out.println("Opción no válida");
			}
		}
		entradaEleccion.close();
		entradaObjeto.close();
		dataOS.close();
		
	}
	

}

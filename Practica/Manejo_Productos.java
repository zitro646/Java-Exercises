package Practica;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Manejo_Productos {
	
	public static void main(String[] args){
		// TODO Auto-generated method stub
		
		Manejo_Productos n = new Manejo_Productos();
		n.menu_opciones();
		
		System.out.println("Fin");
	}
	
	//Creamos las variables
	ArrayList<Producto> lista ;
	
	//Creamos el constructor
	public Manejo_Productos() {
		lista = new ArrayList<Producto>();
	}
	
	//Creamos los metodos necesarios para realizar las operaciones necesarias
	public void menu_opciones() {
		
		Scanner entrada = new Scanner (System.in);
		boolean fin=false;
		do {
			
			System.out.println("Que deseas hacer?\n1.Añadir un producto al array\n2.Generar un archivo con los productos guardados.");
			char n = entrada.nextLine().charAt(0);
			
			switch (n) {
			case '1':
				this.añade_producto_array();
				break;
			case '2':
				this.generar_archivo_binario();
				break;
			case '3':
				fin=true;
				break;
			case '4':
				this.Lee();
				break;
			default:
				break;
			
			}
			
		}while(fin==false);
		
		
	}
	
	//Creamos una metodo que añada productos al array
	public void añade_producto_array() {
		
		Scanner entrada = new Scanner (System.in);
		System.out.println("\nIntroduzca el Id del producto");
		int id = entrada.nextInt();
		
		System.out.println("\nAhora introduce la descripcion del producto");
		String descripcion = entrada.next();
		entrada.nextLine();
		
		System.out.println("\nAhora introduce la cantidad de objetos de esta categoria");
		int stock = entrada.nextInt();
		
		System.out.println("\nAhora introduce el precio del producto");
		double pvp = entrada.nextDouble();
		
		Producto x = new Producto(id,descripcion,stock,pvp);
		System.out.println(x.getId()+","+descripcion+","+x.getPvp()+","+x.getStockanual());
		lista.add(x);
	}
	
	
	//Creamos el metodo que genera archivos binarios 
	public void generar_archivo_binario(){
		
		//Instanciamos la fecha 
		Calendar fecha = new GregorianCalendar();
		
		
		int año=fecha.get(Calendar.YEAR);
		int mes=fecha.get(Calendar.MONTH);
		int dia=fecha.get(Calendar.DAY_OF_MONTH);
		
		String historial = String.valueOf(dia)+"-"+String.valueOf(mes)+"-"+String.valueOf(año);
		//Instanciamos el numero
		int numero = 1;
		boolean fin=false;
		String frase= "PRODUCTOS"+historial+"_"+numero+".dat";
		
		
		
		try {
			
			
			//El comprobamos que el fichero no existe,si existiera cambiamos el nombre del fichero.
			do {
				//Instanciamos el fichero
				File archivo = new File(frase);
				//Si el fichero no existe no se guardara, si existe simplemente dara una vuelta.
				if(!archivo.exists()) {
					
					//Escribimos los datos del fichero
					DataOutputStream escribe = new DataOutputStream (new FileOutputStream (frase,true));
				
					for(int i=0;i<lista.size();i++) {
						
						escribe.write(lista.get(i).getId());
						escribe.writeUTF(lista.get(i).getDescripcion());
						escribe.write(lista.get(i).getStockanual());
						escribe.writeDouble(lista.get(i).getPvp());
					}
					
					escribe.close();
					System.out.println("Fichero creado bajo el nombre de "+frase);
					fin=true;
				}else {
					numero++;
					frase= "PRODUCTOS"+historial+"_"+numero+".dat";
				}
				
			}while(fin==false);
		
			
			
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	public void Lee () {
		
		try {
			DataInputStream lee = new DataInputStream (new FileInputStream ("PRODUCTOS8-10-2019_1.dat"));
			
				int id;
				String des;
				int stock;
				double pvp;
				
				while(true) {
					
					id = lee.read();
					des = lee.readUTF();
					stock = lee.read();
					pvp = lee.readDouble();
					
					System.out.println(id+","+des+","+stock+","+pvp+"€");
				}
		}catch (EOFException eo) {} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
}


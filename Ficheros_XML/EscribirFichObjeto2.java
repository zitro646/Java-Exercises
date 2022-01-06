/* Ejemplo con la clase ObjectOutputStream que escribe un objeto completo
 en un archivo. Previamente se ha de serializar el objeto, es decir, transformar
 un objeto en una secuencia de bytes.
 En este ejemplo los nuevos objetos se añaden al final del archivo, lo que
 provoca un error: se inserta otra cabecera lo que genera una excepcion
 StreamCorruptedException al leerlo.
*/
package Tipos_XML;
import java.io.*; 


public class EscribirFichObjeto2{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persona persona;
		String nombres[]={"Ana","Luis","Alicia"};
		
		int edades[]={18, 45, 56};

		System.out.println("Programa iniciando");
		
		try{
			File f=new File("ficheroPersonas.dat");
			// Se va a escribir en el fichero al final del mismo
			//sin borrar el contenido previo
			if (!f.exists()){
				FileOutputStream ficheroOut=new FileOutputStream(f);
				//conecta el flujo de bytes al de datos
				ObjectOutputStream dataOS=new ObjectOutputStream(ficheroOut);
				for (int i=0; i<edades.length;i++){
					persona=new Persona(nombres[i],edades[i]);
					dataOS.writeObject(persona);
				}
				dataOS.close();	
			}else{
				FileOutputStream ficheroOut=new FileOutputStream(f,true);
				//DatoOS no escribirá la cabecera
				MiObjectOutputStream dataOS=new MiObjectOutputStream(ficheroOut);
				for (int i=0; i<edades.length;i++){
					persona=new Persona(nombres[i],edades[i]);
					dataOS.writeObject(persona);
				}
				dataOS.close();	
			}
			

		} catch (IOException e) {
			
			System.out.println("Problema al escribir en el fichero");
		}

	}

}

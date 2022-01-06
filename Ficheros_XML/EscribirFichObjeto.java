/* Ejemplo con la clase ObjectOutputStream que escribe un objeto completo
 en un archivo. Previamente se ha de serializar el objeto, es decir, transformar
 un objeto en una secuencia de bytes.
*/
package Tipos_XML;
import java.io.*; 


public class EscribirFichObjeto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persona persona;
		
		System.out.println("Programa iniciando");
		
		try{
			File f=new File("ficheroPersonas.dat");
			FileOutputStream ficheroOut=new FileOutputStream(f);
			//conecta el flujo de bytes al de datos
			ObjectOutputStream dataOS=new ObjectOutputStream(ficheroOut);
			
			String nombres[]={"Ana","Luis","Alicia"};
			
			int edades[]={18, 45, 56};
			
			for (int i=0; i<edades.length;i++){
				persona=new Persona(nombres[i],edades[i]);
				dataOS.writeObject(persona);
			}
			dataOS.close();	
		} catch (IOException e) {
			
			System.out.println("Problema al escribir en el fichero");
		}

	}

}


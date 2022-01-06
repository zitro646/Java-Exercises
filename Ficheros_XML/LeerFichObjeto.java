/* Ejemplo con la clase ObjectInputStream que lee un objeto completo
 en un archivo. En este caso el flujo de bytes se deserializa de un flujo de
 bytes a un objeto 
*/
package Tipos_XML;
import java.io.*;

public class LeerFichObjeto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persona persona;
		try {
			File f=new File("ficheroPersonas.dat");
			FileInputStream ficheroOut=new FileInputStream(f);
			//conecta el flujo de bytes al de datos
			ObjectInputStream dataIS=new ObjectInputStream(ficheroOut);
			
			//leemos el primer objeto
			persona= (Persona) dataIS.readObject();
			while (persona!=null){ //en realidad el bucle termina con la excepcion EOFException 
				System.out.printf("Nombre %s, edad %d \n",persona.getNombre()
						,persona.getEdad());
				persona= (Persona) dataIS.readObject();
				
			}
			dataIS.close();
			
		} catch (IOException e) {
			if (e instanceof EOFException){ //Es un tipo de EOFException
				System.out.println("Fin de Fichero");
			} else
				System.out.println("Problema al leer del fichero "+ e);
		
		} catch (ClassNotFoundException e) {
			
			System.out.println("Clase no encontrada "+ e);
		} 
		
		
	}

}

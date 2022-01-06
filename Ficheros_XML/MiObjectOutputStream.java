package Tipos_XML;
import java.io.*;

public class MiObjectOutputStream extends ObjectOutputStream {
	
	public MiObjectOutputStream(OutputStream out) throws IOException{
		super(out);
	}
	//Redefinici�n del m�todo de escribir cabecera
	//para que no haga nada, en caso de que ya se haya escrito
	// Esto ultimo se controlar� en el programa principal
	
	protected void writeStreamHeader() throws IOException{
		//nada, no escribe cabecera
	}

}

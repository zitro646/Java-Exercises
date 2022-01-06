package Tipos_XML;
import java.io.*;

public class MiObjectOutputStream extends ObjectOutputStream {
	
	public MiObjectOutputStream(OutputStream out) throws IOException{
		super(out);
	}
	//Redefinición del método de escribir cabecera
	//para que no haga nada, en caso de que ya se haya escrito
	// Esto ultimo se controlará en el programa principal
	
	protected void writeStreamHeader() throws IOException{
		//nada, no escribe cabecera
	}

}

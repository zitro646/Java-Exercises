package Tipos_XML;
import java.io.*;
public class EscribirFicheroAleatorio {
	public static final int tamanoEnBytes =Integer.SIZE/8+Integer.SIZE/8+Double.SIZE/8+20;
	
	public static void main(String[] args) throws IOException {
		File fichero=new File("AleatorioEmple.dat");
		RandomAccessFile file=new RandomAccessFile(fichero,"rw");
		
		String apellido[]={"FERNANDEZ","GIL","LOPEZ","AA"};
		int dep[]={10,20,10,20};
		Double[] salario={1000.45,200.0,555.5,33.55};
	
		
		System.out.println(tamanoEnBytes);
		
		StringBuffer buffer=null;
		int n=apellido.length;
		file.seek(0);
		for (int i=0;i<n;i++){
			file.writeInt(i+1);
			buffer=new StringBuffer(apellido[i]);
			buffer.setLength(10);
			file.writeChars(buffer.toString());
			file.writeInt(dep[i]);
			file.writeDouble(salario[i]);
		}
		
		System.out.println(fichero.length());
		file.close();
	}


}

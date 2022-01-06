package Tipos_XML;

import java.io.*;

public class LeerFichAleatorio {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File fichero=new File("AleatorioEmple.dat");
		RandomAccessFile file=new RandomAccessFile(fichero,"r");
		
		int id, dep, posicion=0;
		Double salario;
		char apellido[]= new char[10];
		char aux;
		
		file.seek(posicion);
		while (file.getFilePointer()!=file.length()){
			file.seek(posicion);
			id=file.readInt();
			for (int i=0;i<apellido.length;i++){
				aux=file.readChar();
				apellido[i]=aux;
			}
			String apellidos=new String(apellido);
			dep=file.readInt();
			salario=file.readDouble();
			
			if (id>0){
				System.out.printf("ID: %d, Apellido:%s, Departamento: %d, Salario: %.1f",id,
						apellidos, dep, salario);
			}
			posicion=posicion+36;
			System.out.println(posicion);

		}
		
		file.close();

	}
		

	

}

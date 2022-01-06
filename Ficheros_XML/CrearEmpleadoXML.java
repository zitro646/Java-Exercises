package Tipos_XML;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;

public class CrearEmpleadoXML {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		File fichero=new File("AleatorioEmple.dat");
		
		RandomAccessFile file=new RandomAccessFile(fichero,"r");
		int id,dep, posicion=0;
		Double salario;
		char apellido[] =new char[10];
		char aux;
		
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		
		try{
			DocumentBuilder builder=factory.newDocumentBuilder();
			DOMImplementation implementation=builder.getDOMImplementation();
			Document doc= implementation.createDocument(null, "Empleados", null);
			
			doc.setXmlVersion("1.0");
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
					Element empleado=doc.createElement("empleado");
					doc.getDocumentElement().appendChild(empleado);
					
					CrearElemento("id",Integer.toString(id),empleado,doc);
					CrearElemento("apellido",apellidos.trim(),empleado,doc);
					CrearElemento("dep",Integer.toString(dep),empleado,doc);
					CrearElemento("salario",Double.toString(salario),empleado,doc);
				}
				posicion=posicion+36;

			}
			
			Source source = new DOMSource(doc);
			Result result=new StreamResult(new File("Empleados.xml"));
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.transform(source,result);
			
			
		}catch (Exception e){
			System.out.println("Error "+e);
		}
		
		file.close();

	}

	static void CrearElemento(String datoEmple, String valor, Element raiz, Document doc){
		
		Element elem=doc.createElement(datoEmple);
		Text text = doc.createTextNode(valor);
		raiz.appendChild(elem);
		elem.appendChild(text);
		
	}
	
	
}


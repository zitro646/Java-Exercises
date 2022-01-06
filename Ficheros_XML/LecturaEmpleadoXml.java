package Tipos_XML;
import java.io.*;

import javax.xml.parsers.*;

import org.w3c.dom.*;

public class LecturaEmpleadoXml {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		try{
			DocumentBuilder builder=factory.newDocumentBuilder();
			Document doc=builder.parse(new File("Empleados.xml"));
			doc.getDocumentElement().normalize();
			System.out.println("Elemento raiz: "+doc.getDocumentElement().getNodeName());
			
			NodeList empleados=doc.getElementsByTagName("empleado");
			
			System.out.println("Nodos Empleado a recorrer: "+empleados.getLength());
			
			for (int i=0; i<empleados.getLength();i++){
				
				Node emple = empleados.item(i);
				Element elemento = (Element) emple;
				System.out.printf("id: %s apellido: %s Departamento: %s salario: %s %n",
						elemento.getElementsByTagName("id").item(0).getTextContent(),
						elemento.getElementsByTagName("apellido").item(0).getTextContent(),
						elemento.getElementsByTagName("dep").item(0).getTextContent(),
						elemento.getElementsByTagName("salario").item(0).getTextContent());
				
			}
			
		}catch (Exception e){
			System.out.println(e);
		}
	
	}

}

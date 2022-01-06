package Tipos_XML;
import java.util.*;

public class ListaPersonas {
	private ArrayList<Persona> lista;
	
	public ListaPersonas(){
		lista=new ArrayList<Persona>();
	};
	
	public void add(Persona per){
		lista.add(per);
	}
	
	public ArrayList<Persona> getListaPersonas(){
		return lista;
	}
	
}

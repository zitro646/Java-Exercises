package Servidor;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Observable;
import java.util.Scanner;

public class Servidor extends Observable implements Runnable{
	
	String mensaje;
	String cliente;
	ArrayList<String> listado;
	ArrayList<String> fecha_registro;
	ArrayList<String> clientes;
	public Servidor() {
		listado = new ArrayList<String>();
		fecha_registro = new ArrayList<String>();
		clientes = new ArrayList<String>();
	}
	
	@Override
	public void run() {
		ServerSocket servidor = null;
		Socket socket = null;
		final int Puerto=5000;
		DataInputStream in;
		DataOutputStream out;
		
		try {
			servidor = new ServerSocket(Puerto);
			System.out.println("Servidor iniciado");
			
			while(true) {
				
				socket = servidor.accept();
				in = new DataInputStream(socket.getInputStream());
				out = new DataOutputStream(socket.getOutputStream());
				
				String msg = in.readUTF();
				String clt = in.readUTF();
				this.setMensaje(msg);
				this.setCliente(clt);
				if(!msg.equals("")) {
					
					this.setChanged();
					this.notifyObservers();
					this.clearChanged();
					
					this.anadirClientes(clt);
					this.anadirListado(msg);
					this.anadiRegistrofechas(this.fecha_ahora());
					//System.out.println(this.fecha_ahora());
					
					out.writeInt(listado.size());
					for(int i=0;i<listado.size();i++) {
						
						out.writeUTF(this.getClientesposicion(i));
						out.writeUTF(this.getposicionListado(i));
						out.writeUTF(this.getposicionRegistroFecha(i));//
						
					}
					this.setMensaje("");
				}
				
				
				socket.close();
			}
		}catch(IOException e) {
			System.out.println("Error");
		}
		
		
		
	}
	
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String m) {
		mensaje = m;
	}
	
	public ArrayList<String> getArrayLists() {
		return listado;
	}
	public void anadirListado(String m) {
		listado.add(m);
	}
	public String getposicionListado (int pos) {
		return listado.get(pos);
	}
	public void anadiRegistrofechas(String m) {
		fecha_registro.add(m);
	}
	public String getposicionRegistroFecha (int pos) {
		return fecha_registro.get(pos);
	}
	public void anadirClientes(String m) {
		clientes.add(m);
	}
	public String getClientesposicion (int pos) {
		return clientes.get(pos);
	}
	public void setCliente(String c) {
		cliente = c;
	}
	public String getCliente() {
		return cliente;
	}
	public String fecha_ahora() {
		
		Calendar fecha = new GregorianCalendar();
				
		int año=fecha.get(Calendar.YEAR);
		int mes=fecha.get(Calendar.MONTH);
		int dia=fecha.get(Calendar.DAY_OF_MONTH);
		int hora=fecha.get(Calendar.HOUR_OF_DAY);
		int minuto=fecha.get(Calendar.MINUTE);
		int sec=fecha.get(Calendar.SECOND);
		String historial = String.valueOf(hora)+":"+String.valueOf(minuto)+":"+String.valueOf(sec)+".";//+"__"+String.valueOf(dia)+"-"+String.valueOf(mes)+"-"+String.valueOf(año)+
		
		return historial;
	}
	
}

package Servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Scanner;

public class Cliente extends Observable implements Runnable {	
		
	
	ArrayList<String> listado;
	public Cliente() {
		listado = new ArrayList<String>();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String HOST = "127.0.0.1";
		int Puerto = 5000;
		
		DataInputStream in;
		DataOutputStream out;
		Scanner entrada = new Scanner(System.in);
		
		try {
			
			while(true) {
				Socket socket = new Socket("127.0.0.1",5000);
				in = new DataInputStream(socket.getInputStream());
				out = new DataOutputStream(socket.getOutputStream());
				
				
				String msg = in.readUTF();
				System.out.println(msg);
				
				socket.close();
			}
			
		}catch(IOException e) {
			System.out.println("Error");
			
		}
	}
	
	
}

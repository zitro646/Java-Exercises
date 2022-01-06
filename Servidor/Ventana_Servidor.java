package Servidor;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Ventana_Servidor extends JFrame implements Observer {

	private JPanel contentPane;
	private JButton btnBoton;
	private String mensajes;
	private Servidor server;
	private boolean estado;
	private JTable table;
	private DefaultTableModel model;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana_Servidor frame = new Ventana_Servidor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ventana_Servidor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 240);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		model = new DefaultTableModel ();
		model.addColumn("Cliente");
		model.addColumn("Mensaje");
		model.addColumn("Fecha");
		table.setModel(model);
		
		estado = false;
		mensajes = "";
		
		server = new Servidor();
		server.addObserver(this);
		Thread servidor = new Thread(server);
		servidor.start();
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
			Servidor c = (Servidor) o;
			//System.out.println("Servidor Ventana :"+c.getMensaje());
			String[] b = {c.getCliente(),c.getMensaje(),c.fecha_ahora()};
			model.addRow(b);
		
	}
}

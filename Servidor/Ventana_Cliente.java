package Servidor;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Ventana_Cliente extends JFrame implements ActionListener{

	private JPanel contentPane;
	private String cliente;
	private JTextField textField;
	private String HOST = "127.0.0.1";
	private int Puerto = 5000;
	private DataInputStream in;
	private DataOutputStream out;
	Socket socket;
	private JTable table;
	private DefaultTableModel model;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana_Cliente frame = new Ventana_Cliente();
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
	public Ventana_Cliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 297);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(100, 12, 280, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Enviar");
		btnNewButton.setBounds(390, 11, 89, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(this);
		
		JLabel lblEscribaElTexto = new JLabel("Escriba el texto");
		lblEscribaElTexto.setBounds(10, 15, 153, 14);
		contentPane.add(lblEscribaElTexto);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 43, 469, 205);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		model = new DefaultTableModel ();
		model.addColumn("Cliente");
		model.addColumn("Mensaje");
		model.addColumn("Fecha");
		table.setModel(model);
		cliente = "Cliente 1";
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String envio = textField.getText();
		if(!envio.equals("")) {
			try {
				socket = new Socket("127.0.0.1",5000);
				
				out = new DataOutputStream(socket.getOutputStream());
				out.writeUTF(envio);
				out.writeUTF(cliente);
				textField.setText("");
				
				in = new DataInputStream(socket.getInputStream());
				int tam = in.readInt();
				
				while(model.getRowCount()>=1) {
					model.removeRow(0);
				}
				
				for(int i=0;i<tam;i++) {
					String[] x = {in.readUTF(),in.readUTF(),in.readUTF()};
					model.addRow(x);
				}
				socket.close();
				
			}catch(IOException e) {
				System.out.println("Error");
				
			}
		}
		
	}
}

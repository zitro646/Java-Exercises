package Practica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Statement;

import java.awt.CardLayout;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Prueba_Clientes extends JFrame {

	private JPanel contentPane;
	private JTextField textID;
	private JTextField textNombre;
	private JTextField textDireccion;
	private JTextField textPoblacion;
	private JTextField textTelef;
	private JTextField textNIF;
	private JTextField textNIF2;
	private JTextField textID2;
	private JTextField textNombre2;
	private JTextField textDireccion2;
	private JTextField textPoblacion2;
	private JTextField textTelef2;
	private String tipo_conexion;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(final String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					Prueba_Clientes frame = new Prueba_Clientes();
					//Para no ver la ventana como si fuese del siglo pasado
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					SwingUtilities.updateComponentTreeUI(frame);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/
	/**
	 * Create the frame.
	 */
	public Prueba_Clientes(String tipo) {
		
		setResizable(false);
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
		
		tipo_conexion=tipo;
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 849, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, "name_506575882201900");
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Importar", null, panel_5, null);
		panel_5.setLayout(null);
		
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setBounds(29, 13, 755, 397);
		int status = fileChooser.showOpenDialog(null);
		panel_5.add(fileChooser);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Insertar", null, panel_1, null);
		
		panel_1.setLayout(null);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(29, 71, 56, 16);
		panel_1.add(lblId);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(134, 71, 56, 16);
		panel_1.add(lblNombre);
		
		JLabel lblNewLabel = new JLabel("Direccion");
		lblNewLabel.setBounds(256, 71, 56, 16);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Poblacion");
		lblNewLabel_1.setBounds(404, 71, 56, 16);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Telef");
		lblNewLabel_2.setBounds(543, 71, 56, 16);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("NIF");
		lblNewLabel_3.setBounds(696, 71, 56, 16);
		panel_1.add(lblNewLabel_3);
		
		textID = new JTextField();
		textID.setBounds(29, 129, 40, 22);
		panel_1.add(textID);
		textID.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setBounds(134, 129, 73, 22);
		panel_1.add(textNombre);
		textNombre.setColumns(10);
		
		textDireccion = new JTextField();
		textDireccion.setBounds(256, 129, 83, 22);
		panel_1.add(textDireccion);
		textDireccion.setColumns(10);
		
		textPoblacion = new JTextField();
		textPoblacion.setBounds(404, 129, 73, 22);
		panel_1.add(textPoblacion);
		textPoblacion.setColumns(10);
		
		textTelef = new JTextField();
		textTelef.setBounds(543, 129, 83, 22);
		panel_1.add(textTelef);
		textTelef.setColumns(10);
		
		textNIF = new JTextField();
		textNIF.setBounds(696, 129, 73, 22);
		panel_1.add(textNIF);
		textNIF.setColumns(10);
		
		JLabel lblIntroduceLosDatos = new JLabel("Introduce los datos del nuevo cliente");
		lblIntroduceLosDatos.setFont(new Font("Tahoma", Font.ITALIC, 17));
		lblIntroduceLosDatos.setForeground(Color.RED);
		lblIntroduceLosDatos.setBounds(256, 0, 281, 16);
		panel_1.add(lblIntroduceLosDatos);
		
		JButton botonInsertar = new JButton("Insertar");
		botonInsertar.setIcon(new ImageIcon(".\\iconoInsertar.png"));
		botonInsertar.setBounds(334, 243, 193, 73);
		botonInsertar.addActionListener(new ActionListener() {
////////////MÉTODO INSERTAR
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
	
				try {
					Connection conexion;
					if(tipo_conexion.equals("1")) {
						Class.forName("com.mysql.jdbc.Driver");// Cargar el driver
						// Establecemos la conexion con la BD
						conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/practica1", "root", "");
						
					}else {
						//Cargamos el driver
						Class.forName("org.sqlite.JDBC");
						//Establecemos conexión con la BD
						conexion=DriverManager.getConnection
						 ("jdbc:sqlite:C:\\Users\\Miguel\\Downloads\\sqlite-tools-win32-x86-3300100\\practica1.db");
						
					}
					System.out.println("prueba");
					String sql1= "SELECT * FROM clientes WHERE ID_Cliente = ? OR NIF = ?";
					ResultSet resultado;
					PreparedStatement sentenciaSQL1= conexion.prepareStatement(sql1);
					
					sentenciaSQL1.setString(1, textID.getText());
					sentenciaSQL1.setString(2, textNIF.getText());
					
					resultado=sentenciaSQL1.executeQuery();
					//Comprobamos que el campo de nombre no está vacío
					if (textNombre.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "ERROR: No puedes dejar el campo del NOMBRE vacío");
						
						sentenciaSQL1.close();
						conexion.close();
					//Realizamos el control de errores estandar	
					}else if(resultado.next()) {
						JOptionPane.showMessageDialog(null, "ERROR: El ID o el NIF introducidos ya existe");
						
						sentenciaSQL1.close();
						conexion.close();
					}else {
					
					//Preaparamos la sentencia SQL
					//Preparamos las sentencias sql
					String sql2 = "INSERT INTO clientes VALUES ( ? , ? , ? , ? , ? , ? )";
					PreparedStatement sentenciaSQL2= conexion.prepareStatement(sql2);
					
					sentenciaSQL2.setString(1, textID.getText());
					System.out.println(textID.getText());
					sentenciaSQL2.setString(2, textNombre.getText());
					System.out.println(textNombre.getText());
					sentenciaSQL2.setString(3, textDireccion.getText());
					System.out.println(textDireccion.getText());
					sentenciaSQL2.setString(4, textPoblacion.getText());
					System.out.println(textPoblacion.getText());
					sentenciaSQL2.setString(5, textTelef.getText());
					System.out.println(textTelef.getText());
					sentenciaSQL2.setString(6, textNIF.getText());
					System.out.println(textNIF.getText());
					sentenciaSQL2.executeUpdate();
					System.out.println("Cliente introducido correctamente");
					
					JOptionPane.showMessageDialog(null, "Cliente introducido correctamente");
					
					sentenciaSQL1.close();
					sentenciaSQL2.close();
					conexion.close();
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					System.out.println("Driver obtenido");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("Error al ejecutar la sentencia SQL");
				}
				
			}
			
		});
		panel_1.add(botonInsertar);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Cons/Act/Borr", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblNifDelCliente = new JLabel("NIF del cliente a consultar");
		lblNifDelCliente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNifDelCliente.setBounds(12, 25, 181, 16);
		panel_2.add(lblNifDelCliente);
		
		textNIF2 = new JTextField();
		textNIF2.setBounds(12, 54, 116, 22);
		panel_2.add(textNIF2);
		textNIF2.setColumns(10);
		
		JButton botonConsultar = new JButton("Consultar");
		botonConsultar.setIcon(new ImageIcon(".\\iconoConsultar.png"));
		botonConsultar.setBounds(12, 92, 116, 73);
		botonConsultar.addActionListener(new ActionListener () {
////////////MÉTODO CONSULTAR
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				try {
					Connection conexion;
					if(tipo_conexion.equals("1")) {
						Class.forName("com.mysql.jdbc.Driver");// Cargar el driver
						// Establecemos la conexion con la BD
						conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/practica1", "root", "");
						System.out.println("sql");
					}else {
						//Cargamos el driver
						Class.forName("org.sqlite.JDBC");
						//Establecemos conexión con la BD
						conexion=DriverManager.getConnection
						 ("jdbc:sqlite:C:\\Users\\Miguel\\Downloads\\sqlite-tools-win32-x86-3300100\\practica1.db");
						System.out.println("lite");
					}
					
					//Preparamos la sentencia sql del posible error
					String sql= "SELECT * FROM clientes WHERE NIF= ?";
					PreparedStatement sentenciaSQL=conexion.prepareStatement(sql);
					
					ResultSet resultado;
					
					//Variables para obtener los datos de los clientes de la BD
					String id=null;
					String nombre=null;
					String direccion=null;
					String poblacion=null;
					String telef=null;
					
					sentenciaSQL.setString(1, textNIF2.getText());
					resultado=sentenciaSQL.executeQuery();
					
					//Si no se encuentran coincidencias
					if (textNIF2.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "ERROR: El campo está vacío");
						sentenciaSQL.close();
						conexion.close();
					}else if (!resultado.next()) {
						JOptionPane.showMessageDialog(null, "El cliente que busca no existe (o ha introducido un NIF incorrecto)");
						sentenciaSQL.close();
						conexion.close();
					}else { 
						System.out.println("Se ha encontrado 1 coincidencia");
						do {
							id=resultado.getString("id");
							nombre=resultado.getString("nombre");
							direccion=resultado.getString("direccion");
							poblacion=resultado.getString("poblacion");
							telef=resultado.getString("telef");
						}while(resultado.next());
						sentenciaSQL.close();
						conexion.close();
					}
					/*
					while (resultado.next()) {
						id=resultado.getString("id");
						nombre=resultado.getString("nombre");
						direccion=resultado.getString("direccion");
						poblacion=resultado.getString("poblacion");
						telef=resultado.getString("telef");
					} 
					*/
					textID2.setText(id);
					textNombre2.setText(nombre);
					textDireccion2.setText(direccion);
					textPoblacion2.setText(poblacion);
					textTelef2.setText(telef);
					
					textID2.setEditable(false);
					textNombre2.setEditable(false);
					
					sentenciaSQL.close();
					conexion.close();
					
				} catch (SQLException e1) {
					
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		panel_2.add(botonConsultar);
		
		textID2 = new JTextField();
		textID2.setBounds(12, 237, 90, 22);
		panel_2.add(textID2);
		textID2.setColumns(10);
		
		textNombre2 = new JTextField();
		textNombre2.setBounds(146, 237, 90, 22);
		panel_2.add(textNombre2);
		textNombre2.setColumns(10);
		
		textDireccion2 = new JTextField();
		textDireccion2.setBounds(280, 237, 90, 22);
		panel_2.add(textDireccion2);
		textDireccion2.setColumns(10);
		
		textPoblacion2 = new JTextField();
		textPoblacion2.setBounds(415, 237, 90, 22);
		panel_2.add(textPoblacion2);
		textPoblacion2.setColumns(10);
		
		textTelef2 = new JTextField();
		textTelef2.setBounds(547, 237, 90, 22);
		panel_2.add(textTelef2);
		textTelef2.setColumns(10);
		
		JLabel lblId_1 = new JLabel("ID:");
		lblId_1.setBounds(12, 200, 56, 16);
		panel_2.add(lblId_1);
		
		JLabel lblNombre_1 = new JLabel("Nombre:");
		lblNombre_1.setBounds(146, 200, 56, 16);
		panel_2.add(lblNombre_1);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(280, 200, 75, 16);
		panel_2.add(lblDireccion);
		
		JLabel lblPoblacion = new JLabel("Poblacion:");
		lblPoblacion.setBounds(415, 200, 75, 16);
		panel_2.add(lblPoblacion);
		
		JLabel lblTelef = new JLabel("Telef:");
		lblTelef.setBounds(547, 200, 56, 16);
		panel_2.add(lblTelef);
		
		JButton botonActualizar = new JButton("Actualizar");
		botonActualizar.setIcon(new ImageIcon("C:\\Users\\diego\\OneDrive\\Acceso a datos\\practica\\iconoActualizar.png"));
		botonActualizar.setBounds(540, 277, 97, 59);
		botonActualizar.addActionListener(new ActionListener () {
////////MÉTODO ACTUALIZAR
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					Connection conexion;
					if(tipo_conexion.equals("1")) {
						Class.forName("com.mysql.jdbc.Driver");// Cargar el driver
						// Establecemos la conexion con la BD
						conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/practica1", "root", "");
						System.out.println("sql");
					}else {
						//Cargamos el driver
						Class.forName("org.sqlite.JDBC");
						//Establecemos conexión con la BD
						conexion=DriverManager.getConnection
						 ("jdbc:sqlite:C:\\Users\\Miguel\\Downloads\\sqlite-tools-win32-x86-3300100\\practica1.db");
						System.out.println("lite");
					}
					
					//Preparamos la sentencia sql
					String sql= "UPDATE clientes SET direccion= ?, poblacion= ?, telef= ?  WHERE NIF= ?";
					PreparedStatement sentenciaSQL=conexion.prepareStatement(sql);
					
					sentenciaSQL.setString(1, textDireccion2.getText());
					sentenciaSQL.setString(2, textPoblacion2.getText());
					sentenciaSQL.setString(3, textTelef2.getText());
					sentenciaSQL.setString(4, textNIF2.getText());
					
					sentenciaSQL.executeUpdate();
					System.out.println("Cliente actualizado correctamente");
					
					sentenciaSQL.close();
					conexion.close();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					System.out.println("Driver obtenido");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					System.out.println("Conectado a la BD");
				}
				
			}
			
		});
		
		panel_2.add(botonActualizar);
		
		JLabel lblSoloSePodrn = new JLabel("Solo se podr\u00E1n actualizar la direccion, poblacion y telefono (Independientemente de los datos que modifique)");
		lblSoloSePodrn.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblSoloSePodrn.setForeground(Color.RED);
		lblSoloSePodrn.setBounds(143, 127, 661, 38);
		panel_2.add(lblSoloSePodrn);
		
		JLabel lblO = new JLabel("O");
		lblO.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblO.setBounds(656, 294, 56, 16);
		panel_2.add(lblO);
		
		JButton botonEliminar = new JButton("Eliminar");
		botonEliminar.setIcon(new ImageIcon("C:\\Users\\diego\\OneDrive\\Acceso a datos\\practica\\iconoEliminar2.png"));
		botonEliminar.setBounds(683, 263, 97, 73);
		botonEliminar.addActionListener(new ActionListener () {
////////MÉTODO ELIMINAR
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				try {
					Connection conexion;
					if(tipo_conexion.equals("1")) {
						Class.forName("com.mysql.jdbc.Driver");// Cargar el driver
						// Establecemos la conexion con la BD
						conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/practica1", "root", "");
						System.out.println("sql");
					}else {
						//Cargamos el driver
						Class.forName("org.sqlite.JDBC");
						//Establecemos conexión con la BD
						conexion=DriverManager.getConnection
						 ("jdbc:sqlite:C:\\Users\\Miguel\\Downloads\\sqlite-tools-win32-x86-3300100\\practica1.db");
						System.out.println("lite");
					}
					
					ResultSet resultado;
					//Preparamos la sentencia sql del posible error
					String sql1= "SELECT * FROM clientes WHERE NIF= ?";
					PreparedStatement sentenciaSQL1=conexion.prepareStatement(sql1);
					sentenciaSQL1.setString(1, textNIF2.getText());
					resultado=sentenciaSQL1.executeQuery();
					
					if (textNIF2.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "ERROR: El campo está vacío");
						sentenciaSQL1.close();
						conexion.close();
					}else if (!resultado.next()) {
						JOptionPane.showMessageDialog(null, "El cliente que busca no existe (o ya ha sido eliminado)");
						sentenciaSQL1.close();
						conexion.close();
					}else {
					
					//Preparamos la sentencia sql
					String sql2= "DELETE FROM clientes WHERE NIF= ?";
					PreparedStatement sentenciaSQL2=conexion.prepareStatement(sql2);
					
					
					
					sentenciaSQL2.setString(1, textNIF2.getText());
					sentenciaSQL2.executeUpdate();
					System.out.println("Cliente eliminado correctamente");
					
					sentenciaSQL1.close();
					sentenciaSQL2.close();
					conexion.close();
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					System.out.println("Conectado a la BD");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					System.out.println("Error en el driver");
				}
				System.out.println("Conectado a la base de datos");
			}
			
		});
		
		panel_2.add(botonEliminar);
////////MÉTODO IMPORTAR		
		if (status == JFileChooser.APPROVE_OPTION) {
			
			Cliente cliente = null;
			
			try {
				
				//Obtenemos el archivo seleccionado con el filechooser
				File selectedFile = fileChooser.getSelectedFile();
				ObjectInputStream objetoIS= new ObjectInputStream(new FileInputStream(selectedFile));
				
				while(true) {
					cliente= (Cliente) objetoIS.readObject();
					System.out.println("Cliente leido correctamente");
					
					
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				System.out.println("Fallo sin importancia");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				System.out.println("Error al leer el objeto");
			}
			
			//Una vez leido el archivo nos conectamos a la base de datos
			try {
				Connection conexion;
				if(tipo_conexion.equals("1")) {
					Class.forName("com.mysql.jdbc.Driver");// Cargar el driver
					// Establecemos la conexion con la BD
					conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/practica1", "root", "");
					System.out.println("sql");
				}else {
					//Cargamos el driver
					Class.forName("org.sqlite.JDBC");
					//Establecemos conexión con la BD
					conexion=DriverManager.getConnection
					 ("jdbc:sqlite:C:\\Users\\Miguel\\Downloads\\sqlite-tools-win32-x86-3300100\\practica1.db");
					System.out.println("lite");
				}
				//Preparamos las sentencias sql
				String sql = "INSERT INTO clientes VALUES ( ? , ? , ? , ? , ? , ? )";
				PreparedStatement sentenciaSQL= conexion.prepareStatement(sql);
				sentenciaSQL.setInt(1, cliente.getId());
				sentenciaSQL.setString(2, cliente.getNombre());
				sentenciaSQL.setString(3, cliente.getDireccion());
				sentenciaSQL.setString(4, cliente.getPoblacion());
				sentenciaSQL.setString(5, cliente.getTelefono());
				sentenciaSQL.setString(6, cliente.getNIF());
				
				//Ejecutamos
				sentenciaSQL.executeUpdate();
				System.out.println("Cliente introducido a la BD");
				JOptionPane.showMessageDialog(null, "Fichero importado con éxito");
				
				//Cerramos el flujo de datos
				sentenciaSQL.close();
				conexion.close();
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println("Error al conectarse a la BD");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("Error al obtener el Driver");
			}
			
		}  else if (status == JFileChooser.CANCEL_OPTION) {

System.out.println("Importación de archivo cancelada.");
}
	}
}

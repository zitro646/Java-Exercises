package Practica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Prueba_Productos extends JFrame implements ActionListener {
	
	private String tipoconexion;
	private JPanel contentPane;
	private DefaultTableModel model;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;

	/**
	 * Launch the application.
	 */
	/*
	 public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prueba_Productos frame = new Prueba_Productos(args[0]);
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
	public Prueba_Productos(String tipo) {
		tipoconexion = tipo;
		setResizable(false);
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 414, 239);
		contentPane.add(tabbedPane);
		
		JLayeredPane layeredPane = new JLayeredPane();
		tabbedPane.addTab("Insertar Producto", null, layeredPane, null);
		
		JLabel lblInserteNombreDel = new JLabel("Inserte nombre del fichero a buscar");
		lblInserteNombreDel.setBounds(22, 26, 350, 14);
		layeredPane.add(lblInserteNombreDel);
		
		textField = new JTextField();
		textField.setBounds(22, 51, 257, 20);
		layeredPane.add(textField);
		textField.setColumns(10);
		
		JButton btnInsertarFicheroEn = new JButton("Insertar Fichero en Base de Datos");
		btnInsertarFicheroEn.setBounds(22, 82, 257, 23);
		btnInsertarFicheroEn.addActionListener(this);
		layeredPane.add(btnInsertarFicheroEn);
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		tabbedPane.addTab("Buscar Procducto", null, layeredPane_1, null);
		
		JLabel lblBuscaProductoPor = new JLabel("Busca Producto por ID");
		lblBuscaProductoPor.setBounds(29, 29, 129, 14);
		layeredPane_1.add(lblBuscaProductoPor);
		
		textField_1 = new JTextField();
		textField_1.setBounds(29, 53, 220, 20);
		layeredPane_1.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(29, 86, 89, 23);
		btnBuscar.addActionListener(this);
		layeredPane_1.add(btnBuscar);
		
		table = new JTable();
		table.setRowSelectionAllowed(false);
		table.setBounds(41, 120, 295, 80);
		layeredPane_1.add(table);
		table.setBackground(Color.LIGHT_GRAY);
		table.setForeground(Color.white);
		
		
		model = new DefaultTableModel ();
		model.addColumn("ID_Producto");
		model.addColumn("Descripcion");
		model.addColumn("Stock anual");
		model.addColumn("Precio Venta");
		
		table.setModel(model);
		
		JLayeredPane layeredPane_2 = new JLayeredPane();
		tabbedPane.addTab("Eliminar Producto", null, layeredPane_2, null);
		
		JLabel lblEliminaProductoPor = new JLabel("Elimina Producto por ID");
		lblEliminaProductoPor.setBounds(31, 35, 200, 14);
		layeredPane_2.add(lblEliminaProductoPor);
		
		textField_2 = new JTextField();
		textField_2.setBounds(31, 60, 200, 20);
		layeredPane_2.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(31, 91, 142, 23);
		btnEliminar.addActionListener(this);
		layeredPane_2.add(btnEliminar);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		
		String boton = arg0.getActionCommand();
		int id;
		
		try {
			
			Connection conexion;
			if(tipoconexion.equals("1")) {
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
			
			switch (boton) {
			
			case "Insertar Fichero en Base de Datos":
				//Creamos el directorio del fichero
				String directorio = textField.getText()+".dat";
				//Creamos un array list que contendra los productos que lea
				ArrayList<Producto> lista = new ArrayList<Producto>();
				
				try {
					//Buscamos el fichero
					DataInputStream lee = new DataInputStream (new FileInputStream (directorio));
					try {
						//Empieza a leer el fichero y crea los objetos
						while(true) {
							
							id = lee.read();
							String des = lee.readUTF();
							int stock = lee.read();
							double pvp = lee.readDouble();
							Producto x = new Producto(id,des,stock,pvp);//Creamos el producto que hemos leido
							lista.add(x);//Lo añadimos a la lista
							System.out.println(id+","+des+","+stock+","+pvp+"€");
						}
					}catch (EOFException eo) {
						System.out.println("Fichero no encontrado");//Si no encuentra el fichero nos avisara
					}
					
					
					for(int i = 0;i<lista.size();i++) {
							
						String sql = "INSERT INTO productos VALUES ( ? , ? , ? , ? )";//Creamos la sentencia
										    
						PreparedStatement sentencia = conexion.prepareStatement(sql);//Creamos un PreparedStatement				
						sentencia.setInt(1, lista.get(i).getId());
						sentencia.setString(2, lista.get(i).getDescripcion());
						sentencia.setInt(3, lista.get(i).getStockanual());
						sentencia.setDouble(4, lista.get(i).getPvp());
							
						try {
							sentencia.executeUpdate();//Ejecutamos la sentencia
						} catch (SQLException e) {
							System.out.println("HA OCURRIDO UNA EXCEPCIÓN:"); 
						    System.out.println("Mensaje:    "+ e.getMessage()); 
						    System.out.println("SQL estado: "+ e.getSQLState()); 
						   	System.out.println("Cód error:  "+ e.getErrorCode());  
						}
							
						sentencia.close();//Cerramos la sentencia
					}
				
				}catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "Buscar":
					//Sacamos el id del producto
					id = Integer.parseInt(textField_1.getText());
						
					//Preparamos la frase
					String frase = "SELECT * FROM productos WHERE ID_Producto = ?";
						
					//Preparamos la sentencia
					PreparedStatement sentencia = conexion.prepareStatement(frase);
					sentencia.setInt(1,id);
					//Ejecutamos la secuencia
					ResultSet rs = sentencia.executeQuery();
					
					//Eliminamos lo que haya antes en el tablero
					while(model.getRowCount()>=1) {
						model.removeRow(0);
					}
					
					//Miramos el resultado
					while (rs.next()) { 
						
						String i = String.valueOf(rs.getInt(1));
						String d = rs.getString(2);
						String s = String.valueOf(rs.getInt(3));
						String p = String.valueOf(rs.getDouble(4));
						String[] a= {i,d,s,p};
						model.addRow(a);
								                               
					}
							
					rs.close();//Cerramos el resulset
						
			break;
				
			case "Eliminar":
				
				//Sacamos el id del producto
				id = Integer.parseInt(textField_2.getText());
				
				String sql = "DELETE FROM productos WHERE ID_Producto = ? ";//Creamos la sentencia
			    
				PreparedStatement sentencia1 = conexion.prepareStatement(sql);//Creamos un PreparedStatement				
				sentencia1.setInt(1,id);
					
				try {
					sentencia1.executeUpdate();//Ejecutamos la sentencia
					System.out.println("Eliminacion exitosa");
				} catch (SQLException e) {
					System.out.println("HA OCURRIDO UNA EXCEPCIÓN:"); 
					System.out.println("Mensaje:    "+ e.getMessage()); 
					System.out.println("SQL estado: "+ e.getSQLState()); 
				    System.out.println("Cód error:  "+ e.getErrorCode());  
				}
				
				sentencia1.close();//Cerramos la sentencia
					
			break;
			
		}
			
			conexion.close();
			
		} catch (ClassNotFoundException cn) {
			cn.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}

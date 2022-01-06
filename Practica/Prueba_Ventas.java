package Practica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Prueba_Ventas extends JFrame implements ActionListener{
	
	private String tipoconexion;
	private Prueba_Ventas frame;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTable table_1;
	public DefaultTableModel model;
	public DefaultTableModel model2;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		
		 EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					frame = new Prueba_Ventas(args[0]);
					System.out.println("mec");
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
	public Prueba_Ventas(String tipo) {
		
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
		tabbedPane.setBounds(0, 0, 434, 261);
		contentPane.add(tabbedPane);
		
		//Ventanas_____________________________________________________________________________
		
		JLayeredPane layeredPane = new JLayeredPane();
		tabbedPane.addTab("Insertar/Eliminar", null, layeredPane, null);
		
		JLabel lblInsertaDatosPara = new JLabel("Inserta datos para crear Venta");
		lblInsertaDatosPara.setBounds(23, 21, 168, 14);
		layeredPane.add(lblInsertaDatosPara);
		
		JLabel lblIdCliente = new JLabel("Id_Cliente");
		lblIdCliente.setBounds(10, 49, 86, 14);
		layeredPane.add(lblIdCliente);
		
		JLabel lblIdproducto = new JLabel("Id_Producto");
		lblIdproducto.setBounds(9, 74, 87, 14);
		layeredPane.add(lblIdproducto);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 97, 86, 14);
		layeredPane.add(lblCantidad);
		
		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setBounds(10, 122, 86, 14);
		layeredPane.add(lblLocalidad);
		
		textField_3 = new JTextField();
		textField_3.setBounds(92, 46, 86, 20);
		layeredPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(92, 71, 86, 20);
		layeredPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(92, 94, 86, 20);
		layeredPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(92, 119, 86, 20);
		layeredPane.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnInsertarDatos = new JButton("Insertar Datos");
		btnInsertarDatos.setBounds(10, 147, 168, 23);
		btnInsertarDatos.addActionListener(this);
		layeredPane.add(btnInsertarDatos);
		
		JLabel lblEliminarDatos = new JLabel("Eliminar Datos");
		lblEliminarDatos.setBounds(259, 21, 94, 14);
		layeredPane.add(lblEliminarDatos);
		
		textField_7 = new JTextField();
		textField_7.setBounds(223, 46, 154, 20);
		layeredPane.add(textField_7);
		textField_7.setColumns(10);
		
		JButton btnEliminarPorNif = new JButton("Eliminar por NIF");
		btnEliminarPorNif.setBounds(223, 70, 154, 23);
		btnEliminarPorNif.addActionListener(this);
		layeredPane.add(btnEliminarPorNif);
		
		JButton btnEliminarVentasDe = new JButton("Eliminar Ventas de NIF");
		btnEliminarVentasDe.setBounds(223, 93, 154, 23);
		btnEliminarVentasDe.addActionListener(this);
		layeredPane.add(btnEliminarVentasDe);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(287, 183, 89, 23);
		btnSalir.addActionListener(this);
		layeredPane.add(btnSalir);
		
		
		
		//Ventana1_____________________________________________________________________________
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		tabbedPane.addTab("Busca Cliente", null, layeredPane_1, null);
		
		model = new DefaultTableModel ();
		model.addColumn("ID_Venta");
		model.addColumn("Fecha");
		model.addColumn("ID_Cliente");
		model.addColumn("ID_Producto");
		model.addColumn("Cantidad");
		model.addColumn("Ubicacion");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 53, 409, 180);
		layeredPane_1.add(scrollPane_1);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
		table.setModel(model);
		table.setBackground(Color.LIGHT_GRAY);
		table.setForeground(Color.white);
		
		JLabel lblNewLabel = new JLabel("Ingresa NIF");
		lblNewLabel.setBounds(10, 28, 66, 14);
		layeredPane_1.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(86, 22, 108, 20);
		layeredPane_1.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setBounds(204, 19, 89, 23);
		btnNewButton.addActionListener(this);
		layeredPane_1.add(btnNewButton);
		
		JButton btnGenerarArchivo = new JButton("Generar Archivo");
		btnGenerarArchivo.setBounds(295, 19, 124, 23);
		btnGenerarArchivo.addActionListener(this);
		layeredPane_1.add(btnGenerarArchivo);
		
		//Ventana2_____________________________________________________________________________
		
		JLayeredPane layeredPane_2 = new JLayeredPane();
		tabbedPane.addTab("Busca por Fechas", null, layeredPane_2, null);
		
		model2 = new DefaultTableModel ();
		model2.addColumn("ID_Venta");
		model2.addColumn("Fecha");
		model2.addColumn("ID_Cliente");
		model2.addColumn("ID_Producto");
		model2.addColumn("Cantidad");
		model2.addColumn("Ubicacion");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 60, 430, 170);
		layeredPane_2.add(scrollPane);
		scrollPane.setVisible(true);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		table_1.setModel(model2);
		table_1.setBackground(Color.LIGHT_GRAY);
		table_1.setForeground(Color.white);
		
		JLabel lblNewLabel_1 = new JLabel("Busque entre fechas");
		lblNewLabel_1.setBounds(53, 7, 128, 14);
		layeredPane_2.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 22, 100, 20);
		layeredPane_2.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(124, 22, 100, 20);
		layeredPane_2.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnBusca = new JButton("Busca");
		btnBusca.setBounds(264, 3, 155, 23);
		btnBusca.addActionListener(this);
		layeredPane_2.add(btnBusca);
		
		JButton btnGenerarElArchivo = new JButton("Generar el Archivo");
		btnGenerarElArchivo.setBounds(264, 30, 155, 23);
		btnGenerarElArchivo.addActionListener(this);
		layeredPane_2.add(btnGenerarElArchivo);
		
	}
	
public void actionPerformed(ActionEvent arg0) {
		
		String boton = arg0.getActionCommand();
		int id;
		int id_venta;
		int id_cliente;
		boolean realizar_operacion;
		ArrayList<String> listadoventas = new ArrayList<String>();
		ArrayList<String> listadofecha = new ArrayList<String>();
		ArrayList<String> listadocliente = new ArrayList<String>();
		ArrayList<String> listadoproducto = new ArrayList<String>();
		ArrayList<String> listadocantidad = new ArrayList<String>();
		ArrayList<String> listadolugar = new ArrayList<String>();
		
		try {
			
			
			Connection conexion;
			
			if(tipoconexion.equals("1")) {
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
			
			switch(boton) {
			//Este es el boton de crear una venta
			case "Insertar Datos":
				//ID_Venta/Fecha/id_Cliente/id_producto/cantidad/lugar 	
				id_venta=1;
				id_cliente = Integer.parseInt(textField_3.getText());;
				int id_producto=Integer.parseInt(textField_4.getText());;
				int cantidad=Integer.parseInt(textField_5.getText());;
				String lugar=textField_6.getText();
				realizar_operacion = true ;
			
				//Realizamos la comprobacion del codigo en el cliente
				
				String frase1 = "SELECT (ID_Cliente) FROM clientes WHERE ID_Cliente = ?";
				PreparedStatement sentencia1 = conexion.prepareStatement(frase1);
				sentencia1.setInt(1,id_cliente);
				ResultSet rs1 = sentencia1.executeQuery();
				
				
				if(!rs1.next()) {
					realizar_operacion=false;
				}
				
				sentencia1.close();
				
				//Realizamos la comprobacion del codigo en el producto
				
				String frase2 = "SELECT (ID_Producto) FROM productos WHERE ID_Producto = ?";
				PreparedStatement sentencia2 = conexion.prepareStatement(frase2);
				sentencia2.setInt(1,id_producto);
				ResultSet rs2 = sentencia2.executeQuery();
				
				
				if(!rs2.next()) {
					realizar_operacion=false;
				}
				sentencia2.close();
				
				//Si los parametros de comprobacion ha sido pasados procedemos
				if(realizar_operacion) {
					
					//Para asignar la id de venta
					String frase3 = "SELECT MAX(ID_Venta) FROM ventas";
					
					PreparedStatement sentencia3 = conexion.prepareStatement(frase3);
					ResultSet rs3 = sentencia3.executeQuery();
					
					if(rs3.next()) {
						id_venta = rs3.getInt(1)+1;
					}else {
						id_venta = 1;
					}
					
					sentencia3.close();
					
					//Creamos la fecha de venta
					Calendar fecha = new GregorianCalendar();
					int ano=fecha.get(Calendar.YEAR);
					int mes=fecha.get(Calendar.MONTH);
					int dia=fecha.get(Calendar.DAY_OF_MONTH);
					
					String historial = String.valueOf(ano)+"-"+String.valueOf(mes)+"-"+String.valueOf(dia);
					
					
					// construir orden INSERT
					String sql = "INSERT INTO ventas VALUES ( ?, ?, ? ,? ,? ,? )";
	  			    
							    
					PreparedStatement sentencia = conexion.prepareStatement(sql);				
					sentencia.setInt(1,id_venta);
					sentencia.setString(2, historial);
					sentencia.setInt(3,id_cliente);
					sentencia.setInt(4,id_producto);
					sentencia.setInt(5,cantidad);
					sentencia.setString(6,lugar);
					int filas;//
					try {
					  filas = sentencia.executeUpdate();
					  JOptionPane.showMessageDialog(null, "Se ha realizado la venta");
					} catch (SQLException e) {
						System.out.println("HA OCURRIDO UNA EXCEPCIÓN:"); 
					    System.out.println("Mensaje:    "+ e.getMessage()); 
					    System.out.println("SQL estado: "+ e.getSQLState()); 
				    	System.out.println("Cód error:  "+ e.getErrorCode());  
					}
					sentencia.close(); 
				}else {
					JOptionPane.showMessageDialog(null, "El id de cliente o de producto es erroneo");
				}
				
			
			
			break;
			
			/**
			 * __________________________________________________________________________
			**/
			//Para borrar una venta por id
			case "Eliminar por NIF":
				//Cogemos la id a borrar
				id_venta=Integer.parseInt(textField_7.getText());
				realizar_operacion = true;
				
				
				//Comprobamos que la id exista
				String frase = "SELECT (ID_Venta) FROM ventas WHERE ID_Venta = ?";
				PreparedStatement sentencia = conexion.prepareStatement(frase);
				sentencia.setInt(1,id_venta);
				ResultSet rs = sentencia.executeQuery();
				
				
				if(!rs.next()) {
					realizar_operacion=false;
					JOptionPane.showMessageDialog(null, "La id_venta ingresada no existe");
				}
				
				sentencia.close();
				
				//Si la id existe procedemos a realizar la operacion
				if(realizar_operacion) {
					
					String sql = "DELETE FROM ventas WHERE Id_Venta = ? ";
					
					
					PreparedStatement sentencia21 = conexion.prepareStatement(sql);				
					sentencia21.setInt(1,id_venta);
					int filas;//
					try {
					  filas = sentencia21.executeUpdate();
					  JOptionPane.showMessageDialog(null, "Se ha eliminado la venta");
					} catch (SQLException e) {
						System.out.println("HA OCURRIDO UNA EXCEPCIÓN:"); 
					    System.out.println("Mensaje:    "+ e.getMessage()); 
					    System.out.println("SQL estado: "+ e.getSQLState()); 
				    	System.out.println("Cód error:  "+ e.getErrorCode());  
					}
					sentencia.close(); 	
				}
					
		break;
		
		/**
		 * __________________________________________________________________________
		**/
		//Borramos las ventas asignadas a una id
		case "Eliminar Ventas por NIF":
			
			//Cogemos la id del cliente para borrar sus compras
			id_cliente=Integer.parseInt(textField_7.getText());
			realizar_operacion = true;
			
			
			
			//Comprobamos que la id exista
			String frase11 = "SELECT (ID_Venta) FROM ventas WHERE ID_Cliente = ?";
			PreparedStatement sentencia11 = conexion.prepareStatement(frase11);
			sentencia11.setInt(1,id_cliente);
			ResultSet rs11 = sentencia11.executeQuery();
			
			
			if(!rs11.next()) {
				realizar_operacion=false;
				JOptionPane.showMessageDialog(null, "El NIF ingresado no existe");
			}
			
			sentencia11.close();
			
			//Si la id existe procedemos a realizar la operacion
			if(realizar_operacion) {
				
				String sql = "DELETE FROM ventas WHERE Id_Cliente = ? ";
				
				PreparedStatement sentencia21 = conexion.prepareStatement(sql);				
				sentencia21.setInt(1,id_cliente);
				int filas;//
				try {
				  filas = sentencia21.executeUpdate();
				  JOptionPane.showMessageDialog(null, "Se han eliminado las compras del cliente "+id_cliente);
				} catch (SQLException e) {
					System.out.println("HA OCURRIDO UNA EXCEPCIÓN:"); 
				    System.out.println("Mensaje:    "+ e.getMessage()); 
				    System.out.println("SQL estado: "+ e.getSQLState()); 
			    	System.out.println("Cód error:  "+ e.getErrorCode());  
				}
				sentencia11.close(); 	
			}
		
			
		break;
		case "Buscar":
			
			//Sacamos la id introducida
			id_cliente=Integer.parseInt(textField.getText());
			realizar_operacion = true;
			
			//Borramos lo que haya en la tabla
			while(model.getRowCount()>=1) {
				model.removeRow(0);
			}
			
			//Comprobamos que el nif introducido exista
			String frase111 = "SELECT (ID_Cliente) FROM clientes WHERE ID_Cliente = ?";
			PreparedStatement sentencia111 = conexion.prepareStatement(frase111);
			sentencia111.setInt(1,id_cliente);
			ResultSet rs111 = sentencia111.executeQuery();
				
				
			if(!rs111.next()) {
				realizar_operacion=false;
			}
				
			sentencia111.close();
				
			if(realizar_operacion==false) {
				JOptionPane.showMessageDialog(null, "La id introducida no existe");
			}else {
					
				//Ahora sacamos los datos de las ventas relacionadas
				String frase4 = "SELECT * FROM ventas WHERE ID_Cliente = ?";
				PreparedStatement sentencia4 = conexion.prepareStatement(frase4);
				sentencia4.setInt(1,id_cliente);
				ResultSet rs4 = sentencia4.executeQuery();
					
				if(!rs4.next()) {
					JOptionPane.showMessageDialog(null, "El NIF no tiene ninguna venta asociada");
				}else {
					do {
						String c1 = String.valueOf(rs4.getInt(1));
						String c2 = rs4.getString(2);
						String c3 = String.valueOf(rs4.getInt(3));
						String c4 = String.valueOf(rs4.getInt(4));
						String c5 = String.valueOf(rs4.getInt(5));
						String c6 = rs4.getString(6);
						String[] a= {c1,c2,c3,c4,c5,c6};
						model.addRow(a);
					}while(rs4.next());
				}
					
				sentencia4.close();
			}
			
		break;
		case "Busca":
			
			//select * from ventas where FECHAVENTA between '2019-11-12' and '2019-11-19'
			String fecha_menor=textField_1.getText();
			String fecha_mayor=textField_2.getText();
			realizar_operacion = true;
			
				
			//Borramos lo que haya en la tabla
			while(model.getRowCount()>=1) {
				model.removeRow(0);
			}
			
			
			//Ahora sacamos los datos de las ventas relacionadas
			String frase5 = "SELECT * FROM ventas WHERE FECHAVENTA between ? and ? ";
			PreparedStatement sentencia6 = conexion.prepareStatement(frase5);
			sentencia6.setString(1,fecha_menor);
			sentencia6.setString(2,fecha_mayor);
			ResultSet rs6 = sentencia6.executeQuery();
				
				
			if(!rs6.next()) {
				JOptionPane.showMessageDialog(null, "No hay ventas entre las fechas seleccionadas");
				
			}else {
				
				do {
					String c1 = String.valueOf(rs6.getInt(1));
					String c2 = rs6.getString(2);
					String c3 = String.valueOf(rs6.getInt(3));
					String c4 = String.valueOf(rs6.getInt(4));
					String c5 = String.valueOf(rs6.getInt(5));
					String c6 = rs6.getString(6);
					String[] a= {c1,c2,c3,c4,c5,c6};
					model2.addRow(a);
				}while(rs6.next());
					
			}
				
			sentencia6.close();
			
		break;
		case "Generar Archivo":
			
			id_cliente = Integer.parseInt(textField.getText());
			realizar_operacion=true;
			
			
			if(textField.getText()=="") {
				JOptionPane.showMessageDialog(null, "Inserte un cliente a buscar");
			}else {
			
			}
			String[] options = {"xml", "cvs"};
			int tipo_archivo = JOptionPane.showOptionDialog(null, "Elija el tipo Fichero", null,JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null , options, options[0]);
			
			
			//Comprobamos que el nif introducido exista
			String frase7 = "SELECT (ID_Cliente) FROM clientes WHERE ID_Cliente = ?";
			PreparedStatement sentencia7 = conexion.prepareStatement(frase7);
			sentencia7.setInt(1,id_cliente);
			ResultSet rs7 = sentencia7.executeQuery();
					
			if(!rs7.next()) {
				realizar_operacion=false;
			}
			sentencia7.close();
				
			if(realizar_operacion==false) {
				JOptionPane.showMessageDialog(null, "La id introducida no existe");
			}else {
				//Ahora sacamos los datos de las ventas relacionadas
				String frase8 = "SELECT * FROM ventas WHERE ID_Cliente = ?";
				PreparedStatement sentencia8 = conexion.prepareStatement(frase8);
				sentencia8.setInt(1,id_cliente);
				ResultSet rs8 = sentencia8.executeQuery();
				if(!rs8.next()) {
					JOptionPane.showMessageDialog(null, "El NIF no tiene ninguna venta asociada");
				}else {
					do {
						String c1 = String.valueOf(rs8.getInt(1));
						listadoventas.add(c1);
						String c2 = rs8.getString(2);
						listadofecha.add(c2);
						String c3 = String.valueOf(rs8.getInt(3));
						listadocliente.add(c3);
						String c4 = String.valueOf(rs8.getInt(4));
						listadoproducto.add(c4);
						String c5 = String.valueOf(rs8.getInt(5));
						listadocantidad.add(c5);
						String c6 = rs8.getString(6);
						listadolugar.add(c6);
						
					}while(rs8.next());
				}	
				sentencia8.close();
			}
			
			
			
			//Crear el nombre del archivo
			//Instanciamos la fecha 
			Calendar fecha = new GregorianCalendar();
			
			
			int año=fecha.get(Calendar.YEAR);
			int mes=fecha.get(Calendar.MONTH);
			int dia=fecha.get(Calendar.DAY_OF_MONTH);
			
			String historial = String.valueOf(dia)+"-"+String.valueOf(mes)+"-"+String.valueOf(año);
			//Instanciamos el numero
			int numero = 1;
			boolean fin=false;
			String fraseinsertar;
			if(tipo_archivo==0) {
				 fraseinsertar= "VENTAS"+historial+"_"+numero+".xml";
			}else {
				 fraseinsertar= "VENTAS"+historial+"_"+numero+".csv";
			}
			
			//El comprobamos que el fichero no existe,si existiera cambiamos el nombre del fichero.
			do {
				//Instanciamos el fichero
				File archivo = new File(fraseinsertar);
				//Si el fichero no existe se guardara, si existe simplemente dara una vuelta.
				if(!archivo.exists()) {
					fin=true;
				}else {
					numero++;
					if(tipo_archivo==0) {
						 fraseinsertar= "VENTAS"+historial+"_"+numero+".xml";
					}else {
						 fraseinsertar= "VENTAS"+historial+"_"+numero+".csv";
					}
				}	
			}while(fin==false);
			
			
			if(tipo_archivo==0) {
				
				try {
					 
					DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
					DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			 
					// elemento raiz
					Document doc = docBuilder.newDocument();
					Element rootElement = doc.createElement("Ventas");
					doc.appendChild(rootElement);
			 
					
					
					for(int i=0;i<listadoventas.size();i++) {
						// empleado
						Element venta = doc.createElement("id_ventas");
						rootElement.appendChild(venta);
						
						// atributo del elemento empleado
						Attr attr = doc.createAttribute("id");
						attr.setValue(listadoventas.get(i));
						venta.setAttributeNode(attr);
						
						// fecha
						Element apellidos = doc.createElement("fecha");
						apellidos.appendChild(doc.createTextNode(listadofecha.get(i)));
						venta.appendChild(apellidos);
						
						// id_cliente
						Element idcliente = doc.createElement("Id_Cliente");
						idcliente.appendChild(doc.createTextNode(listadocliente.get(i)));
						venta.appendChild(idcliente);
				 
						
				 
						// id_producto
						Element idproducto = doc.createElement("id_producto");
						idproducto.appendChild(doc.createTextNode(listadoproducto.get(i)));
						venta.appendChild(idproducto);
				 
						// cantidad
						Element cantidades = doc.createElement("cantidad");
						cantidades.appendChild(doc.createTextNode(listadocantidad.get(i)));
						venta.appendChild(cantidades);
						
						// lugar
						Element lugares = doc.createElement("lugar");
						lugares.appendChild(doc.createTextNode(listadolugar.get(i)));
						venta.appendChild(lugares);
						
					}
					
					// escribimos el contenido en un archivo .xml
					TransformerFactory transformerFactory = TransformerFactory.newInstance();
					Transformer transformer = transformerFactory.newTransformer();
					DOMSource source = new DOMSource(doc);
					
					
					
					
					
					
					StreamResult result = new StreamResult(new File(fraseinsertar));
					//StreamResult result = new StreamResult(new File("archivo.xml"));
			 
					transformer.transform(source, result);
			 
					JOptionPane.showMessageDialog(null, "Se ha guardado el archivo bajo el nombre de "+fraseinsertar);
			 
					} catch (ParserConfigurationException pce) {
						pce.printStackTrace();
					} catch (TransformerException tfe) {
						tfe.printStackTrace();
					}
				
				
			}else if(tipo_archivo==1) {
				
				FileWriter csvWriter;
				try {
					csvWriter = new FileWriter(fraseinsertar);
					csvWriter.append("id");
					csvWriter.append(',');
					csvWriter.append("fecha");
					csvWriter.append(',');
					csvWriter.append("id_cliente");
					csvWriter.append(',');
					csvWriter.append("id_producto");
					csvWriter.append(',');
					csvWriter.append("cantidad");
					csvWriter.append(',');
					csvWriter.append("lugar");
					csvWriter.append("\n");
					csvWriter.flush();
					for (int i=0;i<listadoventas.size();i++) {
					    csvWriter.append(listadoventas.get(i));
						csvWriter.append(',');
						csvWriter.append(listadofecha.get(i));
						csvWriter.append(',');
						csvWriter.append(listadocliente.get(i));
						csvWriter.append(',');
						csvWriter.append(listadoproducto.get(i));
						csvWriter.append(',');
						csvWriter.append(listadocantidad.get(i));
						csvWriter.append(',');
						csvWriter.append(listadolugar.get(i));
					    csvWriter.append("\n");
					}
					
					csvWriter.flush();
					csvWriter.close();
					
					JOptionPane.showMessageDialog(null, "Se ha añadido el archivo csv bajo el nombre "+fraseinsertar);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				JOptionPane.showMessageDialog(null, "Error imcomprensible");
			}
			
		break;
		
		case "Generar el Archivo":
			//select * from ventas where FECHAVENTA between '2019-11-12' and '2019-11-19'
			String fecha_menor1=textField_1.getText();
			String fecha_mayor1=textField_2.getText();
			realizar_operacion=true;
			
			
			if(textField.getText()=="") {
				JOptionPane.showMessageDialog(null, "Inserte un cliente a buscar");
			}else {
			
			}
			String[] options1 = {"xml", "cvs"};
			int tipo_archivo1 = JOptionPane.showOptionDialog(null, "Elija el tipo Fichero", null,JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null , options1, options1[0]);
			
			
			//Ahora sacamos los datos de las ventas relacionadas
			String frase9 = "SELECT * FROM ventas WHERE FECHAVENTA between ? and ? ";
			PreparedStatement sentencia9 = conexion.prepareStatement(frase9);
			sentencia9.setString(1,fecha_menor1);
			sentencia9.setString(2,fecha_mayor1);
			ResultSet rs9 = sentencia9.executeQuery();
					
			if(!rs9.next()) {
				realizar_operacion=false;
			}
			
			if(realizar_operacion==false) {
				JOptionPane.showMessageDialog(null, "La id introducida no existe");
			}else {
				
					do {
						String c1 = String.valueOf(rs9.getInt(1));
						listadoventas.add(c1);
						String c2 = rs9.getString(2);
						listadofecha.add(c2);
						String c3 = String.valueOf(rs9.getInt(3));
						listadocliente.add(c3);
						String c4 = String.valueOf(rs9.getInt(4));
						listadoproducto.add(c4);
						String c5 = String.valueOf(rs9.getInt(5));
						listadocantidad.add(c5);
						String c6 = rs9.getString(6);
						listadolugar.add(c6);
						
					}while(rs9.next());
					
				sentencia9.close();
			}
			
			
			
			//Crear el nombre del archivo
			//Instanciamos la fecha 
			Calendar fecha1 = new GregorianCalendar();
			
			
			int año1=fecha1.get(Calendar.YEAR);
			int mes1=fecha1.get(Calendar.MONTH);
			int dia1=fecha1.get(Calendar.DAY_OF_MONTH);
			
			String historial1 = String.valueOf(dia1)+"-"+String.valueOf(mes1)+"-"+String.valueOf(año1);
			//Instanciamos el numero
			int numero1 = 1;
			boolean fin1=false;
			String fraseinsertar1;
			if(tipo_archivo1==0) {
				 fraseinsertar1= "VENTAS"+historial1+"_"+numero1+".xml";
			}else {
				 fraseinsertar1= "VENTAS"+historial1+"_"+numero1+".csv";
			}
			
			
			//El comprobamos que el fichero no existe,si existiera cambiamos el nombre del fichero.
			do {
				//Instanciamos el fichero
				File archivo = new File(fraseinsertar1);
				//Si el fichero no existe no se guardara, si existe simplemente dara una vuelta.
				if(!archivo.exists()) {
					fin1=true;
				}else {
					numero1++;
					if(tipo_archivo1==0) {
						 fraseinsertar1= "VENTAS"+historial1+"_"+numero1+".xml";
					}else {
						 fraseinsertar1= "VENTAS"+historial1+"_"+numero1+".csv";
					}
				}	
			}while(fin1==false);
			
			if(tipo_archivo1==0) {
				
				try {
					 
					DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
					DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			 
					// elemento raiz
					Document doc = docBuilder.newDocument();
					Element rootElement = doc.createElement("Ventas");
					doc.appendChild(rootElement);
			 
					
					
					for(int i=0;i<listadoventas.size();i++) {
						// empleado
						Element venta = doc.createElement("id_ventas");
						rootElement.appendChild(venta);
						
						// atributo del elemento empleado
						Attr attr = doc.createAttribute("id");
						attr.setValue(listadoventas.get(i));
						venta.setAttributeNode(attr);
						
						// fecha
						Element apellidos = doc.createElement("fecha");
						apellidos.appendChild(doc.createTextNode(listadofecha.get(i)));
						venta.appendChild(apellidos);
						
						// id_cliente
						Element idcliente = doc.createElement("Id_Cliente");
						idcliente.appendChild(doc.createTextNode(listadocliente.get(i)));
						venta.appendChild(idcliente);
				 
						
				 
						// id_producto
						Element idproducto = doc.createElement("id_producto");
						idproducto.appendChild(doc.createTextNode(listadoproducto.get(i)));
						venta.appendChild(idproducto);
				 
						// cantidad
						Element cantidades = doc.createElement("cantidad");
						cantidades.appendChild(doc.createTextNode(listadocantidad.get(i)));
						venta.appendChild(cantidades);
						
						// lugar
						Element lugares = doc.createElement("lugar");
						lugares.appendChild(doc.createTextNode(listadolugar.get(i)));
						venta.appendChild(lugares);
						
					}
					
					// escribimos el contenido en un archivo .xml
					TransformerFactory transformerFactory = TransformerFactory.newInstance();
					Transformer transformer = transformerFactory.newTransformer();
					DOMSource source = new DOMSource(doc);
					
					
					
					
					
					
					StreamResult result = new StreamResult(new File(fraseinsertar1));
					//StreamResult result = new StreamResult(new File("archivo.xml"));
			 
					transformer.transform(source, result);
			 
					JOptionPane.showMessageDialog(null, "Archivo Creado");
			 
					} catch (ParserConfigurationException pce) {
						pce.printStackTrace();
					} catch (TransformerException tfe) {
						tfe.printStackTrace();
					}
				
				
			}else if(tipo_archivo1==1) {
				
				FileWriter csvWriter;
				try {
					csvWriter = new FileWriter(fraseinsertar1);
					csvWriter.append("id");
					csvWriter.append(',');
					csvWriter.append("fecha");
					csvWriter.append(',');
					csvWriter.append("id_cliente");
					csvWriter.append(',');
					csvWriter.append("id_producto");
					csvWriter.append(',');
					csvWriter.append("cantidad");
					csvWriter.append(',');
					csvWriter.append("lugar");
					csvWriter.append("\n");
					csvWriter.flush();
					for (int i=0;i<listadoventas.size();i++) {
					    csvWriter.append(listadoventas.get(i));
						csvWriter.append(',');
						csvWriter.append(listadofecha.get(i));
						csvWriter.append(',');
						csvWriter.append(listadocliente.get(i));
						csvWriter.append(',');
						csvWriter.append(listadoproducto.get(i));
						csvWriter.append(',');
						csvWriter.append(listadocantidad.get(i));
						csvWriter.append(',');
						csvWriter.append(listadolugar.get(i));
					    csvWriter.append("\n");
					}
					
					csvWriter.flush();
					csvWriter.close();
					JOptionPane.showMessageDialog(null, "Archivo CSV creado bajo el nombre de "+fraseinsertar1);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				JOptionPane.showMessageDialog(null, "Error imcomprensible");
			}
		break;
		}
			
		conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch ( ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

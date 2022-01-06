package Practica;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class Pagina_Principal extends JFrame implements ActionListener {

	private JPanel contentPane;
	private static Pagina_Principal frame;
	private static Prueba_Ventas frame1;
	private static Prueba_Productos frame2;
	private static Prueba_Clientes frame3;
	
	/**
	 * Launch the application.
	 */
	public static void main(final String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Pagina_Principal();
					frame.setVisible(true);
					frame1 = new Prueba_Ventas(args[0]);
					frame2 = new Prueba_Productos(args[0]);
					frame3 = new Prueba_Clientes(args[0]);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Pagina_Principal() {
		
		setResizable(false);
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 354, 160);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnProductos = new JButton("Productos");
		btnProductos.setBounds(10, 56, 98, 23);
		btnProductos.addActionListener(this);
		contentPane.add(btnProductos);
		
		JButton btnVentas = new JButton("Ventas");
		btnVentas.setBounds(118, 56, 89, 23);
		btnVentas.addActionListener(this);
		contentPane.add(btnVentas);
		
		JButton btnClientes = new JButton("Clientes");
		btnClientes.setBounds(217, 56, 89, 23);
		btnClientes.addActionListener(this);
		contentPane.add(btnClientes);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String boton = arg0.getActionCommand();
		
		switch (boton) {
			
		case "Productos":
			
			if(frame2.isVisible()) {
				JOptionPane.showMessageDialog(null, "La ventana Productos ya es visible");
			}else {
				frame2.setVisible(true);
			}
			
			break;
		case "Ventas":
			
			if(frame1.isVisible()) {
				JOptionPane.showMessageDialog(null, "La ventana Ventas ya es visible");
			}else {
				frame1.setVisible(true);
			}
			
			break;
		case "Clientes":
			
			if(frame3.isVisible()) {
				JOptionPane.showMessageDialog(null, "La ventana Clientes ya es visible");
			}else {
				frame3.setVisible(true);
			}
			
			break;	
		
		
		}
	}
}

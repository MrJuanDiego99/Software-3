package Ventanas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class registro_cliente extends JFrame{
	//-----------------------------------------------
	
	public static final String URL = "jdbc:mysql://localhost:3306/software";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "juan9907";
	
	PreparedStatement ps;
	ResultSet re;
	
	public static Connection getConnection() {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
		}catch (Exception e) {
			System.out.println(e);
		}
		return con;
		
	}	
	//----------------------------------------
	
	private JLabel           lb_nombre, lb_apellido, lb_cedula, lb_telefono, lb_direccion, lb_email, lb_genero, lb_tittle, lb_regis;
	private JTextField       tf_nombre, tf_apellido, tf_cedula, tf_telefono, tf_direccion, tf_email;
	private JComboBox        cb_genero;
	private JButton          bt_regist;
	private registro_cliente framerc = this;
	
	//---------------------------------------
	
	public registro_cliente() {
		setTitle("SW Prestamo - Inversion");
		setSize(700,500);
		setLocationRelativeTo(null);
		setupWidgets();
		setupEvents();
	    setVisible(true);
	}
	//-------------------------------------------
	
	public void setupWidgets() {
		
		lb_nombre = new JLabel("Nombre");
		lb_nombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lb_apellido = new JLabel("Apellido");
		lb_apellido.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lb_cedula = new JLabel("Cedula(ID)");
		lb_cedula.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lb_telefono = new JLabel("Telefono");
		lb_telefono.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lb_direccion = new JLabel("Direccion");
		lb_direccion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lb_email = new JLabel("E-mail");
		lb_email.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lb_genero = new JLabel("Genero");
		lb_genero.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lb_tittle = new JLabel("BANK LOAN AND FUTURE");
		lb_tittle.setFont(new Font("Sitka Subheading", Font.BOLD, 24));
		
		lb_regis = new JLabel("Registrar Cliente");
		lb_regis.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		
		tf_nombre    = new JTextField(); 
		tf_apellido  = new JTextField(); 
		tf_cedula    = new JTextField(); 
		tf_telefono  = new JTextField(); 
		tf_direccion = new JTextField(); 
		tf_email     = new JTextField();
		
		cb_genero = new JComboBox();
		cb_genero.addItem("Femenino");
		cb_genero.addItem("Masculino");
		cb_genero.addItem("Otro");
		
		bt_regist = new JButton("Registrar");
		bt_regist.setFont(new Font("Tahoma", Font.ITALIC, 19));
		
		getContentPane().setLayout(null);
		
		getContentPane().add(lb_nombre); lb_nombre.setBounds(50, 152, 62, 20);
		getContentPane().add(tf_nombre); tf_nombre.setBounds(124, 154, 183, 20);
		
		getContentPane().add(lb_apellido); lb_apellido.setBounds(343, 152, 62, 20);
		getContentPane().add(tf_apellido); tf_apellido.setBounds(431, 154, 190, 20);
		
		getContentPane().add(lb_cedula); lb_cedula.setBounds(123, 187, 92, 30);
		getContentPane().add(tf_cedula); tf_cedula.setBounds(154, 208, 153, 20);
		
		getContentPane().add(lb_telefono); lb_telefono.setBounds(343, 202, 76, 30);
		getContentPane().add(tf_telefono); tf_telefono.setBounds(431, 209, 190, 20);
		
		getContentPane().add(lb_direccion); lb_direccion.setBounds(50, 258, 92, 30);
		getContentPane().add(tf_direccion); tf_direccion.setBounds(136, 265, 171, 20);
		
		getContentPane().add(lb_genero); lb_genero.setBounds(50, 301, 92, 30);
		getContentPane().add(cb_genero); cb_genero.setBounds(124, 308, 183, 20);
		
		getContentPane().add(lb_cedula); lb_cedula.setBounds(50, 201, 92, 30);
		getContentPane().add(tf_cedula); tf_cedula.setBounds(154, 208, 141, 20);
		
		getContentPane().add(lb_email); lb_email.setBounds(343, 258, 62, 30);
		getContentPane().add(tf_email); tf_email.setBounds(417, 265, 190, 20);
		
		getContentPane().add(lb_tittle); lb_tittle.setBounds(198, 40, 303, 30);
		
		getContentPane().add(lb_regis); lb_regis.setBounds(255, 83, 150, 30);
		
		getContentPane().add(bt_regist); bt_regist.setBounds(370, 329, 183, 76);
		
	}
	//-------------------------------------------
	
	public void setupEvents() {
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		bt_regist.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Connection con = null;
				
				try {
					con = getConnection();
					ps = (PreparedStatement) con.prepareStatement("INSERT INTO clientes(idcliente, nombre, apellido, telefono, email, genero, direccion) VALUES(?,?,?,?,?,?,?)");
					ps.setString(1, tf_cedula.getText());
					ps.setString(2, tf_nombre.getText());
					ps.setString(3, tf_apellido.getText());
					ps.setString(4, tf_telefono.getText());
					ps.setString(5, tf_email.getText());
					ps.setString(6, cb_genero.getSelectedItem().toString());
					ps.setString(7, tf_direccion.getText());
					
					int res = ps.executeUpdate();
					if(res>0) {
						add(new exitoso_clien(framerc));
					} else {
						JOptionPane.showMessageDialog(null, "Error hp");
					}
				} catch (Exception e2) {
					System.err.println(e2);
				}
			}
		});		
	}	
}

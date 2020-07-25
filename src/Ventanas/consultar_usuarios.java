package Ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class consultar_usuarios extends JFrame {
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
	
	private JLabel           lb_nombre, lb_apellido, lb_telefono, lb_direccion, lb_rol, lb_tittle, lb_buscar, lb_cedula;
	private JTextField       tf_nombre, tf_apellido, tf_telefono, tf_direccion, tf_rol, tf_cedula;
	private JButton          bt_buscar, bt_aceptar;
	
	//---------------------------------------
	
	public consultar_usuarios() {
		setTitle("SW Prestamo - Inversion");
		setSize(700,488);
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
		
		lb_telefono = new JLabel("Telefono");
		lb_telefono.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lb_direccion = new JLabel("Direccion");
		lb_direccion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lb_rol = new JLabel("Rol");
		lb_rol.setFont(new Font("Tahoma", Font.PLAIN, 18));
			
		lb_cedula = new JLabel("Cedula(ID)");
		lb_cedula.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lb_tittle = new JLabel("BANK LOAN AND FUTURE");
		lb_tittle.setFont(new Font("Sitka Subheading", Font.BOLD, 24));
		
		lb_buscar = new JLabel("Consultar Usuario");
		lb_buscar.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		
		tf_nombre = new JTextField(); 
		tf_nombre.setEditable(false);
		
		tf_apellido = new JTextField();
		tf_apellido.setEditable(false);
		
		tf_telefono = new JTextField(); 
		tf_telefono.setEditable(false);
		
		tf_direccion = new JTextField(); 
		tf_direccion.setEditable(false);
		
		tf_rol = new JTextField();
		tf_rol.setEditable(false);
		
		tf_cedula = new JTextField();
		
		bt_buscar = new JButton("Buscar");
		bt_buscar.setForeground(Color.BLUE);
		bt_buscar.setFont(new Font("Tahoma", Font.ITALIC, 16));
		
		bt_aceptar = new JButton("Aceptar");
		bt_aceptar.setFont(new Font("Tahoma", Font.ITALIC, 20));		
		
		getContentPane().setLayout(null);
		
		getContentPane().add(lb_nombre); lb_nombre.setBounds(66, 206, 76, 20);
		getContentPane().add(tf_nombre); tf_nombre.setBounds(140, 210, 183, 20);
		
		getContentPane().add(lb_apellido); lb_apellido.setBounds(359, 206, 76, 20);
		getContentPane().add(tf_apellido); tf_apellido.setBounds(431, 210, 190, 20);
		
		getContentPane().add(lb_telefono); lb_telefono.setBounds(343, 242, 76, 30);
		getContentPane().add(tf_telefono); tf_telefono.setBounds(431, 251, 190, 20);
		
		getContentPane().add(lb_direccion); lb_direccion.setBounds(50, 242, 92, 30);
		getContentPane().add(tf_direccion); tf_direccion.setBounds(136, 251, 171, 20);
		
		getContentPane().add(lb_rol); lb_rol.setBounds(257, 290, 42, 30);
		getContentPane().add(tf_rol); tf_rol.setBounds(297, 299, 190, 20);
		
		getContentPane().add(lb_cedula); lb_cedula.setBounds(154, 143, 92, 30);
		getContentPane().add(tf_cedula); tf_cedula.setBounds(257, 152, 171, 20);
		
		getContentPane().add(lb_tittle); lb_tittle.setBounds(198, 40, 303, 30);
		
		getContentPane().add(lb_buscar); lb_buscar.setBounds(267, 84, 168, 30);
		getContentPane().add(bt_buscar); bt_buscar.setBounds(441, 137, 84, 44);
		
		getContentPane().add(bt_aceptar); bt_aceptar.setBounds(297, 356, 128, 60);
		
	}
	//-------------------------------------------
	
	public void setupEvents() {
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		bt_buscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				tf_cedula.setEditable(false);
				
				Connection con = null;
				
				try {
					con = getConnection();
					ps = (PreparedStatement) con.prepareStatement("SELECT *FROM usuarios WHERE idusuarios = ?");
					ps.setString(1, tf_cedula.getText());
					
					re = ps.executeQuery();
							
					if(re.next()) {
						tf_nombre.setText(re.getString("nombre"));
						tf_apellido.setText(re.getString("apellido"));
						tf_direccion.setText(re.getString("direccion"));
						tf_telefono.setText(re.getString("telefono"));
						tf_rol.setText(re.getString("rol"));
					}else {
						JOptionPane.showMessageDialog(null, "ERROR!!");
					}
			}catch (Exception e1) {
				System.err.println(e1);
			}
			}
		});	
		
		bt_aceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				getContentPane().add(new Inicio());
			}
		});
	}	
}

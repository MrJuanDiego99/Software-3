package Ventanas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import java.awt.Color;

public class actualizar_ciente extends JFrame {
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
	
	private JLabel            lb_cedula, lb_nombre, lb_apellido, lb_telefono, lb_direccion, lb_email, lb_genero, lb_tittle, lb_regis;
	private JTextField        tf_buscar, tf_nombre, tf_apellido, tf_telefono, tf_direccion, tf_email;
	private JComboBox         cb_genero;
	private JButton           bt_buscar, bt_actualizar;
	private actualizar_ciente actucli = this;
	
	//---------------------------------------
	
	public actualizar_ciente() {
		setTitle("SW Prestamo - Inversion");
		setSize(700,468);
		setLocationRelativeTo(null);
		setupWidgets();
		setupEvents();
	    setVisible(true);
	}
	//-------------------------------------------
	
	public void setupWidgets() {
		
		lb_cedula = new JLabel("Cedula(ID)");
		lb_cedula.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lb_nombre = new JLabel("Nombre");
		lb_nombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lb_apellido = new JLabel("Apellido");
		lb_apellido.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
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
		
		lb_regis = new JLabel("Actualizar Cliente");
		lb_regis.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		
		tf_buscar    = new JTextField();
		tf_nombre    = new JTextField(); 
		tf_apellido  = new JTextField();
		tf_telefono  = new JTextField(); 
		tf_direccion = new JTextField(); 
		tf_email     = new JTextField();
		
		cb_genero = new JComboBox();
		cb_genero.addItem("Femenino");
		cb_genero.addItem("Masculino");
		cb_genero.addItem("Otro");
		
		bt_actualizar = new JButton("Actualizar");
		bt_actualizar.setFont(new Font("Tahoma", Font.ITALIC, 19));
		
		bt_buscar = new JButton("Buscar");
		bt_buscar.setForeground(Color.BLUE);
		bt_buscar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		getContentPane().setLayout(null);
		
		getContentPane().add(lb_cedula); lb_cedula.setBounds(149, 151, 92, 20);
		getContentPane().add(tf_buscar); tf_buscar.setBounds(268, 151, 183, 20);

		getContentPane().add(lb_nombre); lb_nombre.setBounds(80, 206, 62, 20);
		getContentPane().add(tf_nombre); tf_nombre.setBounds(162, 208, 183, 20);
		
		getContentPane().add(lb_apellido); lb_apellido.setBounds(363, 206, 62, 20);
		getContentPane().add(tf_apellido); tf_apellido.setBounds(451, 208, 190, 20);
		
		getContentPane().add(lb_telefono); lb_telefono.setBounds(363, 255, 76, 30);
		getContentPane().add(tf_telefono); tf_telefono.setBounds(451, 262, 190, 20);
		
		getContentPane().add(lb_direccion); lb_direccion.setBounds(80, 255, 92, 30);
		getContentPane().add(tf_direccion); tf_direccion.setBounds(162, 262, 171, 20);
		
		getContentPane().add(lb_genero); lb_genero.setBounds(80, 313, 92, 30);
		getContentPane().add(cb_genero); cb_genero.setBounds(150, 320, 183, 20);
		
		getContentPane().add(lb_email); lb_email.setBounds(363, 313, 62, 30);
		getContentPane().add(tf_email); tf_email.setBounds(428, 320, 190, 20);
		
		getContentPane().add(lb_tittle); lb_tittle.setBounds(198, 40, 303, 30);
		
		getContentPane().add(lb_regis); lb_regis.setBounds(269, 83, 170, 30);
		
		getContentPane().add(bt_actualizar); bt_actualizar.setBounds(255, 364, 183, 40);
		
		getContentPane().add(bt_buscar); bt_buscar.setBounds(474, 137, 85, 40);
		
	}
	//-------------------------------------------
	
	public void setupEvents() {
		
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		
		bt_buscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				tf_buscar.setEditable(false);
				
				Connection con = null;

				try {
					con = getConnection();
					ps = (PreparedStatement) con.prepareStatement("SELECT *FROM clientes WHERE idcliente = ?");
					ps.setString(1, tf_buscar.getText());
					
					re = ps.executeQuery();
					 if(re.next()) {
						 tf_nombre.setText(re.getString("nombre"));
						 tf_apellido.setText(re.getString("apellido"));
						 tf_direccion.setText(re.getString("direccion"));
						 tf_telefono.setText(re.getString("telefono"));
						 cb_genero.setSelectedItem(re.getString("genero"));
						 tf_email.setText(re.getString("email"));
					 } else {
						 JOptionPane.showMessageDialog(null, "No hay nada salchichon");
					 }	 
				} catch (Exception e2) {
					System.err.println(e2);
				}				
				
			}
		});
		
		bt_actualizar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				Connection con = null;
				
				try {
					con = getConnection();
					ps = (PreparedStatement) con.prepareStatement("UPDATE clientes SET nombre = ?, apellido = ?, telefono = ?, email = ?, genero = ?, direccion = ? WHERE idcliente = ?");
					ps.setString(1, tf_nombre.getText());
					ps.setString(2, tf_apellido.getText());
					ps.setString(3, tf_telefono.getText());
					ps.setString(4, tf_email.getText());
					ps.setString(5, cb_genero.getSelectedItem().toString());
					ps.setString(6, tf_direccion.getText());
					ps.setString(7, tf_buscar.getText());
					
					int res = ps.executeUpdate();
					if(res>0) {
						getContentPane().add(new exitoso_actucli(actucli));
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

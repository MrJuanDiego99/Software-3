package Ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import jdk.nashorn.internal.ir.ForNode;

public class registro_usuario extends JFrame{
	
	//-----------------------------------------------
	
	public static final String URL = "jdbc:mysql://localhost:3306/software";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "juan9907";
	
	PreparedStatement ps;
	Result re;
	
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
	
	//-------------------------------------------
	
	private JLabel            lb_nombre, lb_apellido, lb_cedula, lb_telefono, lb_direccion, lb_rol, lb_clave, lb_mensaje, lb_regis, lb_tittle;
	private JTextField        tf_nombre, tf_apellido, tf_cedula, tf_telefono, tf_direccion, tf_clave;
	private JComboBox         cb_rol;
	private JButton           bt_regist;
	private registro_usuario  frameru = this;
	
	//-------------------------------------------
	
	public registro_usuario() {
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
		
		lb_rol = new JLabel("Rol");
		lb_rol.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lb_clave = new JLabel("Clave");
		lb_clave.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lb_mensaje = new JLabel("*Si selecciono el rol de jefe de credito");
		lb_mensaje.setForeground(Color.RED);
		
		lb_tittle = new JLabel("BANK LOAN AND FUTURE");
		lb_tittle.setFont(new Font("Sitka Subheading", Font.BOLD, 24));
		
		lb_regis = new JLabel("Registrar Usuario");
		lb_regis.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		
		tf_nombre    = new JTextField(); 
		tf_apellido  = new JTextField(); 
		tf_cedula    = new JTextField(); 
		tf_telefono  = new JTextField(); 
		tf_direccion = new JTextField(); 
		tf_clave     = new JTextField();
		
		cb_rol = new JComboBox();
		cb_rol.addItem("Auxiliar de credito");
		cb_rol.addItem("Jefe de credito");
		
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
		
		getContentPane().add(lb_rol); lb_rol.setBounds(50, 301, 92, 30);
		getContentPane().add(cb_rol); cb_rol.setBounds(106, 308, 201, 20);
		
		getContentPane().add(lb_cedula); lb_cedula.setBounds(50, 201, 92, 30);
		getContentPane().add(tf_cedula); tf_cedula.setBounds(154, 208, 141, 20);
		
		getContentPane().add(lb_clave); lb_clave.setBounds(343, 283, 48, 30);
		getContentPane().add(tf_clave); tf_clave.setBounds(403, 290, 218, 20);
		
		getContentPane().add(lb_mensaje); lb_mensaje.setBounds(403, 260, 238, 30);
		
		getContentPane().add(lb_tittle); lb_tittle.setBounds(198, 40, 303, 30);
		
		getContentPane().add(lb_regis); lb_regis.setBounds(255, 83, 150, 30);
		
		getContentPane().add(bt_regist); bt_regist.setBounds(284, 364, 141, 54);
		
		
	}
	//-------------------------------------------
	
	public void setupEvents() {
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		bt_regist.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				Connection con = null;
				
				try{
					con = getConnection();
					ps = (PreparedStatement) con.prepareStatement("INSERT INTO usuarios(idusuarios, nombre, apellido, telefono, direccion, rol, clave) VALUES(?,?,?,?,?,?,?)");
					ps.setString(1, tf_cedula.getText());
					ps.setString(2, tf_nombre.getText());
					ps.setString(3, tf_apellido.getText());
					ps.setString(4, tf_telefono.getText());
					ps.setString(5, tf_direccion.getText());
					ps.setString(6, cb_rol.getSelectedItem().toString());
					ps.setString(7, tf_clave.getText());
					
					int res = ps.executeUpdate();
					if(res > 0) {
						add(new exitoso_usu(frameru));					
					}else {
						JOptionPane.showMessageDialog(null, "Error hp");
					}
				}catch (Exception e) {
					System.err.println(e);
					
				}	
			}
		});
		
		
		
		/*bt_regist.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent ev) {
				if(ev.getClickCount()==1) {
					add(new exitoso_usu(frameru));
				}
			}
		});*/
		
	}
}

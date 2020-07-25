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

public class actualizar_rol extends JFrame{
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
	//-------------------------------------------
	
	private JLabel                lb_mensajec, lb_tittle, lb_mensaje, lb_new, lb_cedula, lb_clave;
	private JTextField            tf_cedula, tf_clave;
	private JButton               bt_actualizar;
	private JComboBox             cb_rol;
	private actualizar_rol  actusoli = this;
	
	//-------------------------------------------
	
	public actualizar_rol() {
		setTitle("SW Prestamo - Inversion");
		setSize(503,450);
		setLocationRelativeTo(null);
		setupWidgets();
		setupEvents();
	    setVisible(true);
	}
	//-------------------------------------------
	
	public void setupWidgets() {
			
		lb_cedula = new JLabel("Cedula (ID)");
		lb_cedula.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lb_clave = new JLabel("Clave");
		lb_clave.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lb_new = new JLabel("Seleccione el nuevo rol");
		lb_new.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lb_mensaje = new JLabel("*Si selecciono el rol de Jefe");
		lb_mensaje.setForeground(Color.RED);
		lb_mensaje.setFont(new Font("Tahoma", Font.PLAIN, 12));
	
		lb_tittle = new JLabel("BANK LOAN AND FUTURE");
		lb_tittle.setFont(new Font("Sitka Subheading", Font.BOLD, 24));
		
		lb_mensajec = new JLabel("Actualizar rol");
		lb_mensajec.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
	
		tf_cedula = new JTextField(); 
		tf_clave = new JTextField();
		
		cb_rol = new JComboBox();
		cb_rol.addItem("Auxiliar de credito");
		cb_rol.addItem("Jefe de credito");
		
		bt_actualizar = new JButton("Actualizar");
		bt_actualizar.setFont(new Font("Tahoma", Font.ITALIC, 19));
		
		
		getContentPane().setLayout(null);
		
		getContentPane().add(lb_cedula); lb_cedula.setBounds(93, 140, 106, 20);
		getContentPane().add(tf_cedula); tf_cedula.setBounds(205, 144, 191, 20);
		
		getContentPane().add(lb_clave); lb_clave.setBounds(155, 238, 61, 20);
		getContentPane().add(tf_clave); tf_clave.setBounds(208, 242, 106, 20);
		
		getContentPane().add(lb_new); lb_new.setBounds(52, 192, 199, 20);
		getContentPane().add(cb_rol); cb_rol.setBounds(253, 194, 179, 23);
		
		getContentPane().add(lb_mensaje); lb_mensaje.setBounds(205, 268, 199, 20);
		
		getContentPane().add(lb_tittle); lb_tittle.setBounds(93, 49, 303, 30);
		
		getContentPane().add(bt_actualizar); bt_actualizar.setBounds(170, 327, 128, 52);
		
        getContentPane().add(lb_mensajec); lb_mensajec.setBounds(186, 89, 128, 29);
		
		
	}
	//-------------------------------------------
	
	public void setupEvents() {
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		bt_actualizar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Connection con = null;
				
				try {
					con = getConnection();
					ps = (PreparedStatement) con.prepareStatement("UPDATE usuarios SET rol = ? WHERE idusuarios = ? ");
					ps.setString(1, cb_rol.getSelectedItem().toString());
					ps.setString(2, tf_cedula.getText());
					
					int res = ps.executeUpdate();
					if(res>0) {
						getContentPane().add(new exitoso_rol(actusoli));
					}else {
						JOptionPane.showMessageDialog(null, "ERROR!!");
					}
			}catch (Exception e1) {
				System.err.println(e1);
			}
			}		
		});
	}

}

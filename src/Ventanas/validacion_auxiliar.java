package Ventanas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

public class validacion_auxiliar extends JDialog{
	
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
	//--------------------------------------------
	
	private JButton    bt_getin;
	private JTextField tf_cedula;
	private JLabel     lb_cedula;
	private menu_rol   selectrol;
	
	//--------------------------------------------
	
	public validacion_auxiliar(menu_rol h) {
		super(h, true);
		selectrol = h;
		setTitle("Auxiliar de Credito");
		setSize(387,247);
		setLocationRelativeTo(null);
		setupWidgets();
		setupEvents();
		setVisible(true);
	}
	//--------------------------------------------
	
	public void setupWidgets() {
		
        tf_cedula = new JTextField();
		
		lb_cedula = new JLabel("Cedula (ID)");
		lb_cedula.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		bt_getin = new JButton("Entrar");
		bt_getin.setFont(new Font("Tahoma", Font.ITALIC, 25));
		
		getContentPane().setLayout(null);
		
		getContentPane().add(lb_cedula); lb_cedula.setBounds(24, 41, 104, 34);
		getContentPane().add(tf_cedula); tf_cedula.setBounds(153, 50, 204, 22);
		getContentPane().add(bt_getin); bt_getin.setBounds(112, 112, 137, 50);
		
	}
	//--------------------------------------------

	private void setupEvents() {
		
		bt_getin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Connection con = null;
				
				try{
					con = getConnection();
					ps = (PreparedStatement) con.prepareStatement("SELECT *FROM usuarios WHERE idusuarios = ?");
					ps.setString(1, tf_cedula.getText());
					
					re = ps.executeQuery();
					
					if(re.next()) {
						selectrol.setVisible(false);
						getContentPane().add(new menu_aux());
					}else {
						JOptionPane.showMessageDialog(null, "Usuario no encontrado");
					}
				}catch (Exception e1) {
					System.err.println(e1);
					
				}					
			}
		});	
	}
}

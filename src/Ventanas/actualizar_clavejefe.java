package Ventanas;

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

public class actualizar_clavejefe extends JFrame {
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
	
	private JLabel                lb_mensajec, lb_tittle, lb_cedula, lb_nuevaclave;
	private JTextField            tf_cedula, tf_nuevaclave;
	private JButton               bt_actualizar;
	private actualizar_clavejefe  actusoli = this;
	
	//-------------------------------------------
	
	public actualizar_clavejefe() {
		setTitle("SW Prestamo - Inversion");
		setSize(503,397);
		setLocationRelativeTo(null);
		setupWidgets();
		setupEvents();
	    setVisible(true);
	}
	//-------------------------------------------
	
	public void setupWidgets() {
			
		lb_cedula = new JLabel("Cedula (ID)");
		lb_cedula.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lb_nuevaclave = new JLabel("Digite la nueva clave");
		lb_nuevaclave.setFont(new Font("Tahoma", Font.PLAIN, 18));
	
		lb_tittle = new JLabel("BANK LOAN AND FUTURE");
		lb_tittle.setFont(new Font("Sitka Subheading", Font.BOLD, 24));
		
		lb_mensajec = new JLabel("Actualizar Clave");
		lb_mensajec.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
	
		tf_cedula = new JTextField(); 
		
		tf_nuevaclave = new JTextField();
		
		bt_actualizar = new JButton("Actualizar");
		bt_actualizar.setFont(new Font("Tahoma", Font.ITALIC, 19));
		
		
		getContentPane().setLayout(null);
		
		getContentPane().add(lb_cedula); lb_cedula.setBounds(93, 140, 106, 20);
		getContentPane().add(tf_cedula); tf_cedula.setBounds(205, 144, 191, 20);
		
		getContentPane().add(lb_nuevaclave); lb_nuevaclave.setBounds(63, 183, 179, 20);
		getContentPane().add(tf_nuevaclave); tf_nuevaclave.setBounds(240, 187, 191, 20);
		
		getContentPane().add(lb_tittle); lb_tittle.setBounds(93, 49, 303, 30);
		
		getContentPane().add(bt_actualizar); bt_actualizar.setBounds(171, 243, 155, 68);
		
        getContentPane().add(lb_mensajec); lb_mensajec.setBounds(171, 89, 146, 29);
		
		
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
					ps = (PreparedStatement) con.prepareStatement("UPDATE usuarios SET clave = ? WHERE idusuarios = ? ");
					ps.setString(1, tf_nuevaclave.getText());
					ps.setString(2, tf_cedula.getText());
					
					int res = ps.executeUpdate();
					if(res>0) {
						getContentPane().add(new exitoso_clave(actusoli));
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

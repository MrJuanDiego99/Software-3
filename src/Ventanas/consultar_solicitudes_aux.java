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

public class consultar_solicitudes_aux extends JFrame {
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
	
	private JLabel                lb_consultar, lb_cedula, lb_fecha, lb_tasa, lb_monto, lb_garantia, lb_regis, lb_tittle;
	private JTextField            tf_consultar, tf_cedula, tf_fecha, tf_tasa, tf_monto, tf_garantia;
	private JButton               bt_consultar, bt_aceptar;
	
	//-------------------------------------------
	
	public consultar_solicitudes_aux() {
		setTitle("SW Prestamo - Inversion");
		setSize(700,500);
		setLocationRelativeTo(null);
		setupWidgets();
		setupEvents();
	    setVisible(true);
	}
	//-------------------------------------------
	
	public void setupWidgets() {
		
		lb_consultar = new JLabel("No. Solicitud");
		lb_consultar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lb_cedula = new JLabel("Cedula (ID)");
		lb_cedula.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lb_fecha = new JLabel("Fecha");
		lb_fecha.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lb_tasa = new JLabel("Tasa de interes");
		lb_tasa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lb_monto = new JLabel("Monto");
		lb_monto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lb_garantia = new JLabel("Garantia");
		lb_garantia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lb_tittle = new JLabel("BANK LOAN AND FUTURE");
		lb_tittle.setFont(new Font("Sitka Subheading", Font.BOLD, 24));
		
		lb_regis = new JLabel("Solicitud a consultar");
		lb_regis.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		
		tf_consultar = new JTextField();
		
		tf_cedula = new JTextField();
		tf_cedula.setEditable(false);
		
		tf_fecha = new JTextField(); 
		tf_fecha.setEditable(false);
		
		tf_tasa = new JTextField(); 
		tf_tasa.setEditable(false);
		
		tf_monto = new JTextField();
		tf_monto.setEditable(false);
		
		tf_garantia = new JTextField();
		tf_garantia.setEditable(false);
		tf_monto.setEditable(false);
		
		bt_consultar = new JButton("Consultar");
		bt_consultar.setForeground(Color.BLUE);
		bt_consultar.setFont(new Font("Tahoma", Font.ITALIC, 19));
		
		bt_aceptar = new JButton("Aceptar");
		bt_aceptar.setForeground(Color.BLACK);
		bt_aceptar.setFont(new Font("Tahoma", Font.ITALIC, 19));
		
		getContentPane().setLayout(null);
		
		getContentPane().add(lb_consultar); lb_consultar.setBounds(163, 161, 106, 20);
		getContentPane().add(bt_consultar); bt_consultar.setBounds(422, 155, 119, 30);
		
		getContentPane().add(lb_cedula); lb_cedula.setBounds(184, 214, 106, 20);
		getContentPane().add(tf_cedula); tf_cedula.setBounds(302, 216, 199, 20);
		
		getContentPane().add(lb_fecha); lb_fecha.setBounds(74, 265, 62, 20);
		getContentPane().add(tf_fecha); tf_fecha.setBounds(145, 267, 170, 20);
		
		getContentPane().add(lb_tasa); lb_tasa.setBounds(327, 260, 127, 30);
		getContentPane().add(tf_tasa); tf_tasa.setBounds(466, 267, 153, 20);
		
		getContentPane().add(lb_monto); lb_monto.setBounds(74, 308, 76, 30);
		getContentPane().add(tf_monto); tf_monto.setBounds(148, 315, 170, 20);
		
		getContentPane().add(lb_garantia); lb_garantia.setBounds(334, 308, 76, 30);
		getContentPane().add(tf_garantia); tf_garantia.setBounds(422, 315, 201, 20);
		
		getContentPane().add(tf_consultar); tf_consultar.setBounds(293, 163, 108, 20);
		
		getContentPane().add(lb_tittle); lb_tittle.setBounds(198, 49, 303, 30);
		
		getContentPane().add(lb_regis); lb_regis.setBounds(255, 92, 199, 30);
		
		getContentPane().add(bt_aceptar); bt_aceptar.setBounds(278, 371, 132, 47);
		
		
	}
	//-------------------------------------------
	
	public void setupEvents() {
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		bt_consultar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Connection con = null;
				
				try {
					con =  getConnection();
					ps = (PreparedStatement) con.prepareStatement("SELECT *FROM solicitudes WHERE id = ?");
					ps.setString(1, tf_consultar.getText());
					
					re = ps.executeQuery();
					
					if(re.next()) {
						tf_cedula.setText(re.getString("cliente_idcliente"));
						tf_fecha.setText(re.getString("fecha"));
						tf_tasa.setText(re.getString("tasa_interes"));
						tf_monto.setText(re.getString("monto"));
						tf_garantia.setText(re.getString("garantia"));
						
					}else {
						JOptionPane.showMessageDialog(null, "No hay nada salchichon");
					}
			} catch (Exception e1){
				System.err.println(e1);
			}
			}
		});	
		
		bt_aceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				add(new menu_aux());
			}
		});
	}
}

package Ventanas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
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

public class registro_solicitud extends JFrame {
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
	
	private JLabel              lb_mensajec, lb_num, lb_usu, lb_cedula, lb_fecha, lb_tasa, lb_monto, lb_garantia, lb_regis, lb_tittle, lb_estado;
	private JTextField          tf_num, tf_usu, tf_cedula, tf_fecha, tf_tasa, tf_monto;
	private JComboBox           cb_garantia, cb_estado;
	private JButton             bt_regist;
	private registro_solicitud  framers = this;
	
	//-------------------------------------------
	
	public registro_solicitud() {
		setTitle("SW Prestamo - Inversion");
		setSize(700,500);
		setLocationRelativeTo(null);
		setupWidgets();
		setupEvents();
	    setVisible(true);
	}
	//-------------------------------------------
	
	public void setupWidgets() {
		
		lb_num = new JLabel("No de Solicitud");
		lb_num.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lb_usu = new JLabel("ID usuario");
		lb_usu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
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
		
		lb_estado = new JLabel("Estado");
		lb_estado.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lb_tittle = new JLabel("BANK LOAN AND FUTURE");
		lb_tittle.setFont(new Font("Sitka Subheading", Font.BOLD, 24));
		
		lb_regis = new JLabel("Registrar Solicitud");
		lb_regis.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		
		lb_mensajec = new JLabel("Cliente*");
	    lb_mensajec.setFont(new Font("Tahoma", Font.BOLD, 13));
		lb_mensajec.setForeground(Color.RED);
		
		tf_usu = new JTextField();
		tf_num = new JTextField();
		tf_cedula = new JTextField(); 
		tf_fecha  = new JTextField(); 
		tf_tasa   = new JTextField(); 
		tf_monto  = new JTextField();
		
		cb_garantia = new JComboBox();
		cb_garantia.addItem("Fiador");
		cb_garantia.addItem("Hipoteca");
		cb_garantia.addItem("Letra de Cambio");
		
		cb_estado = new JComboBox();
		cb_estado.addItem("PENDIENTE");
		
		bt_regist = new JButton("Registrar");
		bt_regist.setFont(new Font("Tahoma", Font.ITALIC, 19));
		
		getContentPane().setLayout(null);
		
		getContentPane().add(lb_num); lb_num.setBounds(74, 171, 127, 20);
		getContentPane().add(tf_num); tf_num.setBounds(213, 173, 106, 20);
		
		getContentPane().add(lb_usu); lb_usu.setBounds(74, 350, 106, 20);
		getContentPane().add(tf_usu); tf_usu.setBounds(185, 352, 199, 20);
		
		getContentPane().add(lb_cedula); lb_cedula.setBounds(331, 171, 106, 20);
		getContentPane().add(tf_cedula); tf_cedula.setBounds(432, 173, 191, 20);
		
		getContentPane().add(lb_fecha); lb_fecha.setBounds(74, 225, 62, 20);
		getContentPane().add(tf_fecha); tf_fecha.setBounds(148, 227, 170, 20);
		
		getContentPane().add(lb_tasa); lb_tasa.setBounds(331, 220, 127, 30);
		getContentPane().add(tf_tasa); tf_tasa.setBounds(470, 227, 153, 20);
		
		getContentPane().add(lb_monto); lb_monto.setBounds(74, 286, 76, 30);
		getContentPane().add(tf_monto); tf_monto.setBounds(148, 293, 170, 20);
		
		getContentPane().add(lb_garantia); lb_garantia.setBounds(334, 286, 76, 30);
		getContentPane().add(cb_garantia); cb_garantia.setBounds(422, 293, 201, 20);
		
		getContentPane().add(lb_estado); lb_estado.setBounds(74, 394, 76, 30);
		getContentPane().add(cb_estado); cb_estado.setBounds(162, 401, 201, 20);
		
		getContentPane().add(lb_tittle); lb_tittle.setBounds(198, 49, 303, 30);
		
		getContentPane().add(lb_regis); lb_regis.setBounds(255, 92, 170, 30);
		
		getContentPane().add(bt_regist); bt_regist.setBounds(446, 342, 155, 68);
 
        getContentPane().add(lb_mensajec); lb_mensajec.setBounds(341, 191, 68, 16);
		
		
	}
	//-------------------------------------------
	
	public void setupEvents() {
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		bt_regist.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				Connection con = null;
				
								
				try {
					con =  getConnection();
					ps = (PreparedStatement) con.prepareStatement("INSERT INTO solicitudes (id, fecha, tasa_interes, monto, garantia, estado, cliente_idcliente, usuarios_idusuarios ) VALUES (?,?,?,?,?,?,?,?)");
					ps.setString(1, tf_num.getText());
					ps.setDate(2, Date.valueOf(tf_fecha.getText()));
					ps.setString(3, tf_tasa.getText());
					ps.setString(4, tf_monto.getText());
					ps.setString(5, cb_garantia.getSelectedItem().toString());
					ps.setString(6, cb_estado.getSelectedItem().toString());
					ps.setString(7, tf_cedula.getText());
					ps.setString(8, tf_usu.getText());
					
					int res = ps.executeUpdate();
					if(res>0) {
						getContentPane().add(new exitoso_soli(framers));
					} else {
						JOptionPane.showMessageDialog(null, "Error hp");
					}
				} catch (Exception e) {
					System.err.println(e);
				}
			}
		});	
	}	
}

package Ventanas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

public class validacion_inge1 extends JDialog {
	//--------------------------------------
	
	private JButton        bt_getin;
	private JPasswordField pf_key;
	private JLabel         lb_key;
	private Inicio         mainframe;
	
	//--------------------------------------
	
	public validacion_inge1(Inicio f) {
		super(f, true);
		mainframe = f;
		setTitle("Superusuario");
		setSize(350,230);
		setLocationRelativeTo(null);
		setupWidgets();
		setupEvents();
		setVisible(true);
	}
	//--------------------------------------
	
	private void setupWidgets() {
		
		pf_key = new JPasswordField();
		
		lb_key = new JLabel("Clave");
		lb_key.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		bt_getin = new JButton("Entrar");
		bt_getin.setFont(new Font("Tahoma", Font.ITALIC, 25));
		
		getContentPane().setLayout(null);
		
		getContentPane().add(lb_key); lb_key.setBounds(24, 41, 80, 34);
		getContentPane().add(pf_key); pf_key.setBounds(94, 50, 204, 22);
		getContentPane().add(bt_getin); bt_getin.setBounds(101, 111, 123, 40);
		
	}
	//--------------------------------------
	
	private void setupEvents() {
		
		bt_getin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//String valorPass = new String(pf_key.getPassword());
				//String c = "123";
				//if(valorPass == c ) {
					mainframe.setVisible(false);
					getContentPane().add(new actualizar_rol());
				//} else {
					//JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
				//}
			}
		});		
	}
}

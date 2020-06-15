package Ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JDialog;
import javax.swing.JLabel;

public class exitoso_soli extends JDialog {
	
	private JLabel             lb_mensaje;
	private registro_solicitud framers;
	
	//-----------------------------------
	
	public exitoso_soli(registro_solicitud k) {
		super (k, true);
		framers = k;
		setTitle("");
		setSize(350,150);
		setLocationRelativeTo(null);
		setupWidgets();
		setupEvents();
		setVisible(true);
	}
	//--------------------------------------
	
	private void setupWidgets() {
		
		lb_mensaje = new JLabel("REGISTRO EXITOSO!!");
		lb_mensaje.setFont(new Font("Tahoma", Font.BOLD, 25));
		lb_mensaje.setForeground(new Color(51, 204, 0));
		
		getContentPane().setLayout(null);
		
		getContentPane().add(lb_mensaje); lb_mensaje.setBounds(35, 33, 270, 30);
		
	}
	//--------------------------------------
	
	private void setupEvents() {
		
		this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				framers.setVisible(false);
				getContentPane().add(new menu_rol());
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});	
	}
}

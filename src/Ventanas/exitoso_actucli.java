package Ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JDialog;
import javax.swing.JLabel;

public class exitoso_actucli extends JDialog{
	//-----------------------------------
	
	private JLabel               lb_mensaje;
	private actualizar_ciente    actucli;
	
	//-----------------------------------
	
	public exitoso_actucli(actualizar_ciente j) {
		super (j, true);
		actucli = j;
		setTitle("");
		setSize(431,150);
		setLocationRelativeTo(null);
		setupWidgets();
		setupEvents();
		setVisible(true);
	}
	//--------------------------------------
	
	private void setupWidgets() {
		
		lb_mensaje = new JLabel("ACTUALIZACION EXITOSA!!");
		lb_mensaje.setFont(new Font("Tahoma", Font.BOLD, 25));
		lb_mensaje.setForeground(new Color(51, 204, 0));
		
		getContentPane().setLayout(null);
		
		getContentPane().add(lb_mensaje); lb_mensaje.setBounds(35, 33, 360, 30);
		
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
				actucli.setVisible(false);
				getContentPane().add(new menu_aux());
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

package Ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JDialog;
import javax.swing.JLabel;

public class aprobada extends JDialog{
	private JLabel             lb_mensaje;
	private estudiar_solicitudes framees;
	
	//-----------------------------------
	public aprobada(estudiar_solicitudes c) {
		super(c, true);
		framees = c;
		setTitle("");
		setSize(396,150);
		setLocationRelativeTo(null);
		setupWidgets();
		setupEvents();
		setVisible(true);
		
	}
	//-----------------------------------
	
	private void setupWidgets() {
		
		lb_mensaje = new JLabel("SOLICITUD APROBADA!!");
		lb_mensaje.setFont(new Font("Tahoma", Font.BOLD, 25));
		lb_mensaje.setForeground(new Color(51, 204, 0));
		
		getContentPane().setLayout(null);
		
		getContentPane().add(lb_mensaje); lb_mensaje.setBounds(35, 33, 316, 30);
				
	}
	//-----------------------------------
	
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
			    framees.setVisible(false);
			    getContentPane().add(new menu_rol());

		    }
		
		    @Override
		    public void windowClosed(WindowEvent e) {
			    // TODO Auto-generated method stub
			
		    }
		
		    @Override
		    public void windowActivated(WindowEvent e) {
			    // TODO Auto-generated method stub
			
		    }
     	});		
   }

}

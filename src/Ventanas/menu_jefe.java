package Ventanas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class menu_jefe extends JFrame {
	//---------------------------------
	
	private JButton   bt_visualizar, bt_consultar, bt_registrar;
	private JLabel    lb_title, lb_selctoper;
	private menu_jefe framemj = this;
	
	//---------------------------------
	public menu_jefe() {
		setTitle("SW Prestamo - Inversion");
		setSize(581,400);
		setLocationRelativeTo(null);
		setupWidgets();
		setupEvents();
		setVisible(true);
	}
	//-------------------------------------
	
	private void setupWidgets() {
		
		bt_visualizar = new JButton("Visualizar Pendientes");
		bt_visualizar.setFont(new Font("Tahoma", Font.ITALIC, 15));
		
		bt_consultar = new JButton("Consultar Solicitud");
		bt_consultar.setFont(new Font("Tahoma", Font.ITALIC, 15));
		
		bt_registrar = new JButton("Registrar Solicitudes");
		bt_registrar.setFont(new Font("Tahoma", Font.ITALIC, 15));
		
		lb_title = new JLabel("BANK LOAN AND FUTURE");
		lb_title.setFont(new Font("Sitka Subheading", Font.BOLD, 24));
		
		lb_selctoper = new JLabel("\u00BFque desea hacer?");
		lb_selctoper.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));

        getContentPane().setLayout(null);
		
		getContentPane().add(bt_visualizar); bt_visualizar.setBounds(88, 184, 179, 45);
		getContentPane().add(bt_consultar); bt_consultar.setBounds(309, 184, 179, 45);
		getContentPane().add(bt_registrar); bt_registrar.setBounds(85, 255, 192, 45);
		
		getContentPane().add(lb_title); lb_title.setBounds(144, 55, 298, 16);
		getContentPane().add(lb_selctoper);lb_selctoper.setBounds(213, 111, 167, 30);
					
	}
	//------------------------------------
	
	private void setupEvents() {
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		bt_visualizar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getContentPane().add(new solicitudes_pendientes(framemj));
			}
		});
		
		bt_consultar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				getContentPane().add(new estudiar_solicitudes());
			}
		});
		
		bt_registrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				getContentPane().add(new registro_solicitud());
				
			}
		});
	}
}

package Ventanas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class menu_rol extends JFrame{
	//-------------------------------------
	
	private JButton  bt_aux, bt_jefe;
	private JLabel   lb_title, lb_selectrol;
	private menu_rol selectrol = this;
	
	//-------------------------------------
	
	public menu_rol() {
		setTitle("SW Prestamo - Inversion");
		setSize(581,400);
		setLocationRelativeTo(null);
		setupWidgets();
		setupEvents();
		setVisible(true);
	}
	//-------------------------------------
	
	private void setupWidgets() {
		
		bt_aux = new JButton("Auxiliar de Credito");
		bt_aux.setFont(new Font("Tahoma", Font.ITALIC, 15));
		
		bt_jefe = new JButton("Jefe de Credito");
		bt_jefe.setFont(new Font("Tahoma", Font.ITALIC, 15));
		
		lb_title = new JLabel("BANK LOAN AND FUTURE");
		lb_title.setFont(new Font("Sitka Subheading", Font.BOLD, 24));
		
		lb_selectrol = new JLabel("Seleccione su Rol");
		lb_selectrol.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));

        getContentPane().setLayout(null);
		
		getContentPane().add(bt_aux); bt_aux.setBounds(93, 193, 160, 45);
		getContentPane().add(bt_jefe); bt_jefe.setBounds(346, 193, 147, 45);
		
		getContentPane().add(lb_title); lb_title.setBounds(143, 55, 298, 16);
		getContentPane().add(lb_selectrol);lb_selectrol.setBounds(213, 117, 160, 16);
					
	}
	//------------------------------------
	
	private void setupEvents() {
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		bt_aux.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				add(new validacion_auxiliar(selectrol));
			}
		});
		
		bt_jefe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				add(new validacion_jefe(selectrol));
				
			}
		});		
	}
}

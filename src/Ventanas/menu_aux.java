package Ventanas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class menu_aux extends JFrame {
	//---------------------------------
	
	private JButton  bt_regiscli, bt_regissoli, bt_actusoli, bt_actucli, bt_visualizar, bt_consultar, bt_visuclientes, bt_consulclientes;
	private JLabel   lb_title, lb_selctoper;
	private menu_aux frameaux = this;
	
	//---------------------------------
	public menu_aux() {
		setTitle("SW Prestamo - Inversion");
		setSize(581,534);
		setLocationRelativeTo(null);
		setupWidgets();
		setupEvents();
		setVisible(true);
	}
	//-------------------------------------
	
	private void setupWidgets() {
		
		bt_regiscli = new JButton("Registrar Cliente");
		bt_regiscli.setFont(new Font("Tahoma", Font.ITALIC, 15));
		
		bt_regissoli = new JButton("Registrar Solicitud");
		bt_regissoli.setFont(new Font("Tahoma", Font.ITALIC, 15));
		
		bt_actusoli = new JButton("Actualizar Solicitud");
		bt_actusoli.setFont(new Font("Tahoma", Font.ITALIC, 15));
		
		bt_actucli = new JButton("Actualizar Cliente");
		bt_actucli.setFont(new Font("Tahoma", Font.ITALIC, 15));
		
		bt_visualizar = new JButton("Visualizar Solicitudes");
		bt_visualizar.setFont(new Font("Tahoma", Font.ITALIC, 15));
		
		bt_consultar = new JButton("Consultar Solicitud");
		bt_consultar.setFont(new Font("Tahoma", Font.ITALIC, 15));
		
		bt_visuclientes = new JButton("Visualizar Clientes");
		bt_visuclientes.setFont(new Font("Tahoma", Font.ITALIC, 15));
		
		bt_consulclientes = new JButton("Consultar Clientes");
		bt_consulclientes.setFont(new Font("Tahoma", Font.ITALIC, 15));
		
		lb_title = new JLabel("BANK LOAN AND FUTURE");
		lb_title.setFont(new Font("Sitka Subheading", Font.BOLD, 24));
		
		lb_selctoper = new JLabel("\u00BFque desea hacer?");
		lb_selctoper.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));

        getContentPane().setLayout(null);
		
		getContentPane().add(bt_regiscli); bt_regiscli.setBounds(112, 184, 147, 45);
		getContentPane().add(bt_regissoli); bt_regissoli.setBounds(325, 184, 147, 45);
		getContentPane().add(bt_actusoli); bt_actusoli.setBounds(100, 253, 167, 45);
		getContentPane().add(bt_actucli); bt_actucli.setBounds(318, 253, 167, 45);
		getContentPane().add(bt_visualizar); bt_visualizar.setBounds(100, 325, 167, 45);
		getContentPane().add(bt_consultar); bt_consultar.setBounds(318, 325, 167, 45);
		getContentPane().add(bt_visuclientes); bt_visuclientes.setBounds(100, 397, 167, 45);
		getContentPane().add(bt_consulclientes); bt_consulclientes.setBounds(318, 397, 167, 45);
		
		getContentPane().add(lb_title); lb_title.setBounds(144, 41, 298, 30);
		getContentPane().add(lb_selctoper);lb_selctoper.setBounds(213, 111, 167, 30);
		
							
	}
	//------------------------------------
	
	private void setupEvents() {
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		bt_regiscli.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				getContentPane().add(new registro_cliente());			
			}
		});

		bt_regissoli.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				getContentPane().add(new registro_solicitud());
			}
		});	
		
		bt_actusoli.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				getContentPane().add(new actualizar_solicitud());			
			}
		});
		
		bt_actucli.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				getContentPane().add(new actualizar_ciente());	
			}
		});
		
		bt_visualizar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getContentPane().add(new visualizar_solicitudes_aux(frameaux));
			}
		});
		
		bt_consultar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				getContentPane().add(new consultar_solicitudes_aux());
			}
		});
		
		bt_visuclientes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().add(new visualizar_clientes(frameaux));
			}
		});
		
		bt_consulclientes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				getContentPane().add(new consultar_clientes());	
			}
		});
	}
}

package Ventanas;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class visualizar_clientes extends JDialog{
	//----------------------------------------------
	private JTable                     tb_solicitudes;
	private DefaultTableModel          tm_solicitudespendientes;
	private menu_aux                  frameaux;
	//----------------------------------------------
	
	public visualizar_clientes (menu_aux z) {
		super(z, true);
		frameaux = z;
		setTitle("Solicitudes Pendientes");
		setSize(387,247);
		setLocationRelativeTo(null);
		setupWidgets();
		setupEvents();
		setVisible(true);
	}
	//----------------------------------------------
	
	public void setupWidgets() {
		
		tm_solicitudespendientes = new DefaultTableModel(new Object[] {"Clientes Registrados"},0);
		tm_solicitudespendientes.addRow(new Object[] {"Nombre: Daniel Bolaños  Cedula(ID): 102030"});
		tm_solicitudespendientes.addRow(new Object[] {"Nombre: Jhon Jimenez    Cedula(ID): 12745590"});
		tm_solicitudespendientes.addRow(new Object[] {"Nombre: Sara Uribe      Cedula(ID): 12745590"});
		tm_solicitudespendientes.addRow(new Object[] {"Nombre: Lina Revelo     Cedula(ID): 30758691 "});
		
		tb_solicitudes = new JTable();
		tb_solicitudes.setModel(tm_solicitudespendientes);
		tb_solicitudes.setEnabled(false);
		
		add(new JScrollPane(tb_solicitudes), BorderLayout.CENTER);
			
	}
	//----------------------------------------------
	
	public void setupEvents() {
		/*ls_solicitudes.addAncestorListener(new AncestorListener() {
			
			@Override
			public void ancestorRemoved(AncestorEvent event) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void ancestorMoved(AncestorEvent event) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void ancestorAdded(AncestorEvent event) {
				// TODO Auto-generated method stub
				
			}
		});*/
	}
}

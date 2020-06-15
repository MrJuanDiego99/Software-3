package Ventanas;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class visualizar_solicitudes_aux extends JDialog{
	//----------------------------------------------
	private JTable                     tb_solicitudes;
	private DefaultTableModel          tm_solicitudespendientes;
	private menu_aux                  frameaux;
	//----------------------------------------------
	
	public visualizar_solicitudes_aux (menu_aux z) {
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
		
		tm_solicitudespendientes = new DefaultTableModel(new Object[] {"Solicitudes Creada"},0);
		tm_solicitudespendientes.addRow(new Object[] {"001 -- 002 -- 003"});
		
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

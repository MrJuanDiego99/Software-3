package Ventanas;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class solicitudes_pendientes extends JDialog{
	//----------------------------------------------
	private JTable                     tb_solicitudes;
	private DefaultTableModel          tm_solicitudespendientes;
	private menu_jefe                  framemj;
	//----------------------------------------------
	
	public solicitudes_pendientes (menu_jefe z) {
		super(z, true);
		framemj = z;
		setTitle("Solicitudes Pendientes");
		setSize(387,247);
		setLocationRelativeTo(null);
		setupWidgets();
		setupEvents();
		setVisible(true);
	}
	//----------------------------------------------
	
	public void setupWidgets() {
		
		tm_solicitudespendientes = new DefaultTableModel(new Object[] {"Numero de solicitud"},0);
		tm_solicitudespendientes.addRow(new Object[] {"001 -- 002"});
		
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

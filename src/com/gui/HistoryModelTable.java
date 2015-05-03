package com.gui;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class HistoryModelTable extends AbstractTableModel {
	
	private ArrayList<String> addresses;
	
	
	public HistoryModelTable(ArrayList<String> addresses) {
		this.addresses = addresses;
	}
	@Override
	public int getColumnCount() {
		return 1;
	}

	@Override
	public int getRowCount() {
		return addresses.size();
	
	}

	@Override
	public Object getValueAt(int row, int col) {
		return addresses.get(row);
	}

}

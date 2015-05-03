package com.gui;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTable;

public class History extends JFrame {
	private JTable table;
	private ArrayList<String> addresses;
	private HistoryModelTable model;
	private MainFrame frame;
	public History(MainFrame frame) {
		this.frame = frame;
		addresses = new ArrayList<>();
		model = new HistoryModelTable(addresses);
		table = new JTable(model);
		setLayout(new BorderLayout());
		add(table, BorderLayout.CENTER);
		table.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent arg0) {
				if (arg0.getKeyChar() == '\n') {
				}

			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosing(WindowEvent arg0) {
				setVisible(false);
			}

			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		setSize(200, 300);
	}

	public void addAddress(String address) {
		try {
			new URL(address);
			addresses.add(address);
		} catch (MalformedURLException e) {
		}
	}

	public void refresh() {
		model.fireTableDataChanged();
	}
}

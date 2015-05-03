package com.gui;
import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import org.lobobrowser.html.gui.HtmlPanel;


public class TabbedPane extends JTabbedPane {
	
	private static int population = 0; // Number of Tabs.
	private MainFrame frame;
	
	public TabbedPane(MainFrame frame){
		super();
		this.frame = frame;
	}
	
	public void addTab(){
		JPanel panel = new TabPack(frame);
		
		addTab("New Tab",panel);
		population++;
	}
	
}
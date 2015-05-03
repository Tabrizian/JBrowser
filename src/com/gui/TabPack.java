package com.gui;
import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.JTextField;

import org.lobobrowser.html.gui.HtmlPanel;
import org.lobobrowser.html.gui.SelectionChangeEvent;
import org.lobobrowser.html.gui.SelectionChangeListener;

import com.gui.buttons.Go;


public class TabPack extends JPanel implements KeyListener,SelectionChangeListener {
	private JTextField addressBar;
	private HtmlPanel pageBrowser;
	private MainFrame frame;
	private String lastAddress = " ";
	
	public TabPack(MainFrame frame){
		addressBar = new JTextField();
		pageBrowser = new HtmlPanel(frame);
		this.frame = frame;
		
		addressBar.addKeyListener(this);
		pageBrowser.addSelectionChangeListener(this);
		
		setLayout(new BorderLayout());
		
		add(addressBar, BorderLayout.NORTH);
		add(pageBrowser, BorderLayout.CENTER);
	}
	
	public JTextField getAddressBar(){
		return addressBar;
	}

	public HtmlPanel getPageBrowser() {
		return pageBrowser;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		Go button = (Go) ((Toolbar)frame.getToolbar()).getGo();
		if(arg0.getKeyChar() == '\n')
			button.doClick();
			
	}

	public String getLastAddress() {
		return lastAddress;
	}

	public void setLastAddress(String lastAddress) {
		this.lastAddress = lastAddress;
	}

	@Override
	public void selectionChanged(SelectionChangeEvent event) {
		frame.updateRContext();
		String current = frame.getHtmlRendererContext().getCurrentURL();
		if(current != null)
		((TabPack) frame.getTabs().getSelectedComponent()).getAddressBar().setText(current);
	}


	
	
	
}

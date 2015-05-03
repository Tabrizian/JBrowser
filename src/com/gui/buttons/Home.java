package com.gui.buttons;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import com.gui.MainFrame;


public class Home extends JButton implements ActionListener{
	
	private String homeAddress = "http://google.com";
	private MainFrame jFrame;
	
	public Home(MainFrame jFrame){
		super();
		this.jFrame = jFrame;
	}
	
	public void init(){
		setIcon(createIcon());
		setMargin(new Insets(10, 10, 10, 10));
		setBorder(BorderFactory.createEmptyBorder());
		setToolTipText("Home");
		addActionListener(this);
	}
	
	public ImageIcon createIcon(){
		URL url = getClass().getResource("/ico/home168.png");
		ImageIcon icon = new ImageIcon(url);
		return icon;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		jFrame.process(homeAddress);
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getHomeAddress() {
		return homeAddress;
	}
}

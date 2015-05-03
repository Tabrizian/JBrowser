package com.gui.buttons;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import com.gui.MainFrame;
import com.gui.TabPack;

public class Go extends JButton implements ActionListener {

	private MainFrame jFrame;

	public Go(MainFrame jFrame) {
		super();
		this.jFrame = jFrame;
	}

	public void init() {
		setIcon(createIcon());
		setMargin(new Insets(10, 10, 10, 10));
		setBorder(BorderFactory.createEmptyBorder());
		addActionListener(this);
		setToolTipText("Go");
	}

	public ImageIcon createIcon() {
		URL url = getClass().getResource("/ico/play106.png");
		ImageIcon icon = new ImageIcon(url);
		return icon;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		jFrame.process(((TabPack) jFrame.getTabs().getSelectedComponent())
				.getAddressBar().getText());
	}
}

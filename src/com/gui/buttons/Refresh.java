package com.gui.buttons;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import com.gui.MainFrame;

public class Refresh extends JButton implements ActionListener {
	private MainFrame jFrame;

	public Refresh(MainFrame jFrame) {
		super();
		this.jFrame = jFrame;
	}

	public void init() {
		setIcon(createIcon());
		setMargin(new Insets(10, 10, 10, 10));
		setBorder(BorderFactory.createEmptyBorder());
		addActionListener(this);
		setToolTipText("Refresh");
	}

	public ImageIcon createIcon() {
		URL url = getClass().getResource("/ico/arrows130.png");
		ImageIcon icon = new ImageIcon(url);
		return icon;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		jFrame.process(jFrame.getHtmlRendererContext().getCurrentURL());
	}
}

package com.gui.buttons;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import com.gui.MainFrame;
import com.gui.TabPack;

public class Back extends JButton implements ActionListener {

	private MainFrame jFrame;
	private boolean backed;

	public Back(MainFrame jFrame) {
		super();
		this.jFrame = jFrame;
	}

	public void init() {
		setIcon(createIcon());
		setMargin(new Insets(2, 2, 0, 0));
		setBorder(BorderFactory.createEmptyBorder());
		addActionListener(this);
		setToolTipText("Back");
	}

	public ImageIcon createIcon() {
		URL url = getClass().getResource("/ico/left222.png");
		ImageIcon icon = new ImageIcon(url);
		return icon;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (jFrame.getHtmlRendererContext().getPreviousURL() != null && !backed) {
			backed = true;
			jFrame.navigate(jFrame.getHtmlRendererContext().getPreviousURL());
		}
	}

	public boolean isBacked() {
		return backed;
	}

	public void setBacked(boolean backed) {
		this.backed = backed;
	}
}

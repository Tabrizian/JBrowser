package com.gui.buttons;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import com.gui.MainFrame;
import com.gui.Toolbar;

public class Forward extends JButton implements ActionListener {
	private MainFrame jFrame;
	private boolean forwarded = false;

	public Forward(MainFrame jFrame) {
		super();
		this.jFrame = jFrame;
	}

	public void init() {
		setIcon(createIcon());
		setMargin(new Insets(10, 10, 10, 10));
		setBorder(BorderFactory.createEmptyBorder());
		addActionListener(this);
		setToolTipText("Forward");
	}

	public ImageIcon createIcon() {
		URL url = getClass().getResource("/ico/right11.png");
		ImageIcon icon = new ImageIcon(url);
		return icon;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String nextURL = jFrame.getHtmlRendererContext().getPreviousURL();
		if (nextURL != null
				&& ((Back) ((Toolbar) jFrame.getToolbar()).getBack())
						.isBacked()) {
			jFrame.navigate(nextURL);
			forwarded = true;
			((Back) ((Toolbar) jFrame.getToolbar()).getBack())
			.setBacked(false);
		}
	}
}

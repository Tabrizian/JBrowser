package com.gui;
import javax.swing.JButton;
import javax.swing.JToolBar;

import com.gui.buttons.Back;
import com.gui.buttons.Forward;
import com.gui.buttons.Go;
import com.gui.buttons.Home;
import com.gui.buttons.Refresh;

public class Toolbar extends JToolBar {

	private JButton home;
	private JButton back;
	private JButton forward;
	private JButton refresh;
	private JButton go;

	public Toolbar(MainFrame jFrame) {
		setFloatable(false);
		home = new Home(jFrame);
		back = new Back(jFrame);
		forward = new Forward(jFrame);
		refresh = new Refresh(jFrame);
		go = new Go(jFrame);
		
		((Back) back).init();
		((Forward) forward).init();
		((Go) go).init();
		((Home) home).init();
		((Refresh) refresh).init();
		
		add(back);
		add(forward);
		add(refresh);
		add(home);
		add(go);
	}

	
	public JButton getGo() {
		return go;
	}

	public JButton getHome() {
		return home;
	}

	public JButton getBack() {
		return back;
	}

	public JButton getForward() {
		return forward;
	}

	public JButton getRefresh() {
		return refresh;
	}

}

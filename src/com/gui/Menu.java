package com.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterJob;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import com.gui.buttons.Home;

/**
 * @author Iman Tabrizian
 * MenuBar customized for JBrowser.
 *
 */
public class Menu extends JMenuBar {

	private MainFrame frame;
	private String copiedText;
	private boolean toggle = true;

	/**
	 * Constructor of MenuBar.
	 * @param frame : receives MainFrame. 
	 */
	public Menu(MainFrame frame) {
		super();
		this.frame = frame;

	}

	/**
	 * Intializing menu bar.
	 */
	public void init() {
		JMenu file = new JMenu("File");
		JMenuItem newTab = new JMenuItem("New Tab");
		JMenuItem showHistory = new JMenuItem("Show History");
		JMenuItem print = new JMenuItem("Print");
		JMenuItem closeTab = new JMenuItem("Close Tab");
		JMenuItem exit = new JMenuItem("Exit");
		
		//Setting mnemonics
		
		file.setMnemonic(KeyEvent.VK_F);
		newTab.setMnemonic(KeyEvent.VK_N);
		showHistory.setMnemonic(KeyEvent.VK_S);
		print.setMnemonic(KeyEvent.VK_P);
		closeTab.setMnemonic(KeyEvent.VK_C);
		exit.setMnemonic(KeyEvent.VK_X);
		
		//Setting Accelerators
		newTab.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T,ActionEvent.CTRL_MASK));
		showHistory.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,ActionEvent.CTRL_MASK));
		print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
		closeTab.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,ActionEvent.CTRL_MASK));
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
		
		JMenu edit = new JMenu("Edit");
		JMenuItem copy = new JMenuItem("Copy");
		JMenuItem paste = new JMenuItem("Paste");
		JMenuItem setHome = new JMenuItem("Set Home Page");
		
		//Setting mnemonics
		edit.setMnemonic(KeyEvent.VK_E);
		copy.setMnemonic(KeyEvent.VK_C);
		paste.setMnemonic(KeyEvent.VK_P);
		setHome.setMnemonic(KeyEvent.VK_H);
		
		//Setting Accelerators
		copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
		paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,ActionEvent.CTRL_MASK));
		setHome.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,ActionEvent.CTRL_MASK));
		
		JMenu help = new JMenu("Help");
		JMenuItem about = new JMenuItem("About me");
		JMenuItem javaDoc = new JMenuItem("Javadoc");
		
		//Setting mnemonics
		help.setMnemonic(KeyEvent.VK_H);
		about.setMnemonic(KeyEvent.VK_A);
		javaDoc.setMnemonic(KeyEvent.VK_J);
		
		//Setting accelerator
		about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
		javaDoc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2,ActionEvent.CTRL_MASK));
		
		add(file);
		file.add(newTab);
		file.add(showHistory);
		file.add(print);
		file.add(closeTab);
		file.add(exit);

		add(edit);
		edit.add(copy);
		edit.add(paste);
		edit.add(setHome);

		add(help);
		help.add(about);
		help.add(javaDoc);

		// File menu...

		newTab.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.getTabs().addTab();
			}
		});

		closeTab.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.getTabs().remove(frame.getTabs().getSelectedComponent());
			}
		});
		
		showHistory.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(toggle){
					frame.showHistory();
				}
				else{
					frame.hideHistory();
				}
				toggle = !toggle;
			}
		});

		print.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				PrinterJob job = PrinterJob.getPrinterJob();
				job.setPrintable(((TabPack) Menu.this.frame.getTabs()
						.getSelectedComponent()).getPageBrowser());
				boolean ok = job.printDialog();
				if (ok) {
					try {
						job.print();
					} catch (Exception e) {
					}
				}

			}
		});
		
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});

		// Edit Menu...

		copy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				copiedText = ((TabPack) ((TabbedPane) frame.getTabs())
						.getSelectedComponent()).getPageBrowser()
						.getSelectionText();
			}
		});

		paste.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				((TabPack) ((TabbedPane) frame.getTabs())
						.getSelectedComponent()).getAddressBar().setText(
						copiedText);
			}
		});

		setHome.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Home home = ((Home) ((Toolbar) frame.getToolbar()).getHome());
				home.setHomeAddress(JOptionPane.showInputDialog(null));
			}
		});

		// Help Menu
		about.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "This JavaApplication programmed by Iman Tabrizian.\nAll rights reserved.\nCopyright 2015");
			}
		});
		
		javaDoc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.navigate("C:\\Users\\dell-iman\\workspace\\JBrowser\\doc\\index.html");
			}
		});

		this.setVisible(true);
	}
}

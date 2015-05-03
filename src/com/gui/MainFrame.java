package com.gui;
import com.jtattoo.*;
import java.awt.BorderLayout;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.UIManager;

import org.lobobrowser.html.HtmlRendererContext;
import org.lobobrowser.html.UserAgentContext;
import org.lobobrowser.html.gui.HtmlPanel;
import org.lobobrowser.html.test.SimpleHtmlRendererContext;
import org.lobobrowser.html.test.SimpleUserAgentContext;

import com.Main;

/**
 * @author Iman Tabrizian
 * The JFrame of the application is placed here. 
 * Page browser in included in tabs with an address bar.
 */
public class MainFrame extends JFrame {

	private JToolBar toolbar;
	private JMenuBar menu;
	/**
	 * Application tabs.
	 */
	private JTabbedPane tabs;
	private History historyPanel;
	/**
	 * The cobra logging tool.
	 */
	private static final Logger logger = Logger.getLogger(Main.class.getName());
	private SimpleHtmlRendererContext rcontext;
	private final UserAgentContext ucontext;

	/**
	 * Application constructor.
	 */
	public MainFrame() {
		super("JBrowser");
		ucontext = new SimpleUserAgentContext();
		this.rcontext = new LocalHtmlRendererContext(null, ucontext);
	}

	/**
	 * Initializing MainFrame.
	 */
	public void init() {
		try{
			UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
		}catch(Exception e){
			
		}
		toolbar = new Toolbar(this);
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		menu = new Menu(this);
		((Menu) menu).init();
		tabs = new TabbedPane(this);
		((TabbedPane) tabs).addTab();
		historyPanel = new History(this);

		setLayout(new BorderLayout());

		panel.add(toolbar, BorderLayout.CENTER);
		panel.add(menu, BorderLayout.NORTH);
		add(panel, BorderLayout.NORTH);
		add(tabs, BorderLayout.CENTER);
		

		setSize(800, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setVisible(true);
		((TabPack) tabs.getSelectedComponent()).getAddressBar().requestFocus();

	}

	/**
	 * HTML content renderer made by cobra.
	 * @return rcontext.
	 */
	public HtmlRendererContext getHtmlRendererContext() {
		return this.rcontext;
	}
	
	
	/**
	 * @param uri : destination uri.
	 * navigates through the specified uri.
	 */
	public void navigate(String uri) {
		updateRContext();
		((TabPack) tabs.getSelectedComponent()).getAddressBar().setText(uri);
		this.process(uri);
	}

	/**
	 * process the addressbar string.
	 * @param uri : addressbar string.
	 */
	public void process(String uri) {
		updateRContext();
		try {
			URL url;
			try {
				url = new URL(uri);
			} catch (java.net.MalformedURLException mfu) {
				int idx = uri.indexOf(':');
				if (idx == -1 || idx == 1) {
					// try file
					url = new URL("file:" + uri);
				} else {
					throw mfu;
				}
			}
			// Call SimpleHtmlRendererContext.navigate()
			// which implements incremental rendering.
			this.rcontext.navigate(url, null);
		} catch (Exception err) {
			logger.log(Level.SEVERE, "Error trying to load URI=[" + uri + "].",
					err);
		}
	}

	/**
	 * @author Iman Tabrizian
	 * Updates the Context Render when choosing diffrent tabs.
	 */
	public void updateRContext() {
		this.rcontext = new LocalHtmlRendererContext(
				((TabPack) tabs.getSelectedComponent()).getPageBrowser(),
				ucontext);
	}

	/**
	 * @return frame tabs.
	 */
	public TabbedPane getTabs() {
		return (TabbedPane) tabs;
	}
	
	/**
	 * @return frame toolbar.
	 */
	public JToolBar getToolbar() {
		return toolbar;
	}
	
	public void showHistory(){
		historyPanel.setVisible(true);
	}
	
	public void hideHistory(){
		historyPanel.setVisible(false);
	}

	private class LocalHtmlRendererContext extends SimpleHtmlRendererContext {
		public LocalHtmlRendererContext(HtmlPanel contextComponent,
				UserAgentContext ucontext) {
			super(contextComponent, ucontext);
		}

		@Override
		public HtmlRendererContext open(URL url, String windowName,
				String windowFeatures, boolean replace) {
			MainFrame frame = new MainFrame();
			frame.setSize(600, 400);
			frame.setExtendedState(MainFrame.NORMAL);
			frame.setVisible(true);
			HtmlRendererContext ctx = frame.getHtmlRendererContext();
			ctx.setOpener(this);
			frame.navigate(url.toExternalForm());
			return ctx;
		}
	}

	public History getHistoryPanel() {
		return historyPanel;
	}
}

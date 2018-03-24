package lm44_xw47.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

/**
 * Following defines main frame for the game application.
 * 
 * @author Lu Ma
 * @author Xiaojun Wu
 *
 * @param <TListItem> The type for the driplits item.
 */
public class MainViewFrame<TListItem> extends JFrame {

	/**
	 * The adapter the view uses to communicate with model.
	 */
	private final IMainView2ModelAdapter<TListItem> _mainView2ModelAdapter;

	/**
	 * The drop list item.
	 */
	private TListItem item;

	/**
	 * An auto generated id for serialization.
	 */
	private static final long serialVersionUID = -3097617897364258363L;

	/**
	 * The panel used to contain contents.
	 */
	private JPanel contentPane;

	/**
	 * The button used to make a map GUI.
	 */
	private final JButton btnMakeMapGUI = new JButton("Make Map on GUI thread");

	/**
	 * The adapter this view used to communicate with controller.
	 */
	private IMainView2ControllerAdapter controller;

	private final JButton btnMakeMapNonGUI = new JButton("Make Map fully on Non-GUI thread");
	private final JButton btnMakeMapPartiallyNonGUI = new JButton("Make Map partially on Non-GUI Thread");
	private final JButton btnMakeMapBQ = new JButton("Make Map using BQ");

	/**
	 * The panel used to contain control components.
	 */
	private final JPanel ctrlPnl = new JPanel();

	/**
	 * The text field used to enter an ip address.
	 */
	private final JTextField ipField = new JTextField();

	/**
	 * The button used to connect a remote user.
	 */
	private final JButton btnConnect = new JButton("Connect");

	/**
	 * The button used to enter messages.
	 */
	private final JTextField textMessageField = new JTextField();

	/**
	 * The button used to send messages.
	 */
	private final JButton btnSend = new JButton("Send");

	/**
	 * The text area used to display log information.
	 */
	private final JTextArea logArea = new JTextArea();

	/**
	 * The bar for the menu.
	 */
	private final JMenuBar menuBar = new JMenuBar();

	/**
	 * The item for menu.
	 */
	private final JMenuItem menuOption = new JMenuItem("Menu");

	/**
	 * The panel used to contain log info text area.
	 */
	private final JScrollPane scrollPane = new JScrollPane();

	/**
	 * The panel used to hold log info and games.
	 */
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

	/**
	 * Constructor.
	 * 
	 * @param controller The adapter this view used to communicate with controller.
	 * @param adapter The adpater this view used to commnicate with model.
	 */
	public MainViewFrame(IMainView2ControllerAdapter controller, IMainView2ModelAdapter<TListItem> adapter) {
		_mainView2ModelAdapter = adapter;
		textMessageField.setColumns(10);
		ipField.setColumns(10);
		initGUI();
		this.controller = controller;
	}

	/**
	 * Initialize main GUI.
	 */
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 611, 447);

		setJMenuBar(menuBar);

		menuBar.add(menuOption);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		contentPane.add(ctrlPnl, BorderLayout.NORTH);
		GridBagLayout gbl_ctrlPnl = new GridBagLayout();
		gbl_ctrlPnl.columnWidths = new int[] { 189, 134, 117, 0, 0 };
		gbl_ctrlPnl.rowHeights = new int[] { 26, 26, 0, 0, 0, 0, 0 };
		gbl_ctrlPnl.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_ctrlPnl.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		ctrlPnl.setLayout(gbl_ctrlPnl);
		GridBagConstraints gbc_ipField = new GridBagConstraints();
		gbc_ipField.fill = GridBagConstraints.HORIZONTAL;
		gbc_ipField.anchor = GridBagConstraints.NORTH;
		gbc_ipField.insets = new Insets(0, 0, 5, 5);
		gbc_ipField.gridx = 0;
		gbc_ipField.gridy = 0;
		ctrlPnl.add(ipField, gbc_ipField);

		GridBagConstraints gbc_btnConnect = new GridBagConstraints();
		gbc_btnConnect.fill = GridBagConstraints.VERTICAL;
		gbc_btnConnect.insets = new Insets(0, 0, 5, 5);
		gbc_btnConnect.gridx = 1;
		gbc_btnConnect.gridy = 0;
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				item = _mainView2ModelAdapter.connect(ipField.getText());
				if (item != null) {
					appendLog("Connect successfully.");
				}
			}
		});
		ctrlPnl.add(btnConnect, gbc_btnConnect);

		GridBagConstraints gbc_textMessageField = new GridBagConstraints();
		gbc_textMessageField.anchor = GridBagConstraints.NORTH;
		gbc_textMessageField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textMessageField.insets = new Insets(0, 0, 5, 5);
		gbc_textMessageField.gridx = 0;
		gbc_textMessageField.gridy = 1;
		ctrlPnl.add(textMessageField, gbc_textMessageField);

		GridBagConstraints gbc_btnSend = new GridBagConstraints();
		gbc_btnSend.insets = new Insets(0, 0, 5, 5);
		gbc_btnSend.gridx = 1;
		gbc_btnSend.gridy = 1;
		ctrlPnl.add(btnSend, gbc_btnSend);
		GridBagConstraints gbc_btnMakeMapGUI = new GridBagConstraints();
		gbc_btnMakeMapGUI.insets = new Insets(0, 0, 5, 5);
		gbc_btnMakeMapGUI.gridx = 0;
		gbc_btnMakeMapGUI.gridy = 2;
		//panel_1.add(btnMakeMapGUI, gbc_btnMakeMapGUI);
		GridBagConstraints gbc_btnMakeMapNonGUI = new GridBagConstraints();
		gbc_btnMakeMapNonGUI.insets = new Insets(0, 0, 5, 5);
		gbc_btnMakeMapNonGUI.gridx = 0;
		gbc_btnMakeMapNonGUI.gridy = 3;
		//panel_1.add(btnMakeMapNonGUI, gbc_btnMakeMapNonGUI);
		GridBagConstraints gbc_btnMakeMapPartiallyNonGUI = new GridBagConstraints();
		gbc_btnMakeMapPartiallyNonGUI.insets = new Insets(0, 0, 5, 5);
		gbc_btnMakeMapPartiallyNonGUI.gridx = 0;
		gbc_btnMakeMapPartiallyNonGUI.gridy = 4;
		//panel_1.add(btnMakeMapPartiallyNonGUI, gbc_btnMakeMapPartiallyNonGUI);
		GridBagConstraints gbc_btnMakeMapBQ = new GridBagConstraints();
		gbc_btnMakeMapBQ.insets = new Insets(0, 0, 0, 5);
		gbc_btnMakeMapBQ.gridx = 0;
		gbc_btnMakeMapBQ.gridy = 5;
		ctrlPnl.add(btnMakeMapBQ, gbc_btnMakeMapBQ);
		btnMakeMapBQ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.runJob(new Runnable() {

					@Override
					public void run() {
						System.out.println("Main thread job running.");
						controller.makeMap(); // Instantiate the map on the main thread
						controller.startMap(); // put it on the main thread to avoid paint bug.
						//						SwingUtilities.invokeLater(new Runnable() {   // Show the map on the GUI thread.
						//
						//							@Override
						//							public void run() {
						//								controller.startMap();	
						//							}
						//							
						//						});
					}

				});
			}
		});
		btnMakeMapPartiallyNonGUI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				(new Thread() {
					@Override
					public void run() {
						controller.makeMap();
						SwingUtilities.invokeLater(new Runnable() {

							@Override
							public void run() {
								controller.startMap();
							}

						});
					}
				}).start();
			}
		});
		btnMakeMapNonGUI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				(new Thread() {
					@Override
					public void run() {
						controller.makeMap();
						controller.startMap();
					}
				}).start();
			}
		});
		btnMakeMapGUI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.makeMap();
				controller.startMap();
			}
		});
		tabbedPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//tabbedPane.repaint();
				System.out.println("repaint");
				contentPane.repaint();
			}
		});

		contentPane.add(tabbedPane, BorderLayout.CENTER);
		tabbedPane.add("Log", scrollPane);
		scrollPane.setViewportView(logArea);

	}

	/**
	 * Start the main GUI.
	 */
	public void start() {
		setVisible(true);
	}

	/**
	 * Display info to the log area.
	 * 
	 * @param str The info being displayed on log area.
	 */
	public void appendLog(String str) {
		logArea.append(str + "\n");
	}

	/**
	 * add miniView to tabbedPane
	 * 
	 * @param mapView The map view being added to tabbedPane.
	 * @param lable The tab name.
	 */
	public void addMiniView(Component mapView, String label) {
		tabbedPane.add(label, mapView);
	}

}

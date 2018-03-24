package lm44_xw47.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import map.MapPanel;

import com.jgoodies.forms.layout.FormSpecs;
import java.awt.Insets;
import javax.swing.JTextArea;
import javax.swing.JTabbedPane;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AppStartFrame<TListItem> extends JFrame {

	/**
	 * 
	 */
	private final IMainView2ModelAdapter<TListItem> _mainView2ModelAdapter;
	private TListItem item;
	
	private static final long serialVersionUID = -3097617897364258363L;
	private JPanel contentPane;
	private final JButton btnMakeMapGUI = new JButton("Make Map on GUI thread");
	private IAppStart2Controller controller;
	private final JButton btnMakeMapNonGUI = new JButton("Make Map fully on Non-GUI thread");
	private final JButton btnMakeMapPartiallyNonGUI = new JButton("Make Map partially on Non-GUI Thread");
	private final JButton btnMakeMapBQ = new JButton("Make Map using BQ");
	private final JPanel panel_1 = new JPanel();
	private final JTextField ipField = new JTextField();
	private final JButton btnConnect = new JButton("Connect");
	private final JTextField textMessageField = new JTextField();
	private final JButton btnSend = new JButton("Send");
	private final JPanel panel_2 = new JPanel();
	private final JTextArea logArea = new JTextArea();
	private final JMenuBar menuBar = new JMenuBar();
	private final JMenuItem menuOption = new JMenuItem("Menu");
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	
	
	


	/**
	 * Create the frame.
	 */
	public AppStartFrame(IAppStart2Controller controller, IMainView2ModelAdapter<TListItem> adapter) {
		_mainView2ModelAdapter = adapter;
		textMessageField.setColumns(10);
		ipField.setColumns(10);
		initGUI();
		this.controller = controller;
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 611, 447);
		
		setJMenuBar(menuBar);
		
		menuBar.add(menuOption);
		
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		contentPane.add(panel_1, BorderLayout.NORTH);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{189, 134, 117, 0, 0};
		gbl_panel_1.rowHeights = new int[]{26, 26, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		GridBagConstraints gbc_ipField = new GridBagConstraints();
		gbc_ipField.fill = GridBagConstraints.HORIZONTAL;
		gbc_ipField.anchor = GridBagConstraints.NORTH;
		gbc_ipField.insets = new Insets(0, 0, 5, 5);
		gbc_ipField.gridx = 0;
		gbc_ipField.gridy = 0;
		panel_1.add(ipField, gbc_ipField);
		
		GridBagConstraints gbc_btnConnect = new GridBagConstraints();
		gbc_btnConnect.fill = GridBagConstraints.VERTICAL;
		gbc_btnConnect.insets = new Insets(0, 0, 5, 5);
		gbc_btnConnect.gridx = 1;
		gbc_btnConnect.gridy = 0;
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				item = _mainView2ModelAdapter.connect(ipField.getText());
				if(item != null) {
					appendLog("Connect successfully.");
				}
			}
		});
		panel_1.add(btnConnect, gbc_btnConnect);
		
		GridBagConstraints gbc_textMessageField = new GridBagConstraints();
		gbc_textMessageField.anchor = GridBagConstraints.NORTH;
		gbc_textMessageField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textMessageField.insets = new Insets(0, 0, 5, 5);
		gbc_textMessageField.gridx = 0;
		gbc_textMessageField.gridy = 1;
		panel_1.add(textMessageField, gbc_textMessageField);
		
		GridBagConstraints gbc_btnSend = new GridBagConstraints();
		gbc_btnSend.insets = new Insets(0, 0, 5, 5);
		gbc_btnSend.gridx = 1;
		gbc_btnSend.gridy = 1;
		panel_1.add(btnSend, gbc_btnSend);
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
		panel_1.add(btnMakeMapBQ, gbc_btnMakeMapBQ);
		btnMakeMapBQ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.runJob(new Runnable(){

					@Override
					public void run() {
						System.out.println("Main thread job running.");
						controller.makeMap();   // Instantiate the map on the main thread
						controller.startMap();  // put it on the main thread to avoid paint bug.
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
		
		contentPane.add(panel_2, BorderLayout.SOUTH);
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
	
	public void start() {
		setVisible(true);
	}
	
	/**
	 * Display info to the log area.
	 * @param str
	 */
	public void appendLog(String str) {
		logArea.append(str + "\n");
	}
	
	/**
	 * add miniView to tabbedPane
	 */
	public void addMiniView(JPanel mapView) {
		tabbedPane.add("Map panel", mapView);
	}

}

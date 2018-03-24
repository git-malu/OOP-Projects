package lm44_yb22.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


import java.awt.event.ActionListener;

import java.util.function.Consumer;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.MouseEvent;

import java.awt.event.MouseAdapter;

/**
 * Main MVC
 * 
 */
public class MainView extends JFrame {
	
	/**
	 * View to model adapter
	 */
//	private IMain2ModelAdpt view2ModelAdpt;
	private IMainViewAdapter mainViewAdapter;
	
	
	
	/**
	 * Serial version id
	 */
	private static final long serialVersionUID = -1102405858279143552L;

	/**
	 * Tab panel
	 */
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

	/**
	 * JPanel
	 */
	private final JPanel panel = new JPanel();

	/**
	 * Scroll panel
	 */
	private final JScrollPane scrollPane = new JScrollPane();

	/**
	 * Logging textarea
	 */
	private final JTextArea logArea = new JTextArea();

	/**
	 * Menu bar
	 */
	private final JMenuBar menuBar = new JMenuBar();

	/**
	 * Menu item
	 */
	private final JMenu mn_option = new JMenu("Menu");

	/**
	 * Menu item for connect
	 */
	private final JMenuItem mntm_connect = new JMenuItem("Connect");

	/**
	 * Menu item for create
	 */
	private final JMenuItem mntm_create = new JMenuItem("Create Room");



	/**
	 * Constructor
	 */
	public MainView() {
		initGUI();
	}

	/**
	 * Constructor
	 * @param mainViewAdapter
	 */
	public MainView(IMainViewAdapter mainViewAdapter) {
		this.mainViewAdapter = mainViewAdapter;
		initGUI();
	}
	

	/**
	 * Initialization of GUI
	 */
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
//				view2ModelAdpt.closeChatApp();
				System.out.println("Close ChatApp.");
			}
		});
		setTitle("ChatApp");
		setSize(800, 600);
		setLocationRelativeTo(null);
		tabbedPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("state changed");
				mainViewAdapter.updateUserListView();
			}
		});
//		tabbedPane.addContainerListener(new ContainerAdapter() {
//			@Override
//			public void componentAdded(ContainerEvent e) {
//				
//			}
//		});
		

		tabbedPane.setToolTipText("Tab Panel.");
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		tabbedPane.addTab("Log", null, panel, null);
		panel.setLayout(new BorderLayout(0, 0));
		panel.add(scrollPane);
		logArea.setToolTipText("Log.");
		scrollPane.setViewportView(logArea);

		setJMenuBar(menuBar);
		menuBar.add(mn_option);
		mn_option.setToolTipText("Select from the menu.");
		
		//connect button in the menu
		//connect to other users!
		mntm_connect.addActionListener((ActionEvent e) -> {
			String ip = JOptionPane.showInputDialog("Input remote user IP to connect:");
			if (ip == null) {
				return;
			}
			
			
			EventQueue.invokeLater(() -> {
				//IUser user = view2ModelAdpt.connect(ip);
				
				//connect first
				// no need to return for now, all the work should be done in main model
				mainViewAdapter.connectTo(ip);
				
			});
		});

		mn_option.add(mntm_connect);
		mntm_connect.setToolTipText("Connect to other user.");
		mntm_create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String roomName = JOptionPane.showInputDialog("Input a room name");
//				view2ModelAdpt.creatRoom(returnVal);
				mainViewAdapter.createChatRoom(roomName);
			}
		});

		mn_option.add(mntm_create);
		mntm_create.setToolTipText("Create a new chatroom.");
	}

	/**
	 * Start the view
	 */
	public void start() {
		setVisible(true);
	}

	/**
	 * Install the mini view to main view
	 * @param miniView The mini view
	 */
//	public void install(MiniView<IChatServer> miniView) {
//		tabbedPane.add(miniView.toString(), miniView);
//	}

	/**
	 * Append info to logging text area
	 * @param log info The text to be appended
	 */
	public void logDisplay(String log) {
		logArea.append(log + "\n");
	}

	/**
	 * Leave a room
	 * @param miniView Mini view
	 */
//	public void leaveRoom(MiniView<IChatServer> miniView) {
//		tabbedPane.remove(miniView);
//	}
	/**
	 * This method returns the display method for RMIUtil to print info to the log console
	 * @return
	 */
	public Consumer<String> getDisplayToLogMethod(){
		return (e)->{
				logArea.append(e+"\n");
				logArea.setCaretPosition(logArea.getText().length());
			};
	}
	
	/**
	 * add miniView to the mainView
	 * @param miniView
	 */
	public void addMiniView4ChatRoom(JPanel miniView) {
		tabbedPane.add(miniView.toString(), miniView);
	}
	/**
	 * remove miniView from mainView when leaving room
	 * @param miniView
	 */
	public void removeMiniView(JPanel miniView) {
		tabbedPane.remove(miniView);
		
	}
	
	
}

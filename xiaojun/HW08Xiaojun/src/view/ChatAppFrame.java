package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class ChatAppFrame<IDroplistItem> extends JFrame {

	/**
	 * An auto-generated id to remove serializeVersionUID warning. 
	 */
	private static final long serialVersionUID = -514611651617279735L;
	private JPanel contentPane;
	private final JPanel pnlCtrl = new JPanel();
	private final JButton btnQuit = new JButton("Quit");
	private final JPanel pnlConnect = new JPanel();
	private final JTextField txtIp = new JTextField();
	private final JButton btnConnect = new JButton("Connect");
	private final JPanel pnlJoinableChatrooms = new JPanel();
	private final JComboBox<IDroplistItem> comboBoxSelectableChatrooms = new JComboBox<IDroplistItem>();
	private final JButton btnJoin = new JButton("Join");
	private IView2ModelAdapter<IDroplistItem> _view2ModelAdapter;
	private final JPanel panelJoinedChatrooms = new JPanel();
	private final JPanel pnlChatrooms = new JPanel();
	private final JButton btnInfo = new JButton("Info");
	private final JPanel pnlInfoContainer = new JPanel();
	private final JScrollPane scrollPaneInfo = new JScrollPane();
	private final JTextArea textAreaInfo = new JTextArea();
	private final JPanel panelLogin = new JPanel();
	private final JTextField textFieldUsername = new JTextField();
	private final JButton btnLogin = new JButton("Login");
	private final JButton btnTest = new JButton("Test");
	private final JTextField textFieldChatroom = new JTextField();
	private final JButton btnCreateChatroom = new JButton("Create");
	private final JTextField textFieldPort = new JTextField();
	// private final Map<JButton, JPanel> chatroomPnls = new HashMap<JButton, JPanel>();

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// ChatAppFrame frame = new ChatAppFrame();
					// frame.start();;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/

	/**
	 * Create the frame.
	 */
	public ChatAppFrame(IView2ModelAdapter<IDroplistItem> _view2ModelAdapter) {
		textFieldPort.setText("2005");
		textFieldPort.setToolTipText("Put your port number here.");
		textFieldPort.setColumns(10);
		textFieldChatroom.setToolTipText("Enter the name of your created chatroom here.");
		textFieldChatroom.setText("Chatroom Name");
		textFieldChatroom.setColumns(10);
		textFieldUsername.setToolTipText("Enter your username here.");
		textFieldUsername.setText("username");
		panelLogin.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Login:", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelLogin.add(textFieldUsername);
		textFieldUsername.setColumns(10);
		this._view2ModelAdapter = _view2ModelAdapter;
		txtIp.setText("ip");
		txtIp.setToolTipText("The ip address of remote user");
		txtIp.setColumns(10);
		init();
	}
	
	/**
	 * Initialize the chatApp view.
	 */
	public void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		contentPane.add(pnlCtrl, BorderLayout.NORTH);
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_view2ModelAdapter.quit();
			}
		});
		btnQuit.setToolTipText("Quit the chatApp");
		
		pnlCtrl.add(btnQuit);
		
		pnlCtrl.add(panelLogin);
		panelLogin.setLayout(new GridLayout(0, 1, 0, 0));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textFieldUsername.getText();
				int port = Integer.parseInt(textFieldPort.getText());
				if (username == null) {
					return;
				}
				_view2ModelAdapter.login(username, port);
			}
		});
		
		panelLogin.add(textFieldPort);
		btnLogin.setToolTipText("Click here to login.");
		panelLogin.add(btnLogin);
		pnlConnect.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Remote User:", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		pnlCtrl.add(pnlConnect);
		pnlConnect.setLayout(new GridLayout(0, 1, 0, 0));
		
		pnlConnect.add(txtIp);
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_view2ModelAdapter.connect(txtIp.getText());
			}
		});
		
		pnlConnect.add(btnConnect);
		pnlJoinableChatrooms.setBorder(new TitledBorder(null, "Chatrooms:", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		
		pnlCtrl.add(pnlJoinableChatrooms);
		pnlJoinableChatrooms.setLayout(new GridLayout(0, 1, 0, 0));
		comboBoxSelectableChatrooms.setToolTipText("Select the chatroom you want to join");
		
		pnlJoinableChatrooms.add(comboBoxSelectableChatrooms);
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IDroplistItem chatroom = comboBoxSelectableChatrooms.getItemAt(comboBoxSelectableChatrooms.getSelectedIndex());
				if (chatroom == null) {
					return;
				}
				_view2ModelAdapter.join(chatroom);
			}
		});
		btnJoin.setPreferredSize(new Dimension(110, 29));
		btnJoin.setToolTipText("Join the selected chatroom");
		
		pnlJoinableChatrooms.add(btnJoin);
		
		pnlJoinableChatrooms.add(textFieldChatroom);
		btnCreateChatroom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textFieldChatroom.getText();
				if (name == null || name.length() == 0) {
					return;
				}
				_view2ModelAdapter.createChatroom(name);
			}
		});
		btnCreateChatroom.setToolTipText("Push the button to create your chatroom.");
		
		pnlJoinableChatrooms.add(btnCreateChatroom);
		
		contentPane.add(panelJoinedChatrooms, BorderLayout.CENTER);
		panelJoinedChatrooms.setLayout(new BorderLayout(0, 0));
		pnlChatrooms.setBorder(new TitledBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)), "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		panelJoinedChatrooms.add(pnlChatrooms, BorderLayout.NORTH);
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlInfoContainer.removeAll();
				pnlInfoContainer.add(scrollPaneInfo, BorderLayout.CENTER);
				pnlInfoContainer.validate();
				textAreaInfo.append(textAreaInfo.getText());
			}
		});
		btnInfo.setToolTipText("Show the information");
		pnlChatrooms.add(btnInfo);
		btnTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlInfoContainer.removeAll();
				pnlInfoContainer.add(new JScrollPane(), BorderLayout.CENTER);
				pnlInfoContainer.validate();
			}
		});
		
		pnlChatrooms.add(btnTest);
		
		panelJoinedChatrooms.add(pnlInfoContainer, BorderLayout.CENTER);
		pnlInfoContainer.setLayout(new BorderLayout(0, 0));
		
		pnlInfoContainer.add(scrollPaneInfo, BorderLayout.CENTER);
		
		scrollPaneInfo.setViewportView(textAreaInfo);
	}
	
	/**
	 * Start the chatApp GUI.
	 */
	public void start() {
		this.setVisible(true);
	}
	
	/**
	 * Adds the information panel to the information panel container.
	 * 
	 * @param infoPanle
	 */
	public void addComponent(JPanel infoPanle) {
		pnlInfoContainer.add(infoPanle, BorderLayout.CENTER);
	}
	
	/**
	 * Adds the a button for a chatroom to chatroom panel.
	 * 
	 * @param btnChatroom The button for a chatroom.
	 */
	public void addChatroomBtn(JButton btnChatroom) {
		pnlChatrooms.add(btnChatroom);
	}
	
	/**
	 * Adds chatrooms that user can join to the droplist.
	 * 
	 * @param chatrooms The chatrooms that user can join.
	 */
	public void addJoinableChatrooms(Set<IDroplistItem> chatrooms) {
		for (IDroplistItem chatroom : chatrooms) {
			comboBoxSelectableChatrooms.addItem(chatroom);
		}
	}

	/**
	 * Add system info to the info textarea.
	 * 
	 * @param info The system info added to the info textarea.
	 */
	public void appendInfo(String info) {
		textAreaInfo.append(info + "\n");
	}
	
	/**
	 * 
	 * @param button
	 * @param chatroomView
	 */
	public void addTab(JButton button, JPanel chatroomView) {
		pnlChatrooms.add(button);
		pnlChatrooms.validate();
		// chatroomPnls.put(button, chatroomView);
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				pnlInfoContainer.removeAll();
				pnlInfoContainer.add(chatroomView, BorderLayout.CENTER);
				pnlInfoContainer.validate();
				pnlInfoContainer.repaint();
			}
			
		});
	}
	
	/**
	 * 
	 * @param button
	 */
	public void removeTab(JButton button) {
		pnlChatrooms.remove(button);
	}
}

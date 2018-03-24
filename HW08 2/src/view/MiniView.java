package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.Box;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import common.IChatServer;
import common.IChatroom;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;

/**
 * Mini mvc
 * 
 * @author Gengwu Li, Zhaohan Jia
 * @version 1.0, Nov 14, 2016
 * @param <T>
 *            Generic type
 */
public class MiniView<T> extends JPanel {
	/**
	 * Serial version id
	 */
	private static final long serialVersionUID = -6314403003364664653L;

	/**
	 * List panel
	 */
	private JPanel pnl_list = new JPanel();

	/**
	 * User panel
	 */
	private JList<IChatServer> list_usr = new JList<>(new DefaultListModel<>());

	/**
	 * Main panel
	 */
	private JPanel pnl_main = new JPanel();

	/**
	 * Display panel
	 */
	@SuppressWarnings("serial")
	private JPanel pnl_display = new JPanel() {
		@Override
		protected void paintComponent(Graphics g) {
			g.drawImage(new ImageIcon("images/wallpaper/toto.jpg").getImage(), 0, 0, null);
		}
	};

	/**
	 * Control panel
	 */
	private JPanel pnl_ctrl = new JPanel();

	/**
	 * Input panel
	 */
	private JPanel pnl_input = new JPanel();

	/**
	 * Input text area
	 */
	private JTextArea ta_input = new JTextArea();

	/**
	 * Controll panel
	 */
	private JPanel pnl_ctrll = new JPanel();

	/**
	 * Emoji button
	 */
	private JButton btn_emoji = new JButton("Emoji");

	/**
	 * Image button
	 */
	private JButton btn_img = new JButton("Image");

	/**
	 * Invite button
	 */
	private JButton btn_invite = new JButton("Invite");

	/**
	 * Send button
	 */
	private JButton btn_send = new JButton("Send");

	/**
	 * Scroll panel
	 */
	private JScrollPane pnl_scroll = new JScrollPane();

	/**
	 * Mini to model adapter
	 */
	private IMini2ModelAdpt mini2ModelAdpt;

	/**
	 * Chat room
	 */
	private IChatroom room;

	/**
	 * Show panel
	 */
	private JPanel pnl_show = new JPanel();

	/**
	 * Split panel
	 */
	private final JSplitPane pnl_split = new JSplitPane();

	/**
	 * Scroll panel
	 */
	private final JScrollPane scrollPane = new JScrollPane();

	/**
	 * Leave button
	 */
	private final JButton btn_leave = new JButton("Leave");

	/**
	 * Constructor
	 */
	public MiniView() {
		initGUI();
	}

	/**
	 * Constructor
	 * 
	 * @param mini2ModelAdpt
	 *            Mini to model adapter
	 */
	public MiniView(IMini2ModelAdpt mini2ModelAdpt) {
		this();
		this.mini2ModelAdpt = mini2ModelAdpt;
	}

	/**
	 * Constructor
	 * 
	 * @param room
	 *            The Chat room
	 * @param iMini2ModelAdpt
	 *            Mini to model adapter
	 */
	public MiniView(IChatroom room, IMini2ModelAdpt iMini2ModelAdpt) {
		this(iMini2ModelAdpt);
		this.room = room;
	}

	/**
	 * Initialize GUI
	 */
	@SuppressWarnings("serial")
	private void initGUI() {
		pnl_show.setToolTipText("Display here.");
		pnl_show.setOpaque(false);
		pnl_scroll.setOpaque(false);
		pnl_show.setBackground(new Color(0, 0, 0, 0));
		pnl_scroll.getViewport().setOpaque(false);
		pnl_scroll.setBackground(new Color(0, 0, 0, 0));
		list_usr.setToolTipText("List of the users.");
		list_usr.setCellRenderer(new ChatRoomRenderer());
		setLayout(new BorderLayout(0, 0));

		pnl_main.setLayout(new BorderLayout(0, 0));
		pnl_display.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));

		pnl_main.add(pnl_display, BorderLayout.CENTER);
		pnl_display.setLayout(new BorderLayout(0, 0));

		pnl_display.add(pnl_scroll, BorderLayout.CENTER);
		pnl_show.setBorder(new EmptyBorder(5, 20, 0, 10));

		pnl_scroll.setViewportView(pnl_show);
		pnl_scroll.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				if (ta_input.getText().equals(" ")) {
					ta_input.setText("");
					e.getAdjustable().setValue(e.getAdjustable().getMaximum());
				}
			}
		});
		pnl_show.setLayout(new BoxLayout(pnl_show, BoxLayout.Y_AXIS));
		pnl_main.add(pnl_ctrl, BorderLayout.SOUTH);
		pnl_ctrl.setLayout(new BorderLayout(0, 0));
		pnl_input.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));

		pnl_ctrl.add(pnl_input);
		pnl_input.setLayout(new BorderLayout(0, 0));
		ta_input.setToolTipText("Type message here.");
		ta_input.setRows(2);
		ta_input.setColumns(2);
		pnl_input.add(ta_input, BorderLayout.NORTH);
		pnl_ctrll.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));

		pnl_ctrl.add(pnl_ctrll, BorderLayout.NORTH);
		pnl_ctrll.setLayout(new BoxLayout(pnl_ctrll, BoxLayout.X_AXIS));
		btn_emoji.setToolTipText("Send emoji to the chatroom.");
		btn_emoji.addActionListener((ActionEvent e) -> {
			Point location = btn_emoji.getLocationOnScreen();
			new JFrame() {
				{
					setBounds((int) location.getX(), (int) location.getY() - 280, 280, 280);
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					JPanel panel = new JPanel();
					panel.setBorder(null);
					setUndecorated(true);
					getContentPane().add(panel, BorderLayout.CENTER);
					panel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
					for (int i = 0; i < 100; i++) {
						JButton button = new JButton(new ImageIcon("images/face/" + i + ".gif"));
						button.setMargin(new Insets(0, 0, 0, 0));
						button.addActionListener((e) -> {
							for (IChatServer chatServer : room.getChatServers()) {
								mini2ModelAdpt.sendImage(chatServer, (ImageIcon) button.getIcon());
							}
							ta_input.setText(" ");
							setVisible(false);
							dispose();
						});
						button.setBorder(new EtchedBorder());
						panel.add(button);
					}
				}
			}.setVisible(true);
		});

		pnl_ctrll.add(btn_emoji);
		btn_img.setToolTipText("Send image to the chatroom.");
		btn_img.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chooseImageAndAppend();
			}
		});

		pnl_ctrll.add(btn_img);
		btn_send.setToolTipText("Send message.");
		btn_send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HashSet<IChatServer> chatServers = room.getChatServers();
				for (IChatServer s : chatServers) {
					mini2ModelAdpt.addToRemoteRoom(s, ta_input.getText());
				}
				ta_input.setText(" ");
				pnl_show.revalidate();
			}
		});
		pnl_ctrll.add(btn_send);
		btn_invite.setToolTipText("Invite remote host to this chatroom.");
		btn_invite.addActionListener((ActionEvent e) -> {
			String ip = JOptionPane.showInputDialog("Input remote user IP to invite:");
			if (ip != null) {
				System.out.println(ip);
				mini2ModelAdpt.invite(ip);
				return;
			} else {
				return;
			}
		});

		pnl_ctrll.add(btn_invite);
		btn_leave.setToolTipText("Leave this chat room.");
		btn_leave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mini2ModelAdpt.leave();
			}
		});

		pnl_ctrll.add(btn_leave);
		pnl_split.setResizeWeight(0.1);
		pnl_split.setLeftComponent(pnl_list);
		pnl_split.setRightComponent(pnl_main);
		add(pnl_split, BorderLayout.CENTER);
		scrollPane.setViewportView(list_usr);
		pnl_list.setLayout(new BorderLayout(0, 0));

		pnl_list.add(scrollPane, BorderLayout.CENTER);
		list_usr.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
	}

	/**
	 * Choose image and append to view
	 */
	public void chooseImageAndAppend() {
		JFileChooser fc = new JFileChooser();
		fc.addChoosableFileFilter(new FileNameExtensionFilter("Image Files", "jpg", "png", "bmp", "gif"));
		fc.setAcceptAllFileFilterUsed(false);
		int returnVal = fc.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			ImageIcon icon = new ImageIcon(file.getAbsolutePath());
			ImageIcon imageIcon = new ImageIcon(icon.getImage()
					.getScaledInstance(300 * icon.getIconWidth() / icon.getIconHeight(), 300, Image.SCALE_DEFAULT));
			for (IChatServer chatServer : room.getChatServers()) {
				mini2ModelAdpt.sendImage(chatServer, imageIcon);
			}
			ta_input.setText(" ");
		} else {
			System.out.println("Cancelled by user.");
		}
	}

	/**
	 * Append string to view
	 * 
	 * @param text
	 *            Text to be appended
	 */
	public void append(String text) {
		String[] split = text.split("\n");
		for (String string : split) {
			JLabel label = new JLabel(string);
			label.setOpaque(true);
			label.setBackground(Color.white);
			pnl_show.add(label);
		}
		pnl_show.add(Box.createVerticalStrut(10));
	}

	/**
	 * Apend a Image icon to view
	 * 
	 * @param icon
	 *            The image icon to be appended
	 */
	public void append(ImageIcon icon) {
		pnl_show.add(new JLabel(icon));
		pnl_show.add(Box.createVerticalStrut(10));
	}

	/**
	 * Get list of chat servers
	 * 
	 * @return The list of chat servers
	 */
	public IChatServer[] getRooms() {
		HashSet<IChatServer> chatServers = room.getChatServers();
		IChatServer[] rooms = new IChatServer[chatServers.size()];
		int i = 0;
		for (IChatServer server : chatServers) {
			rooms[i++] = server;
		}
		return rooms;
	}

	/**
	 * Add to list of servers to JList
	 * 
	 * @param servers
	 *            The list of chatservers to be added
	 */
	public void addToList(IChatServer[] servers) {
		for (IChatServer iChatServer : servers) {
			if (!((DefaultListModel<IChatServer>) list_usr.getModel()).contains(iChatServer))
				((DefaultListModel<IChatServer>) list_usr.getModel()).addElement(iChatServer);
		}
	}

	/**
	 * Add the list of servers to JList
	 * 
	 * @param servers
	 *            The list of chatservers to be added
	 */
	public void addToList(Set<IChatServer> servers) {
		for (IChatServer iChatServer : servers) {
			if (!((DefaultListModel<IChatServer>) list_usr.getModel()).contains(iChatServer))
				((DefaultListModel<IChatServer>) list_usr.getModel()).addElement(iChatServer);
		}
	}

	/**
	 * Add a single chat server to server
	 * 
	 * @param server
	 *            The chatserver to be added
	 */
	public void addToList(IChatServer server) {
		room.addChatServer(server);
		if (!((DefaultListModel<IChatServer>) list_usr.getModel()).contains(server))
			((DefaultListModel<IChatServer>) list_usr.getModel()).addElement(server);
	}

	/**
	 * To string
	 */
	@Override
	public String toString() {
		return room.getName();
	}

	/**
	 * Get show panel
	 * 
	 * @return The show panel
	 */
	public JPanel getPnlShow() {
		return pnl_show;
	}

	/**
	 * Remove a chat server from user list
	 * 
	 * @param chatServer The chat server to be removed
	 */
	public void removeChatServer(IChatServer chatServer) {
		((DefaultListModel<IChatServer>) list_usr.getModel()).removeElement(chatServer);
		list_usr.revalidate();
	}

	/**
	 * Exit the program
	 */
	public void leaveRoom() {
		System.exit(0);
	}
}

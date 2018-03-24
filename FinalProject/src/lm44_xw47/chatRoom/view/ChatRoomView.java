package lm44_xw47.chatRoom.view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Following defines the view for the chat room.
 * 
 * @author Xiaojun Wu
 * @author Lu Ma
 */
public class ChatRoomView {
	/**
	 * The content panel.
	 */
	private final JPanel pnlContent = new JPanel();
	
	/**
	 * The panel uses to hold message.
	 */
	private final JScrollPane scrollPaneMsg = new JScrollPane();
	
	/**
	 * The text area that display message.
	 */
	private final JTextArea textAreaMsg = new JTextArea();
	
	/**
	 * The panel that holds control components.
	 */
	private final JPanel pnlCtrl = new JPanel();
	
	/**
	 * The text field uses to enter message.
	 */
	private final JTextField textFieldMsg = new JTextField();
	
	/**
	 * The button uses to send message.
	 */
	private final JButton btnSend = new JButton("Send");
	
	/**
	 * The panel uses to leave chat room.
	 */
	private final JButton btnLeave = new JButton("Leave");
	
	/**
	 * The panel uses to add other information.
	 */
	private final JPanel panelOther = new JPanel();
	
	/**
	 * The adapter this chat room view to communicate with chat room model.
	 */
	private IChatRoomView2ModelAdapter chatRoomView2ModelAdapter = IChatRoomView2ModelAdapter.NULL_OBJECT;
	
	/**
	 * Constructor.
	 * 
	 * @param chatRoomView2ModelAdapter The adapter this chat room view to communicate with chat room model.
	 */
	public ChatRoomView(IChatRoomView2ModelAdapter chatRoomView2ModelAdapter) {
		this.chatRoomView2ModelAdapter = chatRoomView2ModelAdapter;
		init();
	}
	
	/**
	 * Initialize.
	 */
	public void init() {
		pnlContent.setLayout(new BorderLayout(0, 0));
		
		pnlContent.add(panelOther, BorderLayout.NORTH);
		
		pnlContent.add(scrollPaneMsg, BorderLayout.CENTER);
		
		scrollPaneMsg.setViewportView(textAreaMsg);
		
		pnlContent.add(pnlCtrl, BorderLayout.SOUTH);
		
		textFieldMsg.setToolTipText("Write your message here.");
		textFieldMsg.setText("Say something.");
		textFieldMsg.setColumns(10);
		pnlCtrl.add(textFieldMsg);
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = textFieldMsg.getText();
				if (msg == null || msg.length() == 0) {
					return;
				}
				
				chatRoomView2ModelAdapter.sendMsg(msg);
			}
		});
		btnSend.setToolTipText("Click button to send message.");
		
		pnlCtrl.add(btnSend);
		btnLeave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chatRoomView2ModelAdapter.leave();
			}
		});
		btnLeave.setToolTipText("Leave this team.");
		
		pnlCtrl.add(btnLeave);
	}
	
	/**
	 * Add message to view.
	 * 
	 * @param msg The message being added to view.
	 */
	public void appendMsg(String msg) {
		textAreaMsg.append(msg);
	}
	
	/**
	 * Set the view visible.
	 */
	public void start() {
		pnlContent.setVisible(true);
	}
	
	/**
	 * Get the content panel.
	 * 
	 * @return The content panel.
	 */
	public JPanel getContentPnl() {
		return pnlContent;
	}
	
	/**
	 * Get the panel that holds other information.
	 * 
	 * @return The panel that holds other information.
	 */
	public JPanel getPanelOther() {
		return panelOther;
	}
}

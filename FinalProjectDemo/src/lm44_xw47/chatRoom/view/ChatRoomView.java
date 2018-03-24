package lm44_xw47.chatRoom.view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChatRoomView {
	/**
	 * The content panel.
	 */
	private final JPanel pnlContent = new JPanel();
	
	private IChatRoomView2ModelAdapter chatRoomView2ModelAdapter = IChatRoomView2ModelAdapter.NULL_OBJECT;
	private final JScrollPane scrollPaneMsg = new JScrollPane();
	private final JTextArea textAreaMsg = new JTextArea();
	private final JPanel pnlCtrl = new JPanel();
	private final JTextField textFieldMsg = new JTextField();
	private final JButton btnSend = new JButton("Send");
	private final JButton btnLeave = new JButton("Leave");
	
	public ChatRoomView(IChatRoomView2ModelAdapter chatRoomView2ModelAdapter) {
		this.chatRoomView2ModelAdapter = chatRoomView2ModelAdapter;
		init();
	}
	
	public void init() {
		pnlContent.setLayout(new BorderLayout(0, 0));
		
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
	
	public void appendMsg(String msg) {
		textAreaMsg.append(msg);
	}
	
	public void start() {
		pnlContent.setVisible(true);
	}
	
	public JPanel getContentPnl() {
		return pnlContent;
	}
}

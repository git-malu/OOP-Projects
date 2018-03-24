package chatroom.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatroomView {
	private final JPanel pnlContent = new JPanel();
	private final JScrollPane scrollPaneUsersList = new JScrollPane();
	private final JTextArea textAreaUsersList = new JTextArea();
	private final JScrollPane scrollPaneMsg = new JScrollPane();
	private final JTextArea textAreaMsg = new JTextArea();
	private final JPanel pnlCtrl = new JPanel();
	private final JTextField txtMsg = new JTextField();
	private final JButton btnSendMsg = new JButton("Send Msg");
	private final JButton btnSendImg = new JButton("Send Img");
	private final JButton btnLeave = new JButton("Leave");
	
	private IChatroomView2ModelAdapter _chatroomView2ModelAdpater = IChatroomView2ModelAdapter.NULL_OBJECT;
	
	public ChatroomView(IChatroomView2ModelAdapter _chatroomView2ModelAdpater) {
		this._chatroomView2ModelAdpater = _chatroomView2ModelAdpater;
		init();
	}
	
	public void init() {
		pnlContent.setLayout(new BorderLayout(0, 0));
		pnlContent.add(scrollPaneUsersList, BorderLayout.WEST);
		textAreaUsersList.setColumns(10);
		scrollPaneUsersList.setViewportView(textAreaUsersList);
		
		pnlContent.add(scrollPaneMsg, BorderLayout.CENTER);
		scrollPaneMsg.setViewportView(textAreaMsg);
		
		pnlContent.add(pnlCtrl, BorderLayout.SOUTH);
		txtMsg.setColumns(10);
		txtMsg.setToolTipText("Write your msg here.");
		
		pnlCtrl.add(txtMsg);
		pnlCtrl.add(btnSendMsg);
		pnlCtrl.add(btnSendImg);
		pnlCtrl.add(btnLeave);
		
		btnSendMsg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = txtMsg.getText();
				if (msg == null) {
					return;
				}
				_chatroomView2ModelAdpater.sendMsg(msg);
			}
		});
		
		btnSendImg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_chatroomView2ModelAdpater.sendImg();
			}
		});
		
		btnLeave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_chatroomView2ModelAdpater.leave();
			}
		});
	}
	
	public JPanel getContentPnl() {
		return pnlContent;
	}
	
	public void addUser(String username) {
		textAreaUsersList.append(username + "\n");
	}
	
	public void removeUser(String username) {
		String[] users = textAreaUsersList.getText().split("\\n");
		textAreaUsersList.setText("");
		for (String user : users) {
			if (! user.equals(username)) {
				textAreaUsersList.append(user);
			}
		}
	}
	
	public void appendMsg(String msg) {
		System.out.println("haha: " + msg);
		textAreaMsg.append(msg);
	}
	
	public void start() {
		pnlContent.setVisible(true);
	}
}
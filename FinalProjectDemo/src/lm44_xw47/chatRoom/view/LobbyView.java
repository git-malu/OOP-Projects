package lm44_xw47.chatRoom.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import common.IChatRoom;
import common.IUser;
import gov.nasa.worldwindx.examples.HelloWorldWind;

public class LobbyView extends JFrame {

	/**
	 * An auto-generated id for serialization.
	 */
	private static final long serialVersionUID = -1059209993763003372L;
	private JPanel contentPane;
	private final JPanel pnlCtrl = new JPanel();
	private final JTextField teamNameTextField = new JTextField();
	private final JButton btnCreateTeam = new JButton("Create Team");
	
	private ILobbyView2ModelAdapter lobbyView2ModelAdapter = ILobbyView2ModelAdapter.NULL_OBJECT;
	private final JPanel pnlTeam = new JPanel();
	private final JPanel pnlGame = new JPanel();
	private final JPanel pnlTeamInfo = new JPanel();
	private final JComboBox<IChatRoom> comboBoxTeam = new JComboBox<IChatRoom>();
	private final JButton btnJoin = new JButton("Join");
	private final JComboBox<IUser> comboBoxInvite = new JComboBox<IUser>();
	private final JButton btnInvite = new JButton("Invite");
	private final JButton btnQuit = new JButton("Quit");
	private final JButton btnReady = new JButton("Ready");

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LobbyView frame = new LobbyView();
					frame.setVisible(true);
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
	public LobbyView(ILobbyView2ModelAdapter lobbyView2ModelAdapter) {
		this.lobbyView2ModelAdapter = lobbyView2ModelAdapter;
		init();
	}
	
	public void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		contentPane.add(pnlCtrl, BorderLayout.NORTH);
		
		teamNameTextField.setToolTipText("Enter the name of your created team right here.");
		teamNameTextField.setText("Team1");
		teamNameTextField.setColumns(10);
		
		pnlCtrl.add(teamNameTextField);
		btnCreateTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String teamname = teamNameTextField.getText();
				if (teamname == null || teamname.length() == 0) {
					return;
				}
				lobbyView2ModelAdapter.createTeam(teamname);
			}
		});
		btnCreateTeam.setToolTipText("Click to create your team.");
		
		pnlCtrl.add(btnCreateTeam);
		
		pnlCtrl.add(pnlTeamInfo);
		pnlTeamInfo.setLayout(new GridLayout(0, 1, 0, 0));
		comboBoxTeam.setToolTipText("Select team.");
		pnlTeamInfo.add(comboBoxTeam);
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IChatRoom team = comboBoxTeam.getItemAt(comboBoxTeam.getSelectedIndex());
				if (team == null) {
					return;
				}
				lobbyView2ModelAdapter.joinTeam(team);
			}
		});
		btnJoin.setToolTipText("Click to join the selected team.");
		pnlTeamInfo.add(btnJoin);
		comboBoxInvite.setToolTipText("Select user your want to invite.");
		
		pnlTeamInfo.add(comboBoxInvite);
		btnInvite.setToolTipText("Invite a user to your team.");
		
		pnlTeamInfo.add(btnInvite);
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnReady.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lobbyView2ModelAdapter.readyToPlay();
			}
		});
		
		pnlCtrl.add(btnReady);
		btnQuit.setToolTipText("Click button to quit the game.");
		
		pnlCtrl.add(btnQuit);
		
		contentPane.add(pnlTeam, BorderLayout.WEST);
		
		contentPane.add(pnlGame, BorderLayout.CENTER);
	}
	
	public void addTeamView(Component view) {
		pnlTeam.add(view);
	}
	
	public void addUser(IUser user) {
		comboBoxInvite.addItem(user);
	}
	
	public void addTeam(IChatRoom team) {
		comboBoxTeam.addItem(team);
	}
	
	public void removeTeamView(Component view) {
		pnlTeam.removeAll();
	}
	
	public void removeUser(IUser user) {
		comboBoxInvite.removeItem(user);
	}
	
	public void removeTeam(IChatRoom team) {
		comboBoxTeam.removeItem(team);
	}
	
	public JPanel getPnlGame() {
		return pnlGame;
	}
	
	public void start() {
		this.setVisible(true);
	}

}

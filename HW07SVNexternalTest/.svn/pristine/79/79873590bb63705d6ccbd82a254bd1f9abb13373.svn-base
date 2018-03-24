package client.clientView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

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

public class MyClientGUI extends JFrame {

	/**
	 * The serialVersionUID of this GUI
	 */
	private static final long serialVersionUID = 6614356678104070643L;
	private JPanel contentPane;
	private final JPanel panelControl = new JPanel();
	private final JPanel panelQuit = new JPanel();
	private final JPanel panelRemoteHost = new JPanel();
	private final JTextField textFieldIP = new JTextField();
	private final JButton buttonQuit = new JButton("Quit");
	private final JPanel panelAddTask = new JPanel();
	private final JTextField textFieldAddTask = new JTextField();
	private final JButton buttonAddTask = new JButton("Add to lists");
	private final JPanel panelRunTask = new JPanel();
	private final JButton buttonRunTask = new JButton("Run Task");
	private final JComboBox comboBoxUpperList = new JComboBox();
	private final JComboBox comboBoxLowerList = new JComboBox();
	private final JButton buttonCombineTask = new JButton("Combine Tasks");
	private final JPanel panelRunParameter = new JPanel();
	private final JTextField textFieldParameter = new JTextField();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTextArea textArea_1 = new JTextArea();
	private final JButton buttonConnect = new JButton("Connect");
	private final JScrollPane scrollPaneSendMsg = new JScrollPane();
	private final JTextArea textAreaSendMsg = new JTextArea();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyClientGUI frame = new MyClientGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MyClientGUI() {
		textFieldParameter.setToolTipText("A parameter used to instantiate the task");
		textFieldParameter.setFont(new Font("American Typewriter", Font.PLAIN, 15));
		textFieldParameter.setColumns(10);
		textFieldAddTask.setToolTipText("The fully qualified classname of an ITask");
		textFieldAddTask.setFont(new Font("American Typewriter", Font.PLAIN, 15));
		textFieldAddTask.setColumns(10);
		textFieldIP.setToolTipText("The IP address of the remote Computer Engine");
		textFieldIP.setFont(new Font("American Typewriter", Font.PLAIN, 15));
		textFieldIP.setColumns(10);
		initGUI();
	}

	private void initGUI() {
		setTitle("Client GUI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		panelControl.setBackground(Color.CYAN);

		contentPane.add(panelControl, BorderLayout.NORTH);
		panelControl.setLayout(new GridLayout(0, 6, 0, 0));
		panelQuit.setBackground(Color.CYAN);
		panelQuit.setBorder(new TitledBorder(null, "Leave", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		panelControl.add(panelQuit);
		panelQuit.setLayout(new GridLayout(0, 1, 0, 0));
		buttonQuit.setToolTipText("Shuts down RMI system and quits");
		buttonQuit.setFont(new Font("American Typewriter", Font.PLAIN, 15));
		panelQuit.add(buttonQuit);
		panelRemoteHost.setBackground(Color.CYAN);
		panelRemoteHost.setBorder(new TitledBorder(null, "Remote Host:", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		panelControl.add(panelRemoteHost);
		panelRemoteHost.setLayout(new GridLayout(2, 1, 0, 0));

		panelRemoteHost.add(textFieldIP);
		buttonConnect.setToolTipText("Click to connect to the remote Computer Engine");
		buttonConnect.setFont(new Font("American Typewriter", Font.PLAIN, 15));

		panelRemoteHost.add(buttonConnect);
		scrollPaneSendMsg.setViewportBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null),
				"Send msg to host", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelControl.add(scrollPaneSendMsg);
		textAreaSendMsg.setToolTipText("Enter the msg and sent it to the remote Computer engine. Done with Hit.");
		textAreaSendMsg.setFont(new Font("American Typewriter", Font.PLAIN, 15));

		scrollPaneSendMsg.setViewportView(textAreaSendMsg);
		panelAddTask.setBackground(Color.CYAN);
		panelAddTask.setBorder(new TitledBorder(null, "Add Task:", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		panelControl.add(panelAddTask);
		panelAddTask.setLayout(new GridLayout(2, 1, 0, 0));

		panelAddTask.add(textFieldAddTask);
		buttonAddTask.setToolTipText("Add the factory based on the specified ITask to the drop lists");
		buttonAddTask.setFont(new Font("American Typewriter", Font.PLAIN, 15));

		panelAddTask.add(buttonAddTask);
		panelRunTask.setBackground(Color.CYAN);

		panelControl.add(panelRunTask);
		panelRunTask.setLayout(new GridLayout(4, 1, 0, 0));
		buttonRunTask.setToolTipText("Instantiate the selected task within the givin parameter and run it on the remote Engine");
		buttonRunTask.setFont(new Font("American Typewriter", Font.PLAIN, 15));

		panelRunTask.add(buttonRunTask);
		comboBoxUpperList.setToolTipText("Select the desired task to run or combine");
		comboBoxUpperList.setFont(new Font("American Typewriter", Font.PLAIN, 15));

		panelRunTask.add(comboBoxUpperList);
		comboBoxLowerList.setToolTipText("Select the desired task to combine");
		comboBoxLowerList.setFont(new Font("American Typewriter", Font.PLAIN, 15));

		panelRunTask.add(comboBoxLowerList);
		buttonCombineTask.setToolTipText("Combine the above selected tasks");
		buttonCombineTask.setFont(new Font("American Typewriter", Font.PLAIN, 15));

		panelRunTask.add(buttonCombineTask);
		panelRunParameter.setBackground(Color.CYAN);
		panelRunParameter.setBorder(new TitledBorder(null, "Run Parameter:", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		panelControl.add(panelRunParameter);

		panelRunParameter.add(textFieldParameter);

		contentPane.add(scrollPane, BorderLayout.CENTER);
		textArea_1.setToolTipText("Display area for texts msg");
		textArea_1.setFont(new Font("American Typewriter", Font.PLAIN, 15));

		scrollPane.setViewportView(textArea_1);
	}

}

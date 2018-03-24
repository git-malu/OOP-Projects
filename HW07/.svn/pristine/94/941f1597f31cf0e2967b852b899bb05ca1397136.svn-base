package client.clientView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

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

/**
 * The view of the client MVC system.
 * 
 * @author Yue Jiang, Lu Ma
 *
 * @param <TDropListItem>
 *            The droplist item
 */
public class MyClientGUI<TDropListItem> extends JFrame {

	/**
	 * The serialVersionUID of this GUI
	 */
	private static final long serialVersionUID = 6614356678104070643L;

	/**
	 * The view to model adapter
	 */
	private IModelAdapter<TDropListItem> iModelAdapter;

	/**
	 * Hash set for droplists inorder to avoid duplicate values
	 */
	HashSet<String> taskFacHS = new HashSet<>();

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
	private final JComboBox<TDropListItem> comboBoxUpperList = new JComboBox<TDropListItem>();
	private final JComboBox<TDropListItem> comboBoxLowerList = new JComboBox<TDropListItem>();
	private final JButton buttonCombineTask = new JButton("Combine Tasks");
	private final JPanel panelRunParameter = new JPanel();
	private final JTextField textFieldParameter = new JTextField();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTextArea textAreaDisplay = new JTextArea();
	private final JButton buttonConnect = new JButton("Connect");
	private final JScrollPane scrollPaneSendMsg = new JScrollPane();
	private final JTextField textFieldSendMsg = new JTextField();

	/**
	 * Make the frame visible
	 */
	public void start() {
		setVisible(true);
	}

	/**
	 * Create the frame.
	 * 
	 * @param iModelAdapter
	 *            view to model adapter
	 */
	public MyClientGUI(IModelAdapter<TDropListItem> iModelAdapter) {
		this.iModelAdapter = iModelAdapter;
		initGUI();
	}

	/**
	 * Initial the GUI
	 */
	private void initGUI() {

		setTitle("Client GUI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		panelControl.setBackground(Color.CYAN);

		textFieldSendMsg.setText("Hit Enter to send messages...");
		textFieldSendMsg.setToolTipText("Enter the msg and sent it to the remote Computer engine. Done with Hit.");
		textFieldSendMsg.setColumns(10);
		textFieldSendMsg.setCaretPosition(0);
		textFieldSendMsg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				iModelAdapter.sendMsgToRemoteHost(textFieldSendMsg.getText());
			}
		});
		textFieldParameter.setText("5");

		textFieldParameter.setToolTipText("A parameter used to instantiate the task");
		textFieldParameter.setFont(new Font("American Typewriter", Font.PLAIN, 15));
		textFieldParameter.setColumns(10);
		textFieldAddTask.setToolTipText("The fully qualified classname of an ITask");
		textFieldAddTask.setFont(new Font("American Typewriter", Font.PLAIN, 15));
		textFieldAddTask.setColumns(10);
		textFieldIP.setToolTipText("The IP address of the remote Computer Engine");
		textFieldIP.setFont(new Font("American Typewriter", Font.PLAIN, 15));
		textFieldIP.setColumns(10);

		contentPane.add(panelControl, BorderLayout.NORTH);
		panelControl.setLayout(new GridLayout(0, 6, 0, 0));
		panelQuit.setBackground(Color.CYAN);
		panelQuit.setBorder(new TitledBorder(null, "Leave", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		panelControl.add(panelQuit);
		panelQuit.setLayout(new GridLayout(0, 1, 0, 0));

		buttonQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iModelAdapter.quit();
			}
		});
		buttonQuit.setToolTipText("Shuts down RMI system and quits");
		buttonQuit.setFont(new Font("American Typewriter", Font.PLAIN, 15));
		panelQuit.add(buttonQuit);
		panelRemoteHost.setBackground(Color.CYAN);
		panelRemoteHost
				.setBorder(new TitledBorder(null, "Remote Host:", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		panelControl.add(panelRemoteHost);
		panelRemoteHost.setLayout(new GridLayout(2, 1, 0, 0));

		panelRemoteHost.add(textFieldIP);
		buttonConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String remoteIP = textFieldIP.getText();
				MyClientGUI.this.append("Attempting to connect to " + remoteIP + "...\n");
				MyClientGUI.this.append(iModelAdapter.connectTo(remoteIP) + "\n");
			}
		});
		buttonConnect.setToolTipText("Click to connect to the remote Computer Engine");
		buttonConnect.setFont(new Font("American Typewriter", Font.PLAIN, 15));

		panelRemoteHost.add(buttonConnect);
		scrollPaneSendMsg.setViewportBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null),
				"Send msg to host", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelControl.add(scrollPaneSendMsg);

		scrollPaneSendMsg.setViewportView(textFieldSendMsg);
		panelAddTask.setBackground(Color.CYAN);
		panelAddTask.setBorder(new TitledBorder(null, "Add Task:", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		panelControl.add(panelAddTask);
		panelAddTask.setLayout(new GridLayout(2, 1, 0, 0));

		panelAddTask.add(textFieldAddTask);
		buttonAddTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TDropListItem taskFac = iModelAdapter.addTask(textFieldAddTask.getText());
				if (null == taskFac) {
					return; // just in case
				}
				if (!taskFacHS.contains(taskFac.toString())) {
					taskFacHS.add(taskFac.toString());
					comboBoxUpperList.insertItemAt(taskFac, 0);
					comboBoxLowerList.insertItemAt(taskFac, 0);
				}
			}
		});
		buttonAddTask.setToolTipText("Add the factory based on the specified ITask to the drop lists");
		buttonAddTask.setFont(new Font("American Typewriter", Font.PLAIN, 15));

		panelAddTask.add(buttonAddTask);
		panelRunTask.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Control Task",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelRunTask.setBackground(Color.CYAN);

		panelControl.add(panelRunTask);
		panelRunTask.setLayout(new GridLayout(4, 1, 0, 0));
		buttonRunTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TDropListItem item = comboBoxUpperList.getItemAt(comboBoxUpperList.getSelectedIndex());
				String para = textFieldParameter.getText();
				String result = iModelAdapter.runTask(item, para);
				MyClientGUI.this.append(result + "\n");
			}
		});
		buttonRunTask.setToolTipText(
				"Instantiate the selected task within the givin parameter and run it on the remote Engine");
		buttonRunTask.setFont(new Font("American Typewriter", Font.PLAIN, 15));

		panelRunTask.add(buttonRunTask);
		comboBoxUpperList.setToolTipText("Select the desired task to run or combine");
		comboBoxUpperList.setFont(new Font("American Typewriter", Font.PLAIN, 15));

		panelRunTask.add(comboBoxUpperList);
		comboBoxLowerList.setToolTipText("Select the desired task to combine");
		comboBoxLowerList.setFont(new Font("American Typewriter", Font.PLAIN, 15));

		panelRunTask.add(comboBoxLowerList);
		buttonCombineTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TDropListItem selectedItem1 = comboBoxUpperList.getItemAt(comboBoxUpperList.getSelectedIndex());
				TDropListItem selectedItem2 = comboBoxLowerList.getItemAt(comboBoxLowerList.getSelectedIndex());
				TDropListItem taskCombine = iModelAdapter.combineTasks(selectedItem1, selectedItem2);
				if (null == taskCombine) {
					return;
				}
				comboBoxUpperList.insertItemAt(taskCombine, 0);
				comboBoxLowerList.insertItemAt(taskCombine, 0);
			}
		});
		buttonCombineTask.setToolTipText("Combine the above selected tasks");
		buttonCombineTask.setFont(new Font("American Typewriter", Font.PLAIN, 15));

		panelRunTask.add(buttonCombineTask);
		panelRunParameter.setBackground(Color.CYAN);
		panelRunParameter.setBorder(
				new TitledBorder(null, "Run Parameter:", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		panelControl.add(panelRunParameter);
		panelRunParameter.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		panelRunParameter.add(textFieldParameter);

		contentPane.add(scrollPane, BorderLayout.CENTER);
		textAreaDisplay.setToolTipText("Display area for texts msg");
		textAreaDisplay.setFont(new Font("American Typewriter", Font.PLAIN, 15));

		scrollPane.setViewportView(textAreaDisplay);
	}

	/**
	 * Appends the string to the end of the text display on the view The view
	 * 
	 * @param s
	 *            The String to append
	 */
	public void append(String s) {
		this.textAreaDisplay.append(s);
		this.textAreaDisplay.setCaretPosition(this.textAreaDisplay.getText().length());
	}

	/**
	 * Sets the displayed remote host address.
	 * 
	 * @param host
	 *            The IP address or host name of the remote host.
	 */
	public void setRemoteHost(String host) {
		this.textFieldIP.setText(host);
	}

}

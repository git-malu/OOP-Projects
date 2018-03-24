package engine.engineView;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Font;

public class EngineGUI extends JFrame {

	private JPanel contentPane;
	private final JPanel panelControl = new JPanel();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JButton buttonQuit = new JButton("Quit");
	private final JScrollPane scrollPane_1 = new JScrollPane();
	private final JTextArea textArea = new JTextArea();
	private final JTextArea textArea_1 = new JTextArea();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EngineGUI frame = new EngineGUI();
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
	public EngineGUI() {
		initGUI();
	}
	private void initGUI() {
		setTitle("RMI Engine");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		contentPane.add(panelControl, BorderLayout.NORTH);
		panelControl.setLayout(new GridLayout(0, 2, 0, 0));
		buttonQuit.setToolTipText("Shuts down RMI system and quits");
		buttonQuit.setFont(new Font("American Typewriter", Font.PLAIN, 15));
		
		panelControl.add(buttonQuit);
		scrollPane_1.setViewportBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Send msg to client", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		panelControl.add(scrollPane_1);
		textArea.setToolTipText("Enter the msg and sent it to the remote Client. Done with Hit.");
		textArea.setFont(new Font("American Typewriter", Font.PLAIN, 15));
		textArea.setRows(2);
		
		scrollPane_1.setViewportView(textArea);
		
		contentPane.add(scrollPane, BorderLayout.CENTER);
		textArea_1.setToolTipText("Display area for texts msg");
		textArea_1.setFont(new Font("American Typewriter", Font.PLAIN, 15));
		
		scrollPane.setViewportView(textArea_1);
	}

}

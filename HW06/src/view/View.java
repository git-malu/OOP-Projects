package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JSplitPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class View extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -151109891844836610L;

	/**
	 * View to model adapter
	 */
	private IView2ModelAdapter _view2ModelAdapter;

	private JPanel contentPane;
	private final JPanel northPanel = new JPanel();
	private final JLabel lblFileName = new JLabel("File:");
	private final JTextField tfFileName = new JTextField();
	private final JButton btnLoad = new JButton("Load");
	private final JButton btnParse = new JButton("Parse");

	/**
	 * Instruments options to users
	 */
	String[] instuments = { "Acoustic Grand Piano: 0", 
			"Bright Grand Piano:1", 
			"Electirc Grand Piano:2" };
	private final JComboBox<String> cbInstrument = new JComboBox<String>(instuments);
	private final JButton btnPlay = new JButton("Play");
	private final JSplitPane splitPane = new JSplitPane();

	private final JTextArea taFileContent = new JTextArea();
	private final JScrollPane spFileContent = new JScrollPane(taFileContent);
	private final JTextArea taParse = new JTextArea();
	private final JScrollPane spParse = new JScrollPane(taParse);

	/**
	 * Start the application
	 */
	public void start() {
		setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public View(IView2ModelAdapter view2ModelAdpter) {
		taFileContent.setToolTipText("Music file will be shown in this area");
		tfFileName.setToolTipText("Type in the song's name");
		tfFileName.setColumns(10);
		initGUI();
		this._view2ModelAdapter = view2ModelAdpter;
	}

	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 687, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		contentPane.add(northPanel, BorderLayout.NORTH);

		northPanel.add(lblFileName);

		northPanel.add(tfFileName);
		btnLoad.setToolTipText("Load the file");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fileContent = _view2ModelAdapter.loadFile(tfFileName.getText());
				taFileContent.setText(fileContent);
				btnParse.setEnabled(true);
			}
		});

		northPanel.add(btnLoad);
		btnParse.setToolTipText("Parse the file");
		btnParse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String parseContent = _view2ModelAdapter.parseFile();
				taParse.setText(parseContent);
				btnPlay.setEnabled(true);
			}
		});
		btnParse.setEnabled(false);

		northPanel.add(btnParse);
		cbInstrument.setToolTipText("select instrument you like");

		northPanel.add(cbInstrument);
		btnPlay.setEnabled(false);
		btnPlay.setToolTipText("Play the music!");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_view2ModelAdapter.playMusic(cbInstrument.getSelectedIndex());
			}
		});

		northPanel.add(btnPlay);
		splitPane.setResizeWeight(0.5);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);

		contentPane.add(splitPane, BorderLayout.CENTER);

		splitPane.setLeftComponent(spFileContent);
		splitPane.setRightComponent(spParse);

		taParse.setToolTipText("Parsed file will be shown in this area");
		taParse.setLineWrap(true);
		taParse.setWrapStyleWord(true);
	}

}

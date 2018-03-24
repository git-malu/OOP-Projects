package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import shape.*;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2689613650118716529L;
	private JPanel contentPane;
	private JTextField northTextField;
	private AShape ashape = new AnArc();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		initGUI();
	}

	void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		//JPanel centerPanel = new JPanel();
		JPanel centerPanel = new JPanel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 9162968205652839109L;

			/**
			* Overridden paintComponent method to paint a shape in the panel.
			* @param g The Graphics object to paint on.
			**/
			public void paintComponent(Graphics g) {
				super.paintComponent(g); // Do everything normally done first, e.g. clear the screen.
				g.setColor(Color.RED); // Set the color to use when drawing
				g.fillOval(75, 100, 20, 40); // paint a filled 20x40 red ellipse whose upper left corner is at (75, 100)

				//				ashape = new ARect();
				//				ashape.paint(g);
				//				ashape = new AnArc();
				//				ashape.paint(g);
				//				ashape = new ARoundRect();
				ashape.paint(g);

			}

		};
		centerPanel.setBackground(Color.BLACK);
		contentPane.add(centerPanel, BorderLayout.CENTER);

		JPanel northPanel = new JPanel();
		northPanel.setBackground(Color.GREEN);
		contentPane.add(northPanel, BorderLayout.NORTH);

		northTextField = new JTextField();
		northTextField.setText("Type here.");
		northPanel.add(northTextField);
		northTextField.setColumns(10);

		JLabel northLabel = new JLabel("Display Area");
		northLabel.setForeground(Color.BLACK);
		northLabel.setBackground(Color.WHITE);
		northPanel.add(northLabel);

		JButton northButton = new JButton("Click here.");
		northButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				northLabel.setText(northTextField.getText());
			}
		});
		northPanel.add(northButton);

		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		contentPane.add(panel, BorderLayout.EAST);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.YELLOW);
		contentPane.add(panel_1, BorderLayout.WEST);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GREEN);
		contentPane.add(panel_2, BorderLayout.SOUTH);

		JButton rectButton = new JButton("Rect");
		rectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ashape = new ARect();
				ashape.setColor(Color.GREEN);
				centerPanel.repaint();
			}
		});
		panel_2.add(rectButton);

		JButton arcButton = new JButton("Arc");
		arcButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ashape = new AnArc();
				ashape.setColor(Color.BLUE);
				centerPanel.repaint();
			}
		});
		panel_2.add(arcButton);

		JButton roundRectButton = new JButton("RoundRect");
		roundRectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ashape = new ARoundRect();
				ashape.setColor(Color.YELLOW);
				centerPanel.repaint();
			}
		});
		panel_2.add(roundRectButton);

		JButton btnHouse = new JButton("A House");
		btnHouse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ACompositeShape compShape = new ACompositeShape();
				compShape.add(new ATriangle());

				ARect compRect = new ARect();
				compRect.setLocation(new int[] { 250, 100 });
				compRect.setSize(new int[] { 100, 100 });

				compShape.add(compRect);
				ashape = compShape;

				centerPanel.repaint();
			}
		});
		panel_2.add(btnHouse);
	}

	void start() {
		setVisible(true);
	}

}

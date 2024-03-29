package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ballModel.*;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.ListIterator;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2689613650118716529L;
	private JPanel contentPane;
	private JTextField northTextField;
	//private AShape ashape;
	// adapter
	IView2ModelAdapter _view2ModelAdpt = IView2ModelAdapter.NULL_OBJECT;
	
	JPanel centerPanel;
	
	LinkedList<Ball> ballList = new LinkedList<Ball>();
	RadiusBall testBall = new RadiusBall();
	/**
	 * Launch the application.
	 */

	public void start() {
		setVisible(true);
	}
	
	
	/**
	 * Create the frame.
	 */
	
	public MainFrame(IView2ModelAdapter adpt) {
		_view2ModelAdpt = adpt;
		ballList.add(new NullBall());
		initGUI(); //initialize GUI
	}

	/**
	 * initialize GUI
	 */
	void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		//center panel creation
		centerPanel = new JPanel() {

			private static final long serialVersionUID = 9162968205652839109L;

			/**
			* Overridden paintComponent method to paint a shape in the panel.
			* @param g The Graphics object to paint on.
			**/
			public void paintComponent(Graphics g) {
				/**
				 * paint a red oval for test
				 */
				super.paintComponent(g); // Do everything normally done first, e.g. clear the screen.
//				g.setColor(Color.RED); // Set the color to use when drawing
//				g.fillOval(75, 100, 20, 40); // paint a filled 20x40 red ellipse whose upper left corner is at (75, 100)

				/**
				 * paint polymorphically (Triangle, Rectangle, house, etc).
				 */
				//ashape.paint(g);
				ListIterator<Ball> iter = ballList.listIterator(0);
				
				while(iter.hasNext()) {
					iter.next().paint(g);
				}
				//testBall.paint(g);
			}

		};

		//center panel
		centerPanel.setBackground(Color.BLACK);
		contentPane.add(centerPanel, BorderLayout.CENTER);

		//north panel
		JPanel northPanel = new JPanel();
		northPanel.setBackground(Color.GREEN);
		contentPane.add(northPanel, BorderLayout.NORTH);
		
		
		//north text field
		northTextField = new JTextField();
		northTextField.setText("Type here.");
		northPanel.add(northTextField);
		northTextField.setColumns(10);
		
		
		//north label
//		JLabel northLabel = new JLabel("Display Area");
//		northLabel.setForeground(Color.BLACK);
//		northLabel.setBackground(Color.WHITE);
//		northPanel.add(northLabel);
		
		
		//make ball button
		JButton makeBallButton = new JButton("Make balls");
		makeBallButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				northLabel.setText(northTextField.getText());
				
				_view2ModelAdpt.request2Model_makeBall(northTextField.getText(), getBounds());
			}
		});
		northPanel.add(makeBallButton);
		
		//clear button
		JButton btnClear = new JButton("clear all");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_view2ModelAdpt.request2Model_clearAll();
			}
		});
		northPanel.add(btnClear);

		
		
		
//		//east panel
//		JPanel eastPanel = new JPanel();
//		eastPanel.setBackground(Color.YELLOW);
//		contentPane.add(eastPanel, BorderLayout.EAST);

//		//west panel
//		JPanel westPanel = new JPanel();
//		westPanel.setBackground(Color.YELLOW);
//		contentPane.add(westPanel, BorderLayout.WEST);

//		//south Panel
//		JPanel southPanel = new JPanel();
//		southPanel.setBackground(Color.GREEN);
//		contentPane.add(southPanel, BorderLayout.SOUTH);

//		/**
//		 * a button that draws a rectangle when clicked
//		 */
//		JButton rectButton = new JButton("Rect");
//		rectButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				//paint a rectangle.
//				ashape = new ARect();
//				ashape.setColor(Color.GREEN);
//				centerPanel.repaint();
//			}
//		});
//		southPanel.add(rectButton);

//		/**
//		 * a button that draws an arc when clicked
//		 */
//		JButton arcButton = new JButton("Arc");
//		arcButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				//paint an arc
//				ashape = new AnArc();
//				ashape.setColor(Color.BLUE);
//				centerPanel.repaint();
//			}
//		});
//		southPanel.add(arcButton);

//		/**
//		 * a button that draws an round rectangle when clicked
//		 */
//		JButton roundRectButton = new JButton("RoundRect");
//		roundRectButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				//paint a round rectangle.
//				ashape = new ARoundRect();
//				ashape.setColor(Color.YELLOW);
//				centerPanel.repaint();
//			}
//		});
//		southPanel.add(roundRectButton);

//		/**
//		 * clicking this button will create a composite shape object, a house for example, and then paint it.
//		 */
//		JButton btnHouse = new JButton("A House");
//		btnHouse.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				//create a composite shape
//				ACompositeShape compShape = new ACompositeShape();
//				//add a child --triangle -- to the composite shape
//				compShape.add(new ATriangle());
//
//				//create a rectangle child
//				ARect compRect = new ARect();
//				compRect.setLocation(new int[] { 250, 100 });
//				compRect.setSize(new int[] { 100, 100 });
//				//add the rect child to the composite shape
//				compShape.add(compRect);
//
//				//now compShape looks like a house, because it has a triangle and a rectangle properly placed
//				ashape = compShape;
//
//				//repaint a house on the center panel
//				centerPanel.repaint();
//			}
//		});
//		southPanel.add(btnHouse);
	}
	
	
	public void handleModelRequest(LinkedList<Ball> list){
		ballList = list;
		centerPanel.repaint();
	}
	

}

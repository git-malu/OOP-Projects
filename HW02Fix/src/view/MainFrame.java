package view;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

/**
 * class MainFrame, container，Used to add other components
 * @author guoqz
 */
public class MainFrame extends JFrame {

	/**
	 * Maintain version compatibility
	 */
	private static final long serialVersionUID = -6787198012587971808L;
	private JPanel contentPane; //contain all components
	private Rectangle bounds; //bounds of canvas
	private final JPanel north_panel = new JPanel(); //edit text here
	private final JButton make_ball = new JButton("Make Ball"); //press the button will make a new ball with type on text
	private final JButton clean_balls = new JButton("Clean Balls"); //press the button will clean all balls on canvas
	private final JTextField ball_shape = new JTextField(); // input the ball type you want here
	// The view adapter is initialized to a no-op to insure that system always has well-defined behavior
	private IView2ModelAdapter _view2ModelAdpt = IView2ModelAdapter.NULL_OBJECT;
	// Create a special panel with an overridden paintComponent method.
	private final JPanel center_panel = new JPanel() {
		/**
		 * Maintain version compatibility
		 */
		private static final long serialVersionUID = -872444218515942499L;

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			bounds = g.getClipBounds();

			_view2ModelAdpt.getBounds(bounds);
			_view2ModelAdpt.paint(g);
		}
	};

	/**
	 * Constructor is supplied with an instance of the model adapter.
	 * @param view2ModelAdpt
	 */
	public MainFrame(IView2ModelAdapter view2ModelAdpt) {
		_view2ModelAdpt = view2ModelAdpt;
		initGUI();
	}

	/**
	 * start
	 */
	public void start() {
		setVisible(true);

	}

	/**
	 * Updates the view by repainting the canvas
	 */
	public void update() {
		center_panel.repaint();
	}

	//initialize GUI, add all sorts of components
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		north_panel.setBackground(Color.GREEN);
		north_panel.setToolTipText("put the button and textfield here ");

		contentPane.add(north_panel, BorderLayout.NORTH);

		north_panel.add(ball_shape);
		make_ball.setToolTipText("make a ball");

		north_panel.add(make_ball);
		clean_balls.setToolTipText("clean all the balls on screen");

		north_panel.add(clean_balls);
		ball_shape.setToolTipText("input the ball type you want");
		ball_shape.setColumns(10);
		center_panel.setToolTipText("paint ball here");

		contentPane.add(center_panel, BorderLayout.CENTER);
		make_ball.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp = ball_shape.getText().toString();
				_view2ModelAdpt.getName(temp);
			}
		});

		clean_balls.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_view2ModelAdpt.clean();
			}
		});

		center_panel.setBackground(Color.BLACK);
	}
}

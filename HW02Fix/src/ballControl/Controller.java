package ballControl;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Rectangle;

import ballModel.BallModel;
import ballModel.IModel2ViewAdapter;
import view.IView2ModelAdapter;
import view.MainFrame;

/**
 * MVC Controller for the system
 */
public class Controller {

	private MainFrame view; // starts off null but will be fine when the constructor is finished.
	private BallModel model; // starts off null but will be fine when the constructor is finished.

	/**
	 * Controller constructor builds the system
	 */
	public Controller() {
		view = new MainFrame(new IView2ModelAdapter() {
			/**
			 * use model update method to paint on canvas
			 */
			public void paint(Graphics g) {
				model.update(g);
			}

			/**
			 * use model method to pass a type name
			 */
			public void getName(String typename) {
				model.make_ball(typename);
			}

			/**
			 * use model method to pass bounds
			 */
			public void getBounds(Rectangle bounds) {
				model.getBounds(bounds);
			}

			/**
			 * use model clean method to clean canvas
			 */
			public void clean() {
				model.clean();
			}

		});

		model = new BallModel(new IModel2ViewAdapter() {
			/**
			 * use view method update the canvas
			 */
			public void update() {
				view.update();
			}

		});
	}

	/**
	 * Start the system
	 */
	public void start() {
		model.start();
		view.start();
	}

	/**
	 * Launch the application.
	 * @param args Arguments given by the system or command line.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Controller controller = new Controller();
					controller.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}

package control;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.util.ArrayList;

import model.BallWorldModel;
import model.IModel2ViewAdapter;
import model.IStrategyFac;
import view.IView2ModelAdapterCtrl;
import view.IView2ModelAdapterPaint;
import view.MainFrame;

/**
 * MVC Controller for the system
 */
public class Controller {

	private MainFrame<IStrategyFac> view; // starts off null but will be fine when the constructor is finished.
	private BallWorldModel model; // starts off null but will be fine when the constructor is finished.

	/**
	 * Controller constructor builds the system
	 */
	public Controller() {
		view = new MainFrame<IStrategyFac>(new IView2ModelAdapterCtrl<IStrategyFac>() {
			/**
			 * use model method to pass a type name
			 */
			public void makeBall(IStrategyFac fac) {
				model.make_ball(fac);
			}

			/**
			 * use model clean method to clean canvas
			 */
			public void clean() {
				model.clean();
			}

			@Override
			public void makeFac(String facName) {
				// TODO Auto-generated method stub
				model.makeFac(facName);
			}

			@Override
			public void combineFac(IStrategyFac dropList1, IStrategyFac dropList2) {
				// TODO Auto-generated method stub
				model.combineFac(dropList1, dropList2);
			}

			@Override
			public void makeSwitchBall(IStrategyFac fac) {
				// TODO Auto-generated method stub
				model.makeSwitchBall(fac);
			}

			@Override
			public void switchStra(IStrategyFac fac) {
				// TODO Auto-generated method stub
				model.switchStra(fac);
			}

		}, new IView2ModelAdapterPaint() {
			/**
			 * use model update method to paint on canvas
			 */
			public void paint(Graphics g) {
				model.paint(g);
			}

		});

		model = new BallWorldModel(new IModel2ViewAdapter() {
			/**
			 * use view method update the canvas
			 */
			public void repaint() {
				view.viewRepaint();
			}

			@Override
			public void facListUpdate(ArrayList<IStrategyFac> straFac) {
				// TODO Auto-generated method stub
				view.dropListUpdate(straFac);
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

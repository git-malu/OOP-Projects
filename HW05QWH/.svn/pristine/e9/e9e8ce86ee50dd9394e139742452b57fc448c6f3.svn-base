package controller;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;

import model.BallModel;
import model.IBallCmd;
import model.IModel2ViewUpdateViewAdapter;
import model.IModelCtrlAdpt;
import model.IPaintStrategyFac;
import model.IStrategyFac;
import model.IModel2ViewGetCanvasAdapter;
import view.BallWorldMainAppFrame;
import view.IView2ModelPaintAdapter;

/**
 * The <code>Controller</code> class is a controller class under MVC pattern.
 * The <code>Controller</code> class is used for instantiates everything,
 * including the model, view and adapters.
 * 
 * @author Yuchang Shen and Weiheng Qiu
 * based on HW02 by Yue Jiang and Yuchang Shen
 *
 */
public class Controller {

	/**
	 * Import the ballModel
	 */
	private BallModel ballModel; // starts off null but will be fine when the constructor is finished.

	/**
	 * Import the view
	 */
	private BallWorldMainAppFrame<IStrategyFac<IBallCmd>, IPaintStrategyFac> ballView; // starts off null but will be fine when the constructor is finished.

	/**
	 * Controller constructor builds the system
	 */
	public Controller() {
		// Here the model is shown being constructed first then the view but it could
		// easily be the other way around if needs dictated it.
		// set the model field
		ballModel = new BallModel(new IModel2ViewUpdateViewAdapter() {
			@Override
			public void updateView() {
				ballView.updateView();
			}

		}, new IModel2ViewGetCanvasAdapter() {
			@Override
			public Component getCanvas() {
				return ballView.getCanvas();
			}
		});
		// set the view field
		ballView = new BallWorldMainAppFrame<IStrategyFac<IBallCmd>, IPaintStrategyFac>(
				new IModelCtrlAdpt<IStrategyFac<IBallCmd>, IPaintStrategyFac>() {
					@Override
					public IStrategyFac<IBallCmd> addStrategy(String className) {
						return ballModel.makeStrategyFac(className);
					}

					@Override
					public IPaintStrategyFac addPaintStrategy(String className) {
						return ballModel.makePaintStratFac(className);
					}

					@Override
					public void makeBall(IStrategyFac<IBallCmd> selectedItem1, IPaintStrategyFac selectedItem2) {
						ballModel.loadBall(selectedItem1.make(), selectedItem2.make());
					}

					@Override
					public void clearBalls() {
						ballModel.clearBalls();
						ballModel.switchSwitcherStrategy(ballModel.defaultStrategy);
					}

					@Override
					public IStrategyFac<IBallCmd> combineStrategy(IStrategyFac<IBallCmd> selectedItem1, IStrategyFac<IBallCmd> selectedItem2) {
						return ballModel.combineStrategyFacs(selectedItem1, selectedItem2);
					}

					@Override
					public void makeSwitcherBall(IPaintStrategyFac selectedItem2) {
						ballModel.loadBall(ballModel.getSwithcerStrategy(), selectedItem2.make());
					}

					@Override
					public void switchStrategy(IStrategyFac<IBallCmd> selectedItem) {
						ballModel.switchSwitcherStrategy(selectedItem.make());
					}
				}, new IView2ModelPaintAdapter() {
					@Override
					public void paint(Graphics g) {
						ballModel.update(g);
					}
				});

	}

	/**
	 * Start the system
	 */
	public void start() {
		ballModel.start(); // better to start the model first but not always
		ballView.start();
	}

	/**
	 * Launch the application.
	 * 
	 * @param args
	 *            Arguments given by the system or command line.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() { // Java specs say that the system must be constructed on the GUI event
												// thread.
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

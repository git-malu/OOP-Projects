package engine.engineController;

import java.awt.EventQueue;
import java.util.function.Consumer;

import engine.engineModel.EngineModel;
import engine.engineModel.IEngineModel2ViewAdapter;
import engine.engineView.EngineView;
import engine.engineView.IEngineView2ModelAdapter;

public class EngineController {
	private EngineModel engineModel; //will be initialized by constructor
	private EngineView engineView; //will be initialized by constructor
	
	/**
	 * constructor who initializes engineModel & engineView
	 */
	public EngineController() {
		engineModel = new EngineModel( new IEngineModel2ViewAdapter() {
			
			@Override
			public Consumer<String> getDisplayMethod() {
				// TODO Auto-generated method stub
				return engineView.displayToConsole();
			}
		});
		
		engineView = new EngineView( new IEngineView2ModelAdapter() {
			
			@Override
			public void engineQuit() {
				// TODO Auto-generated method stub
				engineModel.stop();
			}

			@Override
			public void sendMsg(String s) {
				// TODO Auto-generated method stub
				engineModel.sendMsgToClient(s);
			}
		});
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EngineController engineController = new EngineController();
					engineController.start();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}
	
	/**
	 * start the controller
	 */
	public void start() {
		this.engineModel.start();
		this.engineView.start();
	}
}

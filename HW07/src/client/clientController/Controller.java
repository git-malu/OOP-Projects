package client.clientController;

import java.awt.EventQueue;

import client.clientModel.ClientModel;
import client.clientModel.IViewAdapter;
import client.clientView.IModelAdapter;
import client.clientView.MyClientGUI;
import provided.client.model.taskUtils.ITaskFactory;
import provided.client.model.taskUtils.SingletonTaskFactoryLoader;

/**
 * The <code>Controller</code> class is a controller class under MVC pattern.
 * The <code>Controller</code> class is used for instantiates everything,
 * including the model, view and adapters.
 * 
 * @author Yue Jiang, Lu Ma
 *
 */
public class Controller {
	/**
	 * Import the client GUI
	 */
	private MyClientGUI<ITaskFactory<?>> view;

	/**
	 * Import the client model
	 */
	private ClientModel model;

	/**
	 * Controller constructor builds the system
	 */
	public Controller() {
		model = new ClientModel(new IViewAdapter() {

			@Override
			public void setRemoteHost(String hostAddress) {
				// TODO Auto-generated method stub
				view.setRemoteHost(hostAddress);
			}

			@Override
			public void append(String s) {
				// TODO Auto-generated method stub
				view.append(s);
			}
		});
		view = new MyClientGUI<>(new IModelAdapter<ITaskFactory<?>>() {

			@Override
			public String connectTo(String s) {
				// TODO Auto-generated method stub
				return model.connectTo(s);
			}

			@Override
			public void quit() {
				// TODO Auto-generated method stub
				model.stop();
			}

			@Override
			public void sendMsgToRemoteHost(String s) {
				// TODO Auto-generated method stub
				model.sendMsgToComputeEngine(s);
			}

			@Override
			public String runTask(ITaskFactory<?> factory, String s) {
				// TODO Auto-generated method stub
				try {
					return Controller.this.model.runTask(factory.make(s));
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					String errMsg = "Exception while running task: " + e;
					return errMsg;
				}
			}

			@Override
			public ITaskFactory<?> addTask(String classname) {
				// TODO Auto-generated method stub
				return SingletonTaskFactoryLoader.SINGLETON.load(classname);
			}

			@Override
			public ITaskFactory<?> combineTasks(ITaskFactory<?> item1, ITaskFactory<?> item2) {
				// TODO Auto-generated method stub
				return model.combineTaskFac(item1, item2);
			}
		});
	}

	/**
	 * Start the system
	 */
	public void start() {
		model.start(); // better to start the model first but not always
		view.start();
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

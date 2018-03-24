package client.clientController;

import java.awt.EventQueue;

import client.clientModel.ClientModel;
import client.clientModel.IViewAdapter;
import client.clientView.IModelAdapter;
import client.clientView.MyClientGUI;
import provided.client.model.taskUtils.ITaskFactory;

public class Controller {
	private MyClientGUI<ITaskFactory<?>> view;
	private ClientModel model;

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
			public String runTask(ITaskFactory<?> item, String s) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public ITaskFactory<?> addTask(String s) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public ITaskFactory<?> combineTasks(ITaskFactory<?> item1, ITaskFactory<?> item2) {
				// TODO Auto-generated method stub
				return null;
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

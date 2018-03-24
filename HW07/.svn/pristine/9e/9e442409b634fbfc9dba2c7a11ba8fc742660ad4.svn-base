package client.clientModel;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.function.Consumer;

import client.clientModel.task.MultiTask;
import provided.client.model.IClientModel;
import provided.client.model.taskUtils.ITaskFactory;
import provided.compute.ICompute;
import provided.compute.IRemoteTaskViewAdapter;
import provided.compute.ITask;
import provided.compute.ITaskResultFormatter;
import provided.rmiUtils.IRMIUtils;
import provided.rmiUtils.IRMI_Defs;
import provided.rmiUtils.RMIUtils;

/**
 * The <code>ClientModel</code> class is a mode class under MVC pattern. The
 * <code>ClientModel</code> is the back-end computations
 * 
 * @author Yue Jiang, Lu Ma
 *
 */
public class ClientModel implements IClientModel {

	/**
	 * The adapter let model communicate with view
	 */
	private IViewAdapter viewAdapter;

	/**
	 * The out put commend to accept string
	 */
	private Consumer<String> outputCmd = new Consumer<String>() {

		@Override
		public void accept(String t) {
			// TODO Auto-generated method stub
			ClientModel.this.viewAdapter.append(String.valueOf(t) + "\n");
		}
	};

	/**
	 * Factory for the Registry and other uses.
	 */
	IRMIUtils rmiUtils = new RMIUtils(outputCmd);

	/**
	 * A reference to the proxy stub of the remote ICompute object.
	 */
	private ICompute computeStub;

	/**
	 * RMI stub for engineTVA
	 */
	private IRemoteTaskViewAdapter engineTVAStub;

	/**
	 * The view adapter that the server can use to append messages to this client's
	 * view.
	 */
	private IRemoteTaskViewAdapter clientTVA;

	/**
	 * RMI stub for clientTVA.
	 */
	private IRemoteTaskViewAdapter clientTVAStub;

	/**
	 * Constructor for the class
	 * 
	 * @param viewAdapter
	 *            The adapter to the view.
	 */
	public ClientModel(IViewAdapter viewAdapter) {
		// TODO Auto-generated constructor stub
		clientTVAStub = null;
		engineTVAStub = null;
		clientTVA = new IRemoteTaskViewAdapter() {

			@Override
			public void append(String s) throws RemoteException {
				// TODO Auto-generated method stub
				outputCmd.accept("[Engine Server]" + s);
			}
		};
		this.viewAdapter = viewAdapter;
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		rmiUtils.startRMI(IRMI_Defs.CLASS_SERVER_PORT_CLIENT); // The class server the client uses.
		try {
			viewAdapter.setRemoteHost(rmiUtils.getLocalAddress());
			outputCmd.accept("Client is ready..." + "\n");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			String errMsg = "Error getting local address: ";
			System.err.println(errMsg + e);
			e.printStackTrace();

		}
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		outputCmd.accept("client is quitting." + "\n");
		try {
			rmiUtils.stopRMI();
			System.exit(-1); // close the window
		} catch (Exception e) {
			// TODO: handle exception
			String errMsg = "Error stopping class server: ";
			System.err.println(errMsg + e);
			e.printStackTrace();
			outputCmd.accept(errMsg + e + "\n");
		}
	}

	@Override
	public String connectTo(String remoteHost) {
		// TODO Auto-generated method stub
		try {
			outputCmd.accept("Locating registry at " + remoteHost + "..." + "\n");

			if (null == clientTVAStub) {
				clientTVAStub = (IRemoteTaskViewAdapter) UnicastRemoteObject.exportObject((Remote) this.clientTVA,
						IRemoteTaskViewAdapter.BOUND_PORT_CLIENT);
			}

			Registry registry = rmiUtils.getRemoteRegistry(remoteHost);
			outputCmd.accept("Found registry: " + registry);

			computeStub = (ICompute) registry.lookup(ICompute.BOUND_NAME);
			outputCmd.accept("Found remote Compute object: " + computeStub);

			engineTVAStub = computeStub.setTextAdapter(clientTVAStub);
			outputCmd.accept("Got text adapter: " + engineTVAStub);

			engineTVAStub.append("Hello from the client!");
			return "Connection to " + remoteHost + " established!";
		} catch (Exception e) {
			// TODO: handle exception
			String errMsg = "Error connection to ";
			System.err.println(errMsg + remoteHost + " : " + e + "\n");
			e.printStackTrace();
			outputCmd.accept(errMsg + remoteHost + " : " + e + "\n");
			return "No Connection Established Successfully!";
		}
	}

	@Override
	public void sendMsgToComputeEngine(String text) {
		// TODO Auto-generated method stub
		if (null != engineTVAStub) {
			outputCmd.accept("Sending msg to connected remote host = " + "{" + text + "}");
			try {
				engineTVAStub.append(text);
			} catch (Exception e) {
				// TODO: handle exception
				String errMsg = "RemoteException while sending msg to connected remote host: ";
				System.err.println(errMsg + e + "\n");
				e.printStackTrace();
				outputCmd.accept(errMsg + e + "\n");
			}
		} else {
			outputCmd.accept("Error : stub to remote host is null!");
		}

	}

	@Override
	public <T> String runTask(ITask<T> task) {
		// TODO Auto-generated method stub
		String resultFormatter = "No result yet.";
		try {
			ITaskResultFormatter<T> taskResultFormatter = task.getFormatter();
			T result = computeStub.executeTask(task);
			resultFormatter = taskResultFormatter.format(result);
		} catch (Exception e) {
			// TODO: handle exception
			String errMsg = "Task execution exception: ";
			System.err.println(errMsg + e + "\n");
			e.printStackTrace();
			outputCmd.accept(errMsg + e + "\n");
		}
		return resultFormatter;
	}

	/**
	 * Returns an ITaskFactory that can instantiate a MultiTask with the two tasks
	 * made by the two given ITaskFactory objects.
	 * 
	 * @param taskFactory1
	 *            An ITaskFactory for a task
	 * @param taskFactory2
	 *            An ITaskFactory for a task
	 * @return An ITaskFactory for the composition of the two tasks
	 */
	public ITaskFactory<?> combineTaskFac(final ITaskFactory<?> taskFactory1, final ITaskFactory<?> taskFactory2) {
		return new ITaskFactory<Object[]>() {

			@Override
			public ITask<Object[]> make(String param) {
				// TODO Auto-generated method stub
				return new MultiTask(taskFactory1.make(param), taskFactory2.make(param));
			}

			public String toString() {
				return taskFactory1.toString() + "-" + taskFactory2.toString();
			}
		};

	}

}
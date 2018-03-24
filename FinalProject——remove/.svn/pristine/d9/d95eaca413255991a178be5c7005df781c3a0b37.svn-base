package lm44_xw47.model;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Collection;

import javax.swing.JOptionPane;

import common.IChatRoom;
import common.IReceiver;
import common.IUser;

import provided.rmiUtils.IRMI_Defs;
import provided.rmiUtils.RMIUtils;

public class MainModel {
	private IMainModel2ViewAdapter _mainModel2ViewAdapter;
	private User meUser;
	private IUser userStub;
	private RMIUtils rmiUtils;
	private Registry registry;
	
	public MainModel(IMainModel2ViewAdapter adapter) {
		_mainModel2ViewAdapter = adapter;
	}
	public void start() {
		try {
			// Start the RMI system and get the local Registry, making it if necessary.
			rmiUtils = new RMIUtils((String str)->{
				_mainModel2ViewAdapter.appendLog(str);
			});
			
			rmiUtils.startRMI(IRMI_Defs.CLASS_SERVER_PORT_SERVER);
			registry = rmiUtils.getLocalRegistry();
			
			//save it to prevent garbage collection
			meUser = new User(JOptionPane.showInputDialog("Input a username:"));
			//save it to prevent garbage collection
			userStub = (IUser) UnicastRemoteObject.exportObject(meUser, IRMI_Defs.STUB_PORT_SERVER);
			//bind to the registry
			registry.rebind(IUser.BOUND_NAME, userStub);
			_mainModel2ViewAdapter.appendLog("RMI Server Ready");
			
		}
		catch(Exception e) {
			System.err.println("Exception while intializing RMI: \n" + e);
			e.printStackTrace();
			System.exit(-1); // exit the program.
		}
	}
	
	public IUser connect(String ip) {
		try {
			Registry remoteRegistry = rmiUtils.getRemoteRegistry(ip);
			IUser remoteUserStub = (IUser) remoteRegistry.lookup(IUser.BOUND_NAME);
			return remoteUserStub;
			
		} catch (RemoteException | NotBoundException e) {
			e.printStackTrace();
			return null;
		}
	}
}

package engine.engineModel;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import provided.compute.ICompute;
import provided.compute.ILocalTaskViewAdapter;
import provided.compute.IRemoteTaskViewAdapter;
import provided.compute.ITask;
/**
 * It's computer server, which computes tasks from client.
 * @author malu
 *
 */
public class Compute implements ICompute {
	public IRemoteTaskViewAdapter clientTaskViewAdapter;//this stub is from client
	public IRemoteTaskViewAdapter engineTaskViewAdapter;//this stub is for client to use.
	public ILocalTaskViewAdapter localTaskViewAdapter;// give it to received task
	/**
	 * Engine execute the task sent from client.
	 * display the result locally and then return the task result to the client.
	 */
	@Override
	public <T> T executeTask(ITask<T> t) throws RemoteException {
		// TODO Auto-generated method stub
		t.setTaskViewAdapter(localTaskViewAdapter);
		T result = t.execute();
		localTaskViewAdapter.append(t.getFormatter().format(result));
		return result;
	}
	/**
	 * upon connection to the server, engine save the remote task view adapter from client.
	 */
	@Override
	public IRemoteTaskViewAdapter setTextAdapter(IRemoteTaskViewAdapter clientTVAStub) throws RemoteException {
		// TODO Auto-generated method stub
		clientTaskViewAdapter = clientTVAStub;// keep a copy here! It's sent from client.
		clientTaskViewAdapter.append("Hello from Engine Server.");
		return engineTaskViewAdapter;//return engine's textAdapter stub
	}
	
	/**
	 * used when initializing this engine server.
	 * @param adapter text view adapter of engine view.
	 */
	public void setRemoteTVAForClient(IRemoteTaskViewAdapter adapter) {
		engineTaskViewAdapter = adapter;
		//change it to a stub
		try {
			engineTaskViewAdapter = (IRemoteTaskViewAdapter) UnicastRemoteObject.exportObject(engineTaskViewAdapter, IRemoteTaskViewAdapter.BOUND_PORT_SERVER);
		}
		catch (Exception e) {
			System.err.println("Server Erro: " + e);
			e.printStackTrace();
		}
		
	}
	
	/**
	 * set local task view adapter for local use only.
	 * @param adapter
	 */
	public void setLocalTVA(ILocalTaskViewAdapter adapter) {
		localTaskViewAdapter = adapter;
	}
	

}

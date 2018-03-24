package client.clientModel.task;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.rmi.RemoteException;

import provided.compute.ILocalTaskViewAdapter;
import provided.compute.ITask;
import provided.compute.ITaskResultFormatter;

/**
 * The <code> MultiTask</code> class is a concrete class.
 * <code> MultiTask</code> will combine two tasks during running
 * <code> MultiTask</code> inherits from <code>ITask</code>
 * 
 * @author Yue Jiang, Lu Ma
 *
 */
public class MultiTask implements ITask<Object[]> {

	/**
	 * The serialVersionUID of this MultiTask
	 */
	private static final long serialVersionUID = -4084475870529481306L;

	/**
	 * The first task need to combine
	 */
	private ITask<? extends Object> task1;

	/**
	 * The second task need to combine
	 */
	private ITask<? extends Object> task2;

	/**
	 * The Local Task View Adapter
	 */
	private transient ILocalTaskViewAdapter taskViewAdapter = ILocalTaskViewAdapter.DEFAULT_ADAPTER;
	/**
	 * The constructor of the MultiTask
	 * 
	 * @param task1
	 *            The first task need to combine
	 * @param task2
	 *            The second task need to combine
	 */
	public MultiTask(ITask<? extends Object> task1, ITask<? extends Object> task2) {
		this.task1 = task1;
		this.task2 = task2;
	}

	@Override
	public Object[] execute() throws RemoteException {
		taskViewAdapter.append("MultiTask executing...\n");
		return new Object[] { task1.execute(), task2.execute() };
	}

	@Override
	public void setTaskViewAdapter(ILocalTaskViewAdapter viewAdapter) {
		this.taskViewAdapter = viewAdapter;
		task1.setTaskViewAdapter(viewAdapter);
		task2.setTaskViewAdapter(viewAdapter);
	}

	@Override
	public ITaskResultFormatter<Object[]> getFormatter() {
		return new ITaskResultFormatter<Object[]>() {
			@SuppressWarnings("unchecked")
			ITaskResultFormatter<Object> formatter1 = (ITaskResultFormatter<Object>) task1.getFormatter();
			@SuppressWarnings("unchecked")
			ITaskResultFormatter<Object> formatter2 = (ITaskResultFormatter<Object>) task2.getFormatter();

			@Override
			public String format(Object[] arr) {
				String res = "MultiTask results:\n" + "task: " + formatter1.format(arr[0]) + "\n" + "task: "
						+ formatter2.format(arr[1]);
				return res;
			}
		};
	}

	/**
	 * Reinitializes transient fields upon deserialization. See the <a href=
	 * "http://download.oracle.com/javase/6/docs/api/java/io/Serializable.html">
	 * Serializable</a> marker interface docs. taskView is set to a default value
	 * for now (ILocalTaskViewAdapter.DEFAULT_ADAPTER).
	 * 
	 * @param stream
	 *            The object stream with the serialized data
	 * @throws IOException
	 *             if the input stream cannot be read correctly
	 * @throws ClassNotFoundException
	 *             if the class file associated with the input stream cannot be
	 *             located.
	 */
	private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
		stream.defaultReadObject(); // Deserialize the non-transient data
		taskViewAdapter = ILocalTaskViewAdapter.DEFAULT_ADAPTER; // re-initialize the transient field
	}

}

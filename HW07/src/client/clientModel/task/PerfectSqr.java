package client.clientModel.task;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.rmi.RemoteException;
import java.util.Arrays;

import provided.client.model.taskUtils.ITaskFactory;
import provided.compute.ILocalTaskViewAdapter;
import provided.compute.ITask;
import provided.compute.ITaskResultFormatter;

/**
 * Task to compute Perfect Square to a given number of digits
 * 
 * @author Yue Jiang, Lu Ma
 *
 */

public class PerfectSqr implements ITask<Integer> {

	/**
	 * SerialversionUID for well-defined serialization.
	 */
	private static final long serialVersionUID = 8926790945044956986L;

	/**
	 * Adapter to the local view. Marked "transient" so that it is not serialized
	 * and instead is re-attached at the destination (the server).
	 */
	private transient ILocalTaskViewAdapter taskView = ILocalTaskViewAdapter.DEFAULT_ADAPTER;

	/**
	 * integer number
	 */
	private final int num;

	/**
	 * Construct a task to compute the perfect square of this number
	 * 
	 * @param num
	 *            the number need to be checked
	 */
	public PerfectSqr(int num) {
		// TODO Auto-generated constructor stub
		this.num = num;
		taskView.append("Perfect Squares constructing...");
	}

	/**
	 * compute Perfect Square to a given number
	 * 
	 * @param n
	 *            the number need to be checked
	 * @return the perfect square of this number
	 */
	private int numSquares(int n) {
		// Write your code here
		int[] dp = new int[n + 1];
		// initial array
		Arrays.fill(dp, Integer.MAX_VALUE);
		// find perfect square
		for (int i = 0; i * i <= n; i++) {
			dp[i * i] = 1;
		}
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j * j <= i; j++) {
				dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
			}
		}
		return dp[n];
	}

	@Override
	public Integer execute() throws RemoteException {
		// TODO Auto-generated method stub
		taskView.append("PerfectSqr task called with input = " + num + "\n");
		return numSquares(num);
	}

	@Override
	public void setTaskViewAdapter(ILocalTaskViewAdapter viewAdapter) {
		// TODO Auto-generated method stub
		taskView = viewAdapter;
		viewAdapter.append("PerfectSqr task installed!\n");
	}

	@Override
	public ITaskResultFormatter<Integer> getFormatter() {
		// TODO Auto-generated method stub
		return new ITaskResultFormatter<Integer>() {
			public String format(Integer result) {
				return "Perfect Squares: " + result + "  (input = " + num + ")";
			}
		};
	}

	/**
	 * An ITaskFactory for this task
	 */
	public static final ITaskFactory<Integer> FACTORY = new ITaskFactory<Integer>() {

		@Override
		public ITask<Integer> make(String param) {
			return new PerfectSqr(Integer.parseInt(param));
		}

		@Override
		public String toString() {
			return PerfectSqr.class.getName();
		}

	};

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
		taskView = ILocalTaskViewAdapter.DEFAULT_ADAPTER; // re-initialize the transient field
	}

}

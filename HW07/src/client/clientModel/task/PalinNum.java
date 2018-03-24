package client.clientModel.task;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.rmi.RemoteException;

import provided.client.model.taskUtils.ITaskFactory;
import provided.compute.ILocalTaskViewAdapter;
import provided.compute.ITask;
import provided.compute.ITaskResultFormatter;

/**
 * Check a positive number is a palindrome or not.
 * 
 * @author Yue Jiang, Lu Ma
 *
 */
public class PalinNum implements ITask<Boolean> {

	/**
	 * SerialversionUID for well-defined serialization.
	 */
	private static final long serialVersionUID = -1051597561114402742L;

	/**
	 * Adapter to the local view. Marked "transient" so that it is not serialized
	 * and instead is re-attached at the destination (the server).
	 */
	private transient ILocalTaskViewAdapter taskView = ILocalTaskViewAdapter.DEFAULT_ADAPTER;

	/**
	 * integer number
	 */
	private final int number;

	/**
	 * Construct a task to check if this number is a palindrome or not.
	 * 
	 * @param number
	 *            the number need to be checked
	 */
	public PalinNum(int number) {
		// TODO Auto-generated constructor stub
		this.number = number;
		taskView.append("PalinNum constructing...");
	}

	/**
	 * Check if this number is a palindrome or not.
	 * 
	 * @param x
	 *            the number need to be checked
	 * @return the true or false
	 */
	private boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		return x == reverse(x);
	}

	/**
	 * Reverse this number
	 * 
	 * @param x
	 *            the number need to be checked
	 * @return the reverse number of x
	 */
	private int reverse(int x) {
		int rst = 0;
		while (x != 0) {
			rst = rst * 10 + x % 10;
			x = x / 10;
		}
		return rst;
	}

	@Override
	public Boolean execute() throws RemoteException {
		// TODO Auto-generated method stub
		taskView.append("PalinNum task called with input = " + number + "\n");
		return isPalindrome(number);
	}

	@Override
	public void setTaskViewAdapter(ILocalTaskViewAdapter viewAdapter) {
		// TODO Auto-generated method stub
		taskView = viewAdapter;
		viewAdapter.append("PalinNum task installed!\n");
	}

	@Override
	public ITaskResultFormatter<Boolean> getFormatter() {
		// TODO Auto-generated method stub
		return new ITaskResultFormatter<Boolean>() {
			public String format(Boolean result) {
				return "Is Palindrome: " + result + "  (input = " + number + ")";
			}
		};
	}

	/**
	 * An ITaskFactory for this task
	 */
	public static final ITaskFactory<Boolean> FACTORY = new ITaskFactory<Boolean>() {

		@Override
		public ITask<Boolean> make(String param) {
			return new PalinNum(Integer.parseInt(param));
		}

		@Override
		public String toString() {
			return PalinNum.class.getName();
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